package Actividad4;

import java.util.Arrays;

public class Main {

    // Método principal para encontrar los "n" elementos más grandes
    public static int[] encontrarNMayores(int[] arr, int inicio, int fin, int n) {

        if (inicio == fin) {
            return new int[] { arr[inicio] };
        }

        int mid = (inicio + fin) / 2;
        int[] mayoresIzquierda = encontrarNMayores(arr, inicio, mid, n);
        int[] mayoresDerecha = encontrarNMayores(arr, mid + 1, fin, n);

        return combinarNMayores(mayoresIzquierda, mayoresDerecha, n);
    }

    // Método para combinar los "n" mayores de dos mitades
    private static int[] combinarNMayores(int[] izq, int[] der, int n) {

        int[] combinados = new int[n];
        int i = 0, j = 0, k = 0;


        while (k < n) {
            if (i < izq.length && (j >= der.length || izq[i] >= der[j])) {
                combinados[k++] = izq[i++];
            } else if (j < der.length) {
                combinados[k++] = der[j++];
            } else {

                while (k < n && i < izq.length) {
                    combinados[k++] = izq[i++];
                }
                while (k < n && j < der.length) {
                    combinados[k++] = der[j++];
                }
                break;
            }
        }

        return combinados;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 45, 2, 9, 78, 33 };
        int n = 5;
        int[] resultado = encontrarNMayores(arr, 0, arr.length - 1, n);

        System.out.println("Los " + n + " mayores elementos son: " + Arrays.toString(resultado));
    }
}