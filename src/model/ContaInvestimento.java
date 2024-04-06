package model;
import auxiliares.Banco;
import auxiliares.Credito;
import auxiliares.Rendimento;
import enumerador.Acao;
import enumerador.Tipo;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipo(Tipo.INVESTIMENTO);
    }

    public void processarRendimento() {
        double taxa = getBanco().getUsuarioArrayList(getIdUsuario()).getClassificacao().getTaxaRendimentoMensal();
        double renda = new Rendimento().Calcular(getSaldo(), taxa);
        new Credito().creditar(this, renda);
        getHistoricoAcao().add(new HistoricoAcao(Acao.DEPOSITO, renda, renda, getIdUsuario(), getIdUsuario(), "Renda"));
    }
}
//      ● O rendimento é gerado no início de cada mês