package rest.seccionesparking;

import rest.common.ConexionBBDD;
import rest.common.Punto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSeccionParkingImpl implements RepositorioSeccionParking {


    private Connection conexion;

    public RepositorioSeccionParkingImpl() {
        conexion = ConexionBBDD.conectar();
    }


    @Override
    public SeccionParking findById(String id) {

        SeccionParking seccionParking = null;
        try {
            String sql = "SELECT p.id_1 AS id_seccion, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY," +
                    " numplazas, plazasocupadas FROM proyecto.plazas p, proyecto.secciones_parking sp WHERE p.id_1=sp.id AND p.id_1='" + id + "'";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SeccionParking sptemp = new SeccionParking(
                        rs.getString("id_seccion"),
                        rs.getString("id_centro"),
                        new Punto(1, rs.getDouble("LOCATIONX"), rs.getDouble("LOCATIONY")),
                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazasocupadas")),null,null);
                seccionParking = sptemp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seccionParking;
    }


    @Override
    public List<SeccionParking> obtenerSecciones() {
        List<SeccionParking> secciones = new ArrayList<>();

        try {
            String sql = "SELECT p.id_1 AS id_seccion, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY," +
                    " numplazas, plazasocupadas FROM proyecto.plazas p, proyecto.secciones_parking sp WHERE p.id_1=sp.id";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SeccionParking sptemp = new SeccionParking(
                        rs.getString("id_seccion"),
                        rs.getString("id_centro"),
                        new Punto(1, rs.getDouble("LOCATIONX"), rs.getDouble("LOCATIONY")),
                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazasocupadas")), null, null);

                System.out.println(rs.getString("id_seccion") + " " + rs.getString("id_centro"));
                System.out.println(rs.getString("LOCATIONX"));
                System.out.println(rs.getString("LOCATIONY"));
                System.out.println("Plazas totales: " + rs.getInt("numPlazas")+ ", Libres: " + rs.getInt("plazasocupadas"));
                System.out.println();

                secciones.add(sptemp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return secciones;
    }

    @Override
    public void ocuparPlaza(String id) throws Exception {
        SeccionParking seccionParking = findById(id);
        if(seccionParking != null) {
            seccionParking.ocuparPlaza();

            PreparedStatement preparedStmt;
            String query = "UPDATE proyecto.secciones_parking SET plazasocupadas = '"
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
            String query = "UPDATE proyecto.secciones_parking SET plazasocupadas = '"
                    + seccionParking.obtenerOcupacion().getOcupadas() + "' where id = '" + id + "'";

            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.executeUpdate();
        }
    }

}