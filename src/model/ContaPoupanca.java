package model;
import enumerador.TipoConta;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.POUPANCA);
    }
}