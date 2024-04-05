package model;
import auxiliares.Banco;
import auxiliares.Credito;
import enumerador.Acao;

public class ContaCorrente extends Conta {
    public ContaCorrente(long id, String idUsuario, Banco banco){
        super(id, idUsuario, banco);
    }

    public boolean investir(double valor) {
        if (naoDebitou(valor))
            return false;

        Usuario usuario = getBanco().getUsuarioArrayList(getIdUsuario());
        if (usuario.getContaInvestimento() == null)
            usuario.setContaInvestimento(new ContaInvestimento(2, getIdUsuario(), getBanco()));

        new Credito().creditar(usuario.getContaInvestimento(), valor);

        setHistoricoAcao(
                new HistoricoAcao(Acao.INVESTIMENTO, valor, valor, getIdUsuario(), getIdUsuario(), "Débito"));
        usuario.getContaInvestimento().setHistoricoAcao(
                new HistoricoAcao(Acao.INVESTIMENTO, valor, valor, getIdUsuario(), getIdUsuario(), "Crédito"));
        return true;
    }
}