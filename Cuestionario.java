package com.example.juanesteban.mathchallengueversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class Cuestionario extends AppCompatActivity {

    private TextView tv_question;
    private TextView tv_operacion;

    private RadioGroup radioGroup;
    private RadioButton radio_1;
    private RadioButton radio_2;
    private RadioButton radio_3;
    private RadioButton radio_4;

    private Button btn_confirm;

    private int contador;
    private long tiempo;
    private long inicio;
    private long termino;
    private Generador generador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario);

        tv_question = findViewById(R.id.tv_question);
        tv_operacion = findViewById(R.id.tv_operacion);

        radioGroup = findViewById(R.id.radio_group);
        radio_1 = findViewById(R.id.radio_1);
        radio_2 = findViewById(R.id.radio_2);
        radio_3 = findViewById(R.id.radio_3);
        radio_4 = findViewById(R.id.radio_4);

        inicio = System.currentTimeMillis();

        btn_confirm = findViewById(R.id.btn_confirm);

        contador = 1;
        tiempo = 0;

        generarPreguntas(contador);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (radioGroup.getCheckedRadioButtonId() != -1) {
                    RadioButton aux = findViewById(radioGroup.getCheckedRadioButtonId());

                    if (Integer.parseInt(aux.getText().toString()) == generador.confirmarRespuesta()) {
                        Resultado.correctas++;
                    }
                    contador++;
                    if (contador>5){
                        termino = System.currentTimeMillis();
                        tiempo = (termino - inicio);
                        Intent i = new Intent(getApplicationContext(), Resultado.class);
                        i.putExtra("tiempo", tiempo);
                        startActivity(i);
                    } else {
                        generarPreguntas(contador);
                    }
                }

            }
        });

    }

    public void generarPreguntas(int i) {
        Random rdm = new Random();
        generador = new Generador(new Random());
        switch (i) {
            case 1:
                tv_question.setText("Question "+i+":");
                tv_operacion.setText(generador.getN1() + generador.getSigno() + generador.getN2() +"");
                radio_1.setText(generador.confirmarRespuesta()+"");
                radio_2.setText(rdm.nextInt(50)+"");
                radio_3.setText(rdm.nextInt(50)+"");
                radio_4.setText(rdm.nextInt(50)+"");
                break;
            case 2:
                tv_question.setText("Question "+i+":");
                tv_operacion.setText(generador.getN1() + generador.getSigno() + generador.getN2() +"");
                radio_1.setText(rdm.nextInt(50)+"");
                radio_2.setText(generador.confirmarRespuesta()+"");
                radio_3.setText(rdm.nextInt(50)+"");
                radio_4.setText(rdm.nextInt(50)+"");
                break;
            case 3:
                tv_question.setText("Question "+i+":");
                tv_operacion.setText(generador.getN1() + generador.getSigno() + generador.getN2() +"");
                radio_1.setText(rdm.nextInt(50)+"");
                radio_2.setText(rdm.nextInt(50)+"");
                radio_3.setText(generador.confirmarRespuesta()+"");
                radio_4.setText(rdm.nextInt(50)+"");
                break;
            case 4:
                tv_question.setText("Question "+i+":");
                tv_operacion.setText(generador.getN1() + generador.getSigno() + generador.getN2() +"");
                radio_1.setText(rdm.nextInt(50)+"");
                radio_2.setText(rdm.nextInt(50)+"");
                radio_3.setText(rdm.nextInt(50)+"");
                radio_4.setText(generador.confirmarRespuesta()+"");
                break;
            case 5:
                tv_question.setText("Question "+i+":");
                tv_operacion.setText(generador.getN1() + generador.getSigno() + generador.getN2() +"");
                radio_1.setText(generador.confirmarRespuesta()+"");
                radio_2.setText(rdm.nextInt(50)+"");
                radio_3.setText(rdm.nextInt(50)+"");
                radio_4.setText(rdm.nextInt(50)+"");
                break;
            default:
                break;
        }
    }


}
