package ejercicio9_hilos;
/**
 *
 * @author Gabriel Moreno Fernández
 */
public class Cajera extends Thread {

    private String nombre;

    private Cliente cliente;

    private long initialTime;

    public Cajera() {

    }

    public Cajera(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {

        System.out.println("LA CAJERA " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 10
                + "seg");

        for (int i = 0; i < this.cliente.getCarritos().size(); i++) {
            for (int j = 0; j < this.cliente.getCarritos().get(i).getProductos().size(); j++) {
                this.esperarXsegundos(cliente.getCarritos().get(i).getProductos().get(i).getCodigo());
                System.out.println("Carrito Nº "+(i+1));
                System.out.println("Procesado el producto " + (j + 1)
                        + " del cliente " + this.cliente.getNombre() + "->Tiempo: "
                        + (System.currentTimeMillis() - this.initialTime) / 10
                        + "seg");
            }
        }
        System.out.println("LA CAJERA " + this.nombre + " HA TERMINADO DE PROCESAR "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 10
                + "seg");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 10);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }
}
