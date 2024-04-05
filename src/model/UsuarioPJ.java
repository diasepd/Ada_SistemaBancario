package model;
import auxiliares.Banco;
import enumerador.Classificacao;

public class UsuarioPJ extends Usuario {
    public UsuarioPJ(String id, String nome, Banco banco) {
        super(id, nome, banco);
        setClassificacao(Classificacao.PJ);
    }
}