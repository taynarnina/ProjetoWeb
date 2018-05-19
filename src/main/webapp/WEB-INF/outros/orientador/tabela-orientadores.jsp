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
			<td style="width: 10%">#</td>
			<td style="width: 60%">Nome</td>
			<td style="width: 15%">Editar</td>
			<td style="width: 15%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${orientadores}" var="orientador">
			<tr data-id="${orientador.id}">
				<td>${orientador.id}</td>
				<td>${orientador.nome}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Orientadores cadastrados: <span id="quantidade-orientadores">${orientadores.size()}</span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-orientador">Cadastrar Orientador</button>
			</td>
		</tr>
	</tfoot>
</table>