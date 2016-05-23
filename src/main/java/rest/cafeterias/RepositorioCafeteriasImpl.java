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
    public SeccionParking findById(String id) {
        SeccionParking seccionParking = null;
        try {
            String sql = "SELECT p.id_1 AS id_seccion, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY," +
                    " numplazas, plazasocupadas FROM proyecto.plazas p, proyecto.seccion_parking sp WHERE p.id_1=sp.id AND p.id_1='" + id + "'";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SeccionParking sptemp = new SeccionParking(
                        rs.getString("id_seccion"),
                        rs.getString("id_centro"),
                        new Punto(rs.getDouble("LOCATIONX"), rs.getDouble("LOCATIONY")),
                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazasocupadas")),
                        puntosDeAcceso);
                seccionParking = sptemp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seccionParking;
    }

    @Override
    public List<Cafeteria> obtenerCafeterias() {
        List<Cafeteria> secciones = new ArrayList<>();

        try {
            String sql = "SELECT p.id_1 AS id_seccion, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY," +
                    " numplazas, plazasocupadas FROM proyecto.plazas p, proyecto.seccion_parking sp WHERE p.id_1=sp.id";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                SeccionParking sptemp = new SeccionParking(
//                        rs.getString("id_seccion"),
//                        rs.getString("id_centro"),
//                        new Punto(rs.getDouble("LOCATIONX"), rs.getDouble("LOCATIONY")),
//                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazasocupadas")),
//                        puntosDeAcceso);
//                secciones.add(sptemp);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Collections.sort(secciones);
        return secciones;
    }

    @Override
    public void ocuparPlaza(String id) throws Exception {
        SeccionParking seccionParking = findById(id);
        if(seccionParking != null) {
            seccionParking.ocuparPlaza();

            PreparedStatement preparedStmt;
            String query = "UPDATE proyecto.seccion_parking SET plazasocupadas = '"
                    + seccionParking.obtenerOcupacion().getOcupadas() + "' where id = '" + id + "'";

            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.executeUpdate();
        }
    }

    @Override
    public void liberarPlaza(String id) throws Exception {
        SeccionParking seccionParking = findById(id);
        if(seccionParking != null) {
            seccionParking.liberarPlaza();

            PreparedStatement preparedStmt;
            String query = "UPDATE proyecto.seccion_parking SET plazasocupadas = '"
                    + seccionParking.obtenerOcupacion().getOcupadas() + "' where id = '" + id + "'";

            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.executeUpdate();
        }
    }

}