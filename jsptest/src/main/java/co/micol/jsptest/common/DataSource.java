package co.micol.jsptest.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//	DAO객체를 관례적으로 DataSource라고 함
//	singleton객체
public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	
	private DataSource() {
		
	}
	
	public static SqlSessionFactory dataSource() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
