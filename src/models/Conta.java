package models;
import auxiliares.Credito;
import auxiliares.Debito;
import auxiliares.Retirada;
import enumeradores.Classificacao;
import enumeradores.Status;
import enumeradores.TipoConta;
import enumeradores.TipoAcao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta {
    private long id;
    private String idUsuario;
    private Banco banco;
    private Date dataDeAtualizacao;
    private double saldo = 0;
    private List<Acao> historicoDeAcao = new ArrayList<>();
    private Status status = Status.ATIVO;
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
    public TipoConta getTipoConta() {return tipoConta;}
    public void setTipoConta(TipoConta tipoConta) {this.tipoConta = tipoConta;}
    public Classificacao getTipoPessoa() {
        if (tipoPessoa == null) setTipoPessoa(banco.getUsuario(getIdUsuario()).getClassificacao());
        return tipoPessoa;
    }
    public void setTipoPessoa(Classificacao tipoPessoa) {this.tipoPessoa = tipoPessoa;}

    public void consultarSaldo() {efetuar(TipoAcao.CONSULTA_SALDO, saldo);}
    public void depositar(double valor) {efetuar(TipoAcao.DEPOSITO, valor);}
    public void sacar(double valor) {efetuar(TipoAcao.SAQUE, valor);}
    private void efetuar (TipoAcao acao, double valor) {acao.efetuar(valor, this);}
    public void transferir(double valor, String idDestino) {
        ContaCorrente conta = getBanco().getUsuario(idDestino).getContaCorrente();
        double valorSolicitado = valor;
        valor = calcularValor(valor);
        if (movimentacao(conta, valorSolicitado, valor)) {
            conta.setAcao(new Acao(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, idUsuario, idDestino, "Crédito"));
            historicoDeAcao.add(new Acao(TipoAcao.TRANSFERENCIA, valorSolicitado, valor, idUsuario, idDestino, "Débito"));
        }
//        TipoAcao acao = TipoAcao.TRANSFERENCIA;
//        acao.efetuar(0, this, conta);
    }

    public double calcularValor(double valor) {
        return tipoConta.equals(TipoConta.CORRENTE) ?
                new Retirada().Calcular(valor, getTipoPessoa().getTxSacarTransferir()) : valor;
    }

    public boolean debitou(double valor) { return new Debito().debitar(this, valor); }

    public boolean movimentacao(Conta conta, double valor, double valorReal) {
        if (conta.equals(null) || !debitou(valorReal))
            return false;
        new Credito().creditar(conta, valor);
        return true;
    }
}