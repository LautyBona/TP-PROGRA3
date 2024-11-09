public class DosReinas {
    static int N = 4;

    public static void main(String[] args) {
        int[][] tablero = new int[N][N];
        colocarReinas(tablero, 0, 0);
    }

    public static void colocarReinas(int[][] tablero, int fila, int reinasColocadas) {
        if (reinasColocadas == 2) {
            imprimirTablero(tablero);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguro(tablero, i, j)) {
                    tablero[i][j] = 1;
                    colocarReinas(tablero, i + 1, reinasColocadas + 1);
                    tablero[i][j] = 0;
                }
            }
        }
    }

    public static boolean esSeguro(int[][] tablero, int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] == 1) return false;
        }

        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) return false;
        }

        for (int i = fila, j = columna; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 1) return false;
        }

        return true;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int casilla : fila) {
                System.out.print(casilla == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
