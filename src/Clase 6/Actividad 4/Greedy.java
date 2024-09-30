import java.util.Arrays;

public class Greedy {

    // Método greedy para maximizar las ganancias
    public static int greedy(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        double[] gananciaPorCosto = new double[n];

        // Calcular la relación ganancia/costo para cada paquete
        for (int i = 0; i < n; i++) {
            gananciaPorCosto[i] = (double) ganancias[i] / costos[i];
        }

        // Ordenar los índices por la relación ganancia/costo en orden descendente
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Double.compare(gananciaPorCosto[b], gananciaPorCosto[a]));

        int gananciaTotal = 0;
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (costos[idx] <= presupuesto) {
                gananciaTotal += ganancias[idx];
                presupuesto -= costos[idx];
            }
        }
        return gananciaTotal;
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int maxGanancia = greedy(costos, ganancias, presupuesto);
        System.out.println("Máxima ganancia (Greedy): " + maxGanancia);
    }
}
