package com.tarea.CLI;

import java.util.ArrayList;
import java.util.Scanner;

import com.tarea.Dao.EstudianteDao;
import com.tarea.Dao.NotasDao;
import com.tarea.Model.Estudiante;
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
            System.out.print("1. Registro de calificaciones\n2. Ver registro de calificaciones por mes\n3. Salir\n" +
                                "================================\n" +
                                "Elija una opcion y pulse ENTER: "
            );
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Registro de calificaciones\n");
                    registrar(con, scanner)
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

                if (lista.isEmpty()) {
                    System.out.println("\nEste mes no tiene ningun registro");
                } else {
                    System.out.printf("%-3s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s%n", 
                    "id", "Nombre", "apellido", "Lengua", "Matematica", "Naturales", "Sociales", "Promedio", "Literal"
                    );
                    System.out.println("==================================================================================================");
                    for (Notas n: lista) {
                        System.out.printf("%-5s %-15s %-15s %-10d %-10d %-10d %-10d %-10d %-10c%n", 
                            n.getId(),
                            n.estudiante.getNombre(),
                            n.estudiante.getApellido(),
                            n.getLengua(), 
                            n.getMatematica(), 
                            n.getNaturales(), 
                            n.getSociales(), 
                            n.getSociales(),
                            n.obtenerLiteral()
                            );
                    }
                }
                
                menu = false;
            } else {
                System.out.println("Mes no valido, intente de nuevo.");
            }
        }
       
    }

    public void registrar(ConectionDB conection, Scanner sca) {
        boolean menu = true;
        String s = "";
        while (menu) {
            System.out.print("\nEscribe el mes al que se le desea agregar el registro: ");
            System.out.println("\n- ene\n- feb\n- mar\n- abr\n- may\n- jun\n- jul\n- ago\n- sep\n- oct\n- nov\n- dic");
            s = sca.nextLine();

            if (s.equals("ene") || s.equals("feb") || s.equals("mar") || s.equals("abr") || s.equals("may") || s.equals("jun") || s.equals("jul") || s.equals("ago") || s.equals("sep") || s.equals("oct") || s.equals("nov") || s.equals("dic")) {
                
                NotasDao notasDao = new NotasDao();
                String nombre = "";
                int[] i = new int[5];
                EstudianteDao ed = new EstudianteDao();

                System.out.println("Ingrese el nombre del estudiante que se agregara al registro de este mes: ");
                    ArrayList<Estudiante> lista = ed.cargar(conection);
                    for (Estudiante o : lista) {
                        System.out.println("- " + o.getNombre() + " " + o.getApellido());
                    }
                nombre = sca.nextLine();

                Estudiante es = ed.buscar(conection, nombre);

                if (es == null || es.getNombre() == null || es.getApellido() == null) {
                    System.out.println("Este estudiante no existe");
                } else if (notasDao.ubicar(s, conection, nombre)) {
                    System.out.println("Este estudiante ya tiene un registro");
                }else {
                    System.out.println("Escriba las notas del estudiante:");
                    System.out.print("Matematica: ");
                    i[0] = (int) pedirNota(sca, "Matematica");
                    System.out.print("Naturales: ");
                    i[1] = (int) pedirNota(sca, "Naturales");
                    System.out.print("Sociales: ");
                    i[2] = (int) pedirNota(sca, "Sociales");
                    System.out.print("Lengua: ");
                    i[3] = (int) pedirNota(sca, "Lengua");
                    sca.nextLine(); // Limpiar el buffer
                    notasDao.registrar(s, conection, sca, i, nombre);
                    menu = false;
                }
                

            } else {
                System.out.println("Mes no valido, intente de nuevo.");
            }
        }
     
    }
    public static double pedirNota(Scanner scanner, String materia) {
        while (true) {
            try {
                double nota = Double.parseDouble(scanner.nextLine().trim());
                if (nota >= 0 && nota <= 100) {
                    return nota;
                }
                System.out.print("La nota de " + materia + " debe estar entre 0 y 100. Intente de nuevo: ");
            } catch (NumberFormatException e) {
                System.out.print(materia + " debe ser un número válido: ");
            }
        }
    }
}
