#Aqui iremos colocar os 3 valores a, b, c pedidos na questão:
valora = float(input('Digite um valor real: '))
valorb = float(input('Digite outro valor real: '))
valorc = float(input('Digite um valor real que seja diferente de 0: '))

#Esse while serve para ver se o valor c é igual a 0, sendo igual ele pede para colocar outro valor:
while True:
    if valorc ==0:
        valorc = float(input('POR FAVOR INSIRA UM VALOR REAL QUE SEJA DIFERENTE DE 0: '))
    else:
        break
#Para inserir o valor inteiro para o número de vezes que ele repita:
valorx = int(input('Insira um valor inteiro: '))
v = 0
#Utilizando o laço for para realizar o cálculo do somatório
for i in range(1, valorx+1):
    v = v+ ((valora + valorb) / valorc**i)
print('O resultado do somatório solicitado é: ',v)
#E acima o print para imprimir o resultado