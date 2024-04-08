package acoes;
import auxiliares.Movimentacao;
import auxiliares.Taxa;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Transferencia extends Acao {
    public void realizar(double valor, Conta... conta) {
        double valorSolicitado = valor;
        valor = new Taxa().calcular(valor, conta[0]);
        if (new Movimentacao().movimentar(conta, valorSolicitado, valor)) {
            conta[0].setRegistro(new Registro(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, conta[0].getIdUsuario(),
                    conta[1].getIdUsuario(), "Débito"));
            conta[1].setRegistro(new Registro(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, conta[0].getIdUsuario(),
                    conta[1].getIdUsuario(), "Crédito"));
        }
    }
}