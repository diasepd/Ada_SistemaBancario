package auxiliares;
import models.Conta;
import java.util.Date;

public class Debito {
    public boolean debitar(Conta conta, double valor) {
        if (conta.getSaldo() < valor)
            return false;
        conta.setSaldo(conta.getSaldo() - valor);
        conta.setDataDeAtualizacao(new Date());
        return true;
    }
}