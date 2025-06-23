# 📘 CodeConnect API

**CodeConnect** é uma plataforma onde desenvolvedores podem compartilhar e divulgar seus projetos, semelhante ao GitHub, mas com foco na interação entre a comunidade. A proposta do CodeConnect é ser um ambiente mais convidativo e elegante, especialmente para quem está iniciando no mundo da programação e tecnologia.

Além disso, o CodeConnect pode ser utilizado em eventos acadêmicos, como a **MostraTec** da Uniube, possibilitando que os alunos publiquem seus projetos de forma online e acessível, superando barreiras geográficas.

---

## 🚀 Tecnologias utilizadas

- ✅ **Java 21 (Amazon Corretto)**
- ✅ **Spring Boot**
- ✅ **MySQL**
- ✅ **Docker** (opcional, para facilitar o ambiente)
- ✅ **REST API**
- ✅ **JWT (JSON Web Token)** – Autenticação segura
- ✅ **Swagger/OpenAPI** – Documentação da API
- ✅ **Lombok** – Redução de código repetitivo (caso utilizado)
- ✅ **Maven** – Gerenciamento de dependências

---

## ⚙️ Pré-requisitos

- Java 21 instalado
- MySQL instalado (use o gerenciador de banco que preferir)
- Maven instalado (ou utilizar o wrapper `./mvnw`)

---

## 📦 Como executar o projeto

1️⃣ **Clone o repositório:**

```bash
git clone https://github.com/LorenzoFe/CodeConnect.git
```

2️⃣ **Configure o banco de dados no arquivo **``**:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/codeconnect
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

3️⃣ **Execute o projeto:**

```bash
./mvnw spring-boot:run
```

4️⃣ **Acesse a aplicação:**

```
http://localhost:8080
```


---

## 📬 Endpoints principais

### 🔑 Autenticação

#### POST `/api/v1/auth`

**Descrição:** Login e geração de token JWT

**Corpo da requisição:**

```json
{
  "email": "usuario@email.com",
  "senha": "senha123"
}
```

**Resposta esperada:**

```json
{
  "token": "jwt_token_aqui",
  "id": 1,
  "nome": "Nome do Usuário",
  "email": "usuario@email.com"
}
```

#### POST `/api/v1/usuarios`

**Descrição:** Cadastro de novo usuário

**Corpo da requisição:**

```json
{
  "nome": "Nome do Usuário",
  "email": "usuario@email.com",
  "senha": "senha123"
}
```

**Resposta esperada:**

```json
{
  "id": 1,
  "name": "Nome do Usuário",
  "username": "null",
  "email": "usuario@email.com",
  "descricao": "null",
  "dataCriacao": "2025-06-23T12:00:00":,
  "fotoUrl": "null"
}
```

### 👤 Usuários

#### GET `/api/v1/usuarios`

**Descrição:** Listagem de usuários (admin)

**Resposta esperada:**

```json
[
   {
    "id": 1,
    "name": "Nome do Usuário",
    "username": "null",
    "email": "usuario@email.com",
    "descricao": "null",
    "dataCriacao": "2025-06-23T12:00:00":,
    "fotoUrl": "null"
  }
]
```

### 📁 Postagens

#### POST `/api/v1/Posts`

**Descrição:** Criação de novo projeto/postagem

**Corpo da requisição:**

```json
{
  "titulo": "Nome do Projeto",
  "descricao": "Descrição do projeto",
  "imagemUrl": "https://link-da-imagem.com/projeto.png"
}
```

**Resposta esperada:**

```json
{
  "id": 1,
  "title": "Nome do Projeto",
  "descricao": "Descrição do projeto",
  "userId": 1,
  "nomeUsuario": "Nome do usuário",
  "imagemUrl": "https://link-da-imagem.com/projeto.png",
  "dataCriacaoPost": "2025-06-23T12:00:00"
}
```

#### GET `/api/v1/Posts`

**Descrição:** Listagem de projetos publicados

**Resposta esperada:**

```json
[
  {
    "id": 1,
    "title": "Nome do Projeto",
    "descricao": "Descrição do projeto",
    "userId": 1,
    "nomeUsuario": "Nome do usuário",
    "imagemUrl": "https://link-da-imagem.com/projeto.png",
    "dataCriacaoPost": "2025-06-23T12:00:00"
  }
]
```

---

## 🛠 Variáveis de ambiente (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/codeconnect
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

jwt.secret=UMA_SENHA_SEGURA
jwt.expiration=86400000
```

---

## 🗃️ Estrutura do Projeto

```
codeConnect-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── suicide/
│   │   │           └── codeConnect_api/
│   │   │               ├── config/         # Configurações gerais do projeto
│   │   │               ├── entity/         # Entidades (modelos do banco de dados)
│   │   │               ├── exception/      # Tratamento de exceções
│   │   │               ├── jwt/            # Classes relacionadas à autenticação JWT
│   │   │               ├── repository/     # Interfaces de acesso a dados (JPA)
│   │   │               ├── service/        # Regras de negócio
│   │   │               └── web/
│   │   │                   ├── controller/ # Controllers (Endpoints REST)
│   │   │                   ├── dto/        # Data Transfer Objects
│   │   │                   └── exception/  # Tratamento de exceções específicas da API
│   │   └── resources/
│   │       ├── db.migration/               # Scripts de migração do banco de dados
│   │       ├── static/                     # Arquivos estáticos (caso necessário)
│   │       ├── templates/                  # Templates (se usar Thymeleaf ou similar)
│   │       └── application.properties      # Arquivo de configuração da aplicação
│   └── test/                               # Testes automatizados
│
├── Dockerfile                              # Configuração Docker
├── docker-compose.yml                      # Docker Compose (para orquestração)
├── pom.xml                                 # Gerenciador de dependências Maven
└── README.md                               # Documentação do projeto
```

---

## 👨‍💻 Autor

| Nome    | GitHub                                     |
| ------- | ------------------------------------------ |
| Lorenzo | [@LorenzoFe](https://github.com/LorenzoFe) |

---

