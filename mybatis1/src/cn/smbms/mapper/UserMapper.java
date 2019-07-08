package cn.smbms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserMapper {
	public int count();
	public List<User> getUserList();
	public List<User> getUserByUserName(String userName);
	public List<User> getUserByConditions1(User user);
	public List<User> getUserByConditions2(Map conditions);
	public List<User> getUserByConditions3(Map conditions);
	public int insert(User user);
	public int update(User user);
	public int delete(int id);
	//使用注解Param传参数,xml里就不用parameterType
	public int update2(@Param("id") int id,@Param("userName")String userName);
	
	public List<User> getUserAndRole();
	
	
	public List<User> getUserByConditions12(Map uMap);
	
	public List<User> getUserByConditions11(User user);
	
	public List<User> getUserByUserRole1(int[] roles);
	
	public List<User> getUserByUserRole3(Map roleMap);

	public List<User> getUserByChoose(User user);
	
	public int update3(User user);
	
}
