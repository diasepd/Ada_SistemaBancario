package monolito;
import java.math.BigDecimal;

public class ContaCorrente {
    private int               id;
    private BigDecimal        saldo;
    private HistoricoAcoes    historicoAcoes;
    private String            dataDeAtualizacao;
    private Status            status;
    private long              idUsuario;
    private ContaInvestimento contaInvestimento;

    private enum Status {ATIVA(), INATIVA();}

    public ContaCorrente(int id, long idUsuario, String dataAtual) {
        this.id                = id;
        this.saldo             = new BigDecimal(0);
        this.dataDeAtualizacao = dataAtual;
        this.status            = Status.ATIVA;
        this.idUsuario         = idUsuario;
    }

    public int               getId()                { return id;                }
    public BigDecimal        getSaldo()             { return saldo;             }
    public HistoricoAcoes    getHistoricoAcoes()    { return historicoAcoes;    }
    public String            getDataDeAtualizacao() { return dataDeAtualizacao; }
    public Status            getStatus()            { return status;            }
    public long              getIdUsuario()         { return idUsuario;         }
    public ContaInvestimento getContaInvestimento() { return contaInvestimento; }

    public void setId(int id)                                             { this.id = id;                               }
    public void setSaldo(BigDecimal saldo)                                { this.saldo = saldo;                         }
    public void setHistoricoAcoes(HistoricoAcoes historicoAcoes)          { this.historicoAcoes = historicoAcoes;       }
    public void setDataDeAtualizacao(String dataDeAtualizacao)            { this.dataDeAtualizacao = dataDeAtualizacao; }
    public void setStatus(Status status)                                  { this.status = status;                       }
    public void setIdUsuario(long idUsuario)                              { this.idUsuario = idUsuario;                 }
    public void setContaInvestimento(ContaInvestimento contaInvestimento) { this.contaInvestimento = contaInvestimento; }

    public void saque(BigDecimal valor) { if (valorNaoMaiorSaldo(valor)) saldo = saldo.subtract(valor); }
    public void deposito(BigDecimal valor) {
        saldo = saldo.add(valor);
    }
    public void transferencia(BigDecimal valor, long id) {}
    public void investimento(BigDecimal valor) {
        if (valorNaoMaiorSaldo(valor)) {
            if (contaInvestimento == null) {
                contaInvestimento = new ContaInvestimento(id, idUsuario);
            }
            saque(valor);
            contaInvestimento.deposito(valor);
        }
    }
    public void consultaSaldo() {}
    private boolean valorNaoMaiorSaldo(BigDecimal valor) { return saldo.compareTo(valor) != -1; }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", historicoAcoes=" + historicoAcoes +
                ", dataDeAtualizacao='" + dataDeAtualizacao + '\'' +
                ", status=" + status +
                ", idUsuario=" + idUsuario +
                '}';
    }
}