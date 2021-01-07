package ejercicio_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * @author Gabriel Moreno
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Dinero> dinero = new ArrayList<>();
        ArrayList<Dinero> cambioDinero = new ArrayList<>();

        introducirDinero(dinero, 20, 0.01);
        introducirDinero(dinero, 40, 0.02);
        introducirDinero(dinero, 40, 0.05);
        introducirDinero(dinero, 20, 0.10);
        introducirDinero(dinero, 20, 0.20);
        introducirDinero(dinero, 10, 0.50);
        introducirDinero(dinero, 5, 10);
        introducirDinero(dinero, 5, 20);
        introducirDinero(dinero, 2, 50);

        double importe;
        double vuelta;
        double pago;
        int opc;
        int opc1 = 1;
        int opc2;
        boolean cerrado = false;

        do {

            pago = 0;
            importe = 0;
            vuelta = 0;
            cambioDinero.clear();  //Limpiamos el ArrayList para el próximo cliente
            Collections.sort(dinero, Collections.reverseOrder());

            System.out.println("Cliente Nº" + opc1);
            System.out.println("Introduce el importe de la compra");
            importe = sc.nextDouble();

            while (importe <= 0.0) {

                System.out.println("**IMPORTE INCORRECTO.DEBE SER MAYOR A CERO**");
                System.out.println("Cliente Nº" + opc1);
                System.out.println("Introduce el importe de la compra");
                importe = sc.nextDouble();
            }
            System.out.println("Introduce el dinero con el que vas a pagar");

            do {

                double resto = importe;

                if (resto <= 0) {
                    opc = -30;
                }

                System.out.println("1.Billetes          2.Monedas");
                opc = sc.nextInt();

                if (opc == 1) {
                    System.out.println("Qué tipo de billete?");
                    System.out.println("1.5€      2.10€      3.20€      4.50€      5.100€      6.200€      7.500€");
                    opc2 = sc.nextInt();

                    switch (opc2) {

                        case 1:
                            introducirDinero(dinero, 1, 5);
                            pago += 5;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 2:
                            introducirDinero(dinero, 1, 10);
                            pago += 10;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 3:
                            introducirDinero(dinero, 1, 20);
                            pago += 20;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 4:
                            introducirDinero(dinero, 1, 50);
                            pago += 50;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 5:
                            introducirDinero(dinero, 1, 100);
                            pago += 100;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 6:
                            introducirDinero(dinero, 1, 200);
                            pago += 200;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 7:
                            introducirDinero(dinero, 1, 500);
                            pago += 500;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        default:
                            System.out.println("**OPCIÓN INCORRECTA**");
                            break;
                    }
                } else if (opc == 2) {

                    System.out.println("Qué tipo de moneda?");
                    System.out.println("1.1cent    2.2cent    3.5cent    4.10cent    5.20cent    6.50cent    7.1€    8.2€");
                    opc2 = sc.nextInt();

                    switch (opc2) {

                        case 1:
                            introducirDinero(dinero, 1, 0.01);
                            pago += 0.01;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 2:
                            introducirDinero(dinero, 1, 0.02);
                            pago += 0.02;
                            if (Dinero.resto(resto, pago)) {
                                opc = 3;
                            }
                            break;

                        case 3:
                            introducirDinero(dinero, 1, 0.05);
                            pago += 0.05;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 4:
                            introducirDinero(dinero, 1, 0.10);
                            pago += 0.10;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 5:
                            introducirDinero(dinero, 1, 0.20);
                            pago += 0.20;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 6:
                            introducirDinero(dinero, 1, 0.50);
                            pago += 0.50;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 7:
                            introducirDinero(dinero, 1, 1);
                            pago += 1;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        case 8:
                            introducirDinero(dinero, 1, 2);
                            pago += 2;
                            if (Dinero.resto(resto, pago)) {
                                opc = -30;
                            }
                            break;

                        default:
                            System.out.println("**OPCIÓN INCORRECTA**");
                            break;
                    }

                } else {
                    System.out.println("**OPCIÓN INCORRECTA**");
                }
            } while (opc != -30);

            vuelta = pago - importe;

            do {

                Collections.sort(dinero, Collections.reverseOrder());

                vuelta = (double) Math.round(vuelta * 100) / 100;  //Comprobamos que nuestra vuelta es un double con 2 decimales

                System.out.println("Su vuelta --->  " + vuelta);

                for (int i = 0; i < dinero.size(); i++) {

                    if (dinero.get(i).getValor() > -1) {

                        if (vuelta - dinero.get(i).getValor() >= 0) {

                            if (vuelta >= dinero.get(i).getValor()) {
                                vuelta -= dinero.get(i).getValor();
                                vuelta = (double) Math.round(vuelta * 100) / 100;//Déspues de restar lo compruebo porque me ha dado 
                                cambioDinero.add(dinero.get(i));                 //muchos fallos (Ejemplo->23-10=12,99999999997)
                                dinero.set(i, new Dinero(-1));
                            }
                        }
                    }
                }

                if (vuelta != 0) {        //Comprobamos que si no es 0 es que no hemos tenido cambio para darle al cliente 
                    System.out.println("No hemos quedado sin cambio,tiene que pagar con tarjeta");
                    vuelta = importe;     //Asignamos el importe a la vuelta para devolver el dinero introducido si no hemos tenido
                    cerrado = true;       //suficiente cambio para devolver al cliente

                    for (Dinero i : cambioDinero) {//Añadimos otra vez el dinero que le ibamos a devolver a nuestra caja 
                        dinero.add(i);
                    }
                    cambioDinero.clear();  //Y vaciamos el ArrayList del cambio al cliente

                } else {

                    cerrado = false;
                }

            } while (cerrado);

            for (Dinero j : cambioDinero) {
                System.out.println(j.toString());
            }

            opc1++;

        } while (opc1 != 4);

        System.out.println("\n*******");
        System.out.println("* FIN *");
        System.out.println("*******");

        sc.close();

    }

    public static void introducirDinero(ArrayList<Dinero> dinero, int numero, double valor) {

        for (int i = 0; i < numero; i++) {

            Dinero m = new Dinero(valor);
            dinero.add(m);

        }

    }

}
