package acoes;
import auxiliares.Credito;
import enums_.TipoAcao;
import models.Conta;
import models.Registro;

public class Rendimento extends Acao {
    @Override
    public void realizar(double valor, Conta... conta) {
        double renda = conta[0].getTipoPessoa().calcularRendimento(valor);
        new Credito().creditar(conta[0], renda);
        conta[0].setRegistro(new Registro(TipoAcao.RENDIMENTO, renda, renda, conta[0].getIdUsuario(),
                conta[0].getIdUsuario(), "Renda"));
    }
}