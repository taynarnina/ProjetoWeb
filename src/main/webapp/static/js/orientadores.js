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
		var url = 'orientador';
		var dadosOrientadores= $('#form-orientador').serialize();
		
		$.post(url, dadosOrientadores)
			.done(function(pagina){	
				$('#secao-orientadores').html(pagina)
				aplicarListeners();
			})
			.fail(function(){
				alert('Erro ao salvar!');	
			})
			.always(function(){
				$('#modal-orientador').modal('hide');
			});
	});
}

var aplicarListeners = function(){
	
	$('#modal-orientador').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'orientador/'+id;
		
		$.get(url)
			.done(function(orientador){
				$('#id').val(orientador.id);
				$('#nome').val(orientador.nome);
				
				$('#modal-orientador').modal('show');
			});
	});
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var orientadores = $('#quantidade-orientadores').text();
		
		$.ajax({
			url : "orientador/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
		    	$('#quantidade-orientadores').text(orientadores - 1);
		    }
	    });
	});
}