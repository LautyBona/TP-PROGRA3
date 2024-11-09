public class EscritoriosSillas {
    static int N = 4;

    public static void main(String[] args) {
        int[][] tablero = new int[N][N];
        colocarEscritoriosSillas(tablero, 0, 0);
    }

    public static void colocarEscritoriosSillas(int[][] tablero, int fila, int colocados) {
        if (colocados == 2) {
            imprimirTablero(tablero);
            return;
        }

        for (int i = fila; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (esSeguro(tablero, i, j)) {
                    tablero[i][j] = colocados == 0 ? 1 : 2;
                    colocarEscritoriosSillas(tablero, i + 1, colocados + 1);
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
                System.out.print(casilla == 1 ? "E " : casilla == 2 ? "S " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
