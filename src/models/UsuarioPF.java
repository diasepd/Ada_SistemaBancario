package models;
import enums.Classificacao;

public class UsuarioPF extends Usuario {
    private ContaPoupanca contaPoupanca;

    public UsuarioPF(String id, String nome, Banco banco) {
        super(id, nome, banco);
        setClassificacao(Classificacao.PF);
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) { this.contaPoupanca = contaPoupanca; }
}