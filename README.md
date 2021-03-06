# Projeto API de Canais de Atendimento do Open Banking Brasil

## Open Banking Brasil
O que é Open Banking?
O Open Banking, ou sistema financeiro aberto, propicia o compartilhamento padronizado de dados e serviços por meio de APIs (Application Programming Interfaces) por parte de instituições financeiras e demais instituições autorizadas a funcionar pelo Banco Central do Brasil. No caso de dados de clientes (pessoa física ou jurídica) é o cliente que decidirá quando e com quem ele deseja compartilhá-los no escopo do Open Banking, desde que seja com finalidades específicas e prazos determinados.

## API de Canais de Atendimento
As APIs de Canais de Atendimento, são APIs de dados abertos, que visam exibir e compartilhar dados não sensíveis de instituições participantes do Open Banking Brasil, disponibilizando ao público informações sobre os seus canais de atendimento.

### Modelagem da API
Este projeto conclui a primeira etapa da trilha Sensedia para estagiários do time de consultoria. E foi modelado com base na API de Canais de Atendimento do Open Banking.
Esta aplicação foi contruída, utilizando-se o framework Spring Boot, sendo gerado o projeto inicial pelo site do Spring initializr, usando o Maven como ferramenta de automação e gerenciamento de projetos Java.

Na pasta src/main/java, encontram-se os pacotes:
    bonifacio.sousa.canaisdeatendimentos;
    bonifacio.sousa.canaisdeatendimentos.config.validacao;
    bonifacio.sousa.canaisdeatendimentos.controller;
    bonifacio.sousa.canaisdeatendimentos.controller.dto;
    bonifacio.sousa.canaisdeatendimentos.controller.form;
    bonifacio.sousa.canaisdeatendimentos.repository;
    bonifacio.sousa.canaisdeatendimentos.swagger; e
    bonifacio.sousa.canaisdeatendimentos.tipos;

A classe principal do projeto eatá no pacote bonifacio.sousa.canaisdeatendimentos.
As classes de domínio da aplicação estão no pacote bonifacio.sousa.canaisdeatendimentos.tipos, onde foram definidos os tipos de canais de atendimento utilizados nesta aplicação, a saber:
    A classe *CanaisDeAtendimentoEletronico.java*, representa os tipos de canais de atendimento eletrônico da aplicação e que tem as informações: "id", "tipo" e "nome".
    A classe *CorrespondentesBancarios.java*, guarda as informações como: "id", "nomeDoCorrespondente", "cnpjDoCorrespondente" e o "local" do correspondente bancario.
    Na classe *DependenciasProprias.java*, são armazenas as informações dos estabelicimentos físicos, como: id, nome, cnpj, localidade.
    E a classe *TerminalDeAutoatendimentoCompartilhado.java* contém informações dos terminais de autoatendimento compatilhado da aplicação, como: id, nomeEmpresa, cnpjEmpresa, localidade.
Os endpoints da aplicação são realizados por meio das classes controller, que estão no pacote bonifacio.sousa.canaisdeatendimentos.controller.
No pacote bonifacio.sousa.canaisdeatendimentos.controller.dto, estão as classes DTO *(Data Transfer Object)*, essas classes dão flexibilidade a aplicação, pois consigo controlar quais atributos quero devolver nos endpoints.
Para isolar o acesso ao banco de dados foi criada a interface *repository*, que herda da interface *JpaRepository* os seus métodos, e faz o acesso ao banco de dados via JPA, foi criada uma interface para cada tipo de canais de atendimento desta aplicação, e estão no pacote bonifacio.sousa.canaisdeatendimentos.repository.
No pacote bonifacio.sousa.canaisdeatendimentos.controller.form, estão as classes Form, essas classes permitem que a API receba os dados do usuário e cadastre essas informações no banco de dados.
No pacote bonifacio.sousa.canaisdeatendimentos.config.validacao, foram criadas as classes ErroDeValidacaoHandler e ErroDeRequisicaoDto. A classe ErroDeValidacaoHandler faz o tratamento dos erros de validação, ela funciona como um *intercptor*, o *interceptor ControllerAdvice*, para que, quando ocorra uma *exception*, em qualquer método *Controller*, o *Spring* automaticamente chame esse *intercptor*. A classe ErroDeRequisicaoDto representa um erro de validação, ela devolve um JSON personalizado, quando algum campo é inválido.
O pacote bonifacio.sousa.canaisdeatendimentos.swagger, contém a configuração para a geração automática do swagger.
No arquivo pom.xml estão todas as dependências utilizadas neste projeto.

### Melhoria contínua do projeto
Visando o desenvolvimento contínuo do projeto, minhas próximas melhorias serão na parte de segurança da API, com a criação de login para acesso a aplicação, inserção de mais dados de identificação dos tipos de canais de atendimento.

## Sobre o autor
Em transição de carreira para a área de Tecnologia da Informação, estudando Tecnologia em Análise e Desenvolvimento de Sistemas e estagiando na Sensedia na área de Consultoria, no segmento de Open Banking com uma abordagem arquitetônica em Microsserviços. O projeto aborda a API de Canais de Atendimento que faz parte do escopo do Open Banking.
