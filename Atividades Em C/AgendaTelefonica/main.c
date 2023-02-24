//
// Created by gabri on 10/12/2022.
//
#include "agenda.h"
#include <stdio.h>

int imprimirMenu(){
    int opcao;
    printf("1 - Cadastrar\n");
    printf("2 - Listar\n");
    printf("3 - Buscar\n");
    printf("4 - Sair\n");
    printf("Opcao: ");
    scanf("%d", &opcao);
    return opcao;
}
int main(){
    struct contato c[100];
    int qtd = 0;
    int opcao;
    do{
        opcao = imprimirMenu();
        switch(opcao){
            case 1:
                cadastrar(c, &qtd);
                break;
            case 2:
                listar(c, &qtd);
                break;
            case 3:
                buscar(c, &qtd);
                break;
            case 4:
                printf("Saindo...\n");
                break;
            default:
                printf("Opcao invalida!\n");
        }
    }while(opcao != 4);
    return 0;
}