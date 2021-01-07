package ejercicio_5;
/**
 * @author Gabriel Moreno
 */
public class Main {

    public static void main(String[] args) {
      
        Fecha fecha1 = new Fecha();
        Fecha fecha2 = new Fecha();
        
        System.out.println("Vamos a calcular los minutos que hay entre dos fechas introducidas por teclado\n");
        System.out.println("Introduce la 1ªFecha");
        fecha1.setFecha(fecha1.introducirFecha());
        System.out.println("Introduce la 2ªFecha");
        fecha2.setFecha(fecha2.introducirFecha());
      
        System.out.println(Fecha.diferenciaMinutos(fecha1,fecha2));
    }
}
  
    
    

