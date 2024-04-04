import enumerador.Classificacao;
import model.Banco;
import model.HistoricoAcao;
import model.Usuario;

public class Teste {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Usuario usuario1 = new Usuario("91696232791", Classificacao.PF, "Eduardo Caldas Dias", banco);
        Usuario usuario2 = new Usuario("916962327910001", Classificacao.PJ, "Fábrica de brinquedos", banco);
        usuario2.getContaCorrente().depositar(10);
        banco.setUsuarioArrayList(usuario1);
        banco.setUsuarioArrayList(usuario2);
//        usuario2.getContaCorrente().investir(5);
        usuario2.getContaCorrente().transferir(4, "91696232791");
        System.out.println(usuario2.getContaCorrente().getSaldo());
//        System.out.println(usuario2.getContaInvestimento().getSaldo());
        System.out.println(usuario1.getContaCorrente().getSaldo());
        System.out.println();
        for (HistoricoAcao historicoAcao: usuario2.getContaCorrente().getHistoricoAcaoList()) {
            System.out.println(historicoAcao.toString());
        }
        System.out.println();
//        for (HistoricoAcao historicoAcao: usuario2.getContaInvestimento().getHistoricoAcaoList()) {
//            System.out.println(historicoAcao.toString());
//        }
//        System.out.println();
        for (HistoricoAcao historicoAcao: usuario1.getContaCorrente().getHistoricoAcaoList()) {
            System.out.println(historicoAcao.toString());
        }
    }
}

//  EXPECTATIVAS PROJETO MÓDULO II
//  - Implementação das regras
//  - Melhoria na disposição de funcionalidades
//  - Organização do pacote
//  - SOLID