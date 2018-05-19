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
			<td style="width: 10%">Data</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${jornais}" var="jornal">
			<tr data-id="${jornal.id}">
				<td>${jornal.id}</td>
				<td>${jornal.titulo}</td>
				<td>${jornal.edicao}</td>
				<td>${jornal.editora.nome}</td>
				<td>${jornal.numpaginas}</td>
				<td>${jornal.data}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">Jornais cadastrados: <span id="quantidade-jornais">${jornais.size()}</span></td>
		</tr>
		<tr>
			<td colspan="8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-jornal">Cadastrar Jornal</button>
			</td>
		</tr>
	</tfoot>
</table>