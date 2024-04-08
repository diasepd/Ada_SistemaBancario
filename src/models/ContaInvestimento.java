package models;
import auxiliares.Credito;
import auxiliares.Multiplicacao;
import enums.TipoConta;
import enums.TipoAcao;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.INVESTIMENTO);
    }

    public void processarRendimento() {
        double renda = new Multiplicacao().Calcular(getSaldo(), getTipoPessoa().getTxRendimentoMensal());
        new Credito().creditar(this, renda);
        setRegistro(new Registro(TipoAcao.DEPOSITO, renda, renda, getIdUsuario(), getIdUsuario(), "Renda"));
    }
} // O rendimento é gerado no início de cada mês