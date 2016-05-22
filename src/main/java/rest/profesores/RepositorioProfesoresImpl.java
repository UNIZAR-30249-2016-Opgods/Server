package rest.profesores;

import rest.common.ConexionBBDD;
import rest.common.Localizacion;
import rest.common.Punto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioProfesoresImpl implements RepositorioProfesores {
    private Connection conexion;

    public RepositorioProfesoresImpl() {
        conexion = ConexionBBDD.conectar();
    }

    @Override
    public List<Profesor> fuzzyFind(String nombre) {
        List<Profesor> profesores = new ArrayList<>();
        try {
            List<Profesor> profesoresParcial = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                String sql = "SELECT p.id AS id_profesor, nombre, disponibilidad, info, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, " +
                        "ST_X(ST_PointOnSurface(geom)) AS LOCATIONY FROM proyecto.profesor p, proyecto.planta_"+i+" pl WHERE p.utcdespacho=pl.id_utc";
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Profesor profesorTemp = new Profesor(rs.getString("id_profesor"),
                            rs.getString("nombre"),
                            rs.getBoolean("disponibilidad"),
                            rs.getString("info"),
                            new Despacho(new Localizacion(new Punto(1, rs.getDouble("LocationX"), rs.getDouble("LOCATIONY")), 1, 2), rs.getString("id_centro")));
                    profesoresParcial.add(profesorTemp);
                }
            }
            profesores.addAll(profesoresParcial.stream().filter(p -> p.getNombre().toUpperCase().contains(nombre.toUpperCase())).collect(Collectors.toList()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesores;
    }

    @Override
    public List<Profesor> findFloor(int utcPlanta) {
        List<Profesor> profesores = new ArrayList<>();
        String planta = "";
        switch (utcPlanta) {
            case 0:
                planta = "planta_0";
                break;
            case 1:
                planta = "planta_1";
                break;
            case 2:
                planta = "planta_2";
                break;
            case 3:
                planta = "planta_3";
                break;
            case 4:
                planta = "planta_4";
                break;
            default:
                return null;
        }
        if (utcPlanta == 0) {
            planta = "planta_0";
        }
        // EXAMPLE
        //SELECT * FROM proyecto.profesor p, proyecto.planta_0 pl WHERE p.utcdespacho=pl.id_utc
        try {
            String sql = "SELECT p.id AS id_profesor, nombre, disponibilidad, info, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY FROM proyecto.profesor p, proyecto." + planta + " pl WHERE p.utcdespacho=pl.id_utc";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Profesor profesorTemp = new Profesor(rs.getString("id_profesor"),
                        rs.getString("nombre"),
                        rs.getBoolean("disponibilidad"),
                        rs.getString("info"),
                        new Despacho(new Localizacion(new Punto(1, rs.getDouble("LocationX"), rs.getDouble("LOCATIONY")), 1, 2), rs.getString("id_centro")));
                profesores.add(profesorTemp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesores;
    }

    @Override
    public void modificarDisponibilidad(String id) {
        boolean disponibilidad = false;
        try {
            String sql = "SELECT disponibilidad FROM proyecto.profesor WHERE id = '" + id + "'";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                disponibilidad = rs.getBoolean("disponibilidad");
            }
            int disponibilidadInt = disponibilidad ? 0 : 1;

            PreparedStatement preparedStmt;
            String query = "UPDATE proyecto.profesor SET disponibilidad = '" + disponibilidadInt + "' where id = '" + id + "'";

            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}