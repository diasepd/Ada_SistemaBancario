//        1         2         3         4         5         6         7         8
//3456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
package model;
import enumerador.Acao;
import enumerador.Classificacao;

import java.util.Date;

public class ContaCorrente extends Conta{
    public ContaCorrente(long id, String idUsuario, Date dataAtual, Classificacao classificacao, Banco banco){
        super(id, idUsuario, dataAtual, classificacao, banco);
    }
}
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