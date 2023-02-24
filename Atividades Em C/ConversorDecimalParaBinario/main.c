//
// Created by gabri on 10/12/2022.
//
#include <stdio.h>
#include "DeciToBin.h"

int main() {

    Fila *f = cria_fila();
    int n;
    printf("Digite um numero: ");
    scanf("%d", &n);
    deciToBin(f, n);
    imprime_fila(f);
    return 0;
}