package rest.profesores;

import rest.common.ConexionBBDD;
import rest.common.Localizacion;
import rest.common.Punto;
import rest.simulacion.SimularProfesores;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioProfesoresImpl implements RepositorioProfesores {
    private static final String  PLANTA = "planta_";
    private Connection conexion;

    public RepositorioProfesoresImpl() {
        conexion = ConexionBBDD.conectar();
    }

    @Override
    public List<Profesor> findAll() {
        List<Profesor> profesores = new ArrayList<>();
        try {
            // List<Profesor> profesoresParcial = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                String sql = "SELECT p.id AS id_profesor, nombre, info, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, " +
                        "ST_X(ST_PointOnSurface(geom)) AS LOCATIONY FROM proyecto.profesor p, proyecto.planta_" + i + " pl WHERE p.utcdespacho=pl.id_utc";
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Profesor profesorTemp = new Profesor(rs.getString("id_profesor"),
                            rs.getString("nombre"),
                            false,
                            rs.getString("info"),
                            new Despacho(new Localizacion(new Punto(1, rs.getDouble("LocationX"), rs.getDouble("LOCATIONY")), i, 2), rs.getString("id_centro")));
                    profesores.add(profesorTemp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.sort(profesores);
        return profesores;
    }

    @Override
    public List<Profesor> fuzzyFind(String nombre) {
        List<Profesor> profesores = new ArrayList<>();
        try {
            // List<Profesor> profesoresParcial = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                String sql = "SELECT p.id AS id_profesor, nombre, disponibilidad, info, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, " +
                        "ST_X(ST_PointOnSurface(geom)) AS LOCATIONY FROM proyecto.profesor p, proyecto.planta_" + i + " pl WHERE p.utcdespacho=pl.id_utc";
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Profesor profesorTemp = new Profesor(rs.getString("id_profesor"),
                            rs.getString("nombre"),
                            SimularProfesores.obtenerListaProfesores().get(Integer.parseInt(rs.getString("id_profesor"))).isDisponibilidad(),
                            rs.getString("info"),
                            new Despacho(new Localizacion(new Punto(1, rs.getDouble("LocationX"), rs.getDouble("LOCATIONY")), i, 2), rs.getString("id_centro")));
                    if (profesorTemp.getNombre().toUpperCase().contains(nombre.toUpperCase()))
                        profesores.add(profesorTemp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesores;
    }

    @Override
    public List<Profesor> findFloor(int utcPlanta) {
        List<Profesor> profesores = new ArrayList<>();
        String planta;
        if (utcPlanta >= 0 && utcPlanta <= 4) {
            planta = PLANTA + utcPlanta;
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
                            new Despacho(new Localizacion(new Punto(1, rs.getDouble("LocationX"), rs.getDouble("LOCATIONY")), utcPlanta, 2), rs.getString("id_centro")));
                    profesores.add(profesorTemp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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