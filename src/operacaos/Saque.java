package operacaos;
import enumeradores.TipoAcao;
import models.Acao;
import models.Conta;

public class Saque extends Operacao {
    @Override
    public void realizar(double valor, Conta... conta) {
        historicoAcao = conta[0].getHistoricoDeAcao();
        idUsuario = conta[0].getIdUsuario();
        double valorSolicitado = valor;
        valor = conta[0].calcularValor(valor);
        if (conta[0].debitou(valor))
            historicoAcao.add(new Acao(TipoAcao.SAQUE, valorSolicitado, valor, idUsuario, idUsuario, "Saque"));
    }
}