#include "conta.h"
#include <stdio.h>
#include <stdlib.h>

struct ContaBanco {
    int numero;
    float saldo;
};
ContaBanco *criar_conta(int numero, float saldo) {
    ContaBanco *conta;
    conta = (ContaBanco*) malloc(sizeof(struct ContaBanco));
    conta->numero = 1000;
    conta->saldo = 5;
}
void deposito(ContaBanco *conta, float valor) {
    conta->saldo += valor;
}
void saque(ContaBanco *conta, float valor) {
    conta->saldo -= valor;
}
void mostrar_saldo(ContaBanco *conta) {
    printf("Saldo: %.2f\n", conta->saldo);
}