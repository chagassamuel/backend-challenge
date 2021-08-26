# API Desafio Backend Itaú
Projeto desenvolvido para solução do problema proposto no processo seletivo Backend Itaú.

### Desafio
Neste problema, a API deve implementar um serviço responsável por validar uma senha informada pelo usuário, de acordo com algumas regras predefinidas. As regras pressupostas são:

- Nove ou mais caracteres;
- Ao menos 1 dígito;
- Ao menos 1 letra minúscula;
- Ao menos 1 letra maiúscula;
- Ao menos 1 caractere especial;
- Não possuir caracteres repetidos dentro do conjunto;
- Espaços em branco não devem ser considerados como caracteres válidos.

### Solução
A solução implementada, segue alguns Design Patterns que auxiliaram na resolução do problema. Dentre eles, o Chain of Responsibility, crucial para tomadas de decisão de acordo com as regras pressupostas. O padrão DTO, que auxiliou no trânsito de informações nas camadas de entrada/negócio e negócio/saída. Ademais, o padrão Builder foi responsável por toda construção dos diferentes objetos necessários na execução do serviço. Ainda, o Design Pattern Facade, abstraiu toda regra de negócio em uma única chamada da API (isValid).

Além dos Padrões de Projeto, foram utilizadas tecnologias como Java 8, Spring Boot, Lombok, Swagger, JUnit/Mockito, etc, as quais tornaram possível a construção de uma API coesa e de baixo acoplamento de acordo com seu propósito, uma vez que a API cumpre seu papel e não depende de outros módulos para seu funcionamento. A extensão para novas regras na validação do input, tornou-se trivial, uma vez que é necessária apenas a implementação e adição de sua regra de negócio na cadeia de responsabilidades.

A partir dos testes unitários, é possível perceber que o projeto desenvolvido apresenta duas diferentes soluções para cada premissa na validação do input. Isso se faz importante para validação do problema e tempo de execução de cada solução.

A API expõe o serviço (POST) para validação de senha na seguinte URL:
http://localhost:8080/api/password/validate

Além disso, a documentação para consumo da API pode ser acessada no link a seguir:
http://localhost:8080/swagger-ui.html

### Execução
Necessária a instalação prévia do Java 8 e Maven 3.
```
cd /PROJECT-HOME
mvn clean install
java -jar target/backend-challenge-1.0.0.jar
```

### Teste

Exemplo de chamada feita via Postman:

curl --location --request POST 'http://localhost:8080/api/password/validate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "password": "Abcdefg1+"
}'

Exemplo response:
```json
{
    "valid": true
}
```
