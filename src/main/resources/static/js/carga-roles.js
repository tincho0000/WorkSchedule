	$(document).ready(function() {
		
		const  div = document.getElementById('RolesDeEdicion');
		
		var htmlTemplateCheq = `<div class="form-check form-switch mx-4">
									  <input checked="checked" class="form-check-input" type="checkbox" role="switch" id="ID" name="rol" value="ID">
									  <label class="form-check-label" for="ID">XX</label>
									</div>`
									
		var htmlTemplate = `<div class="form-check form-switch mx-4">
							  <input class="form-check-input" type="checkbox" role="switch" id="ID" name="rol" value="ID">
							  <label class="form-check-label" for="ID">XX</label>
							</div>`
		
		if (div != null){
			
			var listaRolesUsuario = [[${listaRolesUsuario}]];
		    var listaRoles = [[${listaRoles}]];
		    var listaIdRoles = [[${listaIdRoles}]];
		    
		    for (i = 0; i < listaRoles.length; i++) {
// 		    	console.log("Lista Rol: " + listaIdRoles[i] + " " +listaRoles[i] );
		    	var encontro = false;
			    for (j = 0; j < listaRolesUsuario.length; j++) {
// 			    	console.log("	Lista Rol usuario: " + listaRolesUsuario[j]);
			    	if(listaRoles[i] == listaRolesUsuario[j]){
			    		encontro = true;
// 			    		console.log("Encontre");
			    	}
				}
			    if (encontro){
			    	var html = htmlTemplateCheq.replace(/ID/g, listaIdRoles[i]);
			    	html = html.replace(/XX/g, listaRoles[i]);
			    }else{
			    	var html = htmlTemplate.replace(/ID/g, listaIdRoles[i]);
			    	html = html.replace(/XX/g, listaRoles[i]);
			    }
			    
// 			    console.log(html);
			    div.insertAdjacentHTML('afterbegin', html);
		    }
		}
	});
	
