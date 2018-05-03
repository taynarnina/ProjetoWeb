$(document).ready(function(){
	
	$('#btn-salvar').on('click', function(){
		var url = 'curso';
		var dadosCursos = $('#form-curso').serialize();
	
		$.post(url, dadosCursos)
			.done(function(){
				alert('Curso salvo com sucesso');
		})
			.fail(function(){
				alert('Erro ao salvar!');
		});
	});
	
});