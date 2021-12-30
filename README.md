
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
  * [Integrado](#integrado)


* [Tecnologias](#tecnologias)
  * [Spring Boot](#spring-boot)
  * [Spring Data](#spring-data)
  * [Spring Security](#spring-data)
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
  

* [Personas](#personas)




## Sobre

- Este é o microservico template com Clean Architecture;


- Possui conexão com banco de dados. (PostgreSQL)


- O intuito desse projeto é abordar os conteudos: Ecossistema Spring, Kotlin, Clean Architecture e outros Design Pattern's na prática



## Documentação

- http://localhost:8081/swagger-ui/index.html#/

## Grooming


- O termo se refere à preparação de backlog  (que são os requisitos ou lista de pendências) e é mais adequadamente conhecido como refinamento. É o ato de detalhar, entender mais profundamente, adicionar características, estimar, priorizar e manter o backlog do produto vivo.

#### Sistema

                    HumanGenerator

    [Servidor]                   Spring Boot

    [Banco de dados]             Spring Data / PostgreSQL

    [Linguagem]                  Kotlin

    [Autenticação]               SpringSecurity / oAuth2 / JWT

    [Design Pattern's]           Clean Architecture / Strategy / Chain Of Responsability / Builder

    [Mensageria]                 Rabbit 

    [Documentação do Projeto]    Swagger


##### Premissas

    Gerenciar dados de humanos;

    DataBase própria;

    Criação do usuario no LDAP;

    Notificar em Tópico os usuarios criados;


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

#### Criando um Usuario;

#### Criando um humano;

#### Buscando um humano;



## Entradas

#### HTTP

    1. Criar usuario                    POST localhost:8080/v1/user        
    2. Buscar usuario                   GET  localhost:8080/v1/user
    3. Alterar dados usuario            PUT  localhost:8080/v1/user
    4. Bloquear / Desbloquear usuario   PUT  localhost:8080/v1/user

#### Fila


###### Filas

    INP: NotifyCreateUser.INP
    RoutingKey: NotifyCreateUser
    DeadLetter: NotifyCreateUser.BCK.INP
    Routingkey DeadLetter: NotifyCreateUserDL



## Banco de Dados

#### Diagram

#### Scripts

                    Create database users;			
			--DROP DATABASE users;
			
			grant all privileges on database users to postgres;			
			
			CREATE TABLE public.tb_usuario(
			id_usuario bigint PRIMARY KEY,
			nome varchar(255),
			telefone varchar(255),
			email varchar(255),
			ativo boolean,
			bloqueado boolean,
			dh_criacao timestamp,
			dh_alteracao timestamp,
			dh_exclusao timestamp);




## Testes

#### Unitários

#### Integrado


## Tecnologias

#### Spring Boot

#### Spring Data

#### Spring Security

#### JUnit

#### Mockito

#### PostgreSQL
        Clean Architecture    

        Strategy              

        Builder               https://pt.wikipedia.org/wiki/Builder

        Swagger               https://medium.com/@raphaelbluteau/spring-boot-swagger-documentando-sua-api-automaticamente-27903293aeb6


## Design Patter'n

#### Clean Architecture

- https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

#### Strategy

- https://en.wikipedia.org/wiki/Strategy_pattern


#### Builder


#### Server Driven UI

- https://vitor-ramos.medium.com/entendendo-o-server-driven-ui-adb469add630


#### Estrutura de Packages / Nomeclatura dos arquivos

            Entities:
              Domain:
                User -> Objjeto pertinente a camada do banco;
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
            // LOG.info("START {} user: {} body {}", methodName/service?, cpf, body)

            service.execute();

        }.onFailure {
            // LOG.error("ERROR {} user: {} statusCode: {} cause: {} message: {}", methodName/service?, cpf, statusCodeResponse, causeResponse, messageResponse)
            
            throw it

        }.onSucesss {
            // LOG.info("END {} user: {}", methodName/service?, cpf)
        }


## Personas

- Robert Martin -> Clean Code && Clean Architecture


## Contact

- https://www.linkedin.com/in/iagomagalh%C3%A3es/



