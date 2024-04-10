package auxiliares;
import models.Conta;
import java.util.Date;

public class Credito {
    public void creditar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
        conta.setDataDeAtualizacao(new Date());
    }
}