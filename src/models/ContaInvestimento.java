package models;
import enums.TipoConta;
import enums.TipoAcao;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(long id, String idUsuario, Banco banco) {
        super(id, idUsuario, banco);
        setTipoConta(TipoConta.INVESTIMENTO);
    }

    public void render() {
        TipoAcao.RENDIMENTO.efetuar(getSaldo(), this);
    }
} // O rendimento é gerado no início de cada mês