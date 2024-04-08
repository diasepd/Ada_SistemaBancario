package acoes;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Transferencia extends Acao {
    public void realizar(double valor, Conta... conta) {
        double valorSolicitado = valor;
        valor = conta[0].calcularValor(valor);
        if (conta[0].movimentacao(conta[1], valorSolicitado, valor)) {
            conta[0].setRegistro(new Registro(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, conta[0].getIdUsuario(),
                    conta[1].getIdUsuario(), "Débito"));
            conta[1].setRegistro(new Registro(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, conta[0].getIdUsuario(),
                    conta[1].getIdUsuario(), "Crédito"));
        }
    }
}