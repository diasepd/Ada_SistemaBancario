package acoes;
import auxiliares.Movimentacao;
import enums.TipoAcao;
import models.Registro;
import models.Conta;

public class Transferencia extends AcaoImpl {
    @Override
    public void realizar(double valor, Conta... conta) {
        double valorSolicitado = valor;
        valor = conta[0].getTipoPessoa().calcularRetirada(valor, conta[0].getTipoConta());
        if (new Movimentacao().movimentar(conta, valorSolicitado, valor)) {
           conta[0].setRegistro(new Registro(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, conta[0].getIdUsuario(),
                   conta[1].getIdUsuario(), "Débito"));
           conta[1].setRegistro(new Registro(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, conta[0].getIdUsuario(),
                   conta[1].getIdUsuario(), "Crédito"));
        }
    }
}