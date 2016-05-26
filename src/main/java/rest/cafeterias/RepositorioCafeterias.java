package rest.cafeterias;

import java.util.List;

public interface RepositorioCafeterias {

    List<Cafeteria> obtenerCafeterias();

    boolean actualizarCafeteria(Cafeteria cafeteria) throws Exception;

}
