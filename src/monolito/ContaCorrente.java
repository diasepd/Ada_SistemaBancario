package monolito;

import java.math.BigDecimal;


public class ContaCorrente extends ContaImpl{
    public ContaCorrente(int id, long idUsuario, String dataAtual) {
        super(id, idUsuario, dataAtual);
    }
    @Override
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(this.getSaldo()) < 1) setSaldo(valor); // valor (0{==} ou -1{<}) que saldo
    }
    public void depositar(BigDecimal valor) {

    }
    public void transferir() {

    }
    public void consultarSaldo() {

    }
}