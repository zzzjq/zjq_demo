package zjq.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSON;

import zjq.demo.model.PartnerConfig;

/**
 * @author:zhangjq
 * @time:2017年12月18日 下午3:07:17
 * @version:v1.0
 */
public class JdbcTest {
	
	private String url;
	
	private String user;
	
	private String pwd;

	private Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			url = "jdbc:oracle:thin:@192.168.11.142:1521:crossborder";
			user = "cross";
			pwd = "cross123";
			connection = DriverManager.getConnection(url, user, pwd);
			return connection;
		}
		catch(Exception e){
			return null;
		}
	}
	
	private PartnerConfig select(Long partnerConfigNo){
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PartnerConfig config = null;
		String sql = "SELECT * FROM CROSS_FI.PARTNER_CONFIG WHERE PARTNER_CONFIG_NO = ?";
		try{
			statement = (PreparedStatement)connection.prepareStatement(sql);
			statement.setLong(1, partnerConfigNo);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				config = new PartnerConfig();
				config.setDescription(resultSet.getString("description"));
				config.setRemark(resultSet.getString("remark"));
				config.setMemberCode(resultSet.getLong("member_code"));
				config.setPartnerConfigNo(resultSet.getLong("PARTNER_CONFIG_NO"));
				config.setValue(resultSet.getString("value"));
				config.setParamCode(resultSet.getString("param_code"));
			}
			return config;
		}catch(Exception e){
			return null;
		}
		finally{
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args){
		JdbcTest test = new JdbcTest();
		PartnerConfig config = test.select(new Long("1161706281416010089"));
		System.out.println(JSON.toJSON(config));
	}
	
}
