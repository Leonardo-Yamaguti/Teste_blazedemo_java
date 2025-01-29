#language: pt

Funcionalidade: Comprar passagem
    Escolher e comprar passagens aereas

    Cenario: Comprar com sucesso
        Dado que acesso o site "https://blazedemo.com/"
        Quando seleciono a origem "São Paolo" e destino "Cairo"
        E clico no botao Find Flights
        Então visualiza a lista de voos