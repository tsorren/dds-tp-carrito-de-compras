package dominio.cliente;

import dominio.carrito.Carrito;
import dominio.direccion.Direccion;

import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private List<Direccion> direcciones;
    private List<Tarjeta> tarjetas;
    private List<Carrito> carritos;
    private Boolean esPreferencial;

    private static float limiteDeuda;

    public static void setLimiteDeuda(float limiteDeuda) {
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
}