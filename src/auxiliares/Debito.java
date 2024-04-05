package auxiliares;
import model.Conta;

public class Debito {
    public boolean debitar(Conta conta, double valor) {
        double saldo = conta.getSaldo();
        if (saldo < valor) return false;
        conta.setSaldo(saldo - valor);
        return true;
    }
}
