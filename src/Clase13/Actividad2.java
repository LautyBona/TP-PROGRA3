package Clase13;

public class Actividad2 {

    private static final int N = 6; // Tamaño del tablero (6x6)
    private static final int SUBFILAS = 2; // Filas de subcuadrantes (2x3)
    private static final int SUBCOLUMNAS = 3; // Columnas de subcuadrantes

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        if (solve(board)) {
            printBoard(board);
        } else {
            System.out.println("No hay solución");
        }
    }

    // Método para resolver el Sudoku usando backtracking
    public static boolean solve(int[][] board) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 0) { // Buscar una celda vacía
                    for (int num = 1; num <= N; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) { // Intentar resolver con el número colocado
                                return true;
                            }

                            board[row][col] = 0; // Deshacer si no se encuentra solución
                        }
                    }
                    return false; // Si no hay número válido, retrocede
                }
            }
        }
        return true; // Todas las celdas están llenas correctamente
    }

    // Verifica si es seguro colocar un número en board[row][col]
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Verificar fila
        for (int x = 0; x < N; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Verificar columna
        for (int x = 0; x < N; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Verificar subcuadrante de 2x3
        int startRow = row - row % SUBFILAS;
        int startCol = col - col % SUBCOLUMNAS;
        for (int i = 0; i < SUBFILAS; i++) {
            for (int j = 0; j < SUBCOLUMNAS; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true; // Es seguro colocar el número
    }

    // Método para imprimir el tablero
    public static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
