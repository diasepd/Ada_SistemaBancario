package monolito;

import java.math.BigDecimal;

interface Conta {
    void sacar(BigDecimal valor);
    void depositar(BigDecimal valor);
    void transferir();
    void consultarSaldo();
}