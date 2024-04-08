package operacaos;
import enumeradores.TipoAcao;
import models.Acao;
import models.Conta;

public class Investimento extends Operacao {
    @Override
    public void realizar(double valor, Conta... conta) {
        historicoAcao = conta[0].getHistoricoDeAcao();
        idUsuario = conta[0].getIdUsuario();
        if (conta[0].movimentacao(conta[1], valor, valor)) {
            conta[0].setAcao(new Acao(TipoAcao.INVESTIMENTO, valor, valor, idUsuario, idUsuario, "Débito"));
            conta[1].setAcao(new Acao(TipoAcao.INVESTIMENTO, valor, valor, idUsuario, idUsuario, "Crédito"));
        }
    }
}