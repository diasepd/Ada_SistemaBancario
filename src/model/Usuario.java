package model;
import enumerador.Classificacao;
import enumerador.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario{
    private String id;
    private Classificacao classificacao;
    private String nome;
    private Date dataDeCadastro;
    private Status status;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    private ContaInvestimento contaInvestimento;
    private Banco banco;
//    private List<Conta> contaArrayList = new ArrayList<>();

    public Usuario(String id, Classificacao classificacao, String nome, Banco banco){
        this.id = id;
        this.classificacao = classificacao;
        this.nome = nome;
        this.banco = banco;
        dataDeCadastro = new Date();
        status = Status.ATIVO;
        contaCorrente = new ContaCorrente(1, id, dataDeCadastro, classificacao, banco);
//        contaArrayList.add(contaCorrente);
    }

    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public Classificacao getClassificacao(){return classificacao;}
    public void setClassificacao(Classificacao classificacao){this.classificacao = classificacao;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public Date getDataDeCadastro(){return dataDeCadastro;}
    public void setDataDeCadastro(Date dataDeCadastro){this.dataDeCadastro = dataDeCadastro;}
    public Status getStatus(){return status;}
    public void setStatus(Status status){this.status = status;}
    public ContaCorrente getContaCorrente(){return contaCorrente;}
    public void setContaCorrente(ContaCorrente contaCorrente){this.contaCorrente = contaCorrente;}
    public ContaPoupanca getContaPoupanca(){return contaPoupanca;}
    public void setContaPoupanca(ContaPoupanca contaPoupanca){this.contaPoupanca = contaPoupanca;}
    public ContaInvestimento getContaInvestimento(){return contaInvestimento;}
    public void setContaInvestimento(ContaInvestimento contaInvestimento){this.contaInvestimento = contaInvestimento;}

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", classificacao=" + classificacao +
                ", nome='" + nome + '\'' +
                ", dataDeCadastro=" + dataDeCadastro +
                ", status=" + status +
                ", contaCorrente=" + contaCorrente +
                ", contaPoupanca=" + contaPoupanca +
                ", contaInvestimento=" + contaInvestimento +
                ", banco=" + banco +
                '}';
    }
}