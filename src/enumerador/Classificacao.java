package enumerador;

public enum Classificacao {
    PF(0.01, 1.0),
    PJ(0.02, 1.005);

    final double txRendimentoMensal;
    final double txSacarTransferir;

    Classificacao(double txRendimentoMensal, double txSacarTransferir) {
        this.txRendimentoMensal = txRendimentoMensal;
        this.txSacarTransferir = txSacarTransferir;
    }

    public double getTxRendimentoMensal() {
        return txRendimentoMensal;
    }
    public double getTxSacarTransferir() {return txSacarTransferir;}

    @Override
    public String toString() {
        return "Classificacao{" +
                "txRendimentoMensal=" + txRendimentoMensal +
                ", txSacarTransferir=" + txSacarTransferir +
                '}';
    }
}