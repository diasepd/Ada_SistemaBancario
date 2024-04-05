package model;
import auxiliares.Banco;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(long id, String idUsuario, Banco banco){
        super(id, idUsuario, banco);
    }
}