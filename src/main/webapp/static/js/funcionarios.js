$(document).ready(function(){	
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#codigo').val('');
	$('#area').val('');
	$('#tipo').val('');
};

//Falta editar
var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		var url = 'funcionario';
		var dadosFuncionarios = $('#form-funcionario').serialize();
		
		$.post(url, dadosFuncionarios)
			.done(function(pagina){	
				$('#secao-funcionarios').html(pagina)
				aplicarListeners();
			})
			.fail(function(){
				alert('Erro ao salvar!');	
			})
			.always(function(){
				$('#modal-funcionario').modal('hide');
			});
	});
}

//Falta editar
var aplicarListeners = function(){
	
	$('#modal-curso').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'curso/'+id;
		
		$.get(url)
			.done(function(curso){
				$('#id').val(curso.id);
				$('#nome').val(curso.nome);
				$('#codigo').val(curso.codigo);
				$('#area').val(curso.area);
				$('#tipo').val(curso.tipo);
				
				$('#modal-curso').modal('show');
			});
	});
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var cursos = $('#quantidade-cursos').text();
		
		$.ajax({
			url : "curso/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
		    	$('#quantidade-cursos').text(cursos - 1);
		    }
	    });
	});
}