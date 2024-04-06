package enumerador;

import model.Usuario;

public enum Classificacao {
    PF(0.01),
    PJ(0.02);

    final double taxaRendimentoMensal;

    Classificacao(double taxa) {
        this.taxaRendimentoMensal = taxa;
    }

    public double getTaxaRendimentoMensal() {
        return taxaRendimentoMensal;
    }
}
