package a.springboot.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import a.springboot.service.service.StarWarsService;

@RestController
@RequestMapping("/api/v1/starwars")
@CrossOrigin
public class StarWarsController {

	private static final Logger log = LoggerFactory.getLogger(StarWarsController.class);

	public StarWarsController() {
		log.info("[ StarWarsController ] constructor");
	}

	@Autowired
//	@Qualifier("proxy")
	private StarWarsService svc;

	@RequestMapping(value = "/films")
	public ResponseEntity<Object> getFilms(@RequestParam(value = "search", required = false) String search) {
		return new ResponseEntity<>(svc.getFilms(search), HttpStatus.OK);
	}

	@RequestMapping(value = "/people")
	public ResponseEntity<Object> getPeople(@RequestParam(value = "search", required = false) String search) {
		return new ResponseEntity<>(svc.getPeople(search), HttpStatus.OK);
	}

	@RequestMapping(value = "/planets")
	public ResponseEntity<Object> getPlanets(@RequestParam(value = "search", required = false) String search) {
		return new ResponseEntity<>(svc.getPlanets(search), HttpStatus.OK);
	}

	@RequestMapping(value = "/starships")
	public ResponseEntity<Object> getStarships(@RequestParam(value = "search", required = false) String search) {
		return new ResponseEntity<>(svc.getStarships(search), HttpStatus.OK);
	}

	@RequestMapping(value = "/species")
	public ResponseEntity<Object> getSpecies(@RequestParam(value = "search", required = false) String search) {
		return new ResponseEntity<>(svc.getSpecies(search), HttpStatus.OK);
	}

	@RequestMapping(value = "/vehicles")
	public ResponseEntity<Object> getVehicles(@RequestParam(value = "search", required = false) String search) {
		return new ResponseEntity<>(svc.getVehicles(search), HttpStatus.OK);
	}
}