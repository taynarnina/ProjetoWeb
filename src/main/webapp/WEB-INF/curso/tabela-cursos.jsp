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
			<td>#</td>
			<td>Nome</td>
			<td>Codigo</td>
			<td>Area</td>
			<td>Tipo</td>
			<td>Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cursos}" var="curso">
			<tr>
				<td>${curso.id}</td>
				<td>${curso.nome}</td>
				<td>${curso.codigo}</td>
				<td>${curso.area}</td>
				<td>${curso.tipo}</td>
				<td><button class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">Curso cadastrados: ${cursos.size()}</td>
		</tr>
		<tr>
			<td colspan="6">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-curso">Cadastrar Curso</button>
			</td>
		</tr>
	</tfoot>
</table>