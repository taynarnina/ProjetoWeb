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
			<td style="width: 25%">Nome</td>
			<td style="width: 10%">Codigo</td>
			<td style="width: 20%">Area</td>
			<td style="width: 20%">Tipo</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cursos}" var="curso">
			<tr data-id="${curso.id}">
				<td>${curso.id}</td>
				<td>${curso.nome}</td>
				<td>${curso.codigo}</td>
				<td>${curso.area}</td>
				<c:if test="${curso.tipo == 'G'}">
					<td>GRADUACAO</td>
				</c:if>
				<c:if test="${curso.tipo == 'E'}">
					<td>ESPECIALIZACAO</td>
				</c:if>
				<c:if test="${curso.tipo == 'M'}">
					<td>MESTRADO</td>
				</c:if>
				<c:if test="${curso.tipo == 'D'}">
					<td>DOUTORADO</td>
				</c:if>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Cursos cadastrados: <span id="quantidade-cursos">${cursos.size()}</span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-curso">Cadastrar Curso</button>
			</td>
		</tr>
	</tfoot>
</table>