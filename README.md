# ProjetoWeb


Projeto da disciplina de programação web do professor Thiago Batista


Alunos: Murilo Gustavo dos Santos e Taynar Sousa


Explicando os artefatos:

As classes de declaração dos atributos de Funcionários,Alunos e Administrador estão no pacote br.edu.ufab.modelo.pessoas. As classes de declaração dos atributos das classes dos itens do acervo estão na package br.edu.modelo.itens.As classes são: Impressos, Acervo,TrabalhoAcademico,Jornal,Revista,Livro,Cursos,Midias,Anais,Tcc. As classes que fazem o relacionamento com o banco de dados está em um pacote chamado br.edu.ufab.dao e divide-se em pessoas(para Funcionário,Aluno e Administrador),itens(para os itens do acervo) e jdbc (para abrir a conexão com o banco de dados). A classe ConnectionFactory é a classe que vai ativar o banco de dados enquanto as demais classes farão os comandos (CRUD). Cada classe do pacote br.edu.modelo vai ter sua relação com o banco (direta ou indiretamente). 

Os testes estão dentro da package br.edu.ufab.teste e cada um é nomeado de acordo com as classes do pacote biblio.

Tutorial para a execução do projeto:

Como ainda não temos uma interface para que sejam testados todos os métodos, fizemos a validação através dos testes de unidade. Dessa forma será necessário executar apenas as classes de teste com o Junit. Se a barrinha ficar verde, é porque os testes foram validados corretamente. Se não, é porque algo no código está incorreto e algum método não foi validado.

Lemrando que é necessário fazer o import do banco de dados para que sejam feitos os relacionamentos.