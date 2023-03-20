package com.camunda.academy.springrest.entity;

public class Deductibles {
	
	private long bipd;
	private long pip;
	private long collisionDeductibles;
	private long comprehensiveDeductibles;
	
	public Deductibles() {};
	
	public Deductibles(long bipd, long pip, long collisionDeductibles, long comprehensiveDeductibles) {
		this.bipd = bipd;
		this.pip = pip;
		this.collisionDeductibles = collisionDeductibles;
		this.comprehensiveDeductibles = comprehensiveDeductibles;
	}
	
	public long getBipd() {
		return bipd;
	}
	public void setBipd(long bipd) {
		this.bipd = bipd;
	}
	public long getPip() {
		return pip;
	}
	public void setPip(long pip) {
		this.pip = pip;
	}
	public long getCollisionDeductibles() {
		return collisionDeductibles;
	}
	public void setCollisionDeductibles(long collisionDeductibles) {
		this.collisionDeductibles = collisionDeductibles;
	}
	public long getComprehensiveDeductibles() {
		return comprehensiveDeductibles;
	}
	public void setComprehensiveDeductibles(long comprehensiveDeductibles) {
		this.comprehensiveDeductibles = comprehensiveDeductibles;
	}

	@Override
	public String toString() {
		return "Deductibles [bipd=" + bipd + ", pip=" + pip + ", collisionDeductibles=" + collisionDeductibles
				+ ", comprehensiveDeductibles=" + comprehensiveDeductibles + "]";
	}
	
	
	

}
