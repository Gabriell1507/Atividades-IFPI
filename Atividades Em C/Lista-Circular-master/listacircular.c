#include "listacircular.h"
#include <stdio.h>
#include <stdlib.h>

Lista_Circular *criar_lista(){
    Lista_Circular *lista = (Lista_Circular*) malloc(sizeof(Lista_Circular));
    lista->inicio = NULL;
    lista->fim = NULL;
    lista->tamanho = 0;
    return lista;
}
void inserir(Lista_Circular *lista, int valor){
    No *novo = (No*) malloc(sizeof(No));
    novo->valor = valor;
    novo->prox = NULL;
    if(lista->inicio == NULL){
        lista->inicio = novo;
        lista->fim = novo;
        novo->prox = lista->inicio;
    }else{
        lista->fim->prox = novo;
        lista->fim = novo;
        novo->prox = lista->inicio;
    }
    lista->tamanho++;
}
void remover(Lista_Circular *lista, int valor){
    No *aux = lista->inicio;
    No *anterior = NULL;
    while(aux->valor != valor){
        anterior = aux;
        aux = aux->prox;
    }
    if(aux == lista->inicio){
        lista->inicio = aux->prox;
        lista->fim->prox = lista->inicio;
    }else if(aux == lista->fim){
        lista->fim = anterior;
        lista->fim->prox = lista->inicio;
    }else{
        anterior->prox = aux->prox;
    }
    free(aux);
    lista->tamanho--;
}
void imprimir(Lista_Circular *lista){
    No *aux = lista->inicio;
    for(int i = 0; i < lista->tamanho; i++){
        printf("%d ", aux->valor);
        aux = aux->prox;
    }
    printf("\n");
}
