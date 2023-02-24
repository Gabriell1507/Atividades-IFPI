#include <stdio.h>
#include <stdlib.h>
#include "lista.h"
#define MAX 5

struct lista{
    int valor;
    struct numero dados[MAX];
};

Lista* criar_lista() {
    Lista *l;
    l = (Lista*) malloc(sizeof(struct lista));
    if(l == NULL){
        printf("MEMORIA INSUFICIENTE!");
        exit(1);
    }
    if(l != NULL)
        l->valor = 0;
    return l;
}

void liberar_lista(Lista* l) {
    free(l);
}

int size_lista(Lista *l){
    if(l == NULL)
        return -1;
    else
        return l->valor;
}
int print(Lista *l) {
    if(empty_lista(l)) {
        printf("Lista vazia!\n");
        return 0;
    }
    int i;
    for(i = 0; i < l->valor; i ++){
        printf("%d ", l->dados[i].num);
    }
    printf("\n");
    return 1;
}

int full_lista(Lista *l) {
    if(l == NULL)
        return -1;
    return (l->valor == MAX);
}

int empty_lista(Lista *l) {
    if(l == NULL)
        return -1;
    return (l->valor == 0);
}

int inserir_inicio_lista(Lista *l, struct numero valor){
    if(l == NULL)
        return  0;
    if(full_lista(l)){
        printf("Lista Cheia!\n");
        return 0;
    }
    int i;
    for(i = l->valor - 1; i >= 0; i--)
        l->dados[i + 1] = l->dados[i];
    l->dados[0] = valor;
    l->valor++;
    return 1;
}

int inserir_meio_lista(Lista *l, struct numero valor){
    if(l == NULL)
        return  0;
    if(full_lista(l))
        return 0;
}

int inserir_final_lista(Lista *l, struct numero valor){
    if(l == NULL)
        return 0;
    if(full_lista(l)){
        printf("Lista Cheia!\n");
        return 0;
    }
    l->dados[l->valor] = valor;
    l->valor++;
    return 1;
}

int inserir_ordenado_lista(Lista *l, struct numero valor){
    if(l == NULL)
        return 0;
    if(full_lista(l)) {
        printf("Lista Cheia!\n");
        return 0;
    }
    int i, j = 0;
    while(j < l->valor && l->dados[j].num < valor.num)
        j++;
    for(i = l->valor - 1; i >= j; i--)
        l->dados[i + 1] = l->dados[i];
    l->dados[j] = valor;
    l->valor++;
}

int remover_lista(Lista *l, int valor){
    if(l == NULL)
        return 0;
    if(empty_lista(l)) {
        printf("Lista vazia!\n");
        return 0;
    }
    int i, j = 0;
    while(j < l->valor && l->dados[j].num != valor)
        j++;
    if(j == l->valor) {
        printf("Numero nao encontrado!\n");
        return 0;
    }
    for (i = j; i < l->valor - 1; i++) {
        l->dados[i] = l->dados[i + 1];
    }
    l->valor--;
    return 1;
}
int remover_inicio_lista(Lista *l){
    if(l == NULL)
        return 0;
    if(empty_lista(l)) {
        printf("Lista vazia!\n");
        return 0;
    }
    int i = 0;
    for (i = 0; i < l->valor - 1; i++)
        l->dados[i] = l->dados[i + 1];
    l->valor--;
    return 1;
}
int remover_final_lista(Lista *l){
    if(l == NULL)
        return 0;
    if(empty_lista(l)) {
        printf("Lista vazia!\n");
        return 0;
    }
    l->valor--;
    return 1;
}
int append(Lista *l, struct numero valor){
    if(l == NULL)
        return 0;
    if(full_lista(l)) {
        printf("Lista Cheia!\n");
        return 0;
    }
    l->dados[l->valor] = valor;
    l->valor++;
    return 1;
}
int insert(Lista *l, struct numero valor, int pos){
    if(l == NULL)
        return 0;
    if(full_lista(l)) {
        printf("Lista Cheia!\n");
        return 0;
    }
    int i;
    for(i = l->valor - 1; i >= pos; i--)
        l->dados[i + 1] = l->dados[i];
    l->dados[pos] = valor;
    l->valor++;
    return 1;
}