package enums;
import models.Conta;
import acoes.*;

public enum TipoAcao {
    SAQUE(new Saque()),
    DEPOSITO(new Deposito()),
    TRANSFERENCIA(new Transferencia()),
    INVESTIMENTO(new Investimento()),
    CONSULTA_SALDO(new ConsultaSaldo()),
    RENDIMENTO(new Rendimento());

    final Acao acao;

    TipoAcao(Acao acao) {
        this.acao = acao;
    }

    public void efetuar(double valor, Conta... conta) {
        acao.realizar(valor, conta);
    }
}