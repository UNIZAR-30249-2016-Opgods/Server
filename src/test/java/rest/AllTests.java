package rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.runners.Suite;
import rest.TestCafeterias.CafeteriasEndPointTest;
import rest.TestCafeterias.CafeteriasTest;
import rest.TestCafeterias.RepositorioCafeteriasTest;
import rest.TestCommon.OcupacionTest;
import rest.TestProfesores.ProfesorEndPointTest;
import rest.TestProfesores.ProfesoresTest;
import rest.TestProfesores.RepositorioProfesoresTest;
import rest.TestSeccionesParking.ParkingEndPointTest;
import rest.TestSeccionesParking.RepositorioSeccionParkingTest;
import rest.TestSeccionesParking.SeccionesParkingTest;


@RunWith(Suite.class)
@SuiteClasses(
        {
                OcupacionTest.class,

                ProfesorEndPointTest.class,
                ProfesoresTest.class,
                RepositorioProfesoresTest.class,

                CafeteriasEndPointTest.class,
                CafeteriasTest.class,
                RepositorioCafeteriasTest.class,

                ParkingEndPointTest.class,
                SeccionesParkingTest.class,
                RepositorioSeccionParkingTest.class
        })
public class AllTests {}
