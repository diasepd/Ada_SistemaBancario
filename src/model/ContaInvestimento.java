package model;
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
        double renda = new Rendimento().Calcular(getSaldo(), getTipoPessoa().getTxRendimentoMensal());
        new Credito().creditar(this, renda);
        getHistoricoDeAcao().add(new Acao(TipoAcao.DEPOSITO, renda, renda, getIdUsuario(), getIdUsuario(), "Renda"));
    }
}
// O rendimento é gerado no início de cada mês