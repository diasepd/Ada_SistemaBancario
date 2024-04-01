package model;
import enumerador.Classificacao;
import enumerador.Status;

import java.text.SimpleDateFormat;
import java.util.Date;

class Usuario {
    private String            id;
    private Classificacao classificacao;
    private String            nome;
    private Date              dataDeCadastro;
    private Status status;
    private ContaCorrente     contaCorrente;
    private ContaPoupanca     contaPoupanca;
    private ContaInvestimento contaInvestimento;

    Usuario(String id, String classificacao, String nome) {
        classificacao       = classificacao.toUpperCase();
        String dataAtual    = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        this.id             = id;
//        this.classificacao  = "PFPJ".contains(classificacao) ? classificacao: "PF";
        this.nome           = nome;
//        this.dataDeCadastro = dataAtual;
        this.status          = Status.ATIVO;
        this.contaCorrente  = new ContaCorrente(1, id, dataAtual);
    }

    String                getId()             { return id;                }
    Classificacao         getClassificacao()  { return classificacao;     }
    String                getNome()           { return nome;              }
    Date                  getDataDeCadastro() { return dataDeCadastro;    }
    Status                getStatus()         { return status;            }
    ContaCorrente getContaCorrente()          { return contaCorrente;     }
    ContaPoupanca getContaPoupanca()          { return contaPoupanca;     }
    ContaInvestimento getContaInvestimento()  { return contaInvestimento; }

    void setId(String id)                                          { this.id = id;                               }
    void setClassificacao(Classificacao classificacao)             { this.classificacao     = classificacao;     }
    void setNome(String nome)                                      { this.nome              = nome;              }
    void setDataDeCadastro(Date dataDeCadastro)                    { this.dataDeCadastro    = dataDeCadastro;    }
    void setStatus(Status status)                                  { this.status            = status;            }
    void setContaCorrente(ContaCorrente contaCorrente)             { this.contaCorrente     = contaCorrente;     }
    void setContaPoupanca(ContaPoupanca contaPoupanca)             { this.contaPoupanca     = contaPoupanca;     }
    void setContaInvestimento(ContaInvestimento contaInvestimento) { this.contaInvestimento = contaInvestimento; }
}