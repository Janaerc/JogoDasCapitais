package com.example.jogodascapitais;

/* ALUNOS: Janaina Keroline Ercole GRR:20204451
            Nicolle Costa  GRR:20205286
            Rafael Tombolato GRR: 20200204
*/


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[][] estadosCapitais = {{"Amapa","Alagoas","Bahia","Pernambuco","Parana","Santa Catarina","Espirito Santo","Mato Grosso","Amazonas", "Tocantins", "Rio Grande do Norte","Piaui","Goias", "Ceara","Para"},
            {"Macapa","Maceio","Salvador","Recife","Curitiba","Florianopolis","Vitoria","Cuiaba","Manaus", "Palmas", "Natal", "Terezina","Goiania","Fortaleza","Belem"}};
    String estado;
    String capital;
    int i, count, pontos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        pontos= 0;
        mostraEstado();

    }

    public void proximaPagina(View view){
        if(count<5){
            mostraEstado();
        }
        else{
            TextView tvEstado = findViewById(R.id.textViewEstado);
            TextView tvResposta = findViewById(R.id.textViewResposta);
            tvResposta.setText("Fim de Jogo!");
            Button btContinuar =  findViewById(R.id.buttonContinuar);
            Button btEnviar =  findViewById(R.id.buttonEnviar);
            btContinuar.setEnabled(false);
            btEnviar.setEnabled(false);
            tvEstado.setText("Acaboooooou!!");
        }
     }
     public void mostraEstado(){
         TextView tvEstado = findViewById(R.id.textViewEstado);
         i = new Random().nextInt(15);
         estado = estadosCapitais[0][i];
         tvEstado.setText("Estado "+ (count+1) + " : " +estado);
         count++;
         Button btEnviar =  findViewById(R.id.buttonEnviar);
         btEnviar.setEnabled(true);
         Button btContinuar =  findViewById(R.id.buttonContinuar);
         btContinuar.setEnabled(false);
         TextView tvResposta = findViewById(R.id.textViewResposta);
         tvResposta.setText("");
         EditText etCapital = findViewById(R.id.editTextCidade);
         etCapital.setText("");
     }

     public void verificaResposta(View view){
         EditText etCapital = findViewById(R.id.editTextCidade);
         String inputCapital = etCapital.getText().toString().toLowerCase();
         capital = estadosCapitais[1][i].toLowerCase();
         if (capital.equals(inputCapital) ){
             System.out.println("entrou");
             TextView tvResposta = findViewById(R.id.textViewResposta);
             tvResposta.setText("Acertou Miseraviii!!");
             pontos=pontos+10;
             TextView tvPontos = findViewById(R.id.textViewPontos);
             tvPontos.setText(pontos+" pontos");
         }
         else{
             TextView tvResposta = findViewById(R.id.textViewResposta);
             tvResposta.setText("ERRRRRRRRRRROU!!!");
             TextView tvPontos = findViewById(R.id.textViewPontos);
             tvPontos.setText(pontos+" pontos");
         }
         Button btEnviar =  findViewById(R.id.buttonEnviar);
         btEnviar.setEnabled(false);
         Button btContinuar =  findViewById(R.id.buttonContinuar);
         btContinuar.setEnabled(true);


     }

}