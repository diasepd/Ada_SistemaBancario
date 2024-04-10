package acoes;
import auxiliares.Movimentacao;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Investimento extends AcaoImpl {
    @Override
    public void realizar(double valor, Conta... conta) {
        if (new Movimentacao().movimentar(conta, valor, valor)) {
            idUsuario = conta[0].getIdUsuario();
            conta[0].setRegistro(new Registro(TipoAcao.INVESTIMENTO, valor, valor, idUsuario, idUsuario, "Débito"));
            conta[1].setRegistro(new Registro(TipoAcao.INVESTIMENTO, valor, valor, idUsuario, idUsuario, "Crédito"));
        }
    }
}