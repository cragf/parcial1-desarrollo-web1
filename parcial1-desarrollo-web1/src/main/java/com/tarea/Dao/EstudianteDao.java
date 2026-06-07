package com.tarea.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tarea.Model.Estudiante;
import com.tarea.conection.ConectionDB;

public class EstudianteDao {
    public ArrayList<Estudiante> cargar(ConectionDB conection) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        String consulta = "SELECT es.IDestudiantes, es.nombre FROM estudiantes es";

        try (PreparedStatement ps = conection.Conectar().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery()) { 

            while (rs.next()) {
                String[] nombre = rs.getString("nombre").split(" ", 2);

                Estudiante estudiante = new Estudiante(null, null, 0);
                estudiante.setId(rs.getInt("IDestudiantes"));
                estudiante.setNombre(nombre[0]);
                estudiante.setApellido(nombre.length > 1 ? nombre[1] : "");
                lista.add(estudiante);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    public Estudiante buscar(ConectionDB conection, String s) { // para tirar de a uno solo cuando carguemos las notas
        Estudiante estudiante = new Estudiante(null, null, 0);
        
        String consulta = "SELECT\r\n" + //
                    "es.IDestudiantes,\r\n" + //
                    "es.nombre\r\n" + //
                    "FROM estudiantes es\r\n" + //
                    "WHERE nombre = '" + s + "'";

    
        try (PreparedStatement ps = conection.Conectar().prepareStatement(consulta)) {
            ResultSet rs = ps.executeQuery();
            String[] nombre = {"",""};

            while (rs.next()) {
                nombre = rs.getString("nombre").split(" ");
                estudiante.setId(rs.getInt("IDestudiantes"));
                estudiante.setNombre(nombre[0]);
                estudiante.setApellido(nombre[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudiante;
    }
    public ArrayList<Estudiante> mostrar(ConectionDB conection, ArrayList<Estudiante> estudiantes) {
        ArrayList<Estudiante> lista = this.cargar(conection);
        
        System.out.printf("%-3s %-15s %-15s%n", 
            "id", "Nombre", "apellido", "Lengua", "Matematica", "Naturales", "Sociales", "Promedio", "Literal"
            );
            System.out.println("==================================================================================================");
        for (Estudiante e: lista) {
            System.out.printf("%-3s %-15s %-15s%n", 
                    e.getNombre()
                );
        }
        
        return lista;
    
    }
}
