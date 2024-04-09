package enums;
import auxiliares.Multiplicacao;

public enum Classificacao {
    PF(0.01, 1.0),
    PJ(0.02, 1.005);

    final double txRendimentoMensal;
    final double txSacarTransferir;

    Classificacao(double txRendimentoMensal, double txSacarTransferir) {
        this.txRendimentoMensal = txRendimentoMensal;
        this.txSacarTransferir = txSacarTransferir;
    }

    public double getTxRendimentoMensal() { return txRendimentoMensal; }
    public double getTxSacarTransferir() { return txSacarTransferir; }
    public double calcularRendimento(double valor) {
        return new Multiplicacao().Calcular(txRendimentoMensal, valor);
    }
    public double calcularRetirada(double valor, TipoConta tipoConta) {
        return new Multiplicacao().Calcular(tipoConta.equals(TipoConta.CORRENTE) ? txSacarTransferir : 1, valor);
    }
}