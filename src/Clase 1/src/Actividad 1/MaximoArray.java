
public class MaximoArray{
    public static int encontrarMaximo(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numeros = {1,2,3,4,5,-1};
        int maximo = encontrarMaximo(numeros);
        System.out.println("El valor máximo del array es: " + maximo);
    }
}


