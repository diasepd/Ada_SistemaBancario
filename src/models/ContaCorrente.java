package models;
import enumeradores.TipoConta;
import enumeradores.TipoAcao;

public class ContaCorrente extends Conta {
    public ContaCorrente(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.CORRENTE);
    }

    public void investir(double valorReal) {
//        TipoAcao acao = TipoAcao.INVESTIMENTO;
//        acao.efetuar(getBanco(), getIdUsuario(), valorReal, "");
        ContaInvestimento conta = getBanco().getUsuario(getIdUsuario()).ChecaContaInvestimento();
        if (movimentacao(conta, valorReal, valorReal)) {
            conta.setAcao(new Acao(TipoAcao.INVESTIMENTO, valorReal, valorReal, getIdUsuario(), getIdUsuario(), "Crédito"));
            setAcao(new Acao(TipoAcao.INVESTIMENTO, valorReal, valorReal, getIdUsuario(), getIdUsuario(), "Débito"));
        }
    }
}