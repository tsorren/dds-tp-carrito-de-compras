package dominio.cliente;

import dominio.carrito.Carrito;
import dominio.direccion.Direccion;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private final List<Direccion> direcciones = new ArrayList<>();
    private final List<Tarjeta> tarjetas = new ArrayList<>();
    private final List<Carrito> carritos = new ArrayList<>();
    private Boolean esPreferencial;

    private static Double limiteDeuda;

    public static void setLimiteDeuda(Double limiteDeuda) {
        Cliente.limiteDeuda = limiteDeuda;
    }

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

    //Deuda total del cliente
    public double getMontoDeuda() {
        Double totalDeuda = 0.0;

        for (Carrito carrito: carritos) {
            totalDeuda += carrito.getMontoDeuda();
        }
        // Double total = carritos.stream().map(Carrito::getMontoCarrito).reduce(0.0,Double::sum);
        return totalDeuda;
    }

    public Boolean estaHabilitado () {
        return this.getMontoDeuda() < Cliente.limiteDeuda;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void agregarDireccion(Direccion d) {
        direcciones.add(d);
    }

    public void quitarDireccion(Direccion d) {
        direcciones.remove(d);
    }

    public void agregarTarjeta(Tarjeta t) {
        tarjetas.add(t);
    }

    public void quitarTarjeta(Tarjeta t) {
        tarjetas.remove(t);
    }

    public void agregarCarrito(Carrito c) {
        carritos.add(c);
    }

    public void quitarCarrito(Carrito c) {
        carritos.remove(c);
    }
}