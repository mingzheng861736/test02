package mybatis1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.mapper.BillMapper;
import cn.smbms.pojo.Bill;
import cn.smbms.util.MyBatisUtil;

public class Billtest2 {
	private Logger log=Logger.getLogger(Billtest2.class);
	
//	@Test
//	public void testCount5(){
//			SqlSession session=null;
//			int a=0;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				a =session.getMapper(BillMapper.class).count();
//				session.commit();
//			}catch(Exception e){
//				e.getStackTrace();
//			}finally{
//				log.debug("count=======>"+a);
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
//	@Test
//	public void testCount5(){
//			SqlSession session=null;
//			List<Bill> bills=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				bills =session.getMapper(BillMapper.class).getBillList("洗");
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug(bills.get(0).getProductName()+"count=======>"+bills.get(0).getProviderName());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
	
	
//	@Test
//	public void testCount6(){
//			SqlSession session=null;
//			List<Bill> bills=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				bills =session.getMapper(BillMapper.class).getById(6);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug(bills.get(0).getProductName()+"count=======>"+bills.get(0).getProviderName());
//				MyBatisUtil.closeSqlSession(session);
//			}			
//		}
	
//	
//	@Test
//	public void testCount6(){
//			SqlSession session=null;
//			List<Bill> bills=null;
//			try{
//				session=MyBatisUtil.createSqlSession();
//				bills =session.getMapper(BillMapper.class).getIsPayment(1);
//				session.commit();
//			}catch(Exception e){
//				session.rollback();
//			}finally{
//				log.debug(bills.get(0).getProductName()+"count=======>"+bills.get(0).getProviderName()+bills.size());
//				MyBatisUtil.closeSqlSession(session);
//			}
//		}
	

	@Test
	public void testCount6(){
			SqlSession session=null;
			List<Bill> bills=null;
			Bill bill=new Bill();
			bill.setIsPayment(2);
			//bill.setProductName("洗");
			bill.setProviderId(1);
			try{
				session=MyBatisUtil.createSqlSession();
				bills =session.getMapper(BillMapper.class).getBillList1(bill);
				session.commit();
			}catch(Exception e){
				session.rollback();
			}finally{
				log.debug("count=======>"+bills.get(0).getProductName()+bills.size());
				MyBatisUtil.closeSqlSession(session);
			}
		}

}
