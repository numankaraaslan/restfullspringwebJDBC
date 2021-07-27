package com.wservice.restfullspringwebJDBC.DB;

import java.util.HashMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.wservice.restfullspringwebJDBC.model.Ogrenci;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DersOgrenciRepository
{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional
	public boolean insertDersOgrenci(int dersId, Ogrenci ogrenci)
	{
		boolean res = false;
		String sql = "INSERT INTO \"OBS\".\"OGRENCI\"(\"OGR_NUM\", \"OGR_NAME\") VALUES (:OGR_NUM, :OGR_NAME)";
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("OGR_NUM", ogrenci.getNumber());
		paramMap.put("OGR_NAME", ogrenci.getIsim());
		namedParameterJdbcTemplate.update(sql, paramMap);
		sql = "INSERT INTO \"OBS\".\"DERS_OGRENCI\"(\"OGRENCI_ID\", \"DERS_ID\") VALUES (:OGRENCI_ID, :DERS_ID)";
		paramMap = new HashMap<>();
		paramMap.put("OGRENCI_ID", ogrenci.getId());
		paramMap.put("DERS_ID", dersId);
		res = namedParameterJdbcTemplate.update(sql, paramMap) > 0;
		return res;
	}
}
