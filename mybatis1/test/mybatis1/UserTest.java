package mybatis1;

import java.io.IOException;

import java.util.*;


import org.apache.ibatis.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.mapper.BillMapper;
import cn.smbms.mapper.UserMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.pojo.User;
import cn.smbms.util.MyBatisUtil;





public class UserTest {
	private Logger log=Logger.getLogger(UserTest.class);
	
//	@Test
//	public void testCount() throws IOException{
		//先创建一个SqlSessionFactoryBuilder
		//在调用SqlSessionFactoryBuilder.build(InputStream)获取SqlSessionFactory 
		//SqlSessionFactory.openSession()获取SqlSession
		//在调用相应的数据库增删改查,比如SqlSession.selectOne()
//		String resource="mybatis-config.xml";
//		InputStream is=Resources.getResourceAsStream(resource);
//		SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(is);	
//		SqlSession session =factory.openSession();	
//		int count = session.selectOne("cn.smbms.mapper.UserMapper.count");
//		log.debug("count=======>"+count);
//		session.close();
		
		
//		SqlSession session=MyBatisUtil.createSqlSession();
//		int count = session.getMapper(UserMapper.class).count();
//		log.debug("count=======>"+count);
//		MyBatisUtil.closeSqlSession(session);
		
		
//		SqlSession session=MyBatisUtil.createSqlSession();
//		List<User> uList = session.getMapper(UserMapper.class).getUserList();
//		log.debug("count=======>"+uList.size());
//		MyBatisUtil.closeSqlSession(session);

//		SqlSession session=MyBatisUtil.createSqlSession();
//		List<User> uList = session.getMapper(UserMapper.class).getUserByUserName("孙");
//		log.debug("count=======>"+uList.size());
//		MyBatisUtil.closeSqlSession(session);
		
		//多参数时,封装成User对象
//		SqlSession session=MyBatisUtil.createSqlSession();
//		User user =new User();
//		user.setUserName("孙");
//		user.setUserRole(3);;
//		List<User> uList = session.getMapper(UserMapper.class).getUserByConditions1(user);
//		log.debug("count=======>"+uList.size());
//		MyBatisUtil.closeSqlSession(session);
		
		//多参数时封装成Map
//		SqlSession session=MyBatisUtil.createSqlSession();
//		Map uMap=new HashMap<>();
//		uMap.put("userName", "孙");
//		uMap.put("userRole", 3);
//		List<User> uList = session.getMapper(UserMapper.class).getUserByConditions2(uMap);
//		log.debug("count=======>"+uList.size());
//		MyBatisUtil.closeSqlSession(session);
		
		
		//多参数时封装成Map
//		SqlSession session=MyBatisUtil.createSqlSession();
//		Map uMap=new HashMap<>();
//		uMap.put("userName", "孙");
//		uMap.put("userRole", 3);
//		List<User> uList = session.getMapper(UserMapper.class).getUserByConditions3(uMap);
//		log.debug("count=======>"+uList.get(0).getUserRoleName());
//		MyBatisUtil.closeSqlSession(session);
//	}

	//增加
//@Test
//public void testCount2(){
//		
//		SqlSession session=null;
//		int result=0;
//		try{
//			User user = new User();
//			user.setUserCode("admin20");
//			user.setUserName("admin20");
//			user.setUserPassword("0000000");
//			user.setGender(1);
//			user.setBirthday(new Date());
//			user.setPhone("13111111111");
//			user.setAddress("北京");
//			user.setUserRole(3);
//			user.setCreatedBy(1);
//			user.setCreationDate(new Date());
//			
//			session=MyBatisUtil.createSqlSession();
//			result =session.getMapper(UserMapper.class).insert(user);
//			session.commit();
//		}catch(Exception e){
//			session.rollback();
//		}finally{
//			log.debug("count=======>"+result);
//			MyBatisUtil.closeSqlSession(session);
//		}
//			
//	}
	
	
	//修改
//	@Test
//	public void testCount3(){
//			
//			SqlSession session=null;
//			int result=0;
//			try{
//				User user = new User();
//				user.setId(43);
//				user.setUserName("admin2002");
//
//				session=MyBatisUtil.createSqlSession();
//				result =session.getMapper(UserMapper.class).update(user);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+result);
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
	
//	@Test
//	public void testCount4(){
//			SqlSession session=null;
//			int result=0;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				result =session.getMapper(UserMapper.class).delete(44);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+result);
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
	
//	@Test
//	public void testCount4(){
//			SqlSession session=null;
//			List<Bill> bills=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				bills =session.getMapper(BillMapper.class).getBillList("洗");
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+bills.size());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
//	
//	@Test
//	public void testCount3(){
//			
//			SqlSession session=null;
//			int result=0;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				result =session.getMapper(UserMapper.class).update2(43, "admin199");
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+result);
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
	
	
//	@Test
//	public void testCount3(){
//			
//			SqlSession session=null;
//			List <User> users=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				users =session.getMapper(UserMapper.class).getUserAndRole();
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+users.get(0).getRole().getRoleName()+users.size());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
//	@Test
//	public void testCount5(){
//			
//			SqlSession session=null;
//			int [] roles={1,2};
//			
//			List <User> users=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				users =session.getMapper(UserMapper.class).getUserByUserRole1(roles);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+users.size()+users.get(0).getUserName());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
	
//	@Test
//	public void testCount6(){
//			
//			SqlSession session=null;
//			List<Integer> roles=new ArrayList<>();
//			roles.add(1);
//			roles.add(2);
//			Map roleMap =new HashMap<>();
//			roleMap.put("roles", roles);
//			List <User> users=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				users =session.getMapper(UserMapper.class).getUserByUserRole3(roleMap);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+users.get(0).getUserName()+users.size());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
//	@Test
//	public void testCount6(){
//			
//			SqlSession session=null;
//			User user=new User();
//			//user.setUserName("用户");
//			//user.setUserCode("test");
//			user.setGender(1);
//			List <User> users=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				users =session.getMapper(UserMapper.class).getUserByChoose(user);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+users.get(0).getUserName()+users.size());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
	
//	@Test
//	public void testCount6(){
//			
//			SqlSession session=null;
//			Map uMap =new HashMap<>();
//			//uMap.put("userName", "添加");
//			uMap.put("userRole", 3);
//			List <User> users=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				users =session.getMapper(UserMapper.class).getUserByConditions12(uMap);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+users.get(0).getUserName()+users.size());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
	
	
//	@Test
//	public void testCount6(){
//			
//			SqlSession session=null;
//			User user=new User();
//			//user.setUserName("添加");
//			user.setUserRole(3);
//		
//			List <User> users=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				users =session.getMapper(UserMapper.class).getUserByConditions11(user);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+users.get(0).getUserName()+users.size());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
	
	@Test
	public void testCount6(){
			
//			SqlSession session=null;
//			User user=new User();
//			user.setId(43);
//			user.setUserName("admin201");
//			user.setUserCode("admin201");
//			int users=0;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				users =session.getMapper(UserMapper.class).update3(user);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug("count=======>"+users);
//				MyBatisUtil.closeSqlSession(session);
//			}	
		
		SqlSession session=MyBatisUtil.createSqlSession();
		List<User> uList = session.getMapper(UserMapper.class).getUserByUserName("孙");
		log.debug("count=======>"+uList.size());
		MyBatisUtil.closeSqlSession(session);
		}
		

	}
