package models;
import enums_.TipoConta;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.POUPANCA);
    }
}