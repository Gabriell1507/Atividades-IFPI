//
// Created by gabri on 10/12/2022.
//

#ifndef ATIVIDADES_DIA_13_AGENDA_H
#define ATIVIDADES_DIA_13_AGENDA_H
#include <stdio.h>
#include <string.h>

struct contato{
    char nome[50];
    char telefone[20];
    char email[50];
};

void cadastrar(struct contato *c, int *qtd);
void listar(struct contato *c, int *qtd);
void buscar(struct contato *c, int *qtd);
int imprimirMenu();
#endif //ATIVIDADES_DIA_13_AGENDA_H
