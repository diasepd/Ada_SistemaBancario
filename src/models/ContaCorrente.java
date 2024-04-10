package models;
import acoes.Investimento;
import enums.TipoConta;

public class ContaCorrente extends Conta {
    public ContaCorrente(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.CORRENTE);
    }

    public void investir(double valor) {
        new Investimento().realizar(valor, this, getBanco().getUsuario(getIdUsuario()).ChecaContaInvestimento());
    }
}