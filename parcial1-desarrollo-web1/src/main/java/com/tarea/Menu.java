package com.tarea;

import java.util.ArrayList;
import java.util.Scanner;

import com.tarea.Dao.NotasDao;
import com.tarea.Model.Notas;
import com.tarea.conection.ConectionDB;

public class Menu {
    public void mostrarMenu(ConectionDB con){
        Scanner scanner = new Scanner(System.in);
        
        String opcion = "";
        boolean menu = true;
        while (menu) {
            System.out.println("================================");
            System.out.println("\nCOLEGIO DIOS ES BUENO\nREPORTE MENSUAL DE ESTUDIANTES\n\n" +
                                "================================");
            System.out.print("1. Registro de calificaciones\n2. Registro de calificaciones por mes\n3. Salir\n" +
                                "================================\n" +
                                "Elija una opcion y pulse ENTER: "
            );
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Registro de calificaciones\n");
                    ;
                    break;
                case "2":
                    System.out.println("Reporte de calificaciones por mes\n");
                    mostrarReporte(con, scanner);
                    break;
                case "3":
                    System.out.println("Saliendo del programa...");
                    menu = false;
                    break;
                default: 
                System.out.println("Opcion no valida");
                    break;
            }
        }
        
        scanner.close();
    }
    public void mostrarReporte(ConectionDB con, Scanner sca){
        boolean menu = true;
        String s = "";
        while (menu) {
            System.out.print("\nEscribe el mes del reporte que deseas mostrar: ");
            System.out.println("\n- ene\n- feb\n- mar\n- abr\n- may\n- jun\n- jul\n- ago\n- sep\n- oct\n- nov\n- dic");
            s = sca.nextLine();

            if (s.equals("ene") || s.equals("feb") || s.equals("mar") || s.equals("abr") || s.equals("may") || s.equals("jun") || s.equals("jul") || s.equals("ago") || s.equals("sep") || s.equals("oct") || s.equals("nov") || s.equals("dic")) {
                NotasDao notasDao = new NotasDao();
                ArrayList<Notas> lista = notasDao.mostrar(s, con);
                System.out.printf("%-3s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s%n", 
            "id", "Nombre", "apellido", "Lengua", "Matematica", "Naturales", "Sociales", "Promedio", "Literal"
            );
            System.out.println("==================================================================================================");
            for (Notas n: lista) {
                System.out.printf("%-5s %-15s %-15s %-10d %-10d %-10d %-10d %-10d %-10c%n", 
                    n.getId(),

                    n.getLengua(), 
                    n.getMatematica(), 
                    n.getNaturales(), 
                    n.getSociales(), 
                    n.getSociales(),
                    n.obtenerLiteral()
                    );
            }
                menu = false;
            } else {
                System.out.println("Mes no valido, intente de nuevo.");
            }
        }
       
    }
}
