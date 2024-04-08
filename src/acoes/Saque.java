package acoes;
import auxiliares.Debito;
import auxiliares.Taxa;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Saque extends Acao {
    @Override
    public void realizar(double valor, Conta... conta) {
        double valorSolicitado = valor;
        valor = new Taxa().calcular(valor, conta[0]);
        if (new Debito().debitar(conta[0], valor))
            conta[0].setRegistro(new Registro(TipoAcao.SAQUE, valorSolicitado, valor, conta[0].getIdUsuario(),
                    conta[0].getIdUsuario(), "Saque"));
    }
}