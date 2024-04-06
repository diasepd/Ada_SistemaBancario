package model;
import auxiliares.Banco;
import enumerador.TipoConta;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipo(TipoConta.POUPANCA);
    }
}