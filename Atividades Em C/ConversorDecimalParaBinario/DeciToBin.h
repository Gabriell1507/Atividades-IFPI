//
// Created by gabri on 10/12/2022.
//

#ifndef ATIVIDADES_DIA_13_DECITOBIN_H
#define ATIVIDADES_DIA_13_DECITOBIN_H


struct lista {
    int valor;
    struct lista *ant;
    struct lista *prox;
};

typedef struct lista Lista;

struct fila {
    Lista *ini;
    Lista *fim;
};

typedef struct fila Fila;

Fila *cria_fila();

Lista *ins_init(Lista *ini, int v);

void insere_inicio(Fila *f, int v);

void imprime_fila(Fila *f);

void deciToBin(Fila *f, int n);
#endif //ATIVIDADES_DIA_13_DECITOBIN_H
