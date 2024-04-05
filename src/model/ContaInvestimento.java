package model;
import auxiliares.Banco;
import auxiliares.Credito;
import enumerador.Acao;
import enumerador.Classificacao;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(long id, String idUsuario, Banco banco){
        super(id, idUsuario, banco);
    }

    public void rendimento () {
        double valor = getBanco().getUsuarioArrayList(getIdUsuario()).getClassificacao().equals(Classificacao.PJ) ?
                0.02 : 0.01;

        valor *= getSaldo();

        new Credito().creditar(this, valor);
        getHistoricoAcao().add(new HistoricoAcao(Acao.DEPOSITO, valor, valor, getIdUsuario(), getIdUsuario(),
                "Rendimento"));
    }
}
//      ● O rendimento é gerado no início de cada mês