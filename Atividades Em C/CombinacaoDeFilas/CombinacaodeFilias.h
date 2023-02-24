//
// Created by gabri on 10/12/2022.
//

#ifndef ATIVIDADES_DIA_13_COMBINACAODEFILIAS_H
#define ATIVIDADES_DIA_13_COMBINACAODEFILIAS_H
struct lista{
    int info;
    struct lista *prox;
};

typedef struct lista Lista;

struct fila{
    Lista *ini;
    Lista *fim;
};

typedef struct fila Fila;

Fila* cria_fila();
void libera_fila(Fila* fi);
int fila_vazia(Fila* fi);
int insere_fila(Fila* fi, int elem);
int remove_fila(Fila* fi);
void combina_filas_alternada(Fila* fi1, Fila* fi2);
#endif //ATIVIDADES_DIA_13_COMBINACAODEFILIAS_H
