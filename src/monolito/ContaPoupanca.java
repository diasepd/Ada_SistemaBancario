package monolito;

import java.math.BigDecimal;


public class ContaPoupanca extends ContaImpl{
    public ContaPoupanca(int id, long idUsuario, String dataAtual) {
        super(id, idUsuario, dataAtual);
    }
    @Override
    public void sacar(BigDecimal valor) {

    }
    public void depositar(BigDecimal valor) {

    }
    public void transferir() {

    }
    public void consultarSaldo() {

    }
}
