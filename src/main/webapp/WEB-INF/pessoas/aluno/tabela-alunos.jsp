<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<td style="width: 5%">#</td>
			<td style="width: 5%">CPF</td>
			<td style="width: 5%">RG</td>
			<td style="width: 10%">Nome</td>
			<td style="width: 5%">Naturaliade</td>
			<td style="width: 10%">Endereco</td>
			<td style="width: 5%">Telefone</td>
			<td style="width: 5%">Nascimento</td>
			<td style="width: 5%">Senha</td>
			<td style="width: 5%">Email</td>
			<td style="width: 5%">Matricula</td>
			<td style="width: 10%">Nome da Mãe</td>
			<td style="width: 5%">Curso</td>
			<td style="width: 5%">Ano</td>
			<td style="width: 5%">Periodo</td>
			<td style="width: 5%">Editar</td>
			<td style="width: 5%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${alunos}" var="aluno">
			<tr data-id="${aluno.id}">
				<td>${aluno.id}</td>
				<td>${aluno.cpf}</td>
				<td>${aluno.rg}</td>
				<td>${aluno.nome}</td>
				<td>${aluno.naturalidade}</td>
				<td>${aluno.endereco}</td>
				<td>${aluno.telefone}</td>
				<td>${aluno.datanascimento}</td>
				<td>${aluno.senha}</td>
				<td>${aluno.email}</td>
				<td>${aluno.matricula}</td>
				<td>${aluno.nomemae}</td>
				<td>${aluno.curso.nome} - ${aluno.curso.tipo}</td>
				<td>${aluno.ano}</td>
				<td>${aluno.periodo}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="17">Alunos cadastrados: <span id="quantidade-alunos">${alunos.size()}</span></td>
		</tr>
		<tr>
			<td colspan="17">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-aluno">Cadastrar Aluno</button>
			</td>
		</tr>
	</tfoot>
</table>