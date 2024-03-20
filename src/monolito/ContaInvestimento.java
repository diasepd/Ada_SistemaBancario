package monolito;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaInvestimento extends ContaCorrente{
    private int            id;
    private BigDecimal     saldo;
    private HistoricoAcoes historicoAcoes;
    private String         dataDeAtualizacao;
    private Status         status;
    private long           idUsuario;

    private enum Status {ATIVA(), INATIVA();}

    public ContaInvestimento(int id, long idUsuario) {
        super(id, idUsuario, null);
        String dataAtual       = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.id                = id;
        this.saldo             = new BigDecimal(0);
        this.dataDeAtualizacao = dataAtual;
        this.status            = Status.ATIVA;
        this.idUsuario         = idUsuario;
    }
}