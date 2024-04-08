package auxiliares;
import models.Conta;

public class Credito {public void creditar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }}