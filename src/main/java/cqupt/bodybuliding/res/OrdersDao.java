package cqupt.bodybuliding.res;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cqupt.bodybuliding.domain.Orders;

public interface OrdersDao extends JpaRepository<Orders,Integer>{
	
	
	@Query("from Orders o where o.usernamea = ?1 ")//?
	public List<Orders> selectOrderByUsername(String username);
	
	@Query("from Orders o where o.usernameb = ?1 ")//?
	public List<Orders> selectOrderByUsername1(String username);
	
    @Modifying
    @Transactional
	@Query("update Orders set time=?1 where orderid=?2")
	public int updatetime(String time,int orderid);
	
}
