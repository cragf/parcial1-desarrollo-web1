package com.tarea.Model;


public class Notas {

    public Notas(Estudiante estudiante, int id, int lengua, int matematica, int naturales, int sociales) {
        this.id = id;
        this.estudiante = estudiante;
        this.lengua = lengua;
        this.matematica = matematica;
        this.naturales = naturales;
        this.sociales = sociales;
    }
    private int id;
    public Estudiante estudiante;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public char[] literal = {'A', 'B', 'C', 'D', 'F'};
    private int lengua=0, matematica=0, naturales=0, sociales=0;

    public int getSociales() {
        return sociales;
    }
    public void setSociales(int sociales) {
        this.sociales = sociales;
    }
    public int getNaturales() {
        return naturales;
    }
    public void setNaturales(int naturales) {
        this.naturales = naturales;
    }
    public int getMatematica() {
        return matematica;
    }
    public void setMatematica(int matematica) {
        this.matematica = matematica;
    }
    public int getLengua() {
        return lengua;
    }
    public void setLengua(int lengua) {
        this.lengua = lengua;
    }
    public char obtenerLiteral(){
        double promedio = (lengua + matematica + naturales + sociales) / 4;
        if (promedio >= 90) {
            return literal[0];
        } else if (promedio >= 80 && promedio < 90) {
            return literal[1];
        } else if (promedio >= 70 && promedio < 80) {
            return literal[2];
        } else if (promedio >= 60 && promedio < 70) {
            return literal[3];
        } else {
            return literal[4];
        }
    }
    
}
