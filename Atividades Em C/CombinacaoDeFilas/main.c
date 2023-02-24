//
// Created by gabri on 10/12/2022.
//
#include <stdio.h>
#include "CombinacaoDeFilias.h"

int main(void) {
    Fila* fi1 = cria_fila();
    Fila* fi2 = cria_fila();
    insere_fila(fi1, 1);
    insere_fila(fi1, 2);
    insere_fila(fi1, 3);
    insere_fila(fi2, 4);
    insere_fila(fi2, 5);
    insere_fila(fi2, 6);
    combina_filas_alternada(fi1, fi2);
    printf("Fila 1: ");
    while(!fila_vazia(fi1)){
        printf("%d ", fi1->ini->info);
        remove_fila(fi1);
    }
}
