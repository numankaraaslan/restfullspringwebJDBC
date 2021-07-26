package com.wservice.restfullspringwebJDBC;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wservice.restfullspringwebJDBC.DB.OgrenciRepository;
import com.wservice.restfullspringwebJDBC.model.Ogrenci;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MyRestController
{
	private OgrenciRepository ogrenciRepo;

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
}
