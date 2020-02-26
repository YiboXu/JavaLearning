package tk.mybatis.simple.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class EnabledTypeHandler implements TypeHandler<Enabled>{

	private Map<Integer, Enabled> enabledMap = new HashMap<Integer, Enabled>();
	
	public EnabledTypeHandler() {
		for(Enabled enabled:Enabled.values()) {
			enabledMap.put(enabled.getValue(), enabled);
		}
	}
	
	public void setParameter(PreparedStatement ps, int i, Enabled parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setInt(i, parameter.getValue());
		
	}

	public Enabled getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		int value = rs.getInt(columnName);
		return enabledMap.get(value);
	}

	public Enabled getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int value =rs.getInt(columnIndex);
		return enabledMap.get(value);
	}

	public Enabled getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int value = cs.getInt(columnIndex);
		return enabledMap.get(value);
	}

}
