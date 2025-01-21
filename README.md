# VollMed_API

![VollMed API](https://via.placeholder.com/800x200.png?text=VollMed+API+Logo)

## Sobre o Projeto ✨

A **VollMed_API** é uma aplicação desenvolvida em Java utilizando o framework Spring Boot. Seu objetivo é gerenciar uma clínica médica fictícia chamada Voll.med, permitindo o cadastro de médicos e pacientes, além do agendamento e cancelamento de consultas.

## Funcionalidades 🚀

- **Cadastro de Médicos** 🩺: Adicionar, atualizar, listar e remover informações de médicos.
- **Cadastro de Pacientes** 👩‍⚕️: Facilitar a gestão de pacientes com operações CRUD.
- **Agendamento de Consultas** 📅: Permitir marcação de consultas verificando disponibilidade.
- **Cancelamento de Consultas** ❌: Cancelar consultas mantendo histórico.

---

## Tecnologias Utilizadas 🛠️

Aqui estão as principais tecnologias utilizadas neste projeto, com seus respectivos logos:

### Linguagem e Framework

- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)

### Persistência e Banco de Dados

- ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
- ![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)

### Automação e Build

- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

### Segurança

- ![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
- ![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white)

### Utilitários

- ![Lombok](https://img.shields.io/badge/Lombok-FF6347?style=for-the-badge&logoColor=white)
- ![Springdoc OpenAPI](https://img.shields.io/badge/OpenAPI-85EA2D?style=for-the-badge&logo=openapi-initiative&logoColor=black)

---

## Estrutura do Projeto 📂

A aplicação segue a arquitetura MVC (Model-View-Controller), organizada da seguinte forma:

- **Model**: Contém as entidades principais como Médico, Paciente e Consulta, representando as tabelas do banco de dados.
- **Repository**: Interfaces que estendem o JpaRepository, fornecendo métodos para operações CRUD nas entidades.
- **Service**: Camada responsável pela lógica de negócios, intermediando as operações entre o Controller e o Repository.
- **Controller**: Gerencia as requisições HTTP, direcionando-as para os serviços apropriados e retornando as respostas adequadas.

---

## Documentação da API 📖

Após iniciar a aplicação, a documentação interativa dos endpoints estará disponível em:

```
http://localhost:8080/swagger-ui.html
```

Esta interface permite explorar e testar os endpoints disponíveis, facilitando o entendimento e a integração com a API.

---

## Como Executar o Projeto ▶️

1. **Pré-requisitos**:
   - Java 17 instalado.
   - MySQL instalado e configurado.
   - Maven configurado no ambiente.

2. **Clonar o Repositório**:

   ```bash
   git clone https://github.com/gabriel-afd/VollMed_API.git
   ```

3. **Configurar o Banco de Dados**:
   - Crie um banco de dados no MySQL com o nome `vollmed`.
   - Atualize as credenciais de acesso no arquivo `application.properties`.

4. **Executar a Aplicação**:
   - No terminal, navegue até o diretório do projeto e execute:

     ```bash
     mvn spring-boot:run
     ```

5. **Acessar a Documentação**:
   - Abra o navegador e acesse `http://localhost:8080/swagger-ui.html` para visualizar e interagir com os endpoints da API.

---

## Autor ✍️

**Gabriel Medeiros de Mendonça**

Este projeto foi desenvolvido como parte dos estudos em desenvolvimento de APIs RESTful utilizando Java e Spring Boot. Caso tenha dúvidas ou sugestões, entre em contato!
`https://www.linkedin.com/in/gabriel-medeiros-de-mendon%C3%A7a-8a82b7251/`

---

**Enjoy coding!** 🚀
