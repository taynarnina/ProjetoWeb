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
			<td colspan="7">
				<button id="btn-relatorio" type="button" class="btn btn-primary">Gerar Relatorio</button>
			</td>
		</tr>
		<tr>
			<td style="width: 10%">#</td>
			<td style="width: 25%">Aluno</td>
			<td style="width: 30%">Item</td>
			<td style="width: 10%">Emprestimo</td>
			<td style="width: 10%">Devolução</td>
			<td style="width: 10%">Divida</td>
			<td style="width: 10%">Quitar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${emprestimos}" var="emprestimo">
			<tr data-id="${emprestimo.id}">
				<td>${emprestimo.id}</td>
				<td>${emprestimo.aluno.nome}</td>
				<td>
					${emprestimo.anais.titulo}
					${emprestimo.jornal.titulo}
					${emprestimo.livro.titulo}
					${emprestimo.midia.titulo}
					${emprestimo.revista.titulo}
					${emprestimo.tcc.titulo}
				</td>
				<td>${emprestimo.dataemprestimo}</td>
				<td>${emprestimo.datadevolucao}</td>
				<td><fmt:formatNumber value="5" type="currency"/></td>
				<td><button type="button" class="btn btn-success btn-quitar">Quitar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Alunos com divida: <span id="quantidade-divida">${emprestimos.size()}</span></td>
		</tr>
	</tfoot>
</table>