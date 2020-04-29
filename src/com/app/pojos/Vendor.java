package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.type.TrueFalseType;


@Entity//mandatry
@Table(name ="vendors")
public class Vendor {


	private Integer id;
	private String name,email,password;
	private UserRole userRole;
	private double regAmount;
	private Date regDate;

	private List<BankAccount> blist=new ArrayList<>();



	public Vendor(String name, String email, String password, UserRole userRole, double regAmount,
			Date regDate) 
	{
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}



	public Vendor() {
		System.out.println("in vendor ctor");
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vend_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	@Column(length = 30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 30,unique =true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 20,nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role",length = 20)
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}


	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", userRole=" + userRole + ", regAmount="
				+ regAmount + ", regDate=" + regDate + "]";
	}


	//	Add helper methods(addAccount & removeAccount) in Vendor class.

	@OneToMany(mappedBy = "vendor",cascade=CascadeType.ALL,orphanRemoval = true)
	public List<BankAccount> getBlist() {
		return blist;
	}

	public void setBlist(List<BankAccount> blist) {
		this.blist = blist;
	}

	public void addAccount(BankAccount b)
	{
		blist.add(b);
		b.setVendor(this);

	}
	public void removeAcount(BankAccount b)
	{
		blist.remove(b);
		b.setVendor(null);

	}

	//	 id(Integer),name,email,password,role(Enum UserRole
	//			 --VENDOR,ADMIN),reg amount(double), reg date(Date)

}
