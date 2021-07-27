package com.wservice.restfullspringwebJDBC;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wservice.restfullspringwebJDBC.DB.DersOgrenciRepository;
import com.wservice.restfullspringwebJDBC.DB.OgrenciRepository;
import com.wservice.restfullspringwebJDBC.DB.OgretmenRepository;
import com.wservice.restfullspringwebJDBC.model.Ogrenci;
import com.wservice.restfullspringwebJDBC.model.Ogretmen;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MyRestController
{
	private OgrenciRepository ogrenciRepo;

	private OgretmenRepository ogretmenRepo;

	private DersOgrenciRepository dersOgrenciRepo;

	// http://localhost:8080/restfullspringwebJDBC/getOgrenciler
	@GetMapping(path = "/getOgrenciler")
	public ResponseEntity<String> getOgrenciList()
	{
		List<Ogrenci> body = ogrenciRepo.getAllOgrenciler();
		ResponseEntity<String> response = new ResponseEntity<>(body.toString(), HttpStatus.OK);
		return response;
	}

	// http://localhost:8080/restfullspringwebJDBC/getOgrencilerEntity
	@GetMapping(path = "/getOgrencilerEntity")
	public ResponseEntity<List<Ogrenci>> getOgrenciEntityList()
	{
		List<Ogrenci> body = ogrenciRepo.getAllOgrenciler();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		ResponseEntity<List<Ogrenci>> response = new ResponseEntity<>(body, headers, HttpStatus.OK);
		return response;
	}

	// http://localhost:8080/restfullspringwebJDBC/getOgrenci&number=444
	@GetMapping(path = "/getOgrenci")
	public ResponseEntity<Ogrenci> getOgrenci(@RequestParam(name = "number", required = true) int number)
	{
		return new ResponseEntity<>(ogrenciRepo.getOgrenciByNumber(number), HttpStatus.OK);
	}

	// http://localhost:8080/restfullspringwebJDBC/getOgretmenlerList
	@GetMapping(path = "/getOgretmenlerList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ogretmen> getOgretmenList()
	{
		return ogretmenRepo.getAllOgretmenler();
	}

	// http://localhost:8080/restfullspringwebJDBC/postDersOgrenci
	@PostMapping(path = "/postDersOgrenci")
	public ResponseEntity<String> postDersOgrenci(@RequestBody Ogrenci ogrenci, @RequestParam(name = "dersId") Integer dersId)
	{
		// for transactional example
		if (dersOgrenciRepo.insertDersOgrenci(7, ogrenci))
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
