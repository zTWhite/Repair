import random

def generar_variable_numerica(longitud):
    numeros = "0123456789"
    return ''.join(random.choice(numeros) for _ in range(longitud))

def generar_variable_alfanumerica(longitud):
    caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    return ''.join(random.choice(caracteres) for _ in range(longitud))

def generar_variable_compleja(longitud):
    caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

    # Posiciones aleatorias para colocar guiones
    posiciones = sorted(random.sample(range(longitud), 5))

    guion_index = 0
    complejo = ''
    for i in range(longitud):
        if guion_index < 5 and posiciones[guion_index] == i:
            complejo += '-'
            guion_index += 1
        else:
            complejo += random.choice(caracteres)
    return complejo

def generar_promocodes(cantidad, longitud_numeros, longitud_alfanumerico1, longitud_complejo, longitud_alfanumerico2):
    promocodes = []
    for _ in range(cantidad):
        numeros = generar_variable_numerica(longitud_numeros)
        alfanumerico1 = generar_variable_alfanumerica(longitud_alfanumerico1)
        complejo = generar_variable_compleja(longitud_complejo)
        alfanumerico2 = generar_variable_alfanumerica(longitud_alfanumerico2)
        promocodes.append(f"https://discord.com/billing/partner-promotions/{numeros}/{alfanumerico1}..{alfanumerico2}.{complejo}")
    return promocodes

if __name__ == "__main__":
    cantidad_promocodes = int(input("Ingrese la cantidad de promoCodes que desea generar: "))
    longitud_numeros = 19
    longitud_alfanumerico1 = 39
    longitud_complejo = 238  # 5 guiones y 233 caracteres alfanuméricos
    longitud_alfanumerico2 = 16

    promo_codes = generar_promocodes(cantidad_promocodes, longitud_numeros, longitud_alfanumerico1, longitud_complejo, longitud_alfanumerico2)

    print("PromoCodes generados:")
    for promo_code in promo_codes:
        print(promo_code)

    input("Presione Enter para salir...")
