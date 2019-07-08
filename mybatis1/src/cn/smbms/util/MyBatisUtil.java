package cn.smbms.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static{
		try{
			String resource="mybatis-config.xml";
			InputStream is=Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			factory=builder.build(is);				
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession createSqlSession(){
		return factory.openSession(false);
	}
	
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}

}
