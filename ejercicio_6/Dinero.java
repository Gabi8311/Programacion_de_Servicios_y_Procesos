package ejercicio_6;

/**
 * @author Gabriel Moreno
 */
public class Dinero implements Comparable<Dinero> {

    private double valor;

    public Dinero() {

    }

    public Dinero(double valor) {

        this.valor = valor;

    }

    @Override
    public int compareTo(Dinero d2) {

        if (this.getValor() > d2.getValor()) {
            return 1;
        }

        if (this.getValor() < d2.getValor()) {
            return -1;
        }

        return 0;
    }

    public static boolean resto(double resto, double pago) {

        resto -= pago;
        resto = (double) Math.round(resto * 100) / 100;
        
        if (resto > 0) {
            System.out.println("Falta por introducir: " + resto);
            return false;
        }

        return true;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {

        if (this.valor > 3.0) {

            String s = "Un billete de " + this.valor + "€";
            return s;

        } else {

            String s = "Una moneda de " + this.valor + "€";
            return s;

        }

    }

}
