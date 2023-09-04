package dsw.JEGBikes.controller;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fasterxml.jackson.databind.ObjectMapper;

import dsw.JEGBikes.domain.Bicicleta;
import dsw.JEGBikes.domain.Locadora;
import dsw.JEGBikes.service.spec.IBicicletaService;

@CrossOrigin
@RestController
public class BicicletaRestController {

	@Autowired
	private IBicicletaService service;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

    @SuppressWarnings("unchecked")
	private void parse(Locadora locadora, JSONObject json) {
		Map<String, Object> map = (Map<String, Object>) json.get("locadora");
		
		Object id = map.get("id");
		if (id instanceof Integer) {
			locadora.setId(((Integer) id).longValue());
		} else {
			locadora.setId((Long) id);
		}
	}

	private void parse(Bicicleta bicicleta, JSONObject json) {
		
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				bicicleta.setId(((Integer) id).longValue());
			} else {
				bicicleta.setId((Long) id);
			}
		}

		bicicleta.setPlaca((String) json.get("placa"));
		bicicleta.setModelo((String) json.get("modelo"));
		bicicleta.setChassi((String) json.get("chassi"));
        bicicleta.setAno((Integer) json.get("ano"));
        bicicleta.setQuilometragem((Integer) json.get("quilometragem"));
        bicicleta.setDescricao((String) json.get("descricao"));
        bicicleta.setValor(BigDecimal.valueOf((Double) json.get("valor")));
		bicicleta.setFotos((String) json.get("fotos"));

		Locadora locadora = new Locadora();
		parse(locadora, json);
		bicicleta.setLocadora(locadora);
	}

	@GetMapping(path = "/bicicletas")
	public ResponseEntity<List<Bicicleta>> lista() {
		List<Bicicleta> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/bicicletas/{id}")
	public ResponseEntity<Bicicleta> lista(@PathVariable("id") long id) {
		Bicicleta bicicleta = service.buscarPorId(id);
		if (bicicleta == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bicicleta);
	}



	@GetMapping(path = "/bicicletas/modelos/{modelo}")
	public ResponseEntity<List<Bicicleta>> listaPorLocadora(@PathVariable("modelo") String modelo) {
		List<Bicicleta> lista = service.buscaPorModelo(modelo);
		
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}


	@PostMapping(path = "/bicicletas/locadoras/{id}")
	@ResponseBody
	public ResponseEntity<Bicicleta> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Bicicleta bicicleta = new Bicicleta();
				parse(bicicleta, json);
				service.salvar(bicicleta);
				return ResponseEntity.ok(bicicleta);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@PutMapping(path = "/bicicletas/{id}")
	public ResponseEntity<Bicicleta> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				Bicicleta bicicleta = service.buscarPorId(id);
				if (bicicleta == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(bicicleta, json);
					service.salvar(bicicleta);
					return ResponseEntity.ok(bicicleta);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@DeleteMapping(path = "/bicicletas/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

		Bicicleta bicicleta = service.buscarPorId(id);
		if (bicicleta == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}
}