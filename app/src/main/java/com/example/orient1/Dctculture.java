package com.example.orient1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BulletSpan;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Dctculture extends AppCompatActivity {
    // Fix: Declare builder5 at class level
    private SpannableStringBuilder builder5 = new SpannableStringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dctculture);

        String[] sisters = {
                "Sr. Ma. Rosalina Mirabueno, O.P.",
                "Sr. Ines Fider, O.P.",
                "Sr. Irene Lapus, O.P.",
                "Sr. Ma. Magdalena Olfato, O.P.",
                "Sr. Catalina Saligumba, O.P.",
                "Sr. Carmen Tiamzon, O.P.",
                "Sr. Loreto Penuliar, O.P.",
                "Sr. Catherine Cachero, O.P.",
                "Sr. Caridad Bayani, O.P.",
                "Sr. Marisor Fabros, O.P.",
                "Sr. Ma. Alelee M. Masanque, O.P."
        };

        String[] philosophy = {
                "Union with God",
                "Community with others",
                "Harmony with creation"
        };

        String[] values = {
                "FIDES – “Faith in God”",
                "PATRIA – “Love for country and fellowmen”",
                "SAPIENTIA – “Wisdom”"
        };


        appendSection(
                "WISDOM",
                "to possess knowledge and skills for social communication.",
                "to demonstrate sensitive awareness of one’s role in social building.",
                "to positively engage oneself in relevant social issues."
        );

        appendSection(
                "SOCIAL RESPONSIBILITY",
                "to inculcate awareness of Filipino Christian values.",
                "to show appreciation of our Christian dignity as stewards of God’s creation.",
                "to promote moral commitment to ecological balance."
        );

        appendSection(
                "CHRISTIAN WITNESSING",
                "to acquire understanding of scripture teachings.",
                "to manifest love for the scripture.",
                "to practice scriptural truths in every aspect of life."
        );


        TextView description = findViewById(R.id.descriptionText);
        String htmlText = "&emsp;&emsp;Founded on February 14, 1947 by Fr. Mariano M. Sablay. " +
                "It started with 35 students. <b>Fr. Mariano M. Sablay</b> was the Parish Priest of " +
                "San Nicolas de Tolentino of Capas, Tarlac in 1946.";
                description.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY));

        TextView description1 = findViewById(R.id.descriptionText1);
        String htmlText1 = "&emsp;&emsp;In 1960, the Dominican Sisters assumed administration of the school with Sr. Rosalina Mirabueno, " +
                "O.P., as Principal. This transition, along with the completion of the main building," +
                " facilitated an increase in student enrollment and expansion of facilities. " +
                "In 1967, SNA was renamed Dominican School, in honor of St. Dominic, the founder of the Order of Preachers.";
        description1.setText(Html.fromHtml(htmlText1, Html.FROM_HTML_MODE_LEGACY));

        TextView description2 = findViewById(R.id.descriptionText2);
        String htmlText2 = "&emsp;&emsp;Became official on April 20, 1999. Recognized courses include Bachelor programs starting 1997 onward.";
        description2.setText(Html.fromHtml(htmlText2, Html.FROM_HTML_MODE_LEGACY));

        TextView description3 = findViewById(R.id.descriptionText3);
        String htmlText3 = "1.Emphasizes the total integral formation of the human person.<br><br>"+
                "2.Aims for union with God, community with others, and harmony with creation.";
        description3.setText(Html.fromHtml(htmlText3, Html.FROM_HTML_MODE_LEGACY));

        TextView description4 = findViewById(R.id.descriptionText4);
        String htmlText4 = "&emsp;&emsp;<b>Philosophy of Education</b>: Dominican College of Tarlac believes in the ultimate goal of education, that is the total integral formation of the human person that would lead him to attain the purpose for which he was created, namely";
        description4.setText(Html.fromHtml(htmlText4, Html.FROM_HTML_MODE_LEGACY));

        TextView description5 = findViewById(R.id.descriptionText5);
        String htmlText5 = "&emsp;&emsp;The logo embodies this institution’s unwavering commitment to the holistic formation of the person as well as the person’s manifestation of a true educated man in the Dominican way";
        description5.setText(Html.fromHtml(htmlText5, Html.FROM_HTML_MODE_LEGACY));

        TextView description6 = findViewById(R.id.descriptionText6);
        String htmlText6 = "&emsp;&emsp;A God-loving educational community of servant leaders with passion for truth and compassion for humanity";
        description6.setText(Html.fromHtml(htmlText6, Html.FROM_HTML_MODE_LEGACY));

        TextView description7 = findViewById(R.id.descriptionText7);
        String htmlText7 = "&emsp;&emsp;We commit ourselves to the total formation of the person, promotion of truth and transformation of values for the service of humanity.";
        description7.setText(Html.fromHtml(htmlText7, Html.FROM_HTML_MODE_LEGACY));



        TextView sistersTextView = findViewById(R.id.sistersTextView);
        SpannableStringBuilder builder = new SpannableStringBuilder();
        for (String name : sisters) {
            SpannableString bullet = new SpannableString(name + "\n");
            bullet.setSpan(new BulletSpan(20), 0, bullet.length(), 0);
            builder.append(bullet);
        }
        sistersTextView.setText(builder);

        // Philosophy list
        TextView philoTextView = findViewById(R.id.philoed);
        SpannableStringBuilder philoBuilder = new SpannableStringBuilder();
        for (String item : philosophy) {
            SpannableString bullet = new SpannableString(item + "\n");
            bullet.setSpan(new BulletSpan(20), 0, bullet.length(), 0);
            philoBuilder.append(bullet);
        }
        philoTextView.setText(philoBuilder);

        TextView valuesTextView = findViewById(R.id.valuesTextView);
        StringBuilder valuesBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            valuesBuilder.append((i + 1)).append(". ").append(values[i]).append("\n");
        }
        valuesTextView.setText(valuesBuilder.toString());


        // Set text to outcomesView
        TextView outcomesView = findViewById(R.id.outcomesTextView);
        outcomesView.setText(builder5);


        // Home button - go to MainActivity with animation
        ImageButton homeButton = findViewById(R.id.btnHome);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(Dctculture.this, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        });

        // Back button - go back with reverse animation
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }

    private void appendSection(String title, String cognitive, String affective, String psychomotor) {
        int titleStart = builder5.length();
        builder5.append(title).append("\n");
        builder5.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD),
                titleStart, builder5.length(), 0);

        appendBoldLabel("Cognitive – ", cognitive);
        appendBoldLabel("Affective – ", affective);
        appendBoldLabel("Psychomotor – ", psychomotor);
        builder5.append("\n");
    }

    private void appendBoldLabel(String label, String content) {
        int start = builder5.length();
        builder5.append(label);
        builder5.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD),
                start, start + label.length(), 0);
        builder5.append(content).append("\n");
    }
}
