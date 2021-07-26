package com.wservice.restfullspringwebJDBC.DB;

public class DersRepository
{
	public static boolean insertDers(int ogretmenId, int konuId)
	{
		boolean res = false;
		String sql = "INSERT INTO \"OBS\".\"DERS\"(\"OGRETMEN_ID\", \"KONU_ID\") VALUES (?, ?)";
		return res;
	}
}
