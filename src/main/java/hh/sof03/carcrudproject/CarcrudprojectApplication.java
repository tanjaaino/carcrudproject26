package hh.sof03.carcrudproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.carcrudproject.domain.Car;
import hh.sof03.carcrudproject.domain.CarRepository;

@SpringBootApplication
public class CarcrudprojectApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CarcrudprojectApplication.class);  // uusi loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(CarcrudprojectApplication.class, args);
	}
	
	
	//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner carDemo(CarRepository carRepository) { 
		return (args) -> {
			log.info("save a couple of cars");
			Car car1 = new Car("Tesla", 2016);
			Car car2 = new Car("Saab", 1986);
			carRepository.save(car1);
			carRepository.save(car2);	
			
			log.info("fetch all cars");
			for (Car car : carRepository.findAll()) {
				log.info(car.toString());
			}

		};
	}
}
