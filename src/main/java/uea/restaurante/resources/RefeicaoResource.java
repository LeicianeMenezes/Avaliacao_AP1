package uea.restaurante.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import uea.restaurante.models.Refeicao;
import uea.restaurante.services.RefeicaoService;

@RestController
@RequestMapping("/refeicoes")
public class RefeicaoResource {

	@Autowired
	private RefeicaoService refeicaoService;

	@PostMapping
	public ResponseEntity<Refeicao> criar(@Valid @RequestBody Refeicao refeicao) {
		Refeicao refeicaoSalva = refeicaoService.criar(refeicao);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(refeicaoSalva.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(refeicaoSalva);
	}

	@GetMapping
	public ResponseEntity<List<Refeicao>> listar() {
		List<Refeicao> refeicao = refeicaoService.listar();
		return ResponseEntity.ok().body(refeicao);
	}

	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Refeicao> buscarPorCodigo(@PathVariable Long codigo) {
		Refeicao refeicao = refeicaoService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(refeicao);
	}

	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		refeicaoService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Refeicao> atualizar(@PathVariable Long codigo, @Valid @RequestBody Refeicao refeicao) {
		Refeicao refeicaoSalva = refeicaoService.atualizar(codigo, refeicao);
		return ResponseEntity.ok().body(refeicaoSalva);

	}

}
