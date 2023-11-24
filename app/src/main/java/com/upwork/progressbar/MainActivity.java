package com.upwork.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private LinearLayout progressBarsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        progressBarsLayout = findViewById(R.id.progressBarsLayout);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    int percentage = Integer.parseInt(text);
                    addProgressBar(percentage);
                    editText.setText("");
                }
            }
        });
    }

    private void addProgressBar(int pe) {
        // Inside your addButton OnClickListener
        try {
            int percentage = pe;

            // Inflate your custom view
            View customCircleView = getLayoutInflater().inflate(R.layout.progressbar, null);

            // Find the ProgressBar and TextView in the custom view
            ProgressBar progressBar = customCircleView.findViewById(R.id.progressBar);
            TextView textView = customCircleView.findViewById(R.id.textView_per);

            // Set the progress and text
            progressBar.setProgress(percentage);
            textView.setText(percentage + "%");

            // Add the custom view to the container
            progressBarsLayout.addView(customCircleView);
        } catch (NumberFormatException e) {
            // Handle invalid input
        }

    }}
