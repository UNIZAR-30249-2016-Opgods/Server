package rest.common;

import java.util.List;

public class JsonArrayDTO {

    private boolean error;
    private String info;
    private List<?> datos;

    public JsonArrayDTO(boolean error, String info, List<?> datos) {
        this.error = error;
        this.info = info;
        this.datos = datos;
    }

    public boolean isError() {
        return error;
    }

    public String getInfo() {
        return info;
    }

    public List<?> getDatos() {
        return datos;
    }

}
