package model;
import auxiliares.Credito;
import auxiliares.Debito;
import auxiliares.Saque;
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
    private List<Acao> historicoDeAcao = new ArrayList<>();
    private Date dataDeAtualizacao;
    private Status status = Status.ATIVO;
    private String idUsuario;
    private Banco banco;
    private TipoConta tipoConta;
    private Classificacao tipoPessoa;

    public Conta(long id, String idUsuario, Banco banco) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.banco = banco;
        this.dataDeAtualizacao = new Date();
        setAcao(new Acao(TipoAcao.DEPOSITO, 0, 0, idUsuario, idUsuario, "Abertura da Conta"));
    }

    public void setAcao(Acao acao){this.historicoDeAcao.add(acao);}
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public double getSaldo(){return saldo;}
    public void setSaldo(double saldo){this.saldo   = saldo;}
    public List<Acao> getHistoricoDeAcao(){return historicoDeAcao;}
    public void setHistoricoDeAcao(List<Acao> historicoDeAcao) {this.historicoDeAcao = historicoDeAcao;}
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
    public TipoConta getTipoConta() {return tipoConta;}
    public void setTipoConta(TipoConta tipoConta) {this.tipoConta = tipoConta;}
    public Classificacao getTipoPessoa() {
        if (tipoPessoa == null)
            tipoPessoa = banco.getUsuario(getIdUsuario()).getClassificacao();
        return tipoPessoa;
    }
    public void setTipoPessoa(Classificacao tipoPessoa) {this.tipoPessoa = tipoPessoa;}

    public void depositar(double valor, String... historia) {
        new Credito().creditar(this, valor);
        historicoDeAcao.add(new Acao(TipoAcao.DEPOSITO, valor, valor, idUsuario, idUsuario, "Deposito"));
    }

    public boolean sacar(double valor, String... historia) {
        // Ajustar valor
        double valorPretendido = valor;
        if (tipoConta.equals(TipoConta.CORRENTE))
            valor = new Saque().Calcular(valor, getTipoPessoa().getTxSacarTransferir());

        if (naoDebitou(valor))
            return false;

        historicoDeAcao.add(new Acao(TipoAcao.SAQUE, valorPretendido, valor, idUsuario, idUsuario, "Saque"));
        return true;
    }

    public boolean transferir(double valorReal, String idUsuario) {
        // Ajustar valor
        double valor = valorReal;
        if (tipoConta.equals(TipoConta.CORRENTE))
            valorReal = new Saque().Calcular(valorReal, getTipoPessoa().getTxSacarTransferir());

        // Debitar e Creditar
        ContaCorrente contaTerceiro = getBanco().getUsuario(idUsuario).getContaCorrente();
        if (contaTerceiro.equals(null) || naoDebitou(valorReal))
            return false;
        new Credito().creditar(contaTerceiro, valor);

        contaTerceiro.setAcao(new Acao(TipoAcao.TRANSFERENCIA, valor, valorReal, getIdUsuario(), idUsuario, "Crédito"));
        historicoDeAcao.add(new Acao(TipoAcao.TRANSFERENCIA, valor, valorReal, getIdUsuario(), idUsuario, "Débito"));
        return true;
    }

    public double consultarSaldo() {
        historicoDeAcao.add(new Acao(TipoAcao.CONSULTA_SALDO, saldo, saldo, getIdUsuario(), getIdUsuario(), "Consulta"));
        return saldo;
    }

    boolean naoDebitou(double valor) {
        return !new Debito().debitar(this, valor);
    }
}