package dominio.cliente;

public class Tarjeta {
    private String nombre;
    private MarcaTarjeta MarcaTarjeta;
    private String ultimosDigitos;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MarcaTarjeta getMarcaTarjeta() {
        return MarcaTarjeta;
    }
    public void setMarcaTarjeta(MarcaTarjeta marcaTarjeta) {
        MarcaTarjeta = marcaTarjeta;
    }

    public String getUltimosDigitos() {
        return ultimosDigitos;
    }
    public void setUltimosDigitos(String ultimosDigitos) {
        this.ultimosDigitos = ultimosDigitos;
    }
}
