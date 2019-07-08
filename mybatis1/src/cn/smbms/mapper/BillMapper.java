package cn.smbms.mapper;

import java.util.List;

import cn.smbms.pojo.Bill;

public interface BillMapper{
	public List<Bill> getBillList(String productName);
	public int getbill();
	public int count();
	public List<Bill> getById(int id);
	public List<Bill> getIsPayment(int isPayment);
	
	public List<Bill> getBillList1(Bill bill);
}
