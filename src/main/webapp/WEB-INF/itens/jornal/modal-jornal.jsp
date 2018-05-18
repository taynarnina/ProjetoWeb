<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-jornal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-jornal" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações de Jornais</h4>
				</div>
				<div class="modal-body">
					<label for="titulo">Titulo: </label>
					<input id="titulo" name="titulo" class="form-control">
					
					<label for="edicao">Edição: </label>
					<input id="edicao" name="edicao" class="form-control">
					
					<label for="editora">Editora: </label>
					<select id="editora" name="editora" class="form-control">
						<c:forEach items="${editoras}" var="editora">
							<option value="${editora.id}">${editora.nome}</option>
						</c:forEach>
					</select>
					
					<label for="numpaginas">N° de Paginas: </label>
					<input id="numpaginas" name="numpaginas" class="form-control">
					
					<label for="data">Data: </label>
					<input id="data" name="data" class="form-control" type="date">
					
					<input id="id" name="id" value="" type="hidden">
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-primary">Salvar Informações</button>
				</div>
			</form>
		</div>
	</div>
</div>