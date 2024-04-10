package acoes;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class ConsultaSaldo extends AcaoImpl {
    @Override
    public void realizar(double valor, Conta... conta) {
        idUsuario = conta[0].getIdUsuario();
        conta[0].setRegistro(new Registro(TipoAcao.CONSULTA_SALDO, valor, valor, idUsuario, idUsuario, "Consulta"));
    }
}