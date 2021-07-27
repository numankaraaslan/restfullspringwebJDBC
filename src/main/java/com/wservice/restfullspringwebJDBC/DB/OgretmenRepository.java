package com.wservice.restfullspringwebJDBC.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.wservice.restfullspringwebJDBC.model.Ogretmen;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class OgretmenRepository
{
	private JdbcTemplate jdbcTemplate;

	public List<Ogretmen> getAllOgretmenler()
	{
		String sql = "SELECT * FROM \"OBS\".\"OGRETMEN\"";
		return jdbcTemplate.query(sql, new RowMapper<Ogretmen>()
		{
			@Override
			public Ogretmen mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				return new Ogretmen(rs.getInt("OGR_ID"), rs.getString("OGR_NAME"));
			}
		});
	}
}
