package acoes;
import auxiliares.Credito;
import enums.TipoAcao;
import models.Registro;
import models.Conta;


public class Deposito extends Acao {
    @Override
    public void realizar(double valor, Conta... conta) {
        idUsuario = conta[0].getIdUsuario();
        new Credito().creditar(conta[0], valor);
        conta[0].setRegistro(new Registro(TipoAcao.DEPOSITO, valor, valor, idUsuario, idUsuario, "Deposito"));
    }
}