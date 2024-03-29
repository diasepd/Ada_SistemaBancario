package monolito;
import java.math.BigDecimal;

abstract class ContaImpl implements Conta {
    private enum Status {ATIVA(), INATIVA();}

    private int             id;
    private BigDecimal      saldo  = new BigDecimal(0);
    private HistoricoAcoes  historicoAcoes;
    private String          dataDeAtualizacao;
    private Status          status = Status.ATIVA;
    private long            idUsuario;

    public ContaImpl(int id, long idUsuario, String dataAtual) {
        this.id                = id;
        this.dataDeAtualizacao = dataAtual;
        this.idUsuario         = idUsuario;
    }

    public int            getId()                {return id;}
    public long           getIdUsuario()         {return idUsuario;}
    public String         getDataDeAtualizacao() {return dataDeAtualizacao;}
    public BigDecimal     getSaldo()             {return saldo;}
    public Status         getStatus()            {return status;}
    public HistoricoAcoes getHistoricoAcoes()    {return historicoAcoes;}

    public void           setId(int id)                                    {this.id                = id;}
    public void           setIdUsuario(long idUsuario)                     {this.idUsuario         = idUsuario;}
    public void           setDataDeAtualizacao(String dataDeAtualizacao)   {this.dataDeAtualizacao = dataDeAtualizacao;}
    public void           setSaldo(BigDecimal saldo)                       {this.saldo             = saldo;}
    public void           setStatus(Status status)                         {this.status            = status;}
    public void           setHistoricoAcoes(HistoricoAcoes historicoAcoes) {this.historicoAcoes    = historicoAcoes;}

    public void sacar2(BigDecimal valor) {
        if (valor.compareTo(this.getSaldo()) < 1) saldo.subtract(valor); // valor (0{==} ou -1{<}) que saldo
    }
    public void depositar2(BigDecimal valor) {
        saldo.add(valor);
    }
}