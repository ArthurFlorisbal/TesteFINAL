package api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.db.PessoaData;
import api.template.Pessoa;
import api.template.PessoaEndereco;

@RestController
@RequestMapping("/gerenciamento")
public class APIController {

	@Autowired
	private PessoaData pessoaData;

	private Pessoa pessoa;
	

	@PostMapping(value = "/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pessoa post(@RequestBody Pessoa pessoa) {
		return pessoaData.save(pessoa);
	}
	

	@GetMapping(value = "/pid/{id}")
	public Optional<Pessoa> getById(@PathVariable Long id) {
		return pessoaData.findById(id);
	}
	
	
	@GetMapping(value = "/vtodos")
	public List<Pessoa> getAll() {
		return pessoaData.findAll();
	}

	

	@GetMapping(value = "/peid/{id}")
	public PessoaEndereco myEnderecos(@PathVariable Long id) {
		
		PessoaEndereco pessoaForm = new PessoaEndereco();
		pessoaForm.setNome(pessoaData.getReferenceById(id).getNome());
		pessoaForm.setEndereco(pessoaData.getReferenceById(id).getEndereco());
		
		return pessoaForm;
		
	}



	@PatchMapping(value = "/att/{id}")
	public Pessoa patch(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return pessoaData.save(attForm(id, pessoa));
	}

	@PutMapping(value = "/att/{id}")
	public Pessoa put(@PathVariable Long id, @RequestBody(required = true) Pessoa pessoa) {
		return pessoaData.save(pessoa);
	}

	@PutMapping(value = "/endprincipal/{id}/{enderecoPrincipal}")
	public Pessoa selectEndereco(@PathVariable Long id, @PathVariable byte enderecoPrincipal) {
		
		return pessoaData.save(attEndereco(id, enderecoPrincipal));
	}

	@DeleteMapping(value = "/del/{id}")
	public void delete(@PathVariable Long id) {

		System.out.println("DADOS DO USUÁRIO" + pessoaData.getReferenceById(id).getNome() + " DELETADOS COM SUCESSO!");
		pessoaData.deleteById(id);

	}


	public Pessoa attForm(Long id, Pessoa body) {

		pessoa = pessoaData.getReferenceById(id);

		Pessoa pessoaBody = body;

		if (pessoaBody.getNome() != null)
			pessoa.setNome(pessoaBody.getNome());
		if (pessoaBody.getAniversario() != null)
			pessoa.setAniversario(pessoaBody.getAniversario());
		if (pessoaBody.getEndereco() != null)
			pessoa.setEnderecoString(pessoaBody.getEndereco().toString().replace("[", "").replace("]", ""));
		if (pessoaBody.getEnderecoPrincipal() > 0)
			pessoa.setEnderecoPrincipal(pessoaBody.getEnderecoPrincipal());

		return pessoa;
	}
	

	public Pessoa attEndereco(Long id, byte enderecoPrincipal) {

		pessoa = pessoaData.getReferenceById(id);
		
		if(enderecoPrincipal> pessoa.getEndereco().size()) {
			pessoa.setEnderecoPrincipal((byte) pessoa.getEndereco().size());
		}else {
			pessoa.setEnderecoPrincipal(enderecoPrincipal);
		}
		
		return pessoa;
		
	}

}
