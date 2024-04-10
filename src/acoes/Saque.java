package acoes;
import auxiliares.Debito;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Saque extends AcaoImpl {
    @Override
    public void realizar(double valor, Conta... conta) {
        double valorSolicitado = valor;
        valor = conta[0].getTipoPessoa().calcularRetirada(valor, conta[0].getTipoConta());
        if (new Debito().debitar(conta[0], valor)) {
            idUsuario = conta[0].getIdUsuario();
            conta[0].setRegistro(new Registro(TipoAcao.SAQUE, valorSolicitado, valor, idUsuario, idUsuario, "Saque"));
        }
    }
}