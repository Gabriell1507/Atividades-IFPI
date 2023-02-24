def BinPraDec(binario=int):
    
    decimal = i = 0
    while binario != 0:
        dec = binario % 10
        decimal = decimal + dec * pow(2, i)  #Da linha 3 até a 8 está realizando o cáuculo que faz a conversão de binário para a base decimal.
        binario = binario // 10
        i += 1
    print(decimal)

print('CONVERSOR DE BINÁRIO PRA DECIMAL')
binario = int(input('Digite um binario valido: '))
print(f'\033[32mO número {binario}, em decimal será assim:\n')   #Da linha 11 até a 13 vai ser quando digita o número e a parte lá de cima realiza o trabalho, e na linha 14 chama a função.
BinPraDec(binario)