package com.tarea;

import com.tarea.conection.ConectionDB;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ConectionDB con = ConectionDB.Getconexion();

        Notas principal = new Notas();
        Notas enero = new Notas();
        
        enero.agregarEstudiante("Juan", "Perez", 85, 90, 80, 70);
        enero.agregarEstudiante("Felipe", "Navarro", 86, 95, 89, 92);
        enero.agregarEstudiante("Jessica", "Matamoros", 95, 90, 79, 85);
        enero.agregarEstudiante("María", "Rossi", 94, 86, 88, 80);

        principal.meses.add(enero);

        Menu menu = new Menu();
        menu.mostrarMenu(con);
    }
}