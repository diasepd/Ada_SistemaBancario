package operacaos;
import enumeradores.TipoAcao;
import models.Acao;
import models.Conta;
import java.util.List;

public class ConsultaSaldo extends Operacao {
    @Override
    public double realizar(double valor, Conta... conta) {
        List<Acao> historicoAcao = conta[0].getHistoricoDeAcao();
        double saldo = conta[0].getSaldo();
        String idUsuario = conta[0].getIdUsuario();

        historicoAcao.add(new Acao(TipoAcao.CONSULTA_SALDO, saldo, saldo, idUsuario, idUsuario, "Consulta"));
        return 0;
    }
}