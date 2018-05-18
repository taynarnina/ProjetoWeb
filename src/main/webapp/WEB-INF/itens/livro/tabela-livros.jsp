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
			<td style="width: 10%">Edicao</td>
			<td style="width: 10%">Editora</td>
			<td style="width: 10%">N° de Paginas</td>
			<td style="width: 10%">ISBN</td>
			<td style="width: 15%">Autores</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${livros}" var="livro">
			<tr data-id="${livro.id}">
				<td>${livro.id}</td>
				<td>${livro.titulo}</td>
				<td>${livro.edicao}</td>
				<td>${livro.editora.nome}</td>
				<td>${livro.numpaginas}</td>
				<td>${livro.isbn}</td>
				<td>
					<c:forEach items="${livro.autores}" var="autor">
						${autor.nome} <br/>
					</c:forEach>
				</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="9">Livros cadastrados: <span id="quantidade-livros">${livros.size()}</span></td>
		</tr>
		<tr>
			<td colspan="9">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-livro">Cadastrar Livro</button>
			</td>
		</tr>
	</tfoot>
</table>