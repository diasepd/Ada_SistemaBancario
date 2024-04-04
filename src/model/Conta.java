package model;
import enumerador.Acao;
import enumerador.Classificacao;
import enumerador.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// As ações permitidas para a conta-corrente são:
//      ● Saque - Verificar
//          ● Se o valor definido não é superior ao saldo corrente
//            PJ existe a cobrança de uma taxa de 0.5% para cada saque
//      ● Depósito
//      ● Transferência
//          ● A existência do usuário destino, por meio de seu identificador (CPF / CNPJ);
//          ● Se valor da transferência não é superior ao saldo corrente
//          ● Se valor da transferência foi direcionado ao saldo da conta-corr. do usuário destino
//            PJ existe a cobrança de uma taxa de 0.5% para cada transferência
//      ● Investimento - Verificar
//          ● Se a conta-investimento já foi criada, senão criá-la
//          ● Se o valor definido não é superior ao saldo corrente
//      ● Consulta de saldo
// A conta-corrente deve possuir registros das ações realizadas. Esses registros são criados com:
// data, tipo, valor pretendido, valor real, usuário origem, usuário destino e observação.

public abstract class Conta{
    private Long id;
    private double saldo = 0;
    private List<HistoricoAcao> historicoAcaoList = new ArrayList<>();
    private Date dataDeAtualizacao;
    private Status status = Status.ATIVO;
    private String idUsuario;
    private Classificacao classificacao;
    private Banco banco;

    public Conta(Long id, String idUsuario, Date dataDeAtualizacao, Classificacao classificacao, Banco banco){
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataDeAtualizacao = dataDeAtualizacao;
        this.classificacao = classificacao;
        this.banco = banco;
        setHistoricoAcaoList(new HistoricoAcao(Acao.DEPOSITO, 0, 0, idUsuario, idUsuario, "Conta Nova"));
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public double getSaldo(){return saldo;}
    public void setSaldo(double saldo){this.saldo   = saldo;}
    public List<HistoricoAcao> getHistoricoAcaoList(){return historicoAcaoList;}
    public void setHistoricoAcaoList(HistoricoAcao historicoAcao){this.historicoAcaoList.add(historicoAcao);}
    public Date getDataDeAtualizacao(){return dataDeAtualizacao;}
    public void setDataDeAtualizacao(Date dataDeAtualizacao){this.dataDeAtualizacao = dataDeAtualizacao;}
    public Status getStatus(){return status;}
    public void setStatus(Status status){this.status  = status;}
    public String getIdUsuario(){return idUsuario;}
    public void setIdUsuario(String idUsuario){this.idUsuario = idUsuario;}

    public boolean sacar(double valor, String... historia){
        Boolean ehSaque = historia.length == 0;
        Acao acao = ehSaque ? Acao.SAQUE : (historia[1] == "Transferência") ? Acao.TRANSFERENCIA : Acao.INVESTIMENTO;
        double valorPretendido = valor;
        if (classificacao.equals(Classificacao.PJ) && !acao.equals(Acao.INVESTIMENTO))
            valor *= 1.05;
        if (valor > saldo)
            return false;
        setSaldo(saldo - valor);
        if (ehSaque)
            setHistoricoAcaoList(new HistoricoAcao(acao, valorPretendido, valor, idUsuario, idUsuario, "Saque"));
        else
            setHistoricoAcaoList(new HistoricoAcao(acao, valorPretendido, valor, idUsuario, historia[0], historia[1]));
        return true;
    }

    public void depositar(double valor, String... historia) {
        Acao acao = null;
        setSaldo(saldo + valor);
        if (historia.length == 0)
            setHistoricoAcaoList(new HistoricoAcao(Acao.DEPOSITO, valor, valor, idUsuario, idUsuario, "Deposito"));
        else {
            acao = historia[1] == "Transferência" ? Acao.TRANSFERENCIA : Acao.INVESTIMENTO;
            setHistoricoAcaoList(new HistoricoAcao(acao, valor, valor, historia[0], idUsuario, historia[1]));
        }
    }

    public void transferir(double valor, String idUsuario){
        Usuario usuario = banco.getUsuarioArrayList(idUsuario);
        if (!usuario.equals(null)) {
            if (sacar(valor, idUsuario, "Transferência"))
                usuario.getContaCorrente().depositar(valor, this.idUsuario, "Transferência");

        }
    }

    public void investir(double valor){
        if (sacar(valor, idUsuario, "Investimento")) {
            Usuario usuario = banco.getUsuarioArrayList(idUsuario);
            if (usuario.getContaInvestimento() == null)
                usuario.setContaInvestimento(new ContaInvestimento(2, idUsuario, new Date(), classificacao, banco));
            usuario.getContaInvestimento().depositar(valor, idUsuario, "Investimento");
        }
    }

    public double consultarSaldo(){return saldo;}
}