//
// Created by gabri on 10/12/2022.
//
#include <malloc.h>
#include "CalculadoraPF.h"

Calc *CriaCalc() {
    Calc *calc = (Calc *) malloc(sizeof(Calc));
    calc->topo = -1;
    calc->tamanho = 10;
    calc->pilha = (float *) malloc(sizeof(int) * calc->tamanho);
    return calc;
}

void Operando(Calc *calc, float valor) {
    calc->topo++;
    calc->pilha[calc->topo] = valor;
}

void Operador(Calc *calc, char operador) {
    float valor1 = calc->pilha[calc->topo];
    calc->topo--;
    float valor2 = calc->pilha[calc->topo];
    calc->topo--;
    float resultado = 0;
    switch (operador) {
        case '+':
            resultado = valor1 + valor2;
            break;
        case '-':
            resultado = valor1 - valor2;
            break;
        case '*':
            resultado = valor1 * valor2;
            break;
        case '/':
            resultado = valor1 / valor2;
            break;
    }
    calc->topo++;
    calc->pilha[calc->topo] = resultado;
}

void LiberaCalc(Calc *calc) {
    free(calc->pilha);
    free(calc);
}