#include <stdio.h>
#include "conta.h"

int main() {
    ContaBanco *conta;
    conta = criar_conta(1000, 5);
    deposito(conta, 10);
    mostrar_saldo(conta);
    saque(conta, 5);
    mostrar_saldo(conta);
    return 0;
}