# Getting Started

### Reference Documentation

* [Objetivos](#Objetivos)


* [Grooming](#Grooming)


* [Sistema](#Sistema)


* [Premissas](#Premissas)


* [Ações](#Ações)


* [Cenarios](#Cenarios)


* [Filas](#Filas)


* [Banco de Dados](#BancoDeDados)


* [Estrutura de Packages / Padrão nomeclatura arquivos](#)


* [Padrão de logs](#Padrãodelogs)


* [Link's reference](#Link'sreference)


## Objetivos


Abordar os conteudos: Ecossistema Spring, Kotlin e o Clean Architectura e outros Design Pattern's na prática



## Grooming


O termo se refere à preparação de backlog  (que são os requisitos ou lista de pendências) e é mais adequadamente conhecido como refinamento. É o ato de detalhar, entender mais profundamente, adicionar características, estimar, priorizar e manter o backlog do produto vivo.


##### Sistema

                    UserMicroservice

    [Servidor]                   Spring Boot

    [Banco de dados]             Spring Data / PostgreSQL

    [Linguagem]                  Kotlin

    [Autenticação]               SpringSecurity / oAuth2 / JWT

    [Design Pattern's]           Clean Architecture / Strategy / Chain Of Responsability / Builder

    [Documentação do Projeto]    Swagger


###### Premissas

    Gerenciar dados dos usuarios;

    DataBase própria;

    Criação do usuario no LDAP;

    Notificar em Tópico os usuarios criados;


###### Ações


    1. Criar usuario                    POST localhost:8080/v1/user        
    2. Buscar usuario                   GET  localhost:8080/v1/user
    3. Alterar dados usuario            PUT  localhost:8080/v1/user
    4. Bloquear / Desbloquear usuario   PUT  localhost:8080/v1/user



###### Cenarios

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
        



###### Filas

    INP: NotifyCreateUser.INP
    RoutingKey: NotifyCreateUser
    DeadLetter: NotifyCreateUser.BCK.INP
    Routingkey DeadLetter: NotifyCreateUserDL


###### Integrações Externas

    N/A

###### FrontEnd

    N/A


#### Banco de Dados

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



#### Estrutura de Packages / Padrão nomeclatura arquivos


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
        


#### Padrão de logs

        runCatching {
            LOG.info("START {} user: {} body {}", methodName/service?, cpf, body)

            service.execute();

        }.onFailure {
            LOG.error("ERROR {} user: {} statusCode: {} cause: {} message: {}", methodName/service?, cpf, statusCodeResponse, causeResponse, messageResponse)
            
            throw it

        }.onSucesss {
            LOG.info("END {} user: {}", methodName/service?, cpf)
        }


#### Link's reference

        Clean Architecture    https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

        Strategy              https://en.wikipedia.org/wiki/Strategy_pattern

        Builder               https://pt.wikipedia.org/wiki/Builder

        Swagger               https://medium.com/@raphaelbluteau/spring-boot-swagger-documentando-sua-api-automaticamente-27903293aeb6


#### Personas


Robert Martin -> Clean Code && Clean Architecture