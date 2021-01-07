package ejercicio9_hilos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Gabriel Moreno Fernández
 */
public class Cliente extends Thread{

    private static File f = new File("C:\\Users\\gabri\\OneDrive\\Documentos\\NetBeansProjects\\Hilos\\carritoNclienteM.txt");

    private String nombre;
    private ArrayList<Carrito> carritos;

    public Cliente() {

    }

    public Cliente(String nombre, ArrayList<Carrito> carritos) {
        this.nombre = nombre;
        this.carritos = carritos;
    }

    public void decidir_compra() {

        Random r = new Random();
        int num_productos;
        int num_carritos;
        int azar;

        num_carritos = 1 + r.nextInt(4);

        for (int j = 0; j < num_carritos; j++) {
            Carrito carrito = new Carrito(new ArrayList());
            num_productos = 1 + r.nextInt(20);
            for (int k = 0; k < num_productos; k++) {
                Producto p = new Producto();
                try {
                    RandomAccessFile raf = new RandomAccessFile(f, "rw");
                    synchronized(raf){
                    raf.seek(0);
                    azar = r.nextInt(20) * 14;//La posición donde se va a situar el puntero
                    raf.seek(azar);
                    p.setNombre_producto(raf.readLine());
                    p.setCodigo(azar / 14);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                carrito.getProductos().add(p);
            }
            File fi = new File("C:\\Users\\gabri\\OneDrive\\Documentos\\NetBeansProjects\\Hilos\\"+"Cliente"+this.getName()+"Carrito"+(j+1)+".dat");
            
            try {
                
                FileOutputStream fos = new FileOutputStream(fi);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                oos.writeObject(carrito);
                
                oos.flush();
                oos.close();
                fos.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.getCarritos().add(carrito);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(ArrayList<Carrito> carritos) {
        this.carritos = carritos;
    }

}
