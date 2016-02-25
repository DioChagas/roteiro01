package com.example.chagas.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SaudacaoActivity extends AppCompatActivity {

    private TextView mSaudacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saudacao);
        mSaudacao = (TextView)findViewById(R.id.saudacao);
        Bundle bundle = getIntent().getExtras();
        String saudacao = bundle.getString("nome");
        mSaudacao.setText("Olá "+saudacao+ " você foi cadastrado com sucesso!");

    }
}
