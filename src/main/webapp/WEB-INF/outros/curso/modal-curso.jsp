<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-curso" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-curso" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações do Curso</h4>
				</div>
				<div class="modal-body">
					<label for="nome">Nome: </label>
					<input id="nome" name="nome" class="form-control">
					
					<label for="codigo">Código: </label>
					<input id="codigo" name="codigo" class="form-control">
					
					<label for="area">Area: </label>
					<select id="area" name="area" class="form-control">
						<c:forEach items="${areas}" var="area">
							<option value="${area}">${area}</option>
						</c:forEach>
					</select>
					
					<label for="tipo">Tipo: </label>
					<select id="tipo" name="tipo" class="form-control">
						<c:forEach items="${tipos}" var="tipo">
							<c:if test="${tipo == 'G'}">
								<option value="${tipo}">GRADUACAO</option>
							</c:if>
							<c:if test="${tipo == 'E'}">
								<option value="${tipo}">ESPECIALIZACAO</option>
							</c:if>
							<c:if test="${tipo == 'M'}">
								<option value="${tipo}">MESTRADO</option>
							</c:if>
							<c:if test="${tipo == 'D'}">
								<option value="${tipo}">DOUTORADO</option>
							</c:if>
						</c:forEach>
					</select>
					
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