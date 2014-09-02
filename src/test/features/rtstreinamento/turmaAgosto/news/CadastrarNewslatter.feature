#language:  pt
Funcionalidade: Cadastrar e-mail na Newsletter
  Como cliente
  Para enviar ofertas
  Quero um campo de Newsletter na home do site

  Contexto: 
    Dado que eu queira me cadastrar na newsletter

  @validação 
  Cenário: Cadastrar e-mail válido na Newsletter
    Dado que o e-mail não esteja cadastrado
    Quando cadastro esse e-mail
    Então recebo uma mensagem de sucesso

  @exceção 
  Cenário: Não permitir e-mail seja cadastrado mais de uma vez
    Dado que o e-mail "joao@gmail.com" já tenha sido cadastrado
    Quando cadastro o e-mail "joao@gmail.com"
    Entao recebo mensagem de erro

  @exceção @execução-manual
  Cenário: Não permitir e-mail fora do formato
    Quando cadastro o e-mail "gmail.com"
    Entao recebo mensagem de erro invalido
