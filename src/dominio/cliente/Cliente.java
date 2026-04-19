package dominio.cliente;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    //private List<Direccion> direcciones;
    //private List<Tarjeta> tarjetas;
    private Boolean esPreferencial;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEsPreferencial() {
        return esPreferencial;
    }

    public void setEsPreferencial(Boolean esPreferencial) {
        this.esPreferencial = esPreferencial;
    }

    /*
    public float getMontoDeuda() {

    }

    public Boolean estaHabilitado {

    }
    */
}