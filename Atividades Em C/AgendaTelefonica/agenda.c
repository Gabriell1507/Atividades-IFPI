//
// Created by gabri on 10/12/2022.
//
#include "agenda.h"


void cadastrar(struct contato *c, int *qtd){
    printf("Nome: ");
    scanf("%s", c[*qtd].nome);
    printf("Telefone: ");
    scanf("%s", c[*qtd].telefone);
    printf("Email: ");
    scanf("%s", c[*qtd].email);
    *qtd = *qtd + 1;
}

void listar(struct contato *c, int *qtd){
    int i;
    for(i=0; i<*qtd; i++){
        printf("Nome: %s\n", c[i].nome);
        printf("Telefone: %s\n", c[i].telefone);
        printf("Email: %s\n", c[i].email);
    }
}

void buscar(struct contato *c, int *qtd){
    char nome[50];
    int i;
    printf("Nome: ");
    scanf("%s", nome);
    for(i=0; i<*qtd; i++){
        if(strcmp(nome, c[i].nome) == 0){
            printf("Telefone: %s\n", c[i].telefone);
            printf("Email: %s\n", c[i].email);
        }
    }
}