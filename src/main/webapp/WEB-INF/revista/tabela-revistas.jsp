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
			<td style="width: 25%">Titulo</td>
			<td style="width: 15%">Edicao</td>
			<td style="width: 15%">Editora</td>
			<td style="width: 10%">N° de Paginas</td>
			<td style="width: 10%">Data de Publicação</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${revistas}" var="revista">
			<tr data-id="${revista.id}">
				<td>${revista.id}</td>
				<td>${revista.titulo}</td>
				<td>${revista.edicao}</td>
				<td>${revista.editora.nome}</td>
				<td>${revista.numpaginas}</td>
				<td>${revista.datapublicacao}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">Revistas cadastradas: <span id="quantidade-revistas">${revistas.size()}</span></td>
		</tr>
		<tr>
			<td colspan="8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-revista">Cadastrar Revista</button>
			</td>
		</tr>
	</tfoot>
</table>