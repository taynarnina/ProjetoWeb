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
			<td style="width: 40%">Titulo</td>
			<td style="width: 15%">Tipo</td>
			<td style="width: 20%">Data</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${midias}" var="midia">
			<tr data-id="${midia.id}">
				<td>${midia.id}</td>
				<td>${midia.titulo}</td>
				<td>${midia.tipo}</td>
				<td>${midia.data}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">Midias Eletronicas cadastradas: <span id="quantidade-midias">${midias.size()}</span></td>
		</tr>
		<tr>
			<td colspan="6">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-midia">Cadastrar Midia</button>
			</td>
		</tr>
	</tfoot>
</table>