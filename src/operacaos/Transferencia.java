package operacaos;
import enumeradores.TipoAcao;
import models.Acao;
import models.Conta;

public class Transferencia extends Operacao {
    @Override
    public void realizar(double valor, Conta... conta) {
        historicoAcao = conta[0].getHistoricoDeAcao();
        idUsuario = conta[0].getIdUsuario();
        String idDestino = conta[1].getIdUsuario();
        double valorSolicitado = valor;
        valor = conta[0].calcularValor(valor);
        if (conta[0].movimentacao(conta[1], valorSolicitado, valor)) {
            conta[0].setAcao(new Acao(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, idUsuario, idDestino, "Débito"));
            conta[1].setAcao(new Acao(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, idUsuario, idDestino, "Crédito"));
        }
    }
}