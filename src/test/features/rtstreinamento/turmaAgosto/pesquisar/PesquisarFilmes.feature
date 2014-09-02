#language:  pt
@validação
Funcionalidade: Pesquisar um filme na loja
  
  Como cliente
  Para facilitar a compra de um produto
  Quero pesquisar um produto na loja

  @validação 
  Cenário: Pesquisar pelo nome completo do filme
    Dado Que o filme "Senhor dos Aneis as duas torres" esteja cadastrado
    Quando Pesquiso o nome completo do filme
    Então Aparece o produto

   
  Esquema do Cenário: Pesquisar por parte do nome filme
    Dado Que o filme "Senhor dos Aneis as duas torres" e " Senhor dos Aneis Sociedade do Anel "estejam cadastrados
    Quando Pesquiso por "<valorPesquisar>"
    Então Aparecem dois filmes

    Cenários: 
      | valorPesquisar |
      | Aneis          |
      | Senhor         |

  @validação 
  Cenário: Pesquisar por filme um não cadastrado
    Dado Que o filme "Homem Aranha" não esteja cadastrado
    Quando Pesquiso por esse filme
    Então Não exibe nenhum resultado na busca

  @validação @execucaoUnica
  Cenário: Pesquisar por filme um indisponível em estoque
    Dado Que o filme "Thor" esteja indisponível
    Quando Pesquiso por esse filme
    Então Visualizo que o filme está indisponível
