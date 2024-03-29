package monolito;
import java.math.BigDecimal;

class Banco {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(12345678910l, "pf", "Eduardo Caldas Dias");
        System.out.println(usuario1.getContaCorrente().getSaldo());
        usuario1.getContaCorrente().depositar2(new BigDecimal(10));
        System.out.println(usuario1.getContaCorrente().getSaldo());
        usuario1.getContaCorrente().sacar2(new BigDecimal(5));
        System.out.println(usuario1.getContaCorrente().getSaldo());
    }
}
