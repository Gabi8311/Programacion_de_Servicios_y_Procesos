package ejercicio9_hilos;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Gabriel Moreno Fernández
 */
public class Main {

	public static void main(String[] args) {
            
            Random r = new Random();
            int clientes_cajeras = 1+r.nextInt(5);
            
            long initialTime = System.currentTimeMillis();
            
            for(int i = 0;i < clientes_cajeras;i++){
                Cliente cliente = new Cliente("Cliente:"+(i+1),new ArrayList());
                cliente.decidir_compra();
                Cajera cajera = new Cajera("Cajera:"+(i+1), cliente, initialTime);
                cajera.start();
            }
	}
} 