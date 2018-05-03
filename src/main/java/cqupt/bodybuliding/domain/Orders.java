package cqupt.bodybuliding.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	private int orderid;
	private String usernamea;
	private String usernameb;//教练
	private String time;
	 @Id 
     @Column(name = "orderid", nullable = false)   
	 @GeneratedValue(strategy = GenerationType.AUTO)//唯一主键
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	@Column(name="usernamea")
	public String getUsernamea() {
		return usernamea;
	}
	public void setUsernamea(String usernamea) {
		this.usernamea = usernamea;
	}
	@Column(name="usernameb")
	public String getUsernameb() {
		return usernameb;
	}
	public void setUsernameb(String usernameb) {
		this.usernameb = usernameb;
	}
	@Column(name="time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
