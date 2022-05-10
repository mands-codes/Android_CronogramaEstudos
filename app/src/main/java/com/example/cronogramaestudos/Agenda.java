package com.example.cronogramaestudos;

public class Agenda
{
    private int id;
    private String materia;
    private String tarefa;
   private String finalizado;

    public Agenda(){

    }

    public Agenda(String materia, String tarefa, String finalizado) {
      this.setMateria(materia);
      this.setTarefa(tarefa);
      this.setFinalizado(finalizado);

    }

    public Agenda(int id, String materia, String tarefa, String finalizado) {
       this.setId(id);
        this.setMateria(materia);
        this.setTarefa(tarefa);
        this.setFinalizado(finalizado);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getFinalizado() {
       return finalizado;
    }

    public void setFinalizado(String finalizado) {
       this.finalizado = finalizado;
    }



    @Override
    public String toString() {
        return "Disciplina: " + materia + '\n' + "Tarefa: " + tarefa + '\n' + "Finalizada: " + finalizado;
    }
}
