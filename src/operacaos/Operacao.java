package operacaos;
import models.Acao;
import models.Conta;

import java.util.List;

public abstract class Operacao {
    List<Acao> historicoAcao;
    String idUsuario;

    public abstract void realizar(double valor, Conta... conta);
}