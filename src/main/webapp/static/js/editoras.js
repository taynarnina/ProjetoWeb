$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
};

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		var url = 'editora';
		var dadosEditoras= $('#form-editora').serialize();
		
		$.post(url, dadosEditoras)
			.done(function(pagina){	
				$('#secao-editoras').html(pagina)
				aplicarListeners();
			})
			.fail(function(){
				alert('Erro ao salvar!');	
			})
			.always(function(){
				$('#modal-editora').modal('hide');
			});
	});
}

var aplicarListeners = function(){
	
	$('#modal-editora').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'editora/'+id;
		
		$.get(url)
			.done(function(editora){
				$('#id').val(editora.id);
				$('#nome').val(editora.nome);
				
				$('#modal-editora').modal('show');
			});
	});
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var editoras = $('#quantidade-editoras').text();
		
		$.ajax({
			url : "editora/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
		    	$('#quantidade-editoras').text(editoras - 1);
		    }
	    });
	});
}