#Aqui nesses dois prints estão as informações de entrada e saída e também a placa do carro:
print('ENTRADA')
he = int(input('horas: '))
me = int(input('minutos: '))
se = int(input('segundos: '))

print('SAÍDA')
hs = int(input('horas: '))
ms = int(input('minutos: '))
ss = int(input('segundos: '))

#Já aqui está apenas formatando tudo, e deixando a placa do carro em caixa alta:
placa = input('Placa do veículo: ').upper()

print('Horário de entrada: {}h:{}m:{}s'.format(he, me, se))
print('Horário de saída: {}h:{}m:{}s'.format(hs, ms, ss))
print('Placa: {}'.format(placa))

#Essa fórmula é para converter tudo para minutos, facilitando o programa 
hf = hs - he
mf = ms - me
sf = ss - se

print(f'{hf}:{mf}:{sf}')

hf = hf*60
sf = sf/60
tempo_final = hf + mf + sf

#E aqui vai dizer se o carro foi taxado, utilizando as condições if e elif para melhor resultado:
print(tempo_final)
if tempo_final <= 15:
    print('Não será cobrado taxa')
elif tempo_final  <= 60:
    taxa = (tempo_final - 15) * 0.09
    print('A sua taxa será de R${:.2f}'.format(taxa))
elif tempo_final <= 120:
    taxa = ((tempo_final - 60) * 0.12) + 4.05
    print('A sua taxa será de R${:.2f}'.format(taxa))
elif tempo_final > 120:
    taxa = ((tempo_final - 120 ) * 0.20) + 4.05 + 7.20
    print('A sua taxa será de R${:.2f}'.format(taxa))
    
print()