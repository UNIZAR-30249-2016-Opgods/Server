package rest.cafeterias;

import java.util.List;

public interface RepositorioCafeterias {

    List<Cafeteria> obtenerCafeterias();

    void ocuparPlaza(String id) throws Exception;

    void liberarPlaza(String id) throws Exception;

    Cafeteria findById(String id);

}
