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

    return cria_matriz_e_faz_por_escalar()