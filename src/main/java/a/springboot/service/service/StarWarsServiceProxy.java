package a.springboot.service.service;

import java.util.Arrays;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("proxy")
public class StarWarsServiceProxy implements StarWarsService {

	private static final Logger log = LoggerFactory.getLogger(StarWarsService.class);

	@Autowired
	Environment env;

	@Autowired
	RestTemplate restTemplate;

	private Object getResponse(String url, String search) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// solve https 403
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		url = StringUtils.isEmpty(search) ? url : (url + "?search=" + search);
		log.info(new StringJoiner(" ", "[ ", " ]").add(url).toString());

		return restTemplate.exchange(url, HttpMethod.GET, entity, Object.class).getBody();
	}

	@Override
	public Object getFilms(String search) {
//		throw new NotFoundException();
		return getResponse(env.getProperty("swapi.co.api.films"), search);
	}

	@Override
	public Object getPeople(String search) {
		return getResponse(env.getProperty("swapi.co.api.people"), search);
	}

	@Override
	public Object getPlanets(String search) {
		return getResponse(env.getProperty("swapi.co.api.planets"), search);
	}

	@Override
	public Object getStarships(String search) {
		return getResponse(env.getProperty("swapi.co.api.starships"), search);
	}

	@Override
	public Object getSpecies(String search) {
		return getResponse(env.getProperty("swapi.co.api.species"), search);
	}

	@Override
	public Object getVehicles(String search) {
		return getResponse(env.getProperty("swapi.co.api.vehicles"), search);
	}

}
