package api.db;

import org.springframework.data.jpa.repository.JpaRepository;

import api.template.Pessoa;

public interface PessoaData extends JpaRepository<Pessoa, Long> {
	
}
