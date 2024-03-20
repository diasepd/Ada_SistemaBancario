package monolito;
import java.math.BigDecimal;

public class ContaPoupanca extends ContaCorrente {
    public ContaPoupanca(int id, BigDecimal saldo, String dataDeAtualizacao, long idUsuario) {
        super(id, idUsuario);
    }
}
