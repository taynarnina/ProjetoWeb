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
			<td style="width: 15%">Nome do Congresso</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${anais}" var="anal">
			<tr data-id="${anal.id}">
				<td>${anal.id}</td>
				<td>${anal.titulo}</td>
				<td>${anal.local}</td>
				<td>
					<c:forEach items="${anal.autores}" var="autor">
						${autor.nome} <br/>
					</c:forEach>
				</td>
				<td>${anal.tipo}</td>
				<td>${anal.nomecongreco}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">Anais cadastrados: <span id="quantidade-anais">${anais.size()}</span></td>
		</tr>
		<tr>
			<td colspan="8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-anais">Cadastrar Anais</button>
			</td>
		</tr>
	</tfoot>
</table>