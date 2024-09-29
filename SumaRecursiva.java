public class SumaRecursiva {

    public static int sumarN(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumarN(n - 1);
    }

    public static void main(String[] args) {
        int n = 8;
        int resultado = sumarN(n);
        System.out.println("La suma de los primeros " + n + " números enteros es: " + resultado);
    }
}
