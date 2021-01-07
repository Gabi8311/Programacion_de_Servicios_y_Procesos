package ejercicio8_hilos;               //Lo que está comentado es de la primera parte del ejercicio

import java.io.BufferedReader;
import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.List;
/**
 *
 * @author Gabriel Moreno
 */
public class Contador extends Thread {

    //private ArrayList<String> direcciones = new ArrayList<String>();
    private String ruta;
    private static Integer contador_letras = 0;
    private static Integer contador_palabras = 0;
    private static Integer contador_lineas = 0;

    public Contador() {
    }

    public Contador(String ruta) {

        this.ruta = ruta;
    }

    public int cuentaLineas(String direccionFile) {

        int num = 0;
        String linea;
        try {
            FileReader fr = new FileReader(direccionFile);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                num++;
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    public int cuentaPalabras(String direccionFile) {

        int num = 0;
        String linea;
        try {
            FileReader fr = new FileReader(direccionFile);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {

                for (int i = 0; i < linea.length(); i++) {
                    if (i == 0) {
                        if (linea.charAt(i) != ' ') {
                            num++;
                        }
                    } else {
                        if (linea.charAt(i - 1) == ' ') {
                            if (linea.charAt(i) != ' ') {
                                num++;
                            }
                        }
                    }
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    public int cuentaChars(String direccionFile) {

        int num = 0;
        int caracterLeido = 0;
        try {
            FileReader fr = new FileReader(direccionFile);
            caracterLeido = fr.read();
            while (caracterLeido != -1) {
                char caracter = (char) caracterLeido;
                if (caracter != ' ') {
                    num++;
                }
                caracterLeido = fr.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    public  void leer_contar_fichero(String fichero) {
        synchronized(contador_letras){
            contador_letras += cuentaChars(fichero);
            System.out.println("El número de letras en el fichero " + this.getName() + " es --> " + cuentaChars(fichero));
        }
        synchronized(contador_palabras){
            contador_palabras += cuentaPalabras(fichero);
                    System.out.println("El número de palabras en el fichero " + this.getName() + " es --> " + cuentaPalabras(fichero));

        }
        synchronized(contador_lineas){
            contador_lineas += cuentaLineas(fichero);
                    System.out.println("El número de líneas en el fichero " + this.getName() + " es --> " + cuentaLineas(fichero));

        }
    }

    public static void imprimir_totales() {

        System.out.println("Total");///////Como hacer que me las sume todas y como mostrarlo sólo una vez
        System.out.println("-----");
        System.out.println(contador_letras + " letras");
        System.out.println(contador_palabras + " palabras");
        System.out.println(contador_lineas + " líneas");

    }

    public void run() {

        leer_contar_fichero(this.getRuta());

        //1ªParte del Ejercicio_8
        //-----------------------
        // ArrayList<String>direcciones = new ArrayList<String>();
        // direcciones.add("C:\\Users\\gabri\\OneDrive\\Documentos\\NetBeansProjects\\Hilos\\src\\ejercicio8_hilos\\Fichero1.txt");
        // direcciones.add("C:\\Users\\gabri\\OneDrive\\Documentos\\NetBeansProjects\\Hilos\\src\\ejercicio8_hilos\\Fichero2.txt");
        // direcciones.add("C:\\Users\\gabri\\OneDrive\\Documentos\\NetBeansProjects\\Hilos\\src\\ejercicio8_hilos\\Fichero3.txt");
        // for (int i = 0;i < direcciones.size();i++){
        //System.out.println("En el fichero Nº "+(i+1)+" hay "+ this.cuentaChars(direcciones.get(i))+" letras");
        //System.out.println("En el fichero Nº "+(i+1)+" hay "+ this.cuentaPalabras(direcciones.get(i))+" palabras");
        //System.out.println("En el fichero Nº "+(i+1)+" hay "+ this.cuentaLineas(direcciones.get(i))+" líneas");
        //}
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
