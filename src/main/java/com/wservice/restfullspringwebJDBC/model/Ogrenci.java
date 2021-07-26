package com.wservice.restfullspringwebJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ogrenci
{
	private int id;

	private int number;

	private String isim;

	public Ogrenci(int number, String isim)
	{
		this.number = number;
		this.isim = isim;
	}

	@Override
	public String toString()
	{
		return "(" + number + " - " + isim + ")";
	}
}
