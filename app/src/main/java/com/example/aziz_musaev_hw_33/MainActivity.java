package com.example.aziz_musaev_hw_33;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button nextButton ;
    Button skipButton;
    int counter = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextButton = findViewById(R.id.next_btn);
        skipButton = findViewById(R.id.skip_btn);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new MainFragment1()).commit();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter < 2) {
                    counter++;
                }
                if (counter == 1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment2()).commit();
                }
                if (counter == 2)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment3()).commit();

                }
                skipButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (counter == 1){
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment1()).commit();
                            counter = counter - 1;
                        }
                        if (counter == 2)
                        {
                            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment2()).commit();
                            counter = counter - 1;
                        }
                    }
                });
            }
        });

    }


}