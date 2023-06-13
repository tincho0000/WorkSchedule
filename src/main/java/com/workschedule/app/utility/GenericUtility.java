package com.workschedule.app.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericUtility {
	
	public boolean RecorrerListasGeneric(List<?> lista, Object id ) {
		
		//TODO por ahora no es necesario
		for (int i = 0; i < lista.size(); i++) {
			
		}
		return false;
	}

	static public Map<String, List<String>> getUsuariosSistema(){
		Map<String, List<String>> usuariosPorGrupo = new HashMap<>();

		List<String> usuariosShiva = new ArrayList<>();
		usuariosShiva.add("Diego Morinigo");
		usuariosShiva.add("Natalia Fioren");
		usuariosShiva.add("Pablo Ibarrola");

		List<String> usuariosIce = new ArrayList<>();
		usuariosIce.add("Martin Bertomeu");
		usuariosIce.add("Romina Colombo");
		usuariosIce.add("Azucena Panes");

		List<String> usuariosDeimos = new ArrayList<>();
		usuariosDeimos.add("German Elli");
		usuariosDeimos.add("Marcos Baro");
		usuariosDeimos.add("Sergio Gomez");

		usuariosPorGrupo.put("Shiva", usuariosShiva);
		usuariosPorGrupo.put("Ice", usuariosIce);
		usuariosPorGrupo.put("Deimos", usuariosDeimos);

		return usuariosPorGrupo;
	}
	
	
	

}
