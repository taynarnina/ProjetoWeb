$(document).ready(function(){	
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#titulo').val('');
	$('#edicao').val('');
	$('#editora').val('');
	$('#numpaginas').val('');
	$('#data').val('');
};

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		var url = 'jornal';
		var dadosJornais = $('#form-jornal').serialize();
		
		$.post(url, dadosJornais)
			.done(function(pagina){	
				$('#secao-jonais').html(pagina)
				aplicarListeners();
			})
			.fail(function(){
				alert('Erro ao salvar!');	
			})
			.always(function(){
				$('#modal-jornal').modal('hide');
			});
	});
}

var aplicarListeners = function(){
	
	$('#modal-jornal').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'jornal/'+id;
		
		$.get(url)
			.done(function(jornal){
				$('#id').val(jornal.id);
				$('#titulo').val(jornal.titulo);
				$('#edicao').val(jornal.edicao);
				$('#editora').val(jornal.editora);
				$('#numpaginas').val(jornal.numpaginas);
				$('#data').val(jornal.data);
				
				$('#modal-jornal').modal('show');
			});
	});
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var jornais = $('#quantidade-jornais').text();
		
		$.ajax({
			url : "jornal/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
		    	$('#quantidade-jornais').text(jornais - 1);
		    }
	    });
	});
}