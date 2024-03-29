package monolito;

import java.math.BigDecimal;
//  Rendimento de 1% para PF e 2% para PJ, ao mês - como identificar a classificação do cliente?
//  Rendimento gerado no início do mês
public class ContaInvestimento extends ContaImpl {
    public ContaInvestimento(int id, long idUsuario, String dataAtual) {
        super(id, idUsuario, dataAtual);
    }
    @Override
    public void sacar(BigDecimal valor) {

    }
    public void depositar(BigDecimal valor) {

    }
    public void transferir() {

    }
    public void consultarSaldo() {

    }
}