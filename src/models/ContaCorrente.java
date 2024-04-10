package models;
import acoes.Investimento;
import enums.TipoConta;

public class ContaCorrente extends Conta {
    private Investimento investimento = new Investimento();

    public ContaCorrente(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.CORRENTE);
    }

    public void investir(double valor) {
        investimento.realizar(valor, this, getBanco().getUsuario(getIdUsuario()).ChecaContaInvestimento());
    }
}