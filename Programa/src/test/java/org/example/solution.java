package org.example;
/**
 * Clase para calcular las plazas utilizadas en la repesca intercontinental.
 *
 * @author Adrián Boix
 * @version 1.0
 */
public class solution {

    static java.util.Scanner entrada;

    public static void casos_de_prueba() {

        String datos = entrada_datos();
        int vector[] = comprobar_datos(datos);
        int resultado = calculo_resultado(vector);
        mostrar_resultado(resultado);
    }

    public static void main(String[] args) {

        entrada = new java.util.Scanner(System.in);

        int numCasos = entrada.nextInt();
        entrada.nextLine();
        for (int i = 0; i < numCasos; i++)
            casos_de_prueba();
    }

    /**
     * Se introducen los datos.
     *
     * @return datos_entrada - devuelve un valor de tipo String con los datos introducidos.
     */
    public static String entrada_datos(){
        String datos_entrada = entrada.nextLine();
        return datos_entrada;
    }
    /**
     * Valida los datos y la convierte en un vector de enteros.
     *
     * @param datos - es un valor de tipo String con los datos introducidos.
     * @return vector_int - devuelve un vector de enteros que contiene los datos.
     */
    public static int[] comprobar_datos(String datos){


        if (!datos.matches("\\d{1,3} \\d{1,3} \\d{1,3} \\d{1,3} \\d{1,3} \\d{1,3} \\d{1,3}")){
            System.exit(0);
        }
        String[] vector_string = datos.split(" ");

        int[] vector_int = new int[7];

        for(int i = 0; i < vector_string.length; i++){
           vector_int[i] = Integer.parseInt(vector_string[i]);

        }
        int suma = 0;

        for(int i = 1; i < 7; i++){
            suma += vector_int[i];
        }

        if (vector_int[0] < 1 || vector_int[0] > 128 || suma > vector_int[0]){
            System.exit(0);
        }
        return vector_int;
    }

    /**
     * Calcula el número de plazas utilizadas en la repesca intercontinental.
     *
     * @param vector - es un vector de tipo int que contiene el número total de equipos disponibles para el Mundial y las plazas asignadas a cada una de las seis confederaciones continentales en el orden.
     * @return resultado - devuelve el número de plazas utilizadas en la repesca intercontinental.
     */
    public static int calculo_resultado(int vector[]){

        int suma = 0;

        for(int i = 1; i < 7; i++){
            suma += vector[i];
        }

        int resultado = vector[0] - suma;
        return resultado;
    }

    /**
     * Muestar el resultado por pantalla.
     *
     * @param resultado - es un valor int que contiene el número de plazas utilizadas en la repesca intercontinental.
     */
    public static void mostrar_resultado(int resultado){
        System.out.println(resultado);
    }
}

