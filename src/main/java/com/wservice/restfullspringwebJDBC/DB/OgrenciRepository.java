package com.wservice.restfullspringwebJDBC.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.wservice.restfullspringwebJDBC.model.Ogrenci;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class OgrenciRepository
{
	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public boolean insertOgrenci(Ogrenci ogrenci)
	{
		// jdbcTemplate=new JdbcTemplate(dataSource)
		boolean res = false;
		//		String sql = "INSERT INTO \"OBS\".\"OGRENCI\"(\"OGR_NUM\", \"OGR_NAME\") VALUES (?, ?)";
		//		jdbcTemplate.execute(sql, new PreparedStatementCallback<Object>()
		//		{
		//			@Override
		//			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
		//			{
		//				ps.setInt(1, ogrenci.getNumber());
		//				ps.setString(2, ogrenci.getIsim());
		//				return ps.executeUpdate();
		//			}
		//		});
		// --------- named param ile -----------
		//		String sql = "INSERT INTO \"OBS\".\"OGRENCI\"(\"OGR_NUM\", \"OGR_NAME\") VALUES (:OGR_NUM, :OGR_NAME)";
		//		HashMap<String, Object> paramMap = new HashMap<>();
		//		paramMap.put("OGR_NUM", ogrenci.getNumber());
		//		paramMap.put("OGR_NAME", ogrenci.getIsim());
		//		namedParameterJdbcTemplate.execute(sql, paramMap, new PreparedStatementCallback<Object>()
		//		{
		//			@Override
		//			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException
		//			{
		//				return ps.executeUpdate();
		//			}
		//		});
		// --------- arka planda prepared statement ile ---------
		//		String sql = "INSERT INTO \"OBS\".\"OGRENCI\"(\"OGR_NUM\", \"OGR_NAME\") VALUES (:OGR_NUM, :OGR_NAME)";
		//		HashMap<String, Object> paramMap = new HashMap<>();
		//		paramMap.put("OGR_NUM", ogrenci.getNumber());
		//		paramMap.put("OGR_NAME", ogrenci.getIsim());
		//		namedParameterJdbcTemplate.update(sql, paramMap);
		return res;
	}

	public List<Ogrenci> getAllOgrenciler()
	{
		String sql = "SELECT * FROM \"OBS\".\"OGRENCI\"";
		return jdbcTemplate.query(sql, new RowMapper<Ogrenci>()
		{
			@Override
			public Ogrenci mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				return new Ogrenci(rs.getInt("OGR_NUM"), rs.getString("OGR_NAME"));
			}
		});
	}

	public List<Ogrenci> getAllOgrencilerHigherThan(int number)
	{
		// prepstat
		String sql = "SELECT * FROM \"OBS\".\"OGRENCI\" WHERE \"OGR_NUM\" > ?";
		return jdbcTemplate.query(sql, new RowMapper<Ogrenci>()
		{
			@Override
			public Ogrenci mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				return new Ogrenci(rs.getInt("OGR_NUM"), rs.getString("OGR_NAME"));
			}
		}, number);
	}
}
