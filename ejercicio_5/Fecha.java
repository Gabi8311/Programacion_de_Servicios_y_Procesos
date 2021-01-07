package ejercicio_5;

import java.util.Scanner;
/**
 * @author Gabriel Moreno
 */
public class Fecha implements Comparable<Fecha> {

    private static final int MINDIA = 1440;
    private static final int DIASAÑO = 365;
    private String fecha;

    public Fecha() {

    }

    public Fecha(String fecha) {

        this.fecha = fecha;
    }

    public String introducirFecha() {

        Scanner sc = new Scanner(System.in);
        boolean fechaValida = false;

        do {

            System.out.println("Introduce los dígitos con este formato dd/mm/yyyy");
            this.fecha = sc.next();

            fechaValida = validarFecha(fecha);

        } while (!fechaValida);

        return fecha;
    }

    public boolean validarFecha(String fecha) {

        if (fecha.length() != 10) {
            System.out.println("El formato de la fecha no es el correcto");
            return false;

        } else {

            String[] spliteado;
            String dia;
            String mes;
            String año;

            boolean comprobante = true;

            spliteado = fecha.split("/");

            if (spliteado.length > 3 || spliteado.length < 2) {
                System.out.println("**LA FECHA INTRODUCIDA NO ES CORRECTA**");
                return false;
            }

            dia = spliteado[0];
            Integer num1 = Integer.parseInt(dia);

            if (num1 > 31 || num1 < 1) {

                System.out.println("El dia tiene que estar entre 1 y 30.Introduce bien el dia del mes");
                comprobante = false;
            }

            mes = spliteado[1];
            Integer num2 = Integer.parseInt(mes);

            if (num2 > 12 || num2 < 1) {
                System.out.println("El mes tiene que estar entre 1 y 12.Introduce bien el mes del año");
                comprobante = false;
            }

            año = spliteado[2];
            Integer num3 = Integer.parseInt(año);
            if (num3 > 2020 || num3 < 1950) {
                System.out.println("El año tiene que estar entre 1950 y 2020.Introduce bien el año");
                comprobante = false;
            }

            if (!comprobante) {
                return false;
            }

            switch (num2) {

                case 2:
                    if (num1 > 28) {

                        System.out.println("Este mes tiene 28 días");
                        return false;
                    }
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    if (num1 > 30) {

                        System.out.println("Este mes tiene 30 días");
                        return false;
                    }
                    break;
            }
        }
        System.out.println("La fecha introducida es correcta");

        return true;
    }

    public static String diferenciaMinutos(Fecha f1, Fecha f2) {

        int aux;
        int aux2;

        aux = f1.compareTo(f2);

        if (aux == 1 || aux == -1) {

            String[] spliteado1;
            String[] spliteado2;

            int totalAÑos1;
            int totalMeses1;
            int totalDias1;
            int total1;
            
            int totalAÑos2;
            int totalMeses2;
            int totalDias2;
            int total2;

            spliteado1 = f1.fecha.split("/");
            spliteado2 = f2.fecha.split("/");

            int num3 = Integer.parseInt(spliteado1[2]);
            int num2 = Integer.parseInt(spliteado1[1]);
            int num1 = Integer.parseInt(spliteado1[0]);

            int num6 = Integer.parseInt(spliteado2[2]);
            int num5 = Integer.parseInt(spliteado2[1]);
            int num4 = Integer.parseInt(spliteado2[0]);

            int[] mesesArray = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (aux == 1) {

                totalAÑos1 = ((num3 * DIASAÑO) * MINDIA);
                aux2 = calcularDasMes(mesesArray, num2);
                totalMeses1 = aux2 * MINDIA;
                totalDias1 = num1 * MINDIA;
                total1 = totalAÑos1 + totalMeses1 + totalDias1;

                totalAÑos2 = ((num6 * DIASAÑO) * MINDIA);
                aux2 = calcularDasMes(mesesArray, num5);
                totalMeses2 = aux2 * MINDIA;
                totalDias2 = num4 * MINDIA;
                total2 = totalAÑos2 + totalMeses2 + totalDias2;

                return "La 1ªFecha es mayor y la diferencia,en minutos entre ellas es " + (total1 - total2);
            }

            if (aux == -1) {

                totalAÑos2 = ((num6 * DIASAÑO) * MINDIA);
                aux2 = calcularDasMes(mesesArray, num5);
                totalMeses2 = aux2 * MINDIA;
                totalDias2 = num4 * MINDIA;
                total2 = totalAÑos2 + totalMeses2 + totalDias2;

                totalAÑos1 = ((num3 * DIASAÑO) * MINDIA);
                aux2 = calcularDasMes(mesesArray, num2);
                totalMeses1 = aux2 * MINDIA;
                totalDias1 = num1 * MINDIA;
                total1 = totalAÑos1 + totalMeses1 + totalDias1;

                return "La 2ªFecha es mayor y la diferencia,en minutos entre ellas es " + (total2 - total1);
            }
        }
        return "La 1ªFecha y la 2ªFecha son iguales";
    }

    @Override
    public int compareTo(Fecha f2) {

        if (this.fecha.equals(f2.fecha)) {
            return 0;
        } else {

            String[] split1 = this.fecha.split("/");
            String[] split2 = f2.fecha.split("/");

            int num1 = Integer.parseInt(split1[2]);
            int num2 = Integer.parseInt(split2[2]);

            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
            int num3 = Integer.parseInt(split1[1]);
            int num4 = Integer.parseInt(split2[1]);

            if (num3 > num4) {
                return 1;
            }
            if (num3 < num4) {
                return -1;
            }
            int num5 = Integer.parseInt(split1[0]);
            int num6 = Integer.parseInt(split2[0]);

            if (num5 > num6) {
                return 1;
            }
            if (num5 < num6) {
                return -1;
            }
        }
        return 0;
    }

    public static int calcularDasMes(int[] mesesArray, int num2) {

        int aux2 = 0;

        switch (num2) {
            case 1:
                aux2 = 0;
                break;
            case 2:
                aux2 = mesesArray[0];

                break;
            case 3:
                aux2 = mesesArray[0] + mesesArray[1];
                break;
            case 4:
                aux2 = mesesArray[0] + mesesArray[1] + mesesArray[2];
                break;
            case 5:

                for (int i = 0; i < 4; i++) {
                    aux2 += mesesArray[i];
                }
                break;
            case 6:

                for (int i = 0; i < 5; i++) {
                    aux2 += mesesArray[i];
                }
                break;
            case 7:

                for (int i = 0; i < 6; i++) {
                    aux2 += mesesArray[i];
                }
                break;
            case 8:

                for (int i = 0; i < 7; i++) {
                    aux2 += mesesArray[i];
                }
                break;
            case 9:

                for (int i = 0; i < 8; i++) {
                    aux2 += mesesArray[i];
                }
                break;
            case 10:

                for (int i = 0; i < 9; i++) {
                    aux2 += mesesArray[i];
                }
                break;
            case 11:

                for (int i = 0; i < 10; i++) {
                    aux2 += mesesArray[i];
                }
                break;
            case 12:

                for (int i = 0; i < 11; i++) {
                    aux2 += mesesArray[i];
                }
                break;

        }
        return aux2;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

}
