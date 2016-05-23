package rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.runners.Suite;
import rest.TestCommon.OcupacionTest;
import rest.TestProfesores.ProfesorControllerTest;
import rest.TestProfesores.ProfesoresTest;
import rest.TestProfesores.RepositorioProfesoresTest;


@RunWith(Suite.class)
@SuiteClasses(
        {
                OcupacionTest.class,
                ProfesorControllerTest.class,
                ProfesoresTest.class,
                RepositorioProfesoresTest.class
        })
public class AllTests {}