package data.dto;

import java.sql.Timestamp;

public class moneyDto {

	private int num;
	private int deposit;
	private int unexdeposit;
	private int withdraw;
	private int foodexpen;
	private int fixedexpen;
	private int transportexpen;
	private int medicalexpen;
	private int unexexpen;
	private int elesexpen;
	private Timestamp datetime;
	
	public moneyDto() {
		super();
	}	
	public moneyDto(int deposit, int unexdeposit, int withdraw, int foodexpen, int fixedexpen, int transportexpen,
		int medicalexpen, int unexexpen, int elesexpen) {
		super();
		this.deposit = deposit;
		this.unexdeposit = unexdeposit;
		this.withdraw = withdraw;
		this.foodexpen = foodexpen;
		this.fixedexpen = fixedexpen;
		this.transportexpen = transportexpen;
		this.medicalexpen = medicalexpen;
		this.unexexpen = unexexpen;
		this.elesexpen = elesexpen;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getUnexdeposit() {
		return unexdeposit;
	}
	public void setUnexdeposit(int unexdeposit) {
		this.unexdeposit = unexdeposit;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	public int getFoodexpen() {
		return foodexpen;
	}
	public void setFoodexpen(int foodexpen) {
		this.foodexpen = foodexpen;
	}
	public int getFixedexpen() {
		return fixedexpen;
	}
	public void setFixedexpen(int fixedexpen) {
		this.fixedexpen = fixedexpen;
	}
	public int getTransportexpen() {
		return transportexpen;
	}
	public void setTransportexpen(int transportexpen) {
		this.transportexpen = transportexpen;
	}
	public int getMedicalexpen() {
		return medicalexpen;
	}
	public void setMedicalexpen(int medicalexpen) {
		this.medicalexpen = medicalexpen;
	}
	public int getUnexexpen() {
		return unexexpen;
	}
	public void setUnexexpen(int unexexpen) {
		this.unexexpen = unexexpen;
	}
	public int getElesexpen() {
		return elesexpen;
	}
	public void setElesexpen(int elesexpen) {
		this.elesexpen = elesexpen;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
}
