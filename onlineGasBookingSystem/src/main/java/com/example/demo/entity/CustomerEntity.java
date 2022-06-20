package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.Bank;
import com.example.demo.GasBooking;
import com.example.demo.SurrenderCylinder;
import com.example.demo.transformer.Cylinder;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Data
@ToString
public class CustomerEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private Integer cylinderId;
	private Integer bankID;
	private Integer accountNo;
	private String ifscNo;
	private String pan;
	@OneToOne
	private Bank bank;
	@OneToMany
	private List<Cylinder> cylinder = new ArrayList<Cylinder>();
	@OneToMany
	private List<GasBooking> gasBookings=new ArrayList<GasBooking>();
	@OneToOne
	private SurrenderCylinder surrenderCylinder;
	public CustomerEntity() {
		super();
	}
	public CustomerEntity(Integer customerId, Integer cylinderId, Integer bankID, Integer accountNo, String ifscNo,
			String pan, Bank bank, List<GasBooking> gasBookings, SurrenderCylinder surrenderCylinder) {
		super();
		this.customerId = customerId;
		this.cylinderId = cylinderId;
		this.bankID = bankID;
		this.accountNo = accountNo;
		this.ifscNo = ifscNo;
		this.pan = pan;
		this.bank = bank;
		this.gasBookings = gasBookings;
		this.surrenderCylinder = surrenderCylinder;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCylinderId() {
		return cylinderId;
	}
	public void setCylinderId(Integer cylinderId) {
		this.cylinderId = cylinderId;
	}
	public Integer getBankID() {
		return bankID;
	}
	public void setBankID(Integer bankID) {
		this.bankID = bankID;
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfscNo() {
		return ifscNo;
	}
	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public List<GasBooking> getGasBookings() {
		return gasBookings;
	}
	public void setGasBookings(List<GasBooking> gasBookings) {
		this.gasBookings = gasBookings;
	}
	public SurrenderCylinder getSurrenderCylinder() {
		return surrenderCylinder;
	}
	public void setSurrenderCylinder(SurrenderCylinder surrenderCylinder) {
		this.surrenderCylinder = surrenderCylinder;
	}
	public void setBankId(int bankId2) {
		// TODO Auto-generated method stub
		
	}

	
}