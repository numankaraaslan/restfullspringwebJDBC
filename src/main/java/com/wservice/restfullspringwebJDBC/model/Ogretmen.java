package com.wservice.restfullspringwebJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ogretmen
{
	private int id;

	private String isim;

	@Override
	public String toString()
	{
		return "(" + id + " - " + isim + ")";
	}
}
