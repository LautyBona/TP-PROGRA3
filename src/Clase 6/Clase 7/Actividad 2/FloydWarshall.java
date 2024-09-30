public class FloydWarshall {

    static final int INF = Integer.MAX_VALUE;

    public static void floydWarshall(int[][] graf) {
        int n = graf.length;

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graf[i][k] != INF && graf[k][j] != INF) {
                        graf[i][j] = Math.min(graf[i][j], graf[i][k] + graf[k][j]);
                    }
                }
            }
        }
    }

    public static void imprimirDistancias(int[][] graf) {
        int n = graf.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graf[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graf[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Inicializar el grafo con tiempos de entrega (en minutos)
        int[][] graf = {
                {0, 2, INF, 5},
                {INF, 0, INF, 4},
                {INF, INF, 0, INF},
                {INF, INF, 2, 0}
        };

        floydWarshall(graf);
        System.out.println("Distancias mínimas entre los centros de distribución:");
        imprimirDistancias(graf);
    }
}
