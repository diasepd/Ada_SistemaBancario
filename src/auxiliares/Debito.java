package auxiliares;
import model.Conta;

public class Debito {
    public boolean debitar(Conta conta, double valor) {
        if (conta.getSaldo() < valor)
            return false;
        conta.setSaldo(conta.getSaldo() - valor);
        return true;
    }
}