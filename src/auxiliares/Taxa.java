package auxiliares;
import enums.TipoConta;
import models.Conta;

public class Taxa {
    public double calcular(double valor, Conta conta) {
        return conta.getTipoConta().equals(TipoConta.CORRENTE)  ? conta.getTipoPessoa().calcularRetirada(valor) : valor;
    }
}