//
// Created by gabriel on 29/11/2022.
//

struct lista_encadeada {
    int valor;
    struct lista_encadeada *prox;
    struct lista_encadeada *ant;
};

typedef struct lista_encadeada ListaEncadeada;
ListaEncadeada *inserir(ListaEncadeada *lista, int valor);
ListaEncadeada *remover(ListaEncadeada *lista, int valor);
void imprimir(ListaEncadeada *lista);
void imprimir_Inverso(ListaEncadeada *lista);