package a.springboot.service.service;

public interface StarWarsService {
	Object getFilms(String search);

	Object getPeople(String search);

	Object getPlanets(String search);

	Object getStarships(String search);

	Object getSpecies(String search);

	Object getVehicles(String search);
}
