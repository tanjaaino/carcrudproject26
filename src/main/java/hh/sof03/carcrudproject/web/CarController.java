package hh.sof03.carcrudproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import hh.sof03.carcrudproject.domain.Car;
import hh.sof03.carcrudproject.domain.CarRepository;

@Controller
public class CarController {
	
	CarRepository carRepository; 

	// Spring-alusta luo sovelluksen käynnistyessä CarRepository-rajapintaa toteuttavan luokan olion 
	// ja kytkee repositoryolion CarController-luokasta luodun olion attribuuttiolioksi
	public CarController( CarRepository carRepository){
		this.carRepository = carRepository;
	}
	
	// autolistaus
	@GetMapping("/allcars")
	public String getCars(Model model) {
			List<Car> cars =  (List<Car>) carRepository.findAll(); // haetaan tietokannasta autot
			model.addAttribute("cars", cars); // välitetään autolista templatelle model-olion avulla
			return "carlist"; // DispatherServlet saa tämän template-nimen ja kutsuu seuraavaksi carlist.html-templatea,
								// joka prosessoidaan palvelimella
	}

	// tyhjän autolomakkeen muodostaminen
	@GetMapping("/newcar")
	public String getNewCarForm(Model model) {
		model.addAttribute("car", new Car()); // "tyhjä" auto-olio
		return "carform";
	}

	// autolomakkeella syötettyjen tietojen vastaanotto ja tallennus
	@PostMapping("/savecar")
	public String saveCar(@ModelAttribute Car car) {
		// talletetaan yhden auton tiedot tietokantaan
		carRepository.save(car);
		return "redirect:/allcars";
	}

	// auton poisto
	@GetMapping("/deletecar/{id}")
	public String deleteCar(@PathVariable("id") Long carId) {
		carRepository.deleteById(carId);
		return "redirect:/allcars";
	}
	
	// TODO edit car
	

}
