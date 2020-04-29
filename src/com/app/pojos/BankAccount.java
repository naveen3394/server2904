package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "bankaccounts")
public class BankAccount {
	//	 acctNo(Integer @Id), type (enum-AcType -SAVING,CURRENT,FD,LOAN), balance.

	private Integer acctNo;
	private AcType type; 
	private double balance;
	//bank has-a vendor's  account	
	private Vendor vendor;

	public BankAccount() {
		
			System.out.println("in bank acc ctor");
	}

	public BankAccount( AcType actyp, double balance) {
		this.type = actyp;
		this.balance = balance;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(length = 11)
	public Integer getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(Integer acctNo) {
		this.acctNo = acctNo;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "acc_type")
	public AcType getType() {
		return type;
	}

	public void setType(AcType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
@ManyToOne 
@JoinColumn(name = "v_id")
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", type=" + type + ", balance=" + balance + "]";
	}

}
