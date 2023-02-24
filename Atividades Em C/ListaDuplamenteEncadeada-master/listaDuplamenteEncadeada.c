//
// Created by gabriel on 29/11/2022.
//

#include "listaDuplamenteEncadeada.h"
#include <stdio.h>
#include <stdlib.h>

ListaEncadeada *inserir(ListaEncadeada *lista, int valor) {
    ListaEncadeada *novo = (ListaEncadeada *) malloc(sizeof(ListaEncadeada));
    novo->valor = valor;
    novo->prox = lista;
    novo->ant = NULL;
    if (lista != NULL) {
        lista->ant = novo;
    }
    return novo;
}
ListaEncadeada *remover(ListaEncadeada *lista, int valor) {
    ListaEncadeada *aux = lista;
    while (aux != NULL && aux->valor != valor) {
        aux = aux->prox;
    }
    if (aux == NULL) {
        return lista;
    }
    if (aux->ant == NULL) {
        lista = aux->prox;
    } else {
        aux->ant->prox = aux->prox;
    }
    if (aux->prox != NULL) {
        aux->prox->ant = aux->ant;
    }
    free(aux);
    return lista;
}
void imprimir(ListaEncadeada *lista) {
    ListaEncadeada *aux = lista;
    while (aux != NULL) {
        printf("%d ", aux->valor);
        aux = aux->prox;
    }
    printf("\n");
}
void imprimir_Inverso(ListaEncadeada *lista) {
    ListaEncadeada *aux = lista;
    while (aux->prox != NULL) {
        aux = aux->prox;
    }
    while (aux != NULL) {
        printf("%d ", aux->valor);
        aux = aux->ant;
    }
    printf("\n");
}
