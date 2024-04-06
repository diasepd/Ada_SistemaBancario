package model;
import auxiliares.Banco;
import auxiliares.Credito;
import auxiliares.Rendimento;
import enumerador.TipoConta;
import enumerador.TipoAcao;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipo(TipoConta.INVESTIMENTO);
    }

    public void processarRendimento() {
        double taxa = getBanco().getUsuario(getIdUsuario()).getClassificacao().getTxRendimentoMensal();
        double renda = new Rendimento().Calcular(getSaldo(), taxa);
        new Credito().creditar(this, renda);
        getHistoricoDeAcoes().add(new Acao(TipoAcao.DEPOSITO, renda, renda, getIdUsuario(), getIdUsuario(), "Renda"));
    }
}
//      ● O rendimento é gerado no início de cada mês