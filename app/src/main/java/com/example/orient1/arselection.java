package com.example.orient1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.ar.core.ArCoreApk;

public class arselection extends AppCompatActivity {

    private boolean mUserRequestedInstall = true; // Flag for ARCore install

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.fade_in_from_bottom, R.anim.fade_out_to_bottom);
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_arselection);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Handle back button
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

        // Handle Dctmap button click
        Button dctMapButton = findViewById(R.id.Dctmap);
        dctMapButton.setOnClickListener(v -> {
            Intent intent = new Intent(arselection.this, dctlayout.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button ArButton = findViewById(R.id.ARbutton);
        ArButton.setOnClickListener(v -> {
            try {
                // Request ARCore installation if not installed
                ArCoreApk.InstallStatus installStatus =
                        ArCoreApk.getInstance().requestInstall(this, mUserRequestedInstall);

                if (installStatus == ArCoreApk.InstallStatus.INSTALL_REQUESTED) {
                    // ARCore is being installed, wait until next resume
                    mUserRequestedInstall = false;
                    return;
                }

                // ARCore is installed, now check if AR is supported
                ArCoreApk.Availability availability = ArCoreApk.getInstance().checkAvailability(this);

                if (availability.isSupported()) {
                    // Check camera permission
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.CAMERA}, 100);
                    } else {
                        // Permission granted, open camera
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(cameraIntent);
                    }
                } else {
                    Toast.makeText(this, "AR is not supported on this device.", Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                Toast.makeText(this, "Error checking/installing ARCore: " + e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Open camera after permission granted
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cameraIntent);
            } else {
                Toast.makeText(this, "Camera permission is required to use this feature.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
