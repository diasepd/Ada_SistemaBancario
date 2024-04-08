package acoes;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Investimento extends Acao {
    @Override
    public void realizar(double valor, Conta... conta) {
        if (conta[0].movimentacao(conta[1], valor, valor)) {
            String idUsuario = conta[0].getIdUsuario();
            conta[0].setRegistro(new Registro(TipoAcao.INVESTIMENTO, valor, valor, idUsuario, idUsuario, "Débito"));
            conta[1].setRegistro(new Registro(TipoAcao.INVESTIMENTO, valor, valor, idUsuario, idUsuario, "Crédito"));
        }
    }
}