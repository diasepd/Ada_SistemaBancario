package auxiliares;
import enums.TipoConta;
import models.Conta;

public class Taxa {
    public double calcular(double valor, Conta conta) {
        return conta.getTipoConta().equals(TipoConta.CORRENTE) ?
                new Multiplicacao().Calcular(valor, conta.getTipoPessoa().getTxSacarTransferir()) : valor;
    }
}