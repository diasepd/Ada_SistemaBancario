package acoes;
import models.Conta;

public interface Acao {
    void realizar(double valor, Conta... conta);
}