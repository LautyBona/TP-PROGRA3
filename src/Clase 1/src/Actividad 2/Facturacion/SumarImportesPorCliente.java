import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SumaImportesPorCliente {

    public static List<Resultado> calcularSumaImportes(List<Factura> facturas, List<Cliente> clientes) {
        List<Resultado> resultados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            BigInteger suma = BigInteger.ZERO;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    suma = suma.add(factura.importe);
                }
            }
            resultados.add(new Resultado(cliente.idCliente, suma));
        }
        return resultados;
    }

    public static void main(String[] args) {
        // Lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Cliente A"));
        clientes.add(new Cliente(2, "Cliente B"));
        clientes.add(new Cliente(3, "Cliente C"));

        // Lista de facturas
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(101, 1, new BigInteger("1500")));
        facturas.add(new Factura(102, 2, new BigInteger("2500")));
        facturas.add(new Factura(103, 1, new BigInteger("3500")));
        facturas.add(new Factura(104, 3, new BigInteger("4500")));
        facturas.add(new Factura(105, 2, new BigInteger("5500")));

        // Calcular y mostrar los resultados
        List<Resultado> resultados = calcularSumaImportes(facturas, clientes);
        for (Resultado res : resultados) {
            System.out.println(res);
        }
    }
