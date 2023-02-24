struct No{
    int valor;
    struct No *prox;
};

typedef struct No No;

struct Lista_Circular{
    No *inicio;
    No *fim;
    int tamanho;
};

typedef struct Lista_Circular Lista_Circular;
Lista_Circular *criar_lista();
void inserir(Lista_Circular *lista, int valor);
void imprimir(Lista_Circular *lista);
void remover(Lista_Circular *lista, int valor);