package monolito;
import java.text.SimpleDateFormat;
import java.util.Date;

class Usuario {
    private enum Status {ATIVO(), INATIVO();}

    private long                  id;
    private String                classificacao;
    private String                nome;
    private String                dataDeCadastro;
    private Status                status;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    private ContaInvestimento contaInvestimento;

    Usuario(long id, String classificacao, String nome) {
        classificacao          = classificacao.toUpperCase();
        String dataAtual       = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        this.id             = id;
        this.classificacao  = "PFPJ".contains(classificacao) ? classificacao: "PF";
        this.nome           = nome;
        this.dataDeCadastro = dataAtual;
        this.status         = Status.ATIVO;
        this.contaCorrente  = new ContaCorrente(1, id, dataAtual);
    }

    long                  getId()                { return id;                }
    String                getClassificacao()     { return classificacao;     }
    String                getNome()              { return nome;              }
    String                getDataDeCadastro()    { return dataDeCadastro;    }
    Status                getStatus()            { return status;            }
    ContaCorrente getContaCorrente()     { return contaCorrente;     }
    ContaPoupanca getContaPoupanca()     { return contaPoupanca;     }
    ContaInvestimento getContaInvestimento() { return contaInvestimento; }

    void setId(long id)                                                { this.id = id;}
    void setClassificacao(String classificacao)                        { this.classificacao     = classificacao;     }
    void setNome(String nome)                                          { this.nome              = nome;              }
    void setDataDeCadastro(String dataDeCadastro)                      { this.dataDeCadastro    = dataDeCadastro;    }
    void setStatus(Status status)                                      { this.status            = status;            }
    void setContaCorrente(ContaCorrente contaCorrente)         { this.contaCorrente     = contaCorrente; }
    void setContaPoupanca(ContaPoupanca contaPoupanca)             { this.contaPoupanca     = contaPoupanca;     }
    void setContaInvestimento(ContaInvestimento contaInvestimento) { this.contaInvestimento = contaInvestimento; }
}