package model;
import auxiliares.Credito;
import enumerador.TipoConta;
import enumerador.TipoAcao;

public class ContaCorrente extends Conta {
    public ContaCorrente(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipo(TipoConta.CORRENTE);
    }

    public boolean investir(double valor) {
        // Debitar e Creditar
        if (naoDebitou(valor))
            return false;
        ContaInvestimento contaInvest = getBanco().getUsuario(getIdUsuario()).ChecaContaInvestimento();
        new Credito().creditar(contaInvest, valor);

        contaInvest.setAcao(new Acao(TipoAcao.INVESTIMENTO, valor, valor, getIdUsuario(), getIdUsuario(), "Crédito"));
        setAcao(new Acao(TipoAcao.INVESTIMENTO, valor, valor, getIdUsuario(), getIdUsuario(), "Débito"));
        return true;
    }
}