package Actividad3;

public class maxCliente {

    public static Cliente[] encontrarDosMaximosClientes(Cliente[] clientes, int inicio, int fin) {

        // Caso base: si hay un solo cliente, devolvemos ese cliente dos veces
        if (inicio == fin) {
            return new Cliente[]{clientes[inicio], null}; // null para el segundo cliente
        }

        int mitad = (inicio + fin) / 2;

        // Encontrar los dos mayores clientes en la mitad izquierda y derecha
        Cliente[] maxIzquierda = encontrarDosMaximosClientes(clientes, inicio, mitad);
        Cliente[] maxDerecha = encontrarDosMaximosClientes(clientes, mitad + 1, fin);

        // Comparar los máximos y segundos máximos entre las dos mitades
        Cliente primeroMax, segundoMax;

        // Determinar el primer máximo
        if (maxIzquierda[0].getScoring() > maxDerecha[0].getScoring()) {
            primeroMax = maxIzquierda[0];
            // Determinar el segundo máximo
            segundoMax = (maxIzquierda[1] != null && maxIzquierda[1].getScoring() > maxDerecha[0].getScoring()) ? maxIzquierda[1] : maxDerecha[0];
        } else {
            primeroMax = maxDerecha[0];
            // Determinar el segundo máximo
            segundoMax = (maxDerecha[1] != null && maxDerecha[1].getScoring() > maxIzquierda[0].getScoring()) ? maxDerecha[1] : maxIzquierda[0];
        }

        return new Cliente[]{primeroMax, segundoMax};
    }
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Juan", 50),
                new Cliente(2, "Jose", 75),
                new Cliente(3, "Tini", 60),
                new Cliente(4, "Messi", 85),
                new Cliente(5, "Alexis", 85)
        };

        Cliente[] maxClientes = encontrarDosMaximosClientes(clientes, 0, clientes.length - 1);

        System.out.println("Cliente con el scoring máximo: " + maxClientes[0]);
        System.out.println("Cliente con el segundo scoring máximo: " + maxClientes[1]);
    }
}