typedef struct ContaBanco ContaBanco;
ContaBanco *criar_conta(int numero, float saldo);
void deposito(ContaBanco *conta, float valor);
void saque(ContaBanco *conta, float valor);
void mostrar_saldo(ContaBanco *conta);
