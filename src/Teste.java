import model.Banco;
import model.*;

public class Teste {
    public static void main(String[] args) {
        Banco banco = new Banco();
        UsuarioPF usuario1 = new UsuarioPF("12345678911", "Eduardo Caldas Dias", banco);        //Conta corrente PF
        UsuarioPJ usuario2 = new UsuarioPJ("916962327910001", "Fábrica de brinquedos", banco);  // Conta corrente PJ
        banco.setUsuario(usuario1);
        banco.setUsuario(usuario2);
        usuario1.setContaPoupanca(new ContaPoupanca(3, "12345678911", banco));                  //Conta poupança PF

        System.out.println("\nSaldo após DEPOSITO e INVESTIMENTO");
        usuario1.getContaCorrente().depositar(200);                          //100
        usuario2.getContaCorrente().depositar(200);                          //100
        usuario1.getContaPoupanca().depositar(100);                          //100
        usuario1.getContaCorrente().investir(100);                           //100
        usuario2.getContaCorrente().investir(100);                           //100
        saldos(usuario1, usuario2);

        System.out.println("Saldo após SAQUE");
        usuario1.getContaCorrente().sacar(10);                              //90
        usuario2.getContaCorrente().sacar(10);                              //89.95
        usuario1.getContaPoupanca().sacar(10);                              //90
        usuario1.getContaInvestimento().sacar(10);                          //90
        usuario2.getContaInvestimento().sacar(10);                          //90
        saldos(usuario1, usuario2);

        System.out.println("Saldo após TRANSFERIR");
        usuario1.getContaCorrente().transferir(10, "916962327910001");      //100
        usuario2.getContaCorrente().transferir(10, "12345678911");          //109.9
        usuario1.getContaPoupanca().transferir(10, "916962327910001");      //80
        usuario1.getContaInvestimento().transferir(10, "916962327910001");  //80
        usuario2.getContaInvestimento().transferir(10, "12345678911");      //80
        saldos(usuario1, usuario2);

        System.out.println("Consulta saldo\n");
        usuario1.getContaCorrente().consultarSaldo();                       //100
        usuario2.getContaCorrente().consultarSaldo();                       //109
        usuario1.getContaPoupanca().consultarSaldo();                       //80
        usuario1.getContaInvestimento().consultarSaldo();                   //80
        usuario2.getContaInvestimento().consultarSaldo();                   //80

        System.out.println("Saldo após Rendimento");
        usuario1.getContaInvestimento().processarRendimento();              //80.8
        usuario2.getContaInvestimento().processarRendimento();              //81.6
        saldos(usuario1, usuario2);

        System.out.println("Historico das Movimentações");
        historiar(usuario1.getContaCorrente());
        historiar(usuario2.getContaCorrente());
        historiar(usuario1.getContaPoupanca());
        historiar(usuario1.getContaInvestimento());
        historiar(usuario2.getContaInvestimento());
    }

    private static void historiar (Conta conta) {
        for (Acao acao : conta.getHistoricoDeAcao()) {
            System.out.println(acao.toString());
        }
        System.out.println();
    }

    private static void saldos(UsuarioPF usuario1, UsuarioPJ usuario2) {
        System.out.println("PF corrente     " + usuario1.getContaCorrente().getSaldo());
        System.out.println("PJ corrente     " + usuario2.getContaCorrente().getSaldo());
        System.out.println("PF poupança     " + usuario1.getContaPoupanca().getSaldo());
        System.out.println("PF investimento " + usuario1.getContaInvestimento().getSaldo());
        System.out.println("PJ investimento " + usuario2.getContaInvestimento().getSaldo());
        System.out.println();
    }
}
//  EXPECTATIVAS PROJETO MÓDULO II
//  Melhoria na disposição de funcionalidades  ???
//  Organização do pacote
//  SOLID