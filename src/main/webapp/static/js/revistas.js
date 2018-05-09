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
	$('#datapublicacao').val('');
};

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		var url = 'revista';
		var dadosRevistas = $('#form-revista').serialize();
		
		$.post(url, dadosRevistas)
			.done(function(pagina){	
				$('#secao-revistas').html(pagina)
				aplicarListeners();
			})
			.fail(function(){
				alert('Erro ao salvar!');	
			})
			.always(function(){
				$('#modal-revista').modal('hide');
			});
	});
}

var aplicarListeners = function(){
	
	$('#modal-revista').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'revista/'+id;
		
		$.get(url)
			.done(function(revista){
				$('#id').val(revista.id);
				$('#titulo').val(revista.titulo);
				$('#edicao').val(revista.edicao);
				$('#editora').val(revista.editora);
				$('#numpaginas').val(revista.numpaginas);
				$('#datapublicacao').val(revista.datapublicacao);
				
				$('#modal-revista').modal('show');
			});
	});
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var revistas = $('#quantidade-revistas').text();
		
		$.ajax({
			url : "revista/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
		    	$('#quantidade-revistas').text(revistas - 1);
		    }
	    });
	});
}