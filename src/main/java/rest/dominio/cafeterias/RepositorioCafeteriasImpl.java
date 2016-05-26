package rest.dominio.cafeterias;

import rest.infraestructura.ConexionBBDD;
import rest.dominio.common.Ocupacion;
import rest.dominio.common.Punto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioCafeteriasImpl implements RepositorioCafeterias {

    private Connection conexion;

    public RepositorioCafeteriasImpl() {
        conexion = ConexionBBDD.conectar();
    }

    @Override
    @SuppressWarnings("unchecked")
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
    public boolean actualizarCafeteria(Cafeteria cafeteria) throws Exception {
        if(cafeteria != null) {
            int ocupacion = cafeteria.getOcupacion().getOcupadas();
            PreparedStatement preparedStmt;
            String query = "UPDATE proyecto.cafeteria SET plazasocupadas = '"
                    + ocupacion + "' where id = '" + cafeteria.getId() + "'";

            preparedStmt = conexion.prepareStatement(query);
            preparedStmt.executeUpdate();
            return true;
        } else return false;
    }

}