package com.example.tareas;

public class Tarea {
    private int id;
    private String  titulo;
    private boolean completada;

    public Tarea (int id, String titulo, boolean completada){
        this.id = id;
        this.titulo = titulo;
        this.completada = completada;
    }
    public int getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public boolean isCompletada(){
        return completada;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setCompletada(boolean completada){
        this.completada = completada;
    }
}
