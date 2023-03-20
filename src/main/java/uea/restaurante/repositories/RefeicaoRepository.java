package uea.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.restaurante.models.Refeicao;

@Repository
public interface RefeicaoRepository  extends JpaRepository<Refeicao, Long> {

}