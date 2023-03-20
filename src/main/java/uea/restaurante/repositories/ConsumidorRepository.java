package uea.restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.restaurante.models.Consumidor;

@Repository
public interface ConsumidorRepository  extends JpaRepository<Consumidor, Long> {

}