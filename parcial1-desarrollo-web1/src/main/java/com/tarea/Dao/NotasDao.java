package com.tarea.Dao;

import java.util.ArrayList;

import com.tarea.Notas;
import com.tarea.conection.ConectionDB;

public class NotasDao {
    public ArrayList<Notas> mostrar(String mes, ConectionDB conection) {
        ArrayList<Notas> lista = new ArrayList<>();
         String consulta = "SELECT\r\n" + //
                        "nt.IDnota,\r\n" + //
                        "es.nombre,\r\n" + //
                        "nt.matematica,\r\n" + //
                        "nt.sociales,\r\n" + //
                        "nt.naturales,\r\n" + //
                        "nt.lengua\r\n" + //
                        "FROM notas nt\\r\\n" + //
                        "LEFT JOIN estudiantes es on es.IDestudiantes = nt.ID_estudiante";

        System.out.printf("%-5s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s%n", 
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
        
        return lista;
    
    }
}
