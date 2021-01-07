package ejercicio8_hilos;

import static ejercicio8_hilos.Contador.imprimir_totales;

/**
 *
 * @author Gabriel Moreno
 */
public class Main extends Thread {

    public Main(String str) {
        super(str);
    }

    public static void main(String[] args) {

        ejercicio8_hilos.Contador c1 = new ejercicio8_hilos.Contador("C:\\Users\\gabri\\OneDrive\\Documentos\\NetBeansProjects\\Hilos\\src\\ejercicio8_hilos\\Fichero1.txt");
        ejercicio8_hilos.Contador c2 = new ejercicio8_hilos.Contador("C:\\Users\\gabri\\OneDrive\\Documentos\\NetBeansProjects\\Hilos\\src\\ejercicio8_hilos\\Fichero2.txt");
        ejercicio8_hilos.Contador c3 = new ejercicio8_hilos.Contador("C:\\Users\\gabri\\OneDrive\\Documentos\\NetBeansProjects\\Hilos\\src\\ejercicio8_hilos\\Fichero3.txt");

        c1.start();
        c2.start();
        c3.start();
        try{
        Thread.sleep(2000);
        }catch(Exception e){
           e.printStackTrace();
        }
        imprimir_totales();
    }
}
