package operacaos;
import enumeradores.TipoAcao;
import models.Acao;
import models.Conta;

public class ConsultaSaldo extends Operacao {
    @Override
    public void realizar(double valor, Conta... conta) {
        historicoAcao = conta[0].getHistoricoDeAcao();
        idUsuario = conta[0].getIdUsuario();
        historicoAcao.add(new Acao(TipoAcao.CONSULTA_SALDO, valor, valor, idUsuario, idUsuario, "Consulta"));
    }
}