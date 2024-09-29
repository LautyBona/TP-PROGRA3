import java.math.BigInteger;

public class Resultado {
    long idCliente;
    BigInteger sumaImportes;

    public Resultado(long idCliente, BigInteger sumaImportes) {
        this.idCliente = idCliente;
        this.sumaImportes = sumaImportes;
    }

    @Override
    public String toString() {
        return "Cliente ID: " + idCliente + ", Suma de Importes: " + sumaImportes;
    }
}
