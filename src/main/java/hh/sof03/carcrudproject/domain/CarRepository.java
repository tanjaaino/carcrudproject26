package hh.sof03.carcrudproject.domain;

import org.springframework.data.repository.CrudRepository;

// tietokantakäsittelyn rajapinta
public interface CarRepository extends CrudRepository<Car, Long> {
	
	

}
