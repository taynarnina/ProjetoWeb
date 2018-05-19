<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<style>
	#btn-sair{
		margin-top: 7px;
		margin-right: 15px;
	}
</style>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="">Biblioteca UFAB</a>
    </div>
    <ul class="nav navbar-nav">
     <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Movimentar Acervo <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="emprestimo">Emprestimos</a></li>
          <li><a href="divida">Quitar Divida</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pessoas <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="funcionario">Funcionario</a></li>
          <li><a href="aluno">Aluno</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Itens <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="anais">Anais</a></li>
          <li><a href="jornal">Jornais</a></li>
          <li><a href="livro">Livros</a></li>
          <li><a href="midia">Midias Eletronicas</a></li>
          <li><a href="revista">Revistas</a></li>
          <li><a href="tcc">TCC</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Outros <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="autor">Autores</a></li>
          <li><a href="curso">Cursos</a></li>
          <li><a href="editora">Editoras</a></li>
          <li><a href="orientador">Orientadores</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li>
        	<form action="${path}/sair" method="post">
				<input type="hidden" name="_csrf" value="${_csrf.token}">
				<button id="btn-sair" type="submit" class="btn btn-default  glyphicon glyphicon-log-in"> Sair</button>
			</form>
        </li>
    </ul>
  </div>
</nav>