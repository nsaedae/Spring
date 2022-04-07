package kr.co.ch06.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.co.ch06.vo.CustomerVo;

@Repository
public interface CustomerDao {

	@Insert("INSERT INTO `Customer` (`name`, `address`, `phone`) VALUES (#{name}, #{address}, #{phone})")
	public void insertCustomer(CustomerVo vo);
	
	@Select("SELECT * FROM `Customer` WHERE `custid`=#{custid}")
	public CustomerVo selectCustomer(int custid);
	
	@Select("SELECT * FROM `Customer`")
	public List<CustomerVo> selectCustomers();
	
	@Update("UPDATE `Customer` SET `name`=#{name}, `address`=#{address}, `phone`=#{phone} WHERE `custid`=#{custid}")
	public void updateCustomer(CustomerVo vo);
	
	@Delete("DELETE FROM `Customer` WHERE `custid`=#{custid}")
	public void deleteCustomer(int custid);
}
