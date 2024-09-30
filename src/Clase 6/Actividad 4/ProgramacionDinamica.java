public class Dinamica {

    // Método para resolver usando programación dinámica
    public static int programacionDinamica(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla dp de abajo hacia arriba
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], ganancias[i - 1] + dp[i - 1][w - costos[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        int maxGanancia = programacionDinamica(costos, ganancias, presupuesto);
        System.out.println("Máxima ganancia (Programación Dinámica): " + maxGanancia);
    }
}
