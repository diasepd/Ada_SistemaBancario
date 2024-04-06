package auxiliares;
import model.Conta;

public class Credito {
    public void creditar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }
}