package models;
import enums.TipoConta;
import enums.TipoAcao;

public class ContaCorrente extends Conta {
    public ContaCorrente(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.CORRENTE);
    }

    public void investir(double valor) {
        TipoAcao.INVESTIMENTO.efetuar(valor, this, getBanco().getUsuario(getIdUsuario()).ChecaContaInvestimento()); }
}