public class ComputadorasImpresoras {
    static int N = 4;
    static int totalComputadoras = 4;
    static int totalImpresoras = 4;

    public static void main(String[] args) {
        int[][] tablero = new int[N][N];
        colocarComputadorasImpresoras(tablero, 0, 0, 0);
    }

    public static void colocarComputadorasImpresoras(int[][] tablero, int fila, int compColocadas, int impColocadas) {
        if (compColocadas == totalComputadoras && impColocadas == totalImpresoras) {
            imprimirTablero(tablero);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (compColocadas < totalComputadoras && esSeguro(tablero, i, j)) {
                    tablero[i][j] = 1;
                    colocarComputadorasImpresoras(tablero, i + 1, compColocadas + 1, impColocadas);
                    tablero[i][j] = 0;
                }

                if (impColocadas < totalImpresoras && esSeguro(tablero, i, j)) {
                    tablero[i][j] = 2;
                    colocarComputadorasImpresoras(tablero, i + 1, compColocadas, impColocadas + 1);
                    tablero[i][j] = 0;
                }
            }
        }
    }

    public static boolean esSeguro(int[][] tablero, int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] != 0) return false;
        }
        for (int j = 0; j < columna; j++) {
            if (tablero[fila][j] != 0) return false;
        }
        return true;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int casilla : fila) {
                System.out.print(casilla == 1 ? "C " : casilla == 2 ? "I " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
