package rest.dominio.modelo;

import rest.dominio.entidades.SeccionParking;
import rest.dominio.objetosvalor.Ocupacion;
import rest.dominio.objetosvalor.Punto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSeccionParkingImpl implements RepositorioSeccionParking {


    private Connection conexion;

    public RepositorioSeccionParkingImpl() {
        conexion = ConexionBBDD.conectar();
    }


    @Override
    public SeccionParking findById(String id) {
        return null;
    }


    @Override
    public List<SeccionParking> obtenerSecciones() {
        List<SeccionParking> secciones = new ArrayList<>();

        try {
            String sql = "SELECT p.id_1 AS id_seccion, id_centro, ST_Y(ST_PointOnSurface(geom)) AS LOCATIONX, ST_X(ST_PointOnSurface(geom)) AS LOCATIONY," +
                    " numplazas, plazaslibres FROM proyecto.plazas p, proyecto.secciones_parking sp WHERE p.id_1=sp.id";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SeccionParking sptemp = new SeccionParking(
                        Integer.toString((Integer)rs.getInt("id_seccion")),
                        new Punto(1, rs.getDouble("LocationX"), rs.getDouble("LOCATIONY")),
                        new Ocupacion(rs.getInt("numplazas"), rs.getInt("plazaslibres")));

                System.out.println(rs.getString("id_seccion") + " " + rs.getString("id_centro"));
                System.out.println(rs.getString("LOCATIONX"));
                System.out.println(rs.getString("LOCATIONY"));
                System.out.println("Plazas totales: " + rs.getInt("numPlazas")+ ", Libres: " + rs.getInt("plazaslibres"));
                System.out.println();

                secciones.add(sptemp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return secciones;
    }

    public static void main(String[] args) {
        RepositorioSeccionParkingImpl rep = new RepositorioSeccionParkingImpl();
        List<SeccionParking> secciones = rep.obtenerSecciones();
    }

    @Override
    public void ocuparPlaza(String id) throws Exception {
//        SeccionParking seccionParking = findById(id);
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        seccionParking.ocuparPlaza();
//        session.update(seccionParking);
//        session.getTransaction().commit();
//        session.flush();
//        session.close();
    }

    @Override
    public void liberarPlaza(String id) throws Exception {
//        SeccionParking seccionParking = findById(id);
//        Session session = this.sessionFactory.openSession();
//        session.beginTransaction();
//        seccionParking.liberarPlaza();
//        session.update(seccionParking);
//        session.getTransaction().commit();
//        session.flush();
//        session.close();
    }
}