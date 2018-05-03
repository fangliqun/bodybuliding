package cqupt.bodybuliding.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	private Integer userid;
	private String username;
	private String password;
    private String type;//类型
    private String introduce;//简介
    @Id 
	@Column(name = "userid", nullable = false)   
	@GeneratedValue(strategy = GenerationType.AUTO)//唯一主键
    public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="introduce")
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	    
	    
//	 @Id 
//	 @Column(name = "userid", nullable = false)   
//	 @GeneratedValue(strategy = GenerationType.AUTO)//唯一主键
//	public Integer getUserid() {
//		return userid;
//	}
//	public void setUserid(Integer userid) {
//		this.userid = userid;
//	}
//	@Column(name="username")
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	@Column(name="password")
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	} 
//	@Column(name="address")
//	public String getAddress() {
//		return address;
//	}
//    
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	@Column(name="callnumber")
//	public String getCallnumber() {
//		return callnumber;
//	}
//	public void setCallnumber(String callnumber) {
//		this.callnumber = callnumber;
//	}
}

