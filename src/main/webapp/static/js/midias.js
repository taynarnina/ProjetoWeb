$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#titulo').val('');
	$('#tipo').val('');
	$('#data').val('');
};

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		var url = 'midia';
		var dadosMidias= $('#form-midia').serialize();
		
		$.post(url, dadosMidias)
			.done(function(pagina){	
				$('#secao-midias').html(pagina)
				aplicarListeners();
			})
			.fail(function(){
				alert('Erro ao salvar!');	
			})
			.always(function(){
				$('#modal-midia').modal('hide');
			});
	});
}

var aplicarListeners = function(){
	
	$('#modal-midia').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'midia/'+id;
		
		$.get(url)
			.done(function(midia){
				$('#id').val(midia.id);
				$('#titulo').val(midia.titulo);
				$('#tipo').val(midia.tipo);
				$('#data').val(midia.data);
				
				$('#modal-midia').modal('show');
			});
	});
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var midias = $('#quantidade-midias').text();
		
		$.ajax({
			url : "midia/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
		    	$('#quantidade-midias').text(midias - 1);
		    }
	    });
	});
}