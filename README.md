
<h1 align="center">
    <a>🚀 CleanArchitecture</a>
</h1>
<p align="center">Microservico Template com Clean Architecture</p>

* [Sobre](#Sobre)


* [Documentação](#Documentação)


* [Grooming](#Grooming)
  * [Sistema](#sistema)
  * [Premissas](#premissas)  
  * [Cenários](#premissas)  

    
* [Principais Fluxos](#principais-fluxos)
  * [Criando Usuario](#criando-usuario)
  * [Buscando Usuario](#buscando-usuario)
  * [Alterando Usuario](#alterando-usuario)
  * [Deletando Usuario](#deletando-usuario)


* [Entradas](#entradas)
  * [HTTP](#http)
  * [Fila](#fila)
  

* [Banco de Dados](#banco-de-dados)
  * [Diagram](#diagram)
  * [Scripts](#scripts)
  

* [Testes](#testes)
  * [Unitários](#unitario)
    * [Lógica](#unit-logica)
    * [Exceção](#unit-exceção)
    * [Stratégias](#unit-stratégias)
    
  * [Integrado](#integrado)
    * [Lógica](#integrate-logica)
    * [Exceção](#integrate-exceção)
    * [Stratégias](#integrate-stratégias)
    

* [Tecnologias](#tecnologias)
  * [Kotlin](#kotlin)
  * [Spring Boot](#spring-boot)
  * [Spring Data](#spring-data)
  * [Spring Security](#spring-data)
  * [Spring Actuator](#spring-data)
  * [Spring LDAP](#spring-ldap)
  * [RabbitMQ](#rabbit-mq)
  * [JUnit](#junit)
  * [Mockito](#mockito)
  * [PostgreSQL](#postgre-sql)
  

* [Design Patter'n](#design-pattern)
  * [Clean Architecture](#clean-architecture)
  * [Strategy](#strategy)
  * [Builder](#builder)
  * [Server Driven UI](#server-driven-ui)
  * [Estrutura de Packages / Nomeclatura dos arquivos](#estrutura-de-packges)  
  * [Padrão de Logs](#padrão-de-logs)
  * [Clean Code](#clean-code)
  * [SOLID](#solid)
  * [GitFlow](#git-flow)
  

* [Personas](#personas)




## Sobre

- Este é um template de microserviço com o padrão Clean Architecture;


- O intuito desse projeto é abordar os conteudos: Ecossistema Spring, Kotlin, Clean Architecture e outros Design Pattern's na prática


- Possui conexão com banco de dados. (PostgreSQL)





## Documentação

- http://localhost:8081/swagger-ui/index.html#/

## Grooming


- O termo se refere à preparação de backlog  (que são os requisitos ou lista de pendências) e é mais adequadamente conhecido como refinamento. É o ato de detalhar, entender mais profundamente, adicionar características, estimar, priorizar e manter o backlog do produto vivo.

#### Sistema

                    CleanArchitecture

    [Servidor]                   Spring Boot

    [Banco de dados]             Spring Data / PostgreSQL

    [Linguagem]                  Kotlin

    [Autenticação]               SpringSecurity / oAuth2 / JWT

    [Design Pattern's]           Clean Architecture / Strategy / Chain Of Responsability / Builder

    [Mensageria]                 Rabbit 

    [Documentação]               Swagger


##### Premissas

    Gerenciar dados do usuario;

    DataBase própria;

    Criação do usuario no LDAP;

    Notificação CRM pós criação;


##### Cenários

    1.Criar Usuario:
        1.1 Criar usuario na base PostgreSQL;
        1.2 Criar usuario no LDAP;
        1.3 Disparar notificação para o ADM;

    2.Buscar Usuario:
        2.1 Buscar todos usuarios;
        2.2 Buscar usuario por CPF;
        2.3 Buscar usuario por nome;

    3.Alterar dados usuario:
        3.1 Se usuario não estiver bloqueado:Alterar dados na base PostgreSQL
        3.2 Se usuario estiver bloqueado: Retornar exceção

    4. Bloquear / Desbloquear usuario: 


## Principais Fluxos

#### Criando usuario;

#### Alterando usuário;

#### Deletando usuário;



## Entradas

#### HTTP

    1. Criar usuario                    POST localhost:8080/v1/user        
    2. Buscar usuario                   GET  localhost:8080/v1/user
    3. Alterar dados usuario            PUT  localhost:8080/v1/user
    4. Bloquear / Desbloquear usuario   PUT  localhost:8080/v1/user

#### Fila

    INP: NotifyCreateUser.INP
    RoutingKey: NotifyCreateUser
    DeadLetter: NotifyCreateUser.BCK.INP
    Routingkey DeadLetter: NotifyCreateUserDL



## Banco de Dados

#### Diagram

![img.png](readme/images/bd_diagram_v2.png)

https://dbdiagram.io/d/604fca9cfcdcb6230b244b20


#### Scripts

                    Create database users;			
			--DROP DATABASE users;
			
			grant all privileges on database users to postgres;	

			CREATE TABLE public.tb_type_user(
			id_type_user bigint PRIMARY KEY,
			name varchar(255),
			active boolean,
			dh_create timestamp,
			dh_update timestamp,
			dh_exclude timestamp);
			
			CREATE TABLE public.tb_user(
			id_user bigint PRIMARY KEY,
			name varchar(255),
			id_type_user bigint,
			cellphone varchar(255),
			email varchar(255),
			active boolean,
			blocked boolean,
			dh_create timestamp,
			dh_update timestamp,
			dh_exclude timestamp);

			CREATE TABLE public.tb_user_address(
			id_user_address bigint PRIMARY KEY,
			id_user bigint,
			cellphone varchar(255),
			country varchar(255),
			state varchar(255),
			city varchar(255),
			district varchar(255),
			street varchar(255),
			zip_code varchar(255),
			dh_create timestamp,
			dh_update timestamp,
			dh_exclude timestamp);




## Testes

#### Unitários

    O que é: São testes feitos pelo desenvolvedor para garantir que o que precisa ser feito, está sendo feito
    
    Pra que serve: Manter tudo que está funcionando OK, por ex, se um desenvolvedor mexer em uma regra PARANDO de salvar um registro que deveria ser salvo, o teste unitário irá acusar erro
    
    Conceitos: Tabelas, Sequences
    
    Tecnologias:
    
    Exemplos:
    
    Links: https://www.devmedia.com.br/e-ai-como-voce-testa-seus-codigos/39478



##### Lógica

![img.png](readme/images/unit_test_logic_one.png)

![img_1.png](readme/images/unit_test_logic_two.png)


##### Exceção


![img_1.png](readme/images/unit_test_exception.png)


##### Stratégias

![img.png](readme/images/unit_test_strategy.png)


##### Links

- https://resources.jetbrains.com/storage/products/kotlinconf2018/slides/4_Best%20Practices%20for%20Unit%20Testing%20in%20Kotlin.pdf


- https://kotlinlang.org/docs/jvm-test-using-junit.html#what-s-next


- https://www.petrikainulainen.net/programming/testing/running-kotlin-tests-with-gradle/


#### Integrado

![Output sample](https://github.com/IagoSMagalhaes/CleanArchitecture/blob/master/readme/images/test_integration.gif)

##### Lógica

![img.png](readme/images/integration_test_logic.png)


##### Exceção

![img.png](readme/images/integration_test_exception.png)

##### Stratégias

![img.png](readme/images/integration_test_strategy.png)

##### Links

- https://learning.postman.com/docs/writing-scripts/script-references/test-examples/


- https://learning.postman.com/docs/writing-scripts/test-scripts/


- https://learning.postman.com/docs/writing-scripts/intro-to-scripts/


## Tecnologias

#### Koltin

- Declarando funções

- Tratando exceção / sucesso

- Extension Function

#### Spring Boot

    O que é: Framework responsavel por construir o servidor de aplicação onde a REGRA DE NEGOCIO será executada
    
    Pra que serve:  Facilitar o processo de configuração e publicação de aplicações que utilizem o ecossistema Spring.
    
    Conceitos: Injeção de Depêndencias, Bean,
    
    Anotações:
    @SpringBootApplication ->
    @EnableWebMvc ->
    @ComponentScan(value = ["com.example"]) ->
    @EntityScan(basePackages = ["com.example"]) ->
    @EnableJpaRepositories(basePackages = ["com.example"]) ->
    @Configuration  ->
    @Bean ->
    
    Exemplos:
    
    Spring Boot é o framework (tecnologia) que permite construir um servidor de aplicação e
    injetar as dependencias necessárias para execução do serviço.
    
    Ele nos facilita na configuração do servidor, com ele, o desenvolvedor abstrai essa responsabilidade.
    
    Com a evolução do SpringBoot, permitiu-se a evolução da arquitetura de microservicos.
    
    Link:https://blog.geekhunter.com.br/tudo-o-que-voce-precisa-saber-sobre-o-spring-boot/


#### Spring Data

    O que é: O SpringData é um projeto da SpringSource com proposta de unificar e facilitar o acesso a diferentes tecnologias de armazenamento de dados, como bancos de dados relacionais (PostgreSQL , Oracle) e os NoSQL (DynamoDB, ElasticSource).
    
    Pra que serve: Framework que provê acesso a bases de dados através da JPA.
    
    Conceitos: namedQuery, query, DataSourceConfiguration
    
    Anotações:

    
    @Table ->
    @Entity ->
    @Colunm ->
    @OneToOne ->
    @OneToMany ->
    @Repository ->
    @Query ->
    @Transacional ->
    
    Exemplos:
    Links: https://www.infoq.com/br/articles/spring-data-intro/#:~:text=O%20SpringData%20%C3%A9%20um%20projeto,dados%20relacionais%20e%20os%20NoSQL.
    
    Spring Data é o framework (tecnologia) que gerencia a interface de comunicação com o Banco de Dados e
    todo o relacionamento das entidades (TABELAS)




#### Spring Security

#### Spring Actuator

    O que é: Spring Boot Actuator é um subprojeto do Spring Boot Framework. Ele usa pontos de extremidade HTTP para expor informações operacionais sobre qualquer aplicativo em execução.

    Conteúdo completo no link seguinte, dispensa comentários.

    Links: https://springframework.guru/actuator-in-spring-boot/

![img.png](readme/images/actuator_json.png)

#### Spring LDAP



- https://www.baeldung.com/spring-data-ldap

#### RabbitMQ

    O que é: Mensageria é um conceito que define que sistemas distribuídos, possam se comunicar por meio de troca de mensagens (evento), sendo estas mensagens “gerenciadas” por um Message Broker (servidor/módulo de mensagens).”
    
    Pra que serve: Processamento ASSÍNCRONO

    O processamento assíncrono é amplamente utilizado principalmente no sentido de resiliencia e no cenario onde NÃO há RETORNO
    ex: resiliencia: pense em um software que executa a abertura de conta, ele precisa fazer 15 integrações para conseguir abrir a conta... isso tanto pode demorar 2min quanto der erro em alguma dessas etapas.
    
    No fluxo assíncrono com Fila, o usuario faz a solicitação da abertura da conta e no mesmo momento ja recebe um OK, o usuario nao fica aguardando os 2 min, a aplicação se encarrega de AVISAR o usuario quando houver concluido o fluxo.
    ex: sem retorno: Atualização de sessão. não tem retorno, o usuario não precisa aguardar.
    
    Conceitos:
        RoutingKey -> Chave de roteamento para fila
    
        DeadLetter -> Cemitérios de filas mortas. Ex: mensagens que dão exceção por algum motivo, caem na deadletter para serem analisadas/ reprocessadas
    
    Tecnologias: RabbitMQ, Kafka, SQS
    
    Exemplos:
    
    Links: https://rockcontent.com/br/blog/postgresql/
    https://4linux.com.br/o-que-e-postgresql/
    
    

#### JUnit

#### Mockito

#### PostgreSQL

    O que é: PostgreSQL é um sistema gerenciador de banco de dados objeto-relacional baseado no POSTGRES, Versão 4.2, desenvolvido na Universidade da Califórnia no Departamento de Ciências da Computação em Berkeley, o qual foi pioneiro em muitos conceitos que vieram a estar disponíveis em alguns bancos de dados comerciais mais tarde
    
    Pra que serve: Banco de dados responsavel por armazenar as tabelas, sequences, e todos os registros.
    
    Conceitos: Tabelas, Sequences
    
        SELECT -> Buscar Registro. select * from schema.tb_usuario where documento = '12345678'
    
        UPDATE -> Atualizar Registro. update schema.tb_usuario set telefone = '' where documento = '12345678'
    
        DELETE -: Deletar registro. delete from schema.tb_usuario where documento = '123545768'


    Exemplos:

    Links: https://rockcontent.com/br/blog/postgresql/

           https://4linux.com.br/o-que-e-postgresql/
    
    


## Design Patter'n

#### Clean Architecture

    O que é: Arquitetura Limpa (Clean Architecture) é um padrão arquitetural proposto por Robert Martin – mais conhecido como Uncle Bob – com o objetivo de promover a implementação de sistemas que favorecem reusabilidade de código, coesão, independência de tecnologia e testabilidade. Se quisermos adotar a classificação do Capítulo 7, a Arquitetura Limpa pode ser considerada como uma arquitetura em camadas.
             É um padrão organizicional de projeto que visa o encapsulamento dos repositórios, otimizando a delegação de responsabilidade, reaproveitamento dos modulos entre os microservicos e o isolamento da camada de service para o banco de dados
    
    Pra que serve:
    
    Conceitos: Entidades e Casos de Uso, Adaptadores
    
    Tecnologias:
    
    Exemplos:
    
    Links: https://engsoftmoderna.info/artigos/arquitetura-limpa.html
           
           https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html



#### Strategy

    O que é: Strategy é um padrão de projeto de software (do inglês design pattern), pode ser chamado de policy. Este padrão foi documentado no Catálogo GOF (Gang of Four), sendo categorizado como um padrão comportamental de desenvolvimento de software.  De modo que delega as responsabilidades adquiridas pelas entidades, atribuindo, portanto, o comportamento. Assim a comunicação entre os objetos é aprimorada, pois há a distribuição das responsabilidades.
    
    Pra que serve: Otimizar soluções
    
    Conceitos:
    
    Tecnologias:
    
    Exemplos:
    
    Links: https://www.devmedia.com.br/estudo-e-aplicacao-do-padrao-de-projeto-strategy/25856
           
    https://pt.wikipedia.org/wiki/Strategy



#### Builder


#### Server Driven UI

- https://vitor-ramos.medium.com/entendendo-o-server-driven-ui-adb469add630


#### Estrutura de Packages / Nomeclatura dos arquivos

            Entities:
              Domain:
                User -> Objeto pertinente a camada do banco;
                UserEntity -> Objeto para transacionar fora da camada de repositorio;

            DTO:
                RequestNotifieCreateUserEntity -> Objeto de request para integrações
                ResponseNotifieCreateUserEntity -> Objeto de retorno de request para integrações

            Enum:
                TypeUserEnum: -> Referencia de Enum;

            Exception:
                UserPostException: -> Classe de exceção;


        Repository:
            Repository:
                UserRepository -> Interface de comunicação com BD;
            Domain
                User -> Classe de referencia ao BD;
            Config
                DataBaseConfig -> Bean de configuração do BD


        Usecases:
            Service:
                UserService -> Interface;
                UserServiceImpl -> Implementação;          


        Web:
            Controller:
                UserController -> Camada responsável por receber as requisições;
            Config
                SwaggerConfig -> Bean responsavel pela config do Swagger


        GatewayRepository:
            LdapRepository:
                GatewayLdapRepository -> Interface de comunicação entre os módulos

            NotifyRepository:
                GatewayNotifyRepository -> Interface de comunicação entre os módulos

        Other'sRepositoies: ex: LDAP
            Gateway:
                GatewayLdapRepositoryImpl -> Implementação do acesso ao módulo do LDAP

            Service:
                LdapService -> Interface da camada de negócio
                LdapServiceImpl -> Impl da camada de negócio

            Client:
                LdapClient -> Client de integração com LDAP 



#### Padrão de Logs

        runCatching {
             LOG.info("START {} user: {} body {}", methodName/service?, cpf, body)

            service.execute();

        }.onFailure {
             LOG.error("ERROR {} user: {} statusCode: {} cause: {} message: {}", methodName/service?, cpf, statusCodeResponse, causeResponse, messageResponse)
            
            throw it

        }.onSucesss {
             LOG.info("END {} user: {}", methodName/service?, cpf)
        }


#### Clean Code

    O que é: Por que estamos falando tanto sobre código limpo (Clean Code) e por que isto é tão importante para nós? De fato a manutenção de um software é tão importante quanto sua construção.
    
    Como relatado por Robert C. Martin em seu livro clássico, Clean Code, um Best Seller da nossa área, algumas práticas e visões são importantíssimas para mantermos a vida do nosso software.
    
    Pra que serve: As empresas investem milhões em softwares todo ano, mas com tantas mudanças no time e nas tecnologias, como fazer este investimento durar? Como garantir uma boa manutenção, durabilidade, vida ao software? Segundo Uncle Bob, as práticas abaixo são o caminho. Boas praticas para melhorar a manutenção do software
    
    Conceitos:
    
    Exemplos:
    
    Links: https://balta.io/blog/clean-code



#### SOLID

    O que é: Boas praticas na programação.
    
    Pra que serve:
    
    Conceitos:
    
    S.O.L.I.D: Os 5 princípios da POO
    S — Single Responsiblity Principle (Princípio da responsabilidade única)
    O — Open-Closed Principle (Princípio Aberto-Fechado)
    L — Liskov Substitution Principle (Princípio da substituição de Liskov)
    I — Interface Segregation Principle (Princípio da Segregação da Interface)
    D — Dependency Inversion Principle (Princípio da inversão da dependência)
    
    Exemplos:
    Links: https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530



#### GitFlow

    O que é: Fluxo de trabalho -> Fluxo de gerenciamento de código   PADRÕES

    Pra que serve: Manter uma estrutura de varios desenvolvimentos em paralelo
    
    Conceitos: MASTER , FEATURE , RELEASE, HOTFIX
    
    Exemplos:
    Links: https://www.atlassian.com/br/git/tutorials/comparing-workflows/gitflow-workflow
    
    
    Padrão de gerenciamento de código, boas práticas.




## Personas

- Robert Martin -> Clean Code && Clean Architecture


## Contact

- https://www.linkedin.com/in/iagomagalh%C3%A3es/



