package monolito;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
    private long              id;
    private String            classificacao;
    private String            nome;
    private String            dataDeCadastro;
    private Status            status;
    private ContaCorrente     contaCorrente;
    private ContaPoupanca     contaPoupanca;

    private enum Status {ATIVO(), INATIVO();}

    public Usuario(long id, String classificacao, String nome) {
        classificacao       = classificacao.toUpperCase();
        String dataAtual    = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.id             = id;
        this.classificacao  = "PFPJ".contains(classificacao) ? classificacao: "PF";
        this.nome           = nome;
        this.dataDeCadastro = dataAtual;
        this.status         = Status.ATIVO;
        this.contaCorrente  = new ContaCorrente(1, id, dataAtual);
    }

    public long              getId()                { return id;                }
    public String            getClassificacao()     { return classificacao;     }
    public String            getNome()              { return nome;              }
    public String            getDataDeCadastro()    { return dataDeCadastro;    }
    public Status            getStatus()            { return status;            }
    public ContaCorrente     getContaCorrente()     { return contaCorrente;     }
    public ContaPoupanca     getContaPoupanca()     { return contaPoupanca;     }

    //    private void setId(int id) {                                    this.id = id;    }
    public void setClassificacao(String classificacao)                    { this.classificacao = classificacao;         }
    public void setNome(String nome)                                      { this.nome = nome;                           }
    public void setDataDeCadastro(String dataDeCadastro)                  { this.dataDeCadastro = dataDeCadastro;       }
    public void setStatus(Status status)                                  { this.status = status;                       }
    public void setContaCorrente(ContaCorrente contaCorrente)             { this.contaCorrente = contaCorrente;         }
    public void setContaPoupanca(ContaPoupanca contaPoupanca)             { this.contaPoupanca = contaPoupanca;         }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", classificacao='" + classificacao + '\'' +
                ", nome='" + nome + '\'' +
                ", dataDeCadastro='" + dataDeCadastro + '\'' +
                ", status=" + status +
                ", contaCorrente=" + contaCorrente +
                '}';
    }
}