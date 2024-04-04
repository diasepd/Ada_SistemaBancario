package model;
import enumerador.Classificacao;

import java.util.Date;

public class ContaInvestimento extends Conta{
    public ContaInvestimento(long id, String idUsuario, Date dataAtual, Classificacao classificacao, Banco banco){
        super(id, idUsuario, dataAtual, classificacao, banco);
    }
}

// Eu, como USUÁRIO, posso requerir uma conta-investimento.

// A conta-investimento deve conter possuir a mesma estrutura da conta-corrente.

// As ações permitidas para a conta-investimento são as mesmas permitidas para a conta-poupança.

// Regra de negócio:
//      ● Clientes PF possuem rendimentos de 1% ao mês
//      ● Clientes PJ possuem rendimentos de 2% ao mês
//      ● O rendimento é gerado no início de cada mês