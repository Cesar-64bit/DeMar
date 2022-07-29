/*
DESCRIPCIÓN: Clase para probar el modelo de pedidos.
DE: Blas Alberto Tejeda Peinado
FECHA CREACIÓN: 28/07/2022
 */
package DeMar.src.pedidos;

public class PruebasModelo {

    public static void main(String[] args) {
        PedidosModelo modPedidos = new PedidosModelo();

        boolean funciono = modPedidos.registrar(3, 1);

        System.out.print("Resultado: " + funciono);
    }
    
}
