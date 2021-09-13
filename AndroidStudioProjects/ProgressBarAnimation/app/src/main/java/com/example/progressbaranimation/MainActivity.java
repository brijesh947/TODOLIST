package com.example.progressbaranimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        RelativeLayout layout = findViewById(R.id.progress_circular);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int vis = layout.getVisibility();
               if(vis==View.GONE){
                   layout.setVisibility(View.VISIBLE);
               }else{
                   layout.setVisibility(View.GONE);
               }
            }
        });
    }
}