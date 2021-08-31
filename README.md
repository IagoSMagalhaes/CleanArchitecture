# Getting Started

### Reference Documentation

* [Objetivos](Objetivos)


* [Grooming](Grooming)


* [Banco de Dados](Banco de Dados)


* [Design Pattern's](Design Pattern's)


#### Objetivos

    Conhecer o ecossistema Spring / Arquitetura limpa na prática



#### Grooming

                    UserMicroservice

    [Servidor]                   Spring Boot

    [Banco de dados]             PostgreSQL / Spring Data

    [Linguagem]                  Kotlin

    [Autenticação]               SpringSecurity / oAuth2 / JWT

    [Design Pattern's]           Clean Architecture / Strategy / Builder

    [Documentação do Projeto]    Swagger


###### Ações


    - Criar usuario                    POST localhost:8080/v1/user
    - Buscar usuario                   GET  localhost:8080/v1/user
    - Alterar dados usuario            PUT  localhost:8080/v1/user
    - Bloquear / Desbloquear usuario   PUT  localhost:8080/v1/user


###### Filas

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



#### Design Pattern's

        Clean Architecture    https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

        Strategy              https://en.wikipedia.org/wiki/Strategy_pattern

        Builder               https://pt.wikipedia.org/wiki/Builder
