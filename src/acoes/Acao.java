package acoes;
import models.Conta;





public abstract class Acao {
    String idUsuario;
    public abstract void realizar(double valor, Conta... conta);
}
