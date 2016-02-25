package com.example.chagas.roteiro01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText mNome;
    private EditText mSobreNome;
    private EditText mUsuario;
    private EditText mSenha;
    private EditText mConfSenha;
    private Button mCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mNome = (EditText) findViewById(R.id.nome);
        mSobreNome = (EditText)findViewById(R.id.sobrenome);
        mUsuario = (EditText)findViewById(R.id.usuario);
        mSenha = (EditText)findViewById(R.id.senha);
        mConfSenha = (EditText)findViewById(R.id.confSenha);
        mCadastrar = (Button)findViewById(R.id.cadastrar);

        mCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
    }
    private void cadastrar(){
        View focus = null;
        boolean exibir = false;

        String nome = mNome.getText().toString();
        String sobrenome = mSobreNome.getText().toString();
        String usuario = mUsuario.getText().toString();
        String senha = mSenha.getText().toString();
        String confSenha = mConfSenha.getText().toString();

        if(TextUtils.isEmpty(nome)){
            mNome.setError("Campo vazio!");
            focus = mNome;
            exibir = true;

        }
        if(TextUtils.isEmpty(sobrenome)){
            mSobreNome.setError("Campo vazio!");
            focus = mSobreNome;
            exibir = true;

        }

        if(TextUtils.isEmpty(usuario)){
            mUsuario.setError("Campo vazio!");
            focus = mUsuario;
            exibir = true;
        }


        if (TextUtils.isEmpty(senha)){
            mSenha.setError("Campo vazio!");
            focus = mSenha;
            exibir = true;
        }



        if (TextUtils.isEmpty(confSenha)){
            mConfSenha.setError("Campo vazio!");
            focus = mConfSenha;
            exibir = true;
        }

        if(!senha.equalsIgnoreCase(confSenha)){
            mConfSenha.setError("Senhas não conferem");
            focus = mConfSenha;
            exibir = true;
        }
        if (exibir){
            focus.requestFocus();
        }
        else {
            Intent intent = new Intent(this,SaudacaoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("nome", nome);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }





    }
}
