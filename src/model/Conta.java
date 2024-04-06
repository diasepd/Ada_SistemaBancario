package model;
import auxiliares.Banco;
import auxiliares.Credito;
import auxiliares.Debito;
import enumerador.Classificacao;
import enumerador.Status;
import enumerador.TipoConta;
import enumerador.TipoAcao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta {
    private long id;
    private double saldo = 0;
    private List<Acao> historicoDeAcoes = new ArrayList<>();
    private Date dataDeAtualizacao;
    private Status status = Status.ATIVO;
    private String idUsuario;
    private Banco banco;
    private TipoConta tipoConta;

    public Conta(long id, String idUsuario, Banco banco) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.banco = banco;
        this.dataDeAtualizacao = new Date();
        setAcao(new Acao(TipoAcao.DEPOSITO, 0, 0, idUsuario, idUsuario, "Abertura da Conta"));
    }

    public void setAcao(Acao acao){this.historicoDeAcoes.add(acao);}
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public double getSaldo(){return saldo;}
    public void setSaldo(double saldo){this.saldo   = saldo;}
    public List<Acao> getHistoricoDeAcoes(){return historicoDeAcoes;}
    public void setHistoricoDeAcoes(List<Acao> historicoDeAcoes) {this.historicoDeAcoes = historicoDeAcoes;}
    public Date getDataDeAtualizacao(){return dataDeAtualizacao;}
    public void setDataDeAtualizacao(Date dataDeAtualizacao){this.dataDeAtualizacao = dataDeAtualizacao;}
    public Status getStatus(){return status;}
    public void setStatus(Status status){this.status  = status;}
    public String getIdUsuario(){return idUsuario;}
    public void setIdUsuario(String idUsuario){this.idUsuario = idUsuario;}
    public Banco getBanco() {return banco;}
    public void setBanco(Banco banco) {this.banco = banco;}
    public TipoConta getTipo() {return tipoConta;}
    public void setTipo(TipoConta tipoConta) {this.tipoConta = tipoConta;}

    public void depositar(double valor, String... historia) {
        new Credito().creditar(this, valor);

        historicoDeAcoes.add(new Acao(TipoAcao.DEPOSITO, valor, valor, getIdUsuario(), getIdUsuario(), "Deposito"));
    }

    public boolean sacar(double valor, String... historia) {
        double valorPretendido = valor;
        if (ehContaCorrentePJ())
            valor *= 1.005;

        if (naoDebitou(valor))
            return false;

        getHistoricoDeAcoes().add(
                new Acao(TipoAcao.SAQUE, valorPretendido, valor, getIdUsuario(), getIdUsuario(), "Saque"));
        return true;
    }

    public boolean transferir(double valor, String idUsuario) {
        double valorPretendido = valor;
        if (ehContaCorrentePJ())
            valor *= 1.005;

        Usuario usuario = getBanco().getUsuario(idUsuario);
        if (usuario.equals(null) || naoDebitou(valor))
            return false;
        new Credito().creditar(usuario.getContaCorrente(), valorPretendido);

        getHistoricoDeAcoes().add(new
                Acao(TipoAcao.TRANSFERENCIA, valorPretendido, valor, getIdUsuario(), idUsuario, "Débito"));
        usuario.getContaCorrente().setAcao(new
                Acao(TipoAcao.TRANSFERENCIA, valorPretendido, valor, getIdUsuario(), idUsuario, "Crédito"));
        return true;
    }

    public double consultarSaldo () {
        double saldo = getSaldo();
        getHistoricoDeAcoes().add(new
                Acao(TipoAcao.CONSULTA_SALDO, saldo, saldo, getIdUsuario(), getIdUsuario(), "Consulta"));
        return saldo;
    }

    private boolean ehContaCorrentePJ () {
        return tipoConta.equals(TipoConta.CORRENTE) &&
                getBanco().getUsuario(getIdUsuario()).getClassificacao().equals(Classificacao.PJ);
    }

    boolean naoDebitou(double valor) {
        return !new Debito().debitar(this, valor);
    }
}