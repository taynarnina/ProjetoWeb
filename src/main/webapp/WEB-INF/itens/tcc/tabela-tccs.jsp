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
			<td style="width: 20%">Titulo</td>
			<td style="width: 15%">Local</td>
			<td style="width: 15%">Autores</td>
			<td style="width: 10%">Tipo</td>
			<td style="width: 15%">Orientadores</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${tccs}" var="tcc">
			<tr data-id="${tcc.id}">
				<td>${tcc.id}</td>
				<td>${tcc.titulo}</td>
				<td>${tcc.local}</td>
				<td>
					<c:forEach items="${tcc.autores}" var="autor">
						${autor.nome} <br/>
					</c:forEach>
				</td>
				<td>${tcc.tipo}</td>
				<td>
					<c:forEach items="${tcc.orientadores}" var="orientador">
						${orientador.nome} <br/>
					</c:forEach>
				</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">TCCs cadastrados: <span id="quantidade-tccs">${tccs.size()}</span></td>
		</tr>
		<tr>
			<td colspan="8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-tcc">Cadastrar TCC</button>
			</td>
		</tr>
	</tfoot>
</table>