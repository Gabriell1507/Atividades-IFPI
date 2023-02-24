def crazy_string():
    from random import choice
    entrada = input('Insira a string: ')
    entrada2 = input('Insira a outra string: ')
    saída = ''.join(choice((str.upper, str.lower))  #Utilizando o join para juntar a string, e com ajuda do random choice, junto ao laço for abaixo, para alternar entre maiúsculo e minúsculo.
    (letra) for letra in entrada)
    saída2 = ''.join(choice((str.upper, str.lower))  #Imprimindo a segunda saída
    (letra) for letra in entrada)
    print('Imprimindo a saída...') #Imprimindo o resultado de como fica a string.
    print('\033[36m')
    print(saída)
    print(saída2)
    
crazy_string()


