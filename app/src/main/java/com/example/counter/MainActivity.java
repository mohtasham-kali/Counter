package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.plsBTN:
                    plsBTNCounter();
                    break;
                case R.id.resetBTN:
                    initCounter();
                    break;
            }

        }
    };
    private TextView counterTxt;
    private Button minBTN;
    private Button plsBTN;
    private Button resetBTN;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTxt  = findViewById(R.id.counterTxt);
        plsBTN = findViewById(R.id.plsBTN);
        plsBTN.setOnClickListener(clickListener);
        resetBTN = findViewById(R.id.resetBTN);
        resetBTN.setOnClickListener(clickListener);

        initCounter();
        plsBTNCounter();
    }

    private void initCounter() {
        counter = 0;
        counterTxt.setText(counter + "");
    }
    private void plsBTNCounter() {
        counter++;
        counterTxt.setText(counter + "");
    }

}