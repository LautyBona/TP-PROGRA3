package Actividad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxMercaderia {
    public static List<Integer> encontrarMaxPeso(int[] pesos, int carga) {
        Arrays.sort(pesos);
        List<Integer> resultado = new ArrayList<>();
        for (int i = pesos.length - 1; i >= 0; i--) {
            while (carga >= pesos[i]) {
                carga -= pesos[i];
                resultado.add(pesos[i]);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] pesos = {5, 10, 25, 100, 200, 1000};
        int cargaMax = 39;
        List<Integer> resultado = encontrarMaxPeso(pesos, cargaMax);
        System.out.println("Se cargaran los siguientes productos: " + resultado);
    }
}
