#ifndef CALCULADORAPOSFIXA_CALCULADORAPF_H
#define CALCULADORAPOSFIXA_CALCULADORAPF_H

#endif //CALCULADORAPOSFIXA_CALCULADORAPF_H

struct calc {
    float *pilha;
    int topo;
    int tamanho;
};

typedef struct calc Calc;

Calc *CriaCalc();

void Operando(Calc *calc, float valor);

void Operador(Calc *calc, char operador);

void LiberaCalc(Calc *calc);