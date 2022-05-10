package com.example.cronogramaestudos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AnotacoesActivity extends AppCompatActivity {


    private Button btnAdicionar;
    private ListView anotacoes;
    private List<Agenda> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacoes);

        anotacoes = findViewById(R.id.anotacoes);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnotacoesActivity.this, MainActivity.class);
                startActivity( intent );
            }
        });
        carregarAnotacoes();
    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarAnotacoes();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        carregarAnotacoes();
    }

    private void carregarAnotacoes(){
         lista = AgendaDAO.getAgendamentos(this);

        if( lista.size() == 0 ) {
            Agenda fake = new Agenda("Nenhuma disciplina", "nenhuma tarefa", null);
            lista.add(fake);
            anotacoes.setEnabled(false);
        }{
            anotacoes.setEnabled(true);
        }

            ArrayAdapter adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, lista);
            anotacoes.setAdapter(adapter);

    }

}
