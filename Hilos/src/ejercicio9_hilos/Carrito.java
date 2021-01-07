package ejercicio9_hilos;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Gabriel Moreno Fernández
 */
public class Carrito implements Serializable{
    
    private ArrayList<Producto>productos;

    public Carrito() {
    }

    public Carrito(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Carrito:" + "\nProductos --> " + this.productos;
    }
    
    
    
    
    
    
    
}
