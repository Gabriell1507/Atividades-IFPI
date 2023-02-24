#Aqui é onde será feita a escolha dos dois números:
numero1= float(input('Insira um número: '))

numero2 = float(input('Insira outro número: '))

#E aqui nessa condição, utilizando a subtração e divisão inteira, será onde o print vai nos mostrar a diferença dos dois valores escolhidos:
if numero1 // 1 == numero1:
    print(numero1-(numero2 - numero2 //1))
else:
    print(numero2-(numero1 - numero1 //1))