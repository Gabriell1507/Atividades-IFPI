//
// Created by gabri on 10/12/2022.
//
#include <malloc.h>
#include "CombinacaoDeFilias.h"

Fila* cria_fila(){
    Fila* fi = (Fila*) malloc(sizeof(Fila));
    if(fi != NULL){
        fi->ini = NULL;
        fi->fim = NULL;
    }
    return fi;
}

void libera_fila(Fila* fi){
    if(fi != NULL){
        Lista* no;
        while(fi->ini != NULL){
            no = fi->ini;
            fi->ini = fi->ini->prox;
            free(no);
        }
        free(fi);
    }
}

int fila_vazia(Fila* fi){
    if(fi == NULL)
        return 1;
    if(fi->ini == NULL)
        return 1;
    return 0;
}

int insere_fila(Fila* fi, int elem){
    if(fi == NULL)
        return 0;
    Lista* no = (Lista*) malloc(sizeof(Lista));
    if(no == NULL)
        return 0;
    no->info = elem;
    no->prox = NULL;
    if(fi->fim == NULL)
        fi->ini = no;
    else
        fi->fim->prox = no;
    fi->fim = no;
    return 1;
}

int remove_fila(Fila* fi){
    if(fi == NULL)
        return 0;
    if(fi->ini == NULL)
        return 0;
    Lista* no = fi->ini;
    fi->ini = fi->ini->prox;
    if(fi->ini == NULL)
        fi->fim = NULL;
    free(no);
    return 1;
}

void combina_filas_alternada(Fila* fi1, Fila* fi2){
    if(fi1 == NULL || fi2 == NULL)
        return;
    Lista* no1 = fi1->ini;
    Lista* no2 = fi2->ini;
    Lista* aux;
    while(no1 != NULL && no2 != NULL){
        aux = no1->prox;
        no1->prox = no2;
        no1 = aux;
        aux = no2->prox;
        no2->prox = no1;
        no2 = aux;
    }
    fi1->fim = no2;
}