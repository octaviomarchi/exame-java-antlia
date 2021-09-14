# Frontend Angular

O projeto foi gerado com [Angular CLI](https://github.com/angular/angular-cli) versão 12.2.5.

## Requisitos para execução
- NodeJs v14
- @angular/cli

## Execução do Projeto

1. Na pasta do projeto, execute `npm install`. Isso irá baixar as dependências do projeto.
2. Execute `ng serve [-o]` (O atributo `-o` faz com que o navegador seja aberto assim que o servidor estiver funcionando).
3. URL base: <http://localhost:4200>.

## Funcionamento
1. Ao iniciar, a aplicação irá buscar os produtos no backend.
2. Clique em **Novo** para habilitar o formulário.
3. Somente no momento que o Produto for escolhido que a aplicação ira buscar os _Cosifs_.
   1. Ao trocar o _Produto_, o _Cosif_ vai ser atualizado com os _Cosifs_ disponíveis para o novo _Produto_
4. Ao clicar em **Inserir**, a aplicação irá fazer uma chamada para salvar as informações no banco.
5. No momento que essas informações foram salvas e retornadas, serão incluídas numa tabela abaixo do formulário.
