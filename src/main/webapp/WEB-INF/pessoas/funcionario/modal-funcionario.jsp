<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-funcionario" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-funcionario" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações de Funcionario</h4>
				</div>
				<div class="modal-body">
					<label for="cpf">CPF: </label>
					<input id="cpf" name="cpf" class="form-control">
					
					<label for="rg">RG: </label>
					<input id="rg" name="rg" class="form-control">
					
					<label for="nome">Nome: </label>
					<input id="nome" name="nome" class="form-control">
					
					<label for="naturalidade">Naturalidade: </label>
					<input id="naturalidade" name="naturalidade" class="form-control">
					
					<label for="endereco">Endereço: </label>
					<input id="endereco" name="endereco" class="form-control">
					
					<label for="telefone">Telefone: </label>
					<input id="telefone" name="telefone" class="form-control">
					
					<label for="datanascimento">Data de Nascimento: </label>
					<input id="datanascimento" name="datanascimento" class="form-control" type="date">
					
					<label for="senha">Senha: </label>
					<input id="senha" name="senha" class="form-control" type="password">
					
					<label for="email">Email: </label>
					<input id="email" name="email" class="form-control" type="email" placeholder="example@mail.com">
					
					<label for="usuario">Usuario: </label>
					<input id="usuario" name="usuario" class="form-control">
					
					<label for="nivel">Nivel: </label>
					<select id="nivel" name="nivel" class="form-control">
						<c:forEach items="${niveis}" var="nivel">
							<option value="${nivel}">${nivel}</option>
						</c:forEach>
					</select>
					
					<input id="id" name="id" value="" type="hidden">
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