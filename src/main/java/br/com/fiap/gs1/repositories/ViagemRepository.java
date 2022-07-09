package br.com.fiap.gs1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gs1.models.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Integer>{

}
