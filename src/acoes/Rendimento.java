package acoes;
import auxiliares.Credito;
import enums.TipoAcao;
import models.Conta;
import models.Registro;

public class Rendimento extends AcaoImpl {
    @Override
    public void realizar(double valor, Conta... conta) {
        double renda = conta[0].getTipoPessoa().calcularRendimento(valor);
        new Credito().creditar(conta[0], renda);
        idUsuario = conta[0].getIdUsuario();
        conta[0].setRegistro(new Registro(TipoAcao.RENDIMENTO, renda, renda, idUsuario, idUsuario, "Renda"));
    }
}