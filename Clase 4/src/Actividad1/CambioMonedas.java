package Actividad1;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CambioMonedas {

    public static boolean encontrarMinimoMonedas(int[] monedas, int monto) {
        Arrays.sort(monedas);
        List<Integer> resultado = new ArrayList<>();
        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i];
                resultado.add(monedas[i]);
            }
        }

        return 0==monto;
    }

    public static void main(String[] args) {
        int[] monedas = {5, 10, 25};
        int monto = 29;
        boolean cantExacta = encontrarMinimoMonedas(monedas, monto);
        System.out.println("Se puede devolver monto exacto: "+ cantExacta);
    }
}