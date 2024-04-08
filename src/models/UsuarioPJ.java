package models;
import enumeradores.Classificacao;

public class UsuarioPJ extends Usuario {
    public UsuarioPJ(String id, String nome, Banco banco) {
        super(id, nome, banco);
        setClassificacao(Classificacao.PJ);
    }
}