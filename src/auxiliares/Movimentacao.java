package auxiliares;
import models.Conta;

public class Movimentacao {
    public boolean movimentar(Conta[] conta, double valor, double valorReal) {
        if (conta[1].equals(null) || !new Debito().debitar(conta[0], valorReal))
            return false;
        new Credito().creditar(conta[1], valor);
        return true;
    }
}