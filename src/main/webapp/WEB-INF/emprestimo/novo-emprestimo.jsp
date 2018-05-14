<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${titulo}</title>
		<c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
		<style type="text/css">
			@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
			@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
		</style>
	</head>
	<body>
		<jsp:include page="../menu.jsp"/>
		<section class="container">
			<form>
				<div class="form-row">
					<p class="h4">Cadastrar Novo Emprestimo</p>
					<div class="form-group">
						<label for="aluno">Aluno</label>
						<select id="aluno" name="aluno" class="form-control">
							<c:forEach items="${alunos}" var="aluno">
								<option value="${aluno.id}">${aluno.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="emprestimo">Emprestimo</label> 
						<select id="emprestimo" name="emprestimo" class="form-control">
							<option value="anais">Anais</option>
							<option value="jornal">Jornal</option>
							<option value="livro">Livro</option>
							<option value="midia ">Midia Eletronica</option>
							<option value="revista">Revista</option>
							<option value="tcc">TCC</option>
						</select>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Novo Emprestimo</button>
			</form>
		</section>
		
		<script type="text/javascript" src="${path}/static/js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>