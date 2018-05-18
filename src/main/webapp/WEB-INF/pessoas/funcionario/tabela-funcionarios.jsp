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
			<td style="width: 8%">CPF</td>
			<td style="width: 8%">RG</td>
			<td style="width: 10%">Nome</td>
			<td style="width: 7%">Naturaliade</td>
			<td style="width: 10%">Endereco</td>
			<td style="width: 7%">Telefone</td>
			<td style="width: 7%">Nascimento</td>
			<td style="width: 5%">Senha</td>
			<td style="width: 7%">Email</td>
			<td style="width: 5%">Usuario</td>
			<td style="width: 7%">Nivel</td>
			<td style="width: 7%">Editar</td>
			<td style="width: 7%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${funcionarios}" var="funcionario">
			<tr data-id="${funcionario.id}">
				<td>${funcionario.id}</td>
				<td>${funcionario.cpf}</td>
				<td>${funcionario.rg}</td>
				<td>${funcionario.nome}</td>
				<td>${funcionario.naturalidade}</td>
				<td>${funcionario.endereco}</td>
				<td>${funcionario.telefone}</td>
				<td>${funcionario.datanascimento}</td>
				<td>${funcionario.senha}</td>
				<td>${funcionario.email}</td>
				<td>${funcionario.usuario}</td>
				<td>${funcionario.nivel}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="14">Funcionarios cadastrados: <span id="quantidade-funcionarios">${funcionarios.size()}</span></td>
		</tr>
		<tr>
			<td colspan="14">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-funcionario">Cadastrar Funcionario</button>
			</td>
		</tr>
	</tfoot>
</table>