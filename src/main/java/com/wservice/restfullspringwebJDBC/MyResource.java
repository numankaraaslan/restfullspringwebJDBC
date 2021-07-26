package com.wservice.restfullspringwebJDBC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wservice.restfullspringwebJDBC.DB.OgrenciRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MyResource
{
	private OgrenciRepository ogrenciRepo;

	// http://localhost:8080/restfullspringwebJDBC/sayhi
	@GetMapping(path = "/sayhi")
	public String getIt()
	{
		//		ogrenciRepo.insertOgrenci(new Ogrenci(223, "Havvanur"));
		//		List<Ogrenci> list = ogrenciRepo.getAllOgrenciler();
		//		System.out.println(list.toString());
		System.out.println(ogrenciRepo.getAllOgrencilerHigherThan(333));
		return "Hello";
	}
}