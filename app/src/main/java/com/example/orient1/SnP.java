package com.example.orient1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SnP extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private Handler autoScrollHandler = new Handler();
    private Runnable autoScrollRunnable;
    private int scrollSpeed = 1; // Pixels to scroll per tick
    private int scrollDelay = 20; // Milliseconds between scrolls
    private CardView cardFront, cardBack;
    private boolean isFront = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sn_p);
        List<CardAdapter.CardItem> cardItems = new ArrayList<>();
        cardItems.add(new CardAdapter.CardItem(R.drawable.practical_nursing, "Practical Nursing Program"));
        cardItems.add(new CardAdapter.CardItem(R.drawable.contact, "Contact Center Training"));
        cardItems.add(new CardAdapter.CardItem(R.drawable.restaurant, "Restaurant Management"));
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CardAdapter(cardItems));

        // Center the first item
        recyclerView.post(() -> {
            int middle = Integer.MAX_VALUE / 2;
            recyclerView.scrollToPosition(middle);
        });

        // Add snap helper
        new PagerSnapHelper().attachToRecyclerView(recyclerView);

        // Auto-scroll (optional)
        startAutoScroll();

        cardFront = findViewById(R.id.card_front);
        cardBack = findViewById(R.id.card_back);

        // Set click listener on the front card
        cardFront.setOnClickListener(v -> flipCard());

        // Also allow clicking on the back to flip back
        cardBack.setOnClickListener(v -> flipCard());

        ImageView myImage = findViewById(R.id.myImage);
        VideoView myVideo = findViewById(R.id.myVideo);

// On click, hide image and play video
        myImage.setOnClickListener(v -> {
            myImage.setVisibility(View.GONE);
            myVideo.setVisibility(View.VISIBLE);

            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dcthymn);
            myVideo.setVideoURI(videoUri);

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(myVideo);
            myVideo.setMediaController(mediaController);
            myVideo.start();
        });
        TextView descriptionText = findViewById(R.id.descriptionText);
        TextView descriptionText1 = findViewById(R.id.descriptionText1);
        TextView bishopSisonDescription = findViewById(R.id.bishopSisonDescription);
        TextView description4 = findViewById(R.id.description4);
        TextView descriptionText3 = findViewById(R.id.descriptionText3);
        TextView descriptionText5 = findViewById(R.id.descriptionText5);
        TextView descriptionText6 = findViewById(R.id.descriptionText6);
        TextView descriptionText7 = findViewById(R.id.descriptionText7);
        TextView descriptionText8 = findViewById(R.id.descriptionText8);
        TextView descriptionText9 = findViewById(R.id.descriptionText9);
        TextView myTextView = findViewById(R.id.myTextView);
        String[] fruits = {"union with God", "community with others", "harmony with creation"};

        StringBuilder builder = new StringBuilder();
        for (String fruit : fruits) {
            builder.append("• ").append(fruit).append("\n");
        }

        myTextView.setText(builder.toString());

        String html10 = "That’s why <b>DCT</b> wants to build and keep a learning system that helps students think better, grow in faith, and practice good Dominican values." ;
        descriptionText9.setText(Html.fromHtml(html10, Html.FROM_HTML_MODE_LEGACY));

        String html9 = "<b>Dominican College of Tarlac</b> believes in the\n" +
                "ultimate goal of education, that is the total\n" +
                "integral formation of the human person that\n" +
                "would lead him to attain the purpose for\n" +
                "which he was created, namely:" ;
        descriptionText8.setText(Html.fromHtml(html9, Html.FROM_HTML_MODE_LEGACY));

        String html8 = "In <b>2015</b>, the institution expanded its academic programs with the addition of the <b>Bachelor of Science in Criminal Justice Education</b>." ;
        descriptionText7.setText(Html.fromHtml(html8, Html.FROM_HTML_MODE_LEGACY));

        String html7 = "The <b>Bachelor of Science in Business Administration</b> program became available in <b>2011</b>." ;
        descriptionText6.setText(Html.fromHtml(html7, Html.FROM_HTML_MODE_LEGACY));

        String html6 = "<b>2009</b> marked the introduction of the Bachelor of Science in Information Technology program." ;
        descriptionText5.setText(Html.fromHtml(html6, Html.FROM_HTML_MODE_LEGACY));

        String html3 = "<b>DCT</b> has been given accreditation by <b>TESDA</b> by <b>2005-2006</b> ";
        descriptionText3.setText(Html.fromHtml(html3, Html.FROM_HTML_MODE_LEGACY));

        String html4 = "<b>Bachelor of Arts </b>courses and Computer\n<b>Secretarial</b> are offered in this year";
        description4.setText(Html.fromHtml(html4, Html.FROM_HTML_MODE_LEGACY));

        String html1 = "<b>Saint Dominic, OP</b> (Spanish: Santo Domingo; 8 August 1170 – 6 August 1221), also known as <b>Dominic de Guzmán</b>, was a Castilian Catholic priest and the founder of the Dominican Order.";
        descriptionText.setText(Html.fromHtml(html1, Html.FROM_HTML_MODE_LEGACY));

        String html2 = "Last commencement exercises, <b>March 1973</b>, Religious Missionaries St. Dominic.";
        descriptionText1.setText(Html.fromHtml(html2, Html.FROM_HTML_MODE_LEGACY));

        String html5 = "<b>Bishop Jesus J. Sison</b> became the pastor of Bonuan, Pangasinan in 1943 and was named bishop of the newly erected diocese of Tarlac in 1963. During his tenure as bishop, he worked tirelessly to improve the Catholic education of his flock. After his retirement in 1988, he moved to America";
        bishopSisonDescription.setText(Html.fromHtml(html5, Html.FROM_HTML_MODE_LEGACY));

        // Home button - goes to MainActivity with animation
        ImageButton homeButton = findViewById(R.id.btnHome);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(SnP.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        });

        // Back button - goes to previous page with reverse animation
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }

    private void flipCard() {
        View rootLayout = findViewById(R.id.flip_container);

        if (isFront) {
            // Flip to back
            FlipAnimation flipAnimation = new FlipAnimation(cardFront, cardBack);
            rootLayout.startAnimation(flipAnimation);
        } else {
            // Flip to front
            FlipAnimation flipAnimation = new FlipAnimation(cardBack, cardFront);
            rootLayout.startAnimation(flipAnimation);
        }

        isFront = !isFront;
    }
    private void startAutoScroll() {
        final int SCROLL_SPEED = 30;  // Increased from 2 (pixels per tick)
        final int SCROLL_DELAY = 10;  // Reduced from 20 (milliseconds between scrolls)

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                recyclerView.smoothScrollBy(SCROLL_SPEED, 0);
                handler.postDelayed(this, SCROLL_DELAY);
            }
        };
        handler.postDelayed(runnable, SCROLL_DELAY);
    }

}