package acoes;
import auxiliares.Credito;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Deposito extends AcaoImpl {
    @Override
    public void realizar(double valor, Conta... conta) {
        new Credito().creditar(conta[0], valor);
        idUsuario = conta[0].getIdUsuario();
        conta[0].setRegistro(new Registro(TipoAcao.DEPOSITO, valor, valor, idUsuario, idUsuario, "Deposito"));
    }
}