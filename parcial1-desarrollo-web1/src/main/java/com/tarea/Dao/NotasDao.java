package com.tarea.Dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.tarea.Model.Estudiante;
import com.tarea.Model.Notas;
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
                        "FROM notas nt\r\n" + //
                        "INNER JOIN estudiantes es on es.IDestudiantes = nt.ID_estudiante\r\n" + //
                        "WHERE nt.mes = '" + mes + "'";

        
        try (PreparedStatement ps = conection.Conectar().prepareStatement(consulta)) {
            ResultSet rs = ps.executeQuery();

            EstudianteDao ed = new EstudianteDao();

            while (rs.next()) {
                Notas nota = new Notas(null, 0, 0, 0, 0, 0);
                nota.estudiante = ed.buscar(conection, rs.getString("nombre"));
                nota.setId(rs.getInt("IDnota"));
                nota.setMatematica(rs.getInt("matematica"));
                nota.setSociales(rs.getInt("sociales"));
                nota.setNaturales(rs.getInt("naturales"));
                nota.setLengua(rs.getInt("lengua"));
                lista.add(nota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return lista;
    
    }
    public boolean ubicar(String mes, ConectionDB conection, String nombre) {
        boolean esta = false;

        try (PreparedStatement ps = conection.Conectar().prepareStatement(
                "SELECT COUNT(*) FROM notas nt " +
                "INNER JOIN estudiantes es ON es.IDestudiantes = nt.ID_estudiante " +
                "WHERE nt.mes = ? AND es.nombre = ?")) {

            ps.setString(1, mes);
            ps.setString(2, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    esta = rs.getInt(1) > 0;
                    System.out.println(esta);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return esta;
    }
    public void registrar(String mes, ConectionDB conection, Scanner sca, int[] i, String nombre) {
        EstudianteDao ed = new EstudianteDao();
        Estudiante es = ed.buscar(conection, nombre);

        i[4] = es.getId();
        String consulta = "INSERT INTO notas(ID_estudiante, matematica, naturales, sociales, lengua, mes)\r\n" + //
                        "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conection.Conectar().prepareStatement(consulta)) {
            ps.setInt(1, i[4]);
            ps.setInt(2, i[0]);
            ps.setInt(3, i[1]);
            ps.setInt(4, i[2]);
            ps.setInt(5, i[3]);
            ps.setString(6, mes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
