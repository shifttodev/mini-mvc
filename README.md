
<div style="text-align: center">
    <h1 style="text-align: center">Mini MVC</h1>
</div>

## Índice

- [Sobre](#sobre)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Como utilizar o projeto](#como-utilizar-o-projeto)
    - [Requerimentos necessários](#requerimentos-necessários)
    - [Configuração](#configuração)
         
## Sobre

Este projeto fornece uma introdução prática e didática ao uso de dois padrões de projetos - MVC e DAO.

A aplicação consiste em um CRUD, utilizando banco de dados com H2, que implementa as operações CREATE, READ, UPDATE e DELETE.


## Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- Java 8
- Servlet 4
- JSTL 1.2
- Lombok 1.18
- JavaFaker
- H2

## Como utilizar o projeto

### Requerimentos necessários

- Java 8 previamente configurado

#### Configure o H2

- baixe a lib em [h2database](http://www.h2database.com/html/main.html)
- descompacte, configure, crie uma base de dados e suba o servidor

```
$ unzip h2*.zip
$ move h2* /opt
$ java -cp /opt/h2/bin/h2-2.2.224.jar org.h2.tools.Shell
Welcome to H2 Shell 2.2.224 (2023-09-17)
Exit with Ctrl+C
URL       jdbc:h2:~/workspace/h2dbs/appdb2
Driver    org.h2.Driver
User      sa
Password  
sql> CREATE TABLE PUBLIC.LIVRO (
	ID INTEGER NOT NULL AUTO_INCREMENT,
	ISBN CHARACTER VARYING(13) NOT NULL,
	TITULO CHARACTER VARYING(50) NOT NULL,
	AUTOR CHARACTER VARYING(50) NOT NULL,
	ANO INTEGER NOT NULL,
	CONSTRAINT CONSTRAINT_4 PRIMARY KEY (ID),
	CONSTRAINT CONSTRAINT_45 UNIQUE (ISBN)
);
sql> CREATE UNIQUE INDEX CONSTRAINT_INDEX_4 ON PUBLIC.LIVRO (ISBN);
sql> CREATE UNIQUE INDEX PRIMARY_KEY_4 ON PUBLIC.LIVRO (ID);
sql> quit 
$ java -cp /opt/h2/bin/h2*.jar org.h2.tools.Server
```

#### Baixe o projeto

- clone o projeto e importe no Intellij.

```bash
$ git clone https://github.com/shifttodev/mini-mvc.git
```

### Configure o acesso ao banco

- renomeie o arquivo `env`, na pasta resources para `.env`
- configure suas propriedades de acesso ao banco conforme seu contexto:

```
H2_URL_TCP=jdbc:h2:tcp://host-do-banco/local-do-banco
H2_USER=user
H2_PASS=password
```

Execute a aplicação e acesse o endereço [http://localhost:8080](http://localhost:8080)
