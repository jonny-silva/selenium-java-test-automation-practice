#language: pt

Funcionalidade: Validar item presente no checkout
    
Cenario: Verificar se o produto e adiconado corretamente ao carrinho na pagina de checkout
    Dado que eu selecionei um produto
    E defini a quantidade para 5
    E adicionei o produto ao carrinho
    Quando Eu clicar em proceder para o checkout
    Entao o produto selecionado deve estar presente no carrinho
    E a quantidade deve ser 5