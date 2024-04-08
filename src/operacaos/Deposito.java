package operacaos;
import auxiliares.Credito;
import enumeradores.TipoAcao;
import models.Acao;
import models.Conta;

public class Deposito extends Operacao {
    @Override
    public void realizar(double valor, Conta... conta) {
        historicoAcao = conta[0].getHistoricoDeAcao();
        idUsuario = conta[0].getIdUsuario();

        new Credito().creditar(conta[0], valor);
        historicoAcao.add(new Acao(TipoAcao.DEPOSITO, valor, valor, idUsuario, idUsuario, "Deposito"));
    }
}
