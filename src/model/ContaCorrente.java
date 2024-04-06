package model;
import auxiliares.Credito;
import enumerador.TipoConta;
import enumerador.TipoAcao;

public class ContaCorrente extends Conta {
    public ContaCorrente(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipo(TipoConta.CORRENTE);
    }

    public boolean investir(double valorReal) {
        // Debitar e Creditar
        ContaInvestimento conta = getBanco().getUsuario(getIdUsuario()).ChecaContaInvestimento();
        if (conta.equals(null) || naoDebitou(valorReal))
            return false;
        new Credito().creditar(conta, valorReal);

        conta.setAcao(new Acao(TipoAcao.INVESTIMENTO, valorReal, valorReal, getIdUsuario(), getIdUsuario(), "Crédito"));
        setAcao(new Acao(TipoAcao.INVESTIMENTO, valorReal, valorReal, getIdUsuario(), getIdUsuario(), "Débito"));
        return true;
    }
}