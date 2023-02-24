//
// Created by gabri on 10/12/2022.
//
#include <stdio.h>
#include "CalculadoraPF.h"

int main() {
    int opcao1 = 0;
    float valor = 0;
    char operador = ' ';
    Calc *calc = CriaCalc();
    do {
        printf("--------------------\n");
        printf("1 - Operando\n");
        printf("2 - Operador\n");
        printf("3 - Resultado\n");
        printf("4 - Sair\n");
        printf("--------------------\n");
        printf("Opcao: ");
        scanf("%d", &opcao1);

        switch (opcao1) {
            case 1:
                printf("Valor: ");
                scanf("%f", &valor);
                Operando(calc, valor);
                break;
            case 2:
                printf("Operador: ");
                scanf(" %c", &operador);
                Operador(calc, operador);
                break;
            case 3:
                printf("Resultado: %.2f\n", calc->pilha[calc->topo]);
                break;
        }
    } while (opcao1 != 4);
}