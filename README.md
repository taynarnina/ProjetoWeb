# ProjetoWeb


Projeto da disciplina de programação web do professor Thiago Batista


Alunos: Murilo Gustavo dos Santos e Taynar Sousa


Tecnologias utilizadas:

JAVA, Persistência com  JPA (com Hibernate),
Spring MVC,
Relatórios
Spring Security.


Explicando os artefatos:

As classes de declaração dos atributos de Funcionários,Alunos e Administrador estão no pacote br.edu.ufab.model.pessoas. As classes de declaração dos atributos das classes dos itens do acervo estão na package br.edu.modelo.itens.As classes são: Impressos, Acervo,TrabalhoAcademico,Jornal,Revista,Livro,Cursos,Midias,Anais,Tcc. As classes que fazem o controle com o banco de dados está em um pacote chamado br.edu.ufab.conotroller e divide-se em pessoas(para Funcionário,Aluno e Administrador) e itens(para os itens do acervo). A classe do pacote br.edu.ufab.config é a classe que faz as configurações do banco de dados e as configurções web.  

Os testes estão dentro da package br.edu.ufab.teste e cada um é nomeado de acordo com as classes do pacote controller.

Tutorial para a execução do projeto:

É necesário subir o projeto através de um servidor (usamos o tomcat). Após isso usamos o endereço localhor:8080/Biblioteca_ufab/curso.

As rotas estão com o Security ativado. O usuário é admin e a senha admin.

Lemrando que é necessário apenas criar um banco com o nome biblioteca. A tabelas o Hibernate quem gera.
