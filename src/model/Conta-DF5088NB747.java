package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta {
    private enum Status {ATIVA(), INATIVA();}

    private Long                id;
    private double              saldo;
    private List<HistoricoAcao> historicoAcaoList = new ArrayList<>();
    private Date                dataDeAtualizacao;
    private Status              status            = Status.ATIVA;
    private String              idUsuario;

    public Conta(Long id, String idUsuario, Date dataAtual) {
        this.id                = id;
        this.dataDeAtualizacao = dataAtual;
        this.idUsuario         = idUsuario;
    }

    public Long                getId()                {return id;               }
    public double              getSaldo()             {return saldo;            }
    public List<HistoricoAcao> getHistoricoAcaoList() {return historicoAcaoList;}
    public Date                getDataDeAtualizacao() {return dataDeAtualizacao;}
    public Status              getStatus()            {return status;           }
    public String              getIdUsuario()         {return idUsuario;        }

    public void setId(Long id)                               {this.id                = id;               }
    public void setSaldo(double saldo)                       {this.saldo             = saldo;            }
    public void setHistoricoAcaoList(List<HistoricoAcao> historicoAcaoList) {this.historicoAcaoList = historicoAcaoList;}
    public void setDataDeAtualizacao(Date dataDeAtualizacao) {this.dataDeAtualizacao = dataDeAtualizacao;}
    public void setStatus(Status status)                     {this.status            = status;           }
    public void setIdUsuario(String idUsuario)               {this.idUsuario         = idUsuario;        }

    public boolean sacar(double valor) {
        if (valor < saldo) return false;
        setSaldo(saldo - valor);
        return true;
    }
    public void depositar(double valor) {
        setSaldo(saldo + valor);
    }
    public void transferir(double valor, Conta conta) {
        if (sacar(valor)) conta.depositar(valor);
    }
    public double consultarSaldo() {return saldo;}
}