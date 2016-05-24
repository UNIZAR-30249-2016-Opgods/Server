package rest.seccionesparking;

import rest.common.ConexionBBDD;
import rest.common.Ocupacion;
import rest.common.Punto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioSeccionParkingImpl implements RepositorioSeccionParking {

    private Connection conexion;
    private final List<Punto> puntosDeAcceso = new ArrayList<>();

    public RepositorioSeccionParkingImpl() {
        conexion = ConexionBBDD.conectar();
        inicializarAccesos();
    }

    private void inicializarAccesos() {
        this.puntosDeAcceso.clear();
        this.puntosDeAcceso.add(new Punto(41.680372, -0.889839));
        this.puntosDeAcceso.add(new Punto(41.687105, -0.890865));
        this.puntosDeAcceso.add(new Punto(41.688500, -0.883731));
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
                seccionParking = new SeccionParking(
                        rs.getString("id_seccion"),
                        rs.getString("id_centro"),
                        new Punto(rs.getDouble("LOCATIONX"), rs.getDouble("LOCATIONY")),
                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazasocupadas")),
                        puntosDeAcceso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seccionParking;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SeccionParking> obtenerSecciones() {
        List<SeccionParking> secciones = new ArrayList<>();

        try {
            String sql = "SELECT p.id_1 AS id_seccion, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY," +
                    " numplazas, plazasocupadas FROM proyecto.plazas p, proyecto.seccion_parking sp WHERE p.id_1=sp.id";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SeccionParking sptemp = new SeccionParking(
                        rs.getString("id_seccion"),
                        rs.getString("id_centro"),
                        new Punto(rs.getDouble("LOCATIONX"), rs.getDouble("LOCATIONY")),
                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazasocupadas")),
                        puntosDeAcceso);
                secciones.add(sptemp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Collections.sort(secciones);
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

    @Override
    public List<Punto> obtenerPuntosAcceso() {
        return puntosDeAcceso;
    }

}