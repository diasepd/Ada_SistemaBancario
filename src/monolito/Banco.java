package monolito;

import java.math.BigDecimal;

public class Banco {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(12345678910l, "pf", "Eduardo Caldas Dias");
        ContaCorrente contaCorrente1 = usuario1.getContaCorrente();
        contaCorrente1.deposito(new BigDecimal(1));
        contaCorrente1.saque(new BigDecimal(0));
        contaCorrente1.investimento(new BigDecimal(1));
        System.out.println(contaCorrente1.toString());
        ContaInvestimento contaInvestimento = contaCorrente1.getContaInvestimento();
        System.out.println(contaInvestimento.toString());
    }
}
