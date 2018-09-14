package com.example.juanesteban.mathchallengueversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    public static int correctas = 0;
    public static int totales = 5;
    private TextView tv_results;
    private TextView tv_correctas;
    private TextView tv_tiempo;
    private Button btn_restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tv_results = findViewById(R.id.tv_results);
        tv_correctas = findViewById(R.id.tv_correctas);
        tv_tiempo = findViewById(R.id.tv_tiempo);
        btn_restart = findViewById(R.id.btn_restart);

        long tiempoTotal = getIntent().getExtras().getLong("tiempo");

        tv_correctas.setText("Correct answers: " + correctas + "/" + totales);
        tv_tiempo.setText("Total time: " + tiempoTotal / 1000 + " Seconds" );

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctas = 0;
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
