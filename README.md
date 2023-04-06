Projeto finalizado conforme todas as requisições, desenvolvido em Java, utilizando Springboot, Web Service Spring, e Banco de Dados H2.
Utilizando o Postman, pode-se realizar todas as operações solicitadas, conforme a seguinte lista para melhor compreensão:
Com o projeto rodando na porta 8080, para executar as operações basta seguir esse modelo: [Método]  localhost:8080/gerenciamento/ação

Em "Método", podem ser usados: GET, POST, PUT, e DELETE.

Em "ação", podem ser utilizadas as seguintes ações, com suas funções:

/add - Adiciona os dados, utilizando JSON

![image](https://user-images.githubusercontent.com/56934730/230266197-a41ca24b-e14b-4097-abca-a0f49939b0ed.png)

/vtodos - Lista todos os dados dos usuários

![image](https://user-images.githubusercontent.com/56934730/230267007-96292661-69e3-4b44-a3d5-47e632983af0.png)

/pid/{id} - Lista os dados de um usuário específico

![image](https://user-images.githubusercontent.com/56934730/230267081-363aa89d-984f-4ebf-af25-6aafa2c6970b.png)

/peid/{id} - Lista os endereços de uma pessoa

![image](https://user-images.githubusercontent.com/56934730/230267262-c8abf48a-00ec-4156-a154-316e08bf1dd3.png)

/att/{id} - Atualiza os dados da pessoa, pelo ID, com um corpo JSON, podem ser alterados todos ou apenas alguns dados.

![image](https://user-images.githubusercontent.com/56934730/230267806-bfb29e65-9334-4588-bc35-50b84bcf36e1.png)

/endprincipal/{id}/{enderecoPrincipal} - Define o endereço principal de uma pessoa.

![image](https://user-images.githubusercontent.com/56934730/230269328-30da785f-7090-41ec-891f-3419c22e98e9.png)

/del/{id} - Deleta todos os dados de uma pessoa

![image](https://user-images.githubusercontent.com/56934730/230269534-8d7f7aa1-b22c-4a50-a0da-85c99edc3226.png)
