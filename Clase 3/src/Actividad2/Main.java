package Actividad2;

public class Main {

    public static int[] encontrarDosMayores(int[] arr, int inicio, int fin) {
        // Caso base: si hay solo un elemento
        if (inicio == fin) {
            return new int[] { arr[inicio], Integer.MIN_VALUE };
        }

        // Caso base: si hay dos elementos, devolver el mayor y el segundo mayor
        if (fin - inicio == 1) {
            if (arr[inicio] > arr[fin]) {
                return new int[] { arr[inicio], arr[fin] };
            } else {
                return new int[] { arr[fin], arr[inicio] };
            }
        }

        int mid = (inicio + fin) / 2;
        int[] mayoresIzquierda = encontrarDosMayores(arr, inicio, mid);
        int[] mayoresDerecha = encontrarDosMayores(arr, mid + 1, fin);

        return combinarMayores(mayoresIzquierda, mayoresDerecha);
    }

    private static int[] combinarMayores(int[] izq, int[] der) {
        int mayor, segundoMayor;

        if (izq[0] > der[0]) {
            mayor = izq[0];
            segundoMayor = Math.max(izq[1], der[0]);
        } else {
            mayor = der[0];
            segundoMayor = Math.max(izq[0], der[1]);
        }

        return new int[] { mayor, segundoMayor };
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 45, 2, 9, 78, 33 };
        int[] resultado = encontrarDosMayores(arr, 0, arr.length - 1);
        System.out.println("Mayor: " + resultado[0]);
        System.out.println("Segundo Mayor: " + resultado[1]);
    }
}