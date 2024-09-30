import java.util.ArrayList;
import java.util.List;

public class FuerzaBruta {

    // Método para evaluar todas las combinaciones posibles (fuerza bruta)
    public static int fuerzaBruta(int[] costos, int[] ganancias, int presupuesto) {
        return calcularMaximo(0, costos, ganancias, presupuesto);
    }

    // Método recursivo para calcular el máximo beneficio
    private static int calcularMaximo(int i, int[] costos, int[] ganancias, int presupuesto) {
        if (i == costos.length) {
            return 0;
        }

        // Omitir el paquete actual
        int sinPaquete = calcularMaximo(i + 1, costos, ganancias, presupuesto);

        // Incluir el paquete actual si su costo no excede el presupuesto
        int conPaquete = 0;
        if (costos[i] <= presupuesto) {
            conPaquete = ganancias[i] + calcularMaximo(i + 1, costos, ganancias, presupuesto - costos[i]);
        }

        return Math.max(sinPaquete, conPaquete);
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int maxGanancia = fuerzaBruta(costos, ganancias, presupuesto);
        System.out.println("Máxima ganancia (Fuerza Bruta): " + maxGanancia);
    }
}
