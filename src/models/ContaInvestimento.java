package models;
import acoes.Rendimento;
import enums.TipoConta;

public class ContaInvestimento extends Conta {
    private Rendimento rendimento = new Rendimento();

    public ContaInvestimento(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.INVESTIMENTO);
    }

    public void render() {
        rendimento.realizar(getSaldo(), this);
    }
} // O rendimento é gerado no início de cada mês