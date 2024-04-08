package models;
import enumeradores.TipoConta;
import enumeradores.TipoAcao;

public class ContaCorrente extends Conta {
    public ContaCorrente(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.CORRENTE);
    }

    public void investir(double valorReal) {
        this.efetuar2(TipoAcao.TRANSFERENCIA, valorReal, getBanco().getUsuario(getIdUsuario()).ChecaContaInvestimento());
    }
}