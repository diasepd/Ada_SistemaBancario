package enumeradores;
import models.Conta;
import operacaos.*;

public enum TipoAcao {
    SAQUE(new Saque()),
    DEPOSITO(new Deposito()),
    TRANSFERENCIA(new Transferencia()),
    INVESTIMENTO(new Investimento()),
    CONSULTA_SALDO(new ConsultaSaldo());

    final Operacao operacao;

    TipoAcao(Operacao operacao) {this.operacao = operacao; }

    public void efetuar(double valor, Conta... conta) {
        operacao.realizar(valor, conta);
    }
}