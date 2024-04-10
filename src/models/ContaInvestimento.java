package models;
import acoes.Rendimento;
import enums.TipoConta;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.INVESTIMENTO);
    }

    public void render() {
        new Rendimento().realizar(getSaldo(), this);
    }
} // O rendimento é gerado no início de cada mês