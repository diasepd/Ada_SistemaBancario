package operacaos;
import models.Conta;

public abstract class Operacao {
    double resultado = 0;

    public abstract double realizar(double valor, Conta... conta);
}