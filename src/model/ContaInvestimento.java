package model;
//  Rendimento de 1% para PF e 2% para PJ, ao mês - como identificar a classificação do cliente?
//  Rendimento gerado no início do mês
public class ContaInvestimento extends Conta {
    public ContaInvestimento(Long id, String idUsuario, String dataAtual) {
        super(id, idUsuario, dataAtual);
    }
}