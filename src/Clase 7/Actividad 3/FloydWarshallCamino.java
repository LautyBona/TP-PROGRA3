import java.util.Scanner;

public class FloydWarshallCamino {

    static final int INF = Integer.MAX_VALUE;

    public static void floydWarshall(int[][] graf, int[][] predecesor) {
        int n = graf.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graf[i][k] != INF && graf[k][j] != INF) {
                        if (graf[i][j] > graf[i][k] + graf[k][j]) {
                            graf[i][j] = graf[i][k] + graf[k][j];
                            predecesor[i][j] = k; // Guardamos el predecesor
                        }
                    }
                }
            }
        }
    }

    public static void imprimirCamino(int[][] predecesor, int origen, int destino) {
        if (predecesor[origen][destino] == -1) {
            System.out.println("No hay camino desde " + origen + " hasta " + destino);
            return;
        }

        System.out.print("Camino más corto: " + origen);
        while (destino != origen) {
            origen = predecesor[origen][destino];
            System.out.print(" -> " + origen);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] graf = {
                {0, 2, INF, 5},
                {INF, 0, INF, 4},
                {INF, INF, 0, INF},
                {INF, INF, 2, 0}
        };

        int n = graf.length;
        int[][] predecesor = new int[n][n];

        // Inicializar predecesores
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graf[i][j] != INF && i != j) {
                    predecesor[i][j] = i;
                } else {
                    predecesor[i][j] = -1; // No hay predecesor
                }
            }
        }

        floydWarshall(graf, predecesor);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nodo de origen (0 a " + (n - 1) + "): ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el nodo de destino (0 a " + (n - 1) + "): ");
        int destino = scanner.nextInt();

        imprimirCamino(predecesor, origen, destino);
    }
}
