package mybatis1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.mapper.RoleMapper;
import cn.smbms.mapper.UserMapper;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.util.MyBatisUtil;

public class RoleTest {
	private Logger log=Logger.getLogger(RoleTest.class);
	@Test
	public void testCount3(){
		
			SqlSession session=null;
			List <Role> roles=null;
			try{
				session=MyBatisUtil.createSqlSession();
				roles =session.getMapper(RoleMapper.class).getAllRole();
				session.commit();
			}catch(Exception e){
				session.rollback();
			}finally{
				log.debug("count=======>"+roles.size());
				log.debug("count=======>"+roles.get(1).getUserList().get(5).getUserName());
				
				MyBatisUtil.closeSqlSession(session);
			}			
		}

}
