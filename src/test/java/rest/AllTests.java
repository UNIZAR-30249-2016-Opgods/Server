package rest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.runners.Suite;


@RunWith(Suite.class)
@SuiteClasses(
        {
                AppliactionTest.class,
                OcupacionTest.class,
                ProfesorControllerTest.class,
                ProfesoresTest.class,
                RepositorioProfesoresTest.class
        })
public class AllTests {}