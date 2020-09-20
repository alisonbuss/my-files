<!-- Destacar embremas/crachas http://shields.io/ -->

# Formulation
### API REST para criação de formulários de perguntas e respostas e análises dos dados com ênfase em micro-serviços.


&nbsp;


> **Nota do Projeto:**
> 
> Trabalho de Conclusão de Curso para Tecnólogo em Sistema Para Internet da 
  Universidade Tiradentes, sob orientação do prof. M. Sc. Fabio Gomes Rocha, 
  como um dos requisito para obtenção do título de Tecnólogo em Sistema Para 
  Internet.
>
> - **Autor:** Alison Buss de Arruda.
> - **Contato:** alisonbuss.dev@gmail.com.
> - **Dando Início:** 03/03/2017 Aracaju - (SE).
> - **Status do Projeto:** Em andamento.
>


## **Índice do Conteúdo** 

- [1 - Visão Geral do Projeto](#user-content-1---visão-geral-do-projeto)
- [2 - Objetivos do Projeto](#user-content-2---objetivos-do-projeto)
- [3 - Tecnologia Principal](#user-content-3---tecnologia-principal)
- [4 - Disponibilidade](#user-content-4---disponibilidade)
- [5 - Ambiente](#user-content-5---ambiente)
  - [5.1 - Modelo do Ambiente de Desenvolvimento](#user-content-51---modelo-do-ambiente-de-desenvolvimento)
  - [5.2 - Modelo do Ambiente de Teste](#user-content-52---modelo-do-ambiente-de-testes)
  - [5.3 - Modelo de Ambiente de Produção](#user-content-53---modelo-de-ambiente-de-produção)
- [6 - Requisitos do Ambiente](#ancora)  
  - [6.1 - Requisitos Não-Funcionais](#ancora)
    - [6.1.1 - RNF de Entrega](#ancora)
    - [6.1.2 - RNF de Padrão](#ancora)
    - [6.1.3 - RNF de Implementação](#ancora)
    - [6.1.4 - RNF de Confiabilidade](#ancora)
    - [6.1.5 - RNF de Portabilidade](#ancora)
    - [6.1.6 - RNF de Desempenho](#ancora)
    - [6.1.7 - RNF de Espaço](#ancora)
    - [6.1.8 - RNF de Interoperabilidade](#ancora)
    - [6.1.9 - RNF de Segurança](#ancora)
  - [6.2 - Requisitos Funcionais](#ancora)
      - [6.2.1 - RF01 Regra Xxx...](#ancora)
      - [6.2.2 - RF02 Regra Xxx...](#ancora)
  - [6.3 - Diagramas...](#ancora) 
- [7 - Modularização do Domínio/Negócio/MicroService](#ancora)
  - [7.1 - Módulo Xxx...](#ancora)
    - [7.1.1 - Requisitos Não-Funcionais](#ancora)
      - [7.1.1.1 - RNF de Entrega](#ancora)
      - [7.1.1.2 - RNF de Padrão](#ancora)
      - [7.1.1.3 - RNF de Implementação](#ancora)
      - [7.1.1.4 - RNF de Confiabilidade](#ancora)
      - [7.1.1.5 - RNF de Portabilidade](#ancora)
      - [7.1.1.6 - RNF de Desempenho](#ancora)
      - [7.1.1.7 - RNF de Espaço](#ancora)
      - [7.1.1.8 - RNF de Interoperabilidade](#ancora)
      - [7.1.1.9 - RNF de Segurança](#ancora)
    - [7.1.2 - Requisitos Funcionais](#ancora)
      - [7.1.2.1 - RF01 Regra Xxx...](#ancora)
      - [7.1.2.2 - RF02 Regra Xxx...](#ancora)
    - [7.1.3 - Diagrama de Caso de Uso](#ancora)
      - [7.1.3.1 - DCU01 Regra Xxx...](#ancora)
    - [7.1.4 - Diagrama Entidade Relacionamento (DER)](#ancora)
- [8 - Considerações Finais](#user-content-8---considerações-finais)
- [9 - Referências](#user-content-9---referências)
 

<!--
EXEMPLO DE CONTEUDO POR SESSÃO:

---------- 
-- SESSÃO ##################################################################################### --
## Nº - Titulo... 

Conteúdo...

#### Voltar para o <*[Índice do Conteúdo](#indice-do-conteudo)*>

#### **REFERÊNCIAS:**

* WIKIPÉDIA, Fulano de Tau. ***Titulo Post...*** 
  Acessado: *11 de Setembro de 2016.*
  Disponível: *[http://link.com/qlqr](http://link.com/qlqr)*.
* Beutrano Araujo Junior. ***Titulo do Livro...*** 
  *2ª Edição -- São Paulo -- Novatec Editora, 2011*
-->

 
<!-- SESSÃO ##################################################################################### -->
## 1 - Visão Geral do Projeto 

O **Formulation** é projeto Open Source de serviços REST de criação de formulários 
de perguntas e respostas e análises dos dados, com a finalidade de fornecer 
acesso programático para ler e gravar dados, todo o seu núcleo é baseado na 
arquitetura de micro-serviços com alta coesão, baixo acoplamento, autônomo e 
independente, garantindo segurança e performance, feito sobre medida, para uma 
plataforma de serviços de nuvem via Internet, assim disponibilizando os serviços 
24 horas por dia, 7 dias por semana, com esse ambiente, forneço a possibilidade 
de integração com qualquer tipo de aplicativo, sendo, mobile, web, desktop, 
smart TV e web services, disponibilizando e interagindo com vários aplicativos 
com milhares de acessos, dando ao **Formulation** um potencial de Big Data.    

As APIs REST do **Formulation** fornecem serviços básicos para a criação de 
formulários de perguntas e respostas e análises dos dados, os aplicativos 
que se integrarem a esses serviços REST tem a possibilidade de atender aos 
requisitos iniciais:

- Criação de formulários de perguntas e respostas;
- Integrar-se com colaboradores para auxiliar na manipulação dos formulários;
- Definir grupos de pessoas para responder à um determinado formulário;
- Publicar formulário para um determinado grupo de pessoas ou ao público, para 
  ser respondido;
- Submeter várias respostas para um determinado formulário;
- Gerar análise dos dados das respostas de um determinado formulário;
- Publicar dados das resposta de um determinado formulários para um determinado 
  grupo de pessoas ou ao público;
- Publicar dados gerados pela análise das respostas para um determinado grupo 
  de pessoas ou ao público.

Com esses requisitos iniciais, os aplicativos que se integram ao Formulation 
poderão  fornecer às pessoas, empresas e instituições, várias linha de estudos 
(exemplo, Censo Demográfico), como, geociências, estatísticas sociais e 
econômicas entre outros temas, definido como o conjunto das operações que 
consistem em recolher, agrupar, analisar e publicar dados relativos a um 
momento determinado ou em certos períodos.


#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>

 
<!-- SESSÃO ##################################################################################### -->
## 2 - Objetivos do Projeto

O principal objetivo do projeto **Formulation** é atender de média a grande 
quantidade de acessos às APIs REST do projeto de forma segura, ágil e 
escalável.  Focando principalmente na sua infraestrutura, arquitetura e ao 
código, tornando-se assim um projeto de sucesso, satisfazendo o cliente e 
toda a equipe do projeto. 

Para que o projeto garanta essas virtudes, concentrei-me em dar foco nos três 
pilares principais do projeto, na sua infraestrutura, arquitetura e ao código, 
com base nos conhecimento da academia, experiência profissional e no constante 
dinamismo tecnológico do mercado global nas suas soluções.

Antes de começar as especificações do negócio, proponho construir uma base para 
o projeto, deixando assim o negócio por último, dando ênfase primeiramente na 
infraestrutura, arquitetura e ao código e só depois começar as especificações 
do negócio e a suas codificações, caso negócio exija posteriormente algum tipo 
de mudança nos três pilares do projeto, será muito mais fácil de contemplar 
essas mudanças por conta de se utilizar uma ótima estratégia dos três pilares.
Vale ressaltar que adotando essa estratégia dos três pilares, garanto a 
possibilidade de aproveitar essa estrutura base para vários outros negócios 
novos, economizando tempo, dinheiro e esforço da equipe.

Basicamente a estratégia dos três pilares consiste em um conceito simples: 

1. **Infraestrutura:** Uma boa estratégia de infraestrutura é ter possibilidades 
   de escalonamento e a automação entre suas infraestruturas, reduzindo ou 
   aumentando os custos na medida certa, de acordo com as necessidades do 
   cliente, sem prejudicar o projeto em produção, ou seja ter a capacidade de 
   monitorar, gerenciar e distribuir cargas com agilidade e fornecer de forma 
   rápida e segura, serviços por meio de APIs, podendo usar instâncias remotas, 
   por exemplo no Amazon Web Services (AWS), DigitalOcean ou OpenShift;

2. **Arquitetura:** Baseada em micro-serviços, trata-se de uma arquitetura que 
   permite que pequenos serviços de aplicação coexistam e se comuniquem entre si 
   através de APIs REST, de modo seguro, escalável, alta coesão, baixo acoplamento, 
   autônomo, independente, permitindo que novos serviços possam ser incluídos na 
   plataforma a qualquer momento, complementando as funcionalidades já existentes. 
   Observe-se que não se trata de um único produto composto por múltiplos serviços 
   relacionados, mas sim de uma plataforma de agregação de serviços, podendo 
   utilizar-se de containers LXC ou Docker.

3. **Codificação:** Baseia-se no conceito de Domain-Driven Design ou Projeto 
   Orientado ao Domínio é um padrão de modelagem de software orientado a objetos 
   que procura reforçar conceitos e boas práticas relacionadas à Orientação a 
   Objetos com foco na modelagem das entidades principais de negócio usando a 
   linguagem adequada daquele domínio para facilitar a manutenção, extensão e 
   entendimento, aplicando-se o conceito de Contextos Delimitados do DDD, divido 
   um domínio (Negócio) complexo em múltiplos contextos limitados e mapeando o 
   relacionamento entre eles, obtendo assim separações do domínio e formando os 
   micro-serviços, atendendo de forma natural e eficaz a **Infraestrutura** e a 
   **Arquitetura** do projeto.


#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>

 
<!-- SESSÃO ##################################################################################### -->
## 3 - Tecnologia Principal 

A tecnologia principal do projeto baseia-se em  APIs REST, toda a comunicação 
entre cliente e servidor será através de APIs REST, inclusive de micro-serviço 
para micro-serviço sobre o protocolo HTTPS.

> **Nota:**
> - **API** significa Application Programming Interface (ou **Interface de Programação 
    de Aplicativos**, em tradução livre), é um conjunto de rotinas e padrões de 
    programação para acesso a um aplicativo de software ou plataforma baseada 
    na Web.
>    
> - **REST** significa Representational State Transfer (ou **Transferência de Estado 
    Representacional**, em tradução livre), é um conjunto de princípios e abstração 
    dos elementos arquitetônicos que definem como Web Standards e portanto, a 
    essência de seu comportamento como uma aplicação baseada no HTTP e URIs.
>
> - **API REST** é uma Interface de Programação de Aplicativos (**API**) que usa 
    solicitações HTTP (com o conceito **REST**) especificando o tipo do método GET, 
    POST, PUT, HEAD ou DELETE dos dados solicitados, representados por URIs.


#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>

 
<!-- SESSÃO ##################################################################################### -->
## 4 - Disponibilidade

A proposta de disponibilidade do projeto será de 24 horas por dia, 7 dias por 
semana, sem interrupções, garantindo assim o objetivo do projeto de atender de 
média a grande quantidade de acessos às APIs REST de forma segura, ágil e 
escalável.


#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>

 
<!-- SESSÃO ##################################################################################### -->
## 5 - Ambiente

O ambiente será constituído por desenvolvimento, teste e produção, com o 
propósito de obter uma orquestração sofisticado de todo o seu ambiente, dando 
uma incrível agilidade em todo o seu processo.

No ambiente de desenvolvimento o deploy (instalação da aplicação em um servidor
de aplicações) dos micro-serviços será executado em uma VM (máquina virtual), 
já o ambiente de teste e produção poderam ser implantado em um o ambiente que 
consiste basicamente de uma plataforma de serviços de nuvem como Amazon Web 
Services (AWS), DigitalOcean ou OpenShift entre outros serviços de nuvem, 
operando sobre sistema operacional linux CoreOS desenvolvido para ser tolerante 
à falhas e fácil de escalar suportado nativamente o funcionamento em cluster e 
com um software de gerenciamento de contêiner Kubernetes com recursos 
essenciais como, balanceamento automático de carga, replicação de containers 
entre outros recurso, utilizando containers Docker para rodar os micro-serviços.
Todos o versionamento do projeto será operado por um sistema de controle de 
versão descentralizado Git, para um repositórios no GitHub.

> **Nota:**
>
> *Todo o ambiente de desenvolvimento, teste e produção será documentado ao 
   longo do tempo, ou seja, esse documento será alterado periodicamente.*


#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>

 
<!-- SESSÃO ##################################################################################### -->
## 5.1 - Modelo do Ambiente de Desenvolvimento
    
    ...

#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>

 
<!-- SESSÃO ##################################################################################### -->
## 5.2 - Modelo do Ambiente de Testes
    
    ...

#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>

 
<!-- SESSÃO ##################################################################################### -->
## 5.3 - Modelo de Ambiente de Produção
    
    ...

#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>


<!-- SESSÃO ##################################################################################### -->
## 8 - Considerações Finais
 
> Se o monolítico o aprisiona, o micro-serviço o libertará!   
> *por Alison Buss de Arruda.*

#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>


<!-- SESSÃO ##################################################################################### -->
## 9 - Referências

* WIKIPÉDIA, Fulano de Tau. ***Titulo Post...*** 
  Acessado: *11 de Setembro de 2016.*
  Disponível: *[http://link.com/qlqr](http://link.com/qlqr)*.
* Beutrano Araujo Junior. ***Titulo do Livro...*** 
  *2ª Edição -- São Paulo -- Novatec Editora, 2011*.

https://en.wikipedia.org/wiki/Application_programming_interface  
http://searchexchange.techtarget.com/definition/application-program-interface  
https://www.infoq.com/br/articles/rest-introduction  
https://aws.amazon.com/pt/what-is-cloud-computing/  
http://www.obomprogramador.com/2015/03/micro-servicos-o-que-sao-e-para-que.html  
https://pt.wikipedia.org/wiki/Instituto_Brasileiro_de_Geografia_e_Estat%C3%ADstica  
https://pt.wikipedia.org/wiki/Censo_demogr%C3%A1fico  
https://nandovieira.com.br/entendendo-um-pouco-mais-sobre-o-protocolo-http  
https://code.tutsplus.com/pt/tutorials/a-beginners-guide-to-http-and-rest--net-16340  
http://blog.da2k.com.br/2015/02/08/aprenda-markdown/  
https://www.infoq.com/br/articles/microservices-intro  
http://www.rafaelromao.com/2014/03/arquitetura-de-micro-servicos-e-ddd.html  
https://www.upguard.com/articles/docker-vs-lxc  
http://luizricardo.org/2014/11/quando-usar-o-domain-driven-design-ddd/  
http://dddcommunity.flywheelsites.com/learning-ddd/what_is_ddd/  
http://www.agileandart.com/2010/07/16/ddd-introducao-a-domain-driven-design/  
http://www.pedromendes.com.br/2016/01/02/microservicos/  
http://labs.bluesoft.com.br/core-os/  
https://coreos.com/tectonic/docs/latest/  
https://kubernetes.io/docs/  

#### Voltar para o <*[Índice do Conteúdo](#user-content-Índice-do-conteúdo)*>



