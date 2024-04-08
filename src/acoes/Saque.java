package acoes;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Saque extends Acao {
    @Override
    public void realizar(double valor, Conta... conta) {
        double valorSolicitado = valor;
        valor = conta[0].calcularValor(valor);
        if (conta[0].debitou(valor))
            conta[0].setRegistro(new Registro(TipoAcao.SAQUE, valorSolicitado, valor, conta[0].getIdUsuario(),
                    conta[0].getIdUsuario(), "Saque"));
    }
}