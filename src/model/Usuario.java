package model;
import auxiliares.Banco;
import enumerador.Classificacao;
import enumerador.Status;
import java.util.Date;

public abstract class Usuario {
    private String id;
    private Classificacao classificacao;
    private String nome;
    private Date dataDeCadastro;
    private Status status;
    private Banco banco;
    private ContaCorrente contaCorrente;
    private ContaInvestimento contaInvestimento;

    public Usuario(String id, String nome, Banco banco) {
        this.id = id;
        this.nome = nome;
        this.banco = banco;
        dataDeCadastro = new Date();
        status = Status.ATIVO;
        contaCorrente = new ContaCorrente(1, id, banco);
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public Classificacao getClassificacao() {return classificacao;}
    public void setClassificacao(Classificacao classificacao) {this.classificacao = classificacao;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Date getDataDeCadastro() {return dataDeCadastro;}
    public void setDataDeCadastro(Date dataDeCadastro) {this.dataDeCadastro = dataDeCadastro;}
    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}
    public Banco getBanco() {return banco;}
    public void setBanco(Banco banco) {this.banco = banco;}
    public ContaCorrente getContaCorrente() {return contaCorrente;}
    public void setContaCorrente(ContaCorrente contaCorrente) {this.contaCorrente = contaCorrente;}
    public ContaInvestimento getContaInvestimento() {return contaInvestimento;}
    public void setContaInvestimento(ContaInvestimento contaInvestimento) {this.contaInvestimento = contaInvestimento;}

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", classificacao=" + classificacao +
                ", nome='" + nome + '\'' +
                ", dataDeCadastro=" + dataDeCadastro +
                ", status=" + status +
                ", banco=" + banco +
                ", contaCorrente=" + contaCorrente +
                ", contaInvestimento=" + contaInvestimento +
                '}';
    }
}