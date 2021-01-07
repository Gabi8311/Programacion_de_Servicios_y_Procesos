package ejercicio_4;

import java.util.Scanner;
/**
 *
 * @author Gabriel Moreno
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dia;
        String mes;
        String año;
        String fecha;
        String[] spliteado;
        boolean valid = true;

        do {

            System.out.println("Introduce los dígitos con este formato dd/mm/yyyy");
            fecha = sc.next();

            if (fecha.length() != 10) {
                System.out.println("El formato de la fecha no es el correcto");
                valid = false;

            } else {
                spliteado = fecha.split("/");

                if (spliteado.length > 3 || spliteado.length < 2) {
                    System.out.println("**LA FECHA INTRODUCIDA NO ES CORRECTA**");
                    valid = false;
                } else {
                    valid = true;
                }

                if (valid == true) {
                    dia = spliteado[0];
                    Integer num1 = Integer.parseInt(dia);

                    if (num1 > 31 || num1 < 1) {

                        System.out.println("El dia tiene que estar entre 1 y 30.Introduce bien el dia del mes");
                        valid = false;

                    }

                    mes = spliteado[1];
                    Integer num2 = Integer.parseInt(mes);

                    if (num2 > 12 || num2 < 1) {
                        System.out.println("El mes tiene que estar entre 1 y 12.Introduce bien el mes del año");
                        valid = false;
                    }

                    año = spliteado[2];
                    Integer num3 = Integer.parseInt(año);
                    if (num3 > 2020 || num3 < 1950) {
                        System.out.println("El año tiene que estar entre 1900 y 2020.Introduce bien el año");
                        valid = false;
                    }

                    switch (num2) {

                        case 2:
                            if (num1 > 28) {
                                valid = false;
                                System.out.println("Este mes tiene 28 días");
                            }
                            break;

                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            if (num1 > 30) {
                                valid = false;
                                System.out.println("Este mes tiene 30 días");
                            }
                            break;

                    }

                }

            }

        } while (!valid);

        System.out.println("La fecha introducida es correcta");
    }

}
