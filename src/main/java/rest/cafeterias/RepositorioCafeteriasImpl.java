package rest.cafeterias;

import rest.common.ConexionBBDD;
import rest.common.Ocupacion;
import rest.common.Punto;
import rest.seccionesparking.SeccionParking;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioCafeteriasImpl implements RepositorioCafeterias {

    private Connection conexion;
    private final List<Punto> puntosDeAcceso = new ArrayList<>();

    public RepositorioCafeteriasImpl() {
        conexion = ConexionBBDD.conectar();
    }


    @Override
    public Cafeteria findById(String id) {
        Cafeteria cafeteria = null;
        try {
            String sql = "SELECT p.id_4 AS id_cafeteria, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY," +
                    " numplazas, plazasocupadas FROM proyecto.cafeteria c, proyecto.planta_0 p WHERE p.id_4=c.id AND p.id_4='" + id + "'";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cafeteria = new Cafeteria(
                        rs.getString("id_Cafeteria"),
                        "cafeteria",
                        new Punto(rs.getDouble("LOCATIONX"), rs.getDouble("LOCATIONY")),
                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazasocupadas")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cafeteria;
    }

    @Override
    public List<Cafeteria> obtenerCafeterias() {
        List<Cafeteria> cafeterias = new ArrayList<>();

        try {
            String sql = "SELECT p.id_4 AS id_cafeteria, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY," +
            " numplazas, plazasocupadas FROM proyecto.cafeteria c, proyecto.planta_0 p WHERE c.id=p.id_4";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cafeteria cafeteria = new Cafeteria(
                        rs.getString("id_Cafeteria"),
                        "cafeteria",
                        new Punto(rs.getDouble("LOCATIONX"), rs.getDouble("LOCATIONY")),
                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazasocupadas")));
                cafeterias.add(cafeteria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Collections.sort(cafeterias);
        return cafeterias;
    }

    @Override
    public void ocuparPlaza(String id) throws Exception {
        Cafeteria cafeteria = findById(id);
        if(cafeteria != null) {
            cafeteria.ocuparPlaza();

            PreparedStatement preparedStmt;
            String query = "UPDATE proyecto.cafeteria SET plazasocupadas = '"
                    + cafeteria.getOcupacion().getOcupadas() + "' where id = '" + id + "'";

            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.executeUpdate();
        }
    }

    @Override
    public void liberarPlaza(String id) throws Exception {
        Cafeteria cafeteria = findById(id);
        if(cafeteria != null) {
            cafeteria.liberarPlaza();

            PreparedStatement preparedStmt;
            String query = "UPDATE proyecto.cafeteria SET plazasocupadas = '"
                    + cafeteria.getOcupacion().getOcupadas() + "' where id = '" + id + "'";

            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.executeUpdate();
        }
    }

}