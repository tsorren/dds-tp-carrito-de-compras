package dominio.carrito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String EAN13;
    private String nombre;
    private final List<PrecioProducto> preciosHistoricos = new ArrayList<>();
    
    public String getEAN13() { return EAN13; }
    public void setEAN13(String EAN13) {this.EAN13 = EAN13;}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {this.nombre = nombre;}

    //public String getNombreCorto() { return }
    public Double getPrecio (LocalDate fechaVigencia){
        for (PrecioProducto a : preciosHistoricos){
            if (a.getCumpleVigencia(fechaVigencia)){
                return a.getPrecio();
            }
        }
        return null;
    }

    public void agregarNuevoPrecio(PrecioProducto precio) {
        this.preciosHistoricos.add(precio);
    }
}
