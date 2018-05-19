<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-emprestimo" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-emprestimo" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Novo Emprestimo</h4>
				</div>
				<div class="modal-body">
					
					<label for="aluno">Aluno: </label>
					<select id="aluno" name="aluno" class="form-control">
						<c:forEach items="${alunos}" var="aluno">
							<option value="${aluno.id}">${aluno.nome}</option>
						</c:forEach>
					</select>
					
					<label for="emprestimo">Item Emprestimo:</label> 
					<select id="emprestimo" name="emprestimo" class="form-control">
						<option value="anais">Anais</option>
						<option value="jornal">Jornal</option>
						<option value="livro">Livro</option>
						<option value="midia">Midia Eletronica</option>
						<option value="revista">Revista</option>
						<option value="tcc">TCC</option>
					</select>
					
					<label id="anais-l" for="anais">Anais: </label>
					<select id="anais" name="anais" class="form-control">
						<c:forEach items="${anais}" var="anal">
							<option value="${anal.id}">${anal.titulo}</option>
						</c:forEach>
					</select>
					
					<label id="jornal-l" for="jornal">Jornal: </label>
					<select id="jornal" name="jornal" class="form-control">
						<c:forEach items="${jornais}" var="jornal">
							<option value="${jornal.id}">${jornal.titulo}</option>
						</c:forEach>
					</select>
					
					<label id="livro-l" for="livro">Livro: </label>
					<select id="livro" name="livro" class="form-control">
						<c:forEach items="${livros}" var="livro">
							<option value="${livro.id}">${livro.titulo}</option>
						</c:forEach>
					</select>
					
					<label id="midia-l" for="midia">Midia Eletronica: </label>
					<select id="midia" name="midia" class="form-control">
						<c:forEach items="${midias}" var="midia">
							<option value="${midia.id}">${midia.titulo}</option>
						</c:forEach>
					</select>
					
					<label id="revista-l" for="revista">Revista: </label>
					<select id="revista" name="revista" class="form-control">
						<c:forEach items="${revistas}" var="revista">
							<option value="${revista.id}">${revista.titulo}</option>
						</c:forEach>
					</select>
					
					<label id="tcc-l" for="tcc">TCC: </label>
					<select id="tcc" name="tcc" class="form-control">
						<c:forEach items="${tccs}" var="tcc">
							<option value="${tcc.id}">${tcc.titulo}</option>
						</c:forEach>
					</select>
					
					<label for="dataemprestimo">Data de Emprestimo: </label>
					<input id="dataemprestimo" name="dataemprestimo" class="form-control" type="date">
					
					<label for="datadevolucao">Data de Devolucao: </label>
					<input id="datadevolucao" name="datadevolucao" class="form-control" type="date">
					
					<label for="senha">Senha: </label>
					<input id="senha" name="senha" class="form-control" type="password">
					
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-primary">Salvar Informações</button>
				</div>
			</form>
		</div>
	</div>
</div>