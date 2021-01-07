package ejercicio9_hilos;

import java.io.Serializable;

/**
 *
 * @author Gabriel Moreno Fernández
 */
public class Producto implements Serializable{
    private Integer codigo;
    private String nombre_producto;

    public Producto() {
    }

    public Producto(Integer codigo, String nombre_producto) {
        
        this.codigo = codigo;
        this.nombre_producto = nombre_producto;
    }
    
    public void pasarlosPorCaja(int codidoProducto){
        
        System.out.println("Nombre del producto --> "+this.getNombre_producto());
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    @Override
    public String toString() {
        return "Producto: " + "\nCodigo --> " + this.codigo + "\nNombre del producto --> " + this.nombre_producto;
    }
    
    
    
}
