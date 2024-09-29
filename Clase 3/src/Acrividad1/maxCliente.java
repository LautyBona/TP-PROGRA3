package Acrividad1;

public class maxCliente {

    public static Cliente encontrarMaximoCliente(Cliente[] clientes, int inicio, int fin) {

        if (inicio == fin) {
            return clientes[inicio];
        }

        int mitad = (inicio + fin) / 2;

        Cliente maxIzquierda = encontrarMaximoCliente(clientes, inicio, mitad);
        Cliente maxDerecha = encontrarMaximoCliente(clientes, mitad + 1, fin);

        if (maxIzquierda.getScoring() > maxDerecha.getScoring()) {
            return maxIzquierda;
        } else{
            return maxDerecha;
        }
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "juan", 50),
                new Cliente(2, "jose", 75),
                new Cliente(3, "Tini", 60),
                new Cliente(4, "Messi", 85),
                new Cliente(5, "Alexis", 85)
        };

        Cliente maxCliente = encontrarMaximoCliente(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con el scoring máximo: " + maxCliente);
    }
}