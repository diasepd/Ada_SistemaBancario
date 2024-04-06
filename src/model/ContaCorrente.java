package model;
import auxiliares.Banco;
import auxiliares.Credito;
import enumerador.TipoConta;
import enumerador.TipoAcao;

public class ContaCorrente extends Conta {
    public ContaCorrente(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipo(TipoConta.CORRENTE);
    }

    public boolean investir(double valor) {
        if (naoDebitou(valor))
            return false;

        Usuario usuario = getBanco().getUsuario(getIdUsuario());
        if (usuario.getContaInvestimento() == null)
            usuario.setContaInvestimento(new ContaInvestimento(2, getIdUsuario(), getBanco()));

        new Credito().creditar(usuario.getContaInvestimento(), valor);

        setAcao(
                new Acao(TipoAcao.INVESTIMENTO, valor, valor, getIdUsuario(), getIdUsuario(), "Débito"));
        usuario.getContaInvestimento().setAcao(
                new Acao(TipoAcao.INVESTIMENTO, valor, valor, getIdUsuario(), getIdUsuario(), "Crédito"));
        return true;
    }
}