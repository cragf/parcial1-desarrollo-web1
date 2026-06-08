package com.tarea;

import com.tarea.CLI.Menu;
import com.tarea.conection.ConectionDB;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ConectionDB con = ConectionDB.Getconexion();


        Menu menu = new Menu();
        menu.mostrarMenu(con);

        
    }
}