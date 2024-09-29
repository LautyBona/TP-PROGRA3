import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    long idFactura;
    long idCliente;
    BigInteger importe;

    public Factura(long idFactura, long idCliente, BigInteger importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}
