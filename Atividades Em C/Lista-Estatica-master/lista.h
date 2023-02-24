struct numero{
    int num;
};
typedef struct lista Lista;

Lista* criar_lista();
void liberar_lista(Lista* l);

int size_lista(Lista* l);
int full_lista(Lista *l);
int empty_lista(Lista *l);

int inserir_inicio_lista(Lista *l, struct numero valor);
int inserir_meio_lista(Lista *l, struct numero valor);
int inserir_final_lista(Lista *l, struct numero valor);
int inserir_ordenado_lista(Lista *l, struct numero valor);
int insert(Lista *l, struct numero valor, int pos);
int append(Lista *l, struct numero valor);

int remover_lista(Lista *l, int valor);
int remover_inicio_lista(Lista *l);
int remover_final_lista(Lista *l);

int print(Lista *l);