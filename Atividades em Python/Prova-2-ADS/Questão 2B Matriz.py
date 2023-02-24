#Bom professor, fiz a questão de duas formas distintas, no primeiro caso o senhor poderá gerar a matriz colocando os números da sua preferência, já no segundo gera automaticamente.


#Essa o senhor pode inserir os números que desejar.
def matriz():
    import numpy as np
    matriz = [[0, 0 , 0], [0, 0 , 0], [0, 0 , 0]]
    for l in range(0, 3):              #Essa primeiro for é para criar a matriz.
        for c in range(0, 3):
            matriz[l][c] = float(input(f'Digite um valor: [{l} , {c}] ')) 
    print('-_-'*30)
    for l in range(0,3):                #Esta segunda utilização do for é para mostrar em estrutura de matriz.
        for c in range(0,3):
            print(f'[{matriz[l][c]:^5}]', end='')   #Imprimindo a matriz após colocar os devidos valores.
    
    A = np.array(matriz) #Utilizando a biblioteca numpy para auxiliar                         
    escalar = int(input('Qual o seu escalar? '))    #Linha 15 até 17 é para realizar o cálculo por escalar.
    result_escalar = A * escalar
    print('Multiplicando pelo escalar:\n')  #Da linha 18 até a 22 imprimindo resultados.
    print(escalar)
    print(result_escalar)
    print()
    print('-_-'*30)
matriz()


print('\033[34mSegundo caso\n')


def cria_matriz_e_faz_por_escalar():   #Nessa a matriz 3x3 é criada automaticamente usando a biblioteca numpy.
    import numpy as np
    matriz = np.random.rand(3,3)   #O np.random.rand(), ele gera uma matriz já em números reais que os valores serão aleatórios
    A = np.array(matriz)    
    escalar = int(input('Qual o seu escalar? ')) 
    result_escalar = A * escalar                           #Vai multiplicar a matriz pelo escalar acima pedido o valor.          
    
    print(matriz)                                # A partir daqui só vai mostrar os resultados
    print('Multiplicando pelo escalar:\n') 
    print(escalar)
    print()
    print(result_escalar)
    print()

cria_matriz_e_faz_por_escalar()







