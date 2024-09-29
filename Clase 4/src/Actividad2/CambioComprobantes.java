package Actividad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CambioComprobantes {

    public static List<Integer> encontrarMinimoComprobantes(int[] monedas, int monto) {
        Arrays.sort(monedas);
        List<Integer> resultado = new ArrayList<>();
        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i];
                resultado.add(monedas[i]);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] comprobantes = {5, 10, 25, 100, 2000, 10000};
        int monto = 39;
        List<Integer> resultado = encontrarMinimoComprobantes(comprobantes, monto);
        System.out.println("Se puede devolver monto exacto: " + resultado);
    }
}