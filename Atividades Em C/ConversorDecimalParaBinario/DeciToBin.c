//
// Created by gabri on 10/12/2022.
//
#include <stdio.h>
#include <malloc.h>
#include "DeciToBin.h"

Fila *cria_fila() {
    Fila *f = (Fila *) malloc(sizeof(Fila));
    f->ini = f->fim = NULL;
    return f;
}

Lista *ins_init(Lista *ini, int v) {
    Lista *aux = (Lista *) malloc(sizeof(Lista));
    aux->valor = v;
    aux->prox = ini;
    aux->ant = NULL;
    if (ini != NULL) {
        ini->ant = aux;
    }
    return aux;
}

void insere_inicio(Fila *f, int v) {
    f->ini = ins_init(f->ini, v);
    if (f->fim == NULL) {
        f->fim = f->ini;
    }
}

void imprime_fila(Fila *f) {
    Lista *aux = f->ini;
    while (aux != NULL) {
        printf("%d", aux->valor);
        aux = aux->prox;
    }
}


void deciToBin(Fila *f, int n) {
    int resto;
    while (n > 0) {
        resto = n % 2;
        n = n / 2;
        insere_inicio(f, resto);
    }
}