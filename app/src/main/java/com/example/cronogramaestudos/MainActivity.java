package com.example.cronogramaestudos;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
 private Button btnSalvar;
 private EditText editMateria;
 private EditText editTarefa;
 private CheckBox finalizado;
 private Agenda agenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvar = findViewById(R.id.btnSalvar);
        editMateria = findViewById(R.id.editMateria);
        editTarefa = findViewById((R.id.editTarefa));
        finalizado = findViewById(R.id.chckFinalizado);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Salvar();

               finish();
            }
        });
    }

    private void Salvar(){
        String materia = editMateria.getText().toString();
        String tarefa = editTarefa.getText().toString();
        if(!materia.isEmpty()){
            agenda = new Agenda();
            agenda.setMateria(materia);
            agenda.setTarefa(tarefa);
            if(finalizado.isChecked()){
                agenda.setFinalizado("Sim");
            }else{
                agenda.setFinalizado("Não");
            }
            AgendaDAO.inserir(this, agenda);
        }

    }


}