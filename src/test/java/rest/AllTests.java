package rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.runners.Suite;
import rest.TestCafeterias.CafeteriasControllerTest;
import rest.TestCafeterias.CafeteriasTest;
import rest.TestCafeterias.RepositorioCafeteriasTest;
import rest.TestCommon.OcupacionTest;
import rest.TestProfesores.ProfesorControllerTest;
import rest.TestProfesores.ProfesoresTest;
import rest.TestProfesores.RepositorioProfesoresTest;
import rest.TestSeccionesParking.ParkingControllerTest;
import rest.TestSeccionesParking.RepositorioSeccionParkingTest;
import rest.TestSeccionesParking.SeccionesParkingTest;


@RunWith(Suite.class)
@SuiteClasses(
        {
                OcupacionTest.class,

                ProfesorControllerTest.class,
                ProfesoresTest.class,
                RepositorioProfesoresTest.class,

                CafeteriasControllerTest.class,
                CafeteriasTest.class,
                RepositorioCafeteriasTest.class,

                ParkingControllerTest.class,
                SeccionesParkingTest.class,
                RepositorioSeccionParkingTest.class
        })
public class AllTests {}