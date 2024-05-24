package br.usp.ime.mac321.lista08.ex1;
import java.math.BigInteger;

public class FatorialController {

    public static BigInteger calcularFatorial(int numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("O número deve ser não-negativo.");
        }
        BigInteger fatorial = BigInteger.ONE;
        for (int i = 1; i <= numero; i++) {
            fatorial = fatorial.multiply(BigInteger.valueOf(i));
        }
        return fatorial;
    }
}