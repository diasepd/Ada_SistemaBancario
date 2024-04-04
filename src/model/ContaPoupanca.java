package model;
import enumerador.Classificacao;

import java.util.Date;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Long id, String idUsuario, Date dataAtual, Classificacao classificacao, Banco banco){
        super(id, idUsuario, dataAtual, classificacao, banco);
    }
}
// Eu, como USUÁRIO (PF), posso requerir uma conta-poupança.

// A conta-corrente deve conter possuir a mesma estrutura da conta-corrente.

// As ações permitidas para a conta-poupança são:
//        ● Saque
//        ● Depósito
//        ● Transferência
//        ● Consulta de saldo