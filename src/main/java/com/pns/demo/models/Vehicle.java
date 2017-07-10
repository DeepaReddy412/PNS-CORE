package com.pns.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	private int vehicleId;
	private int vehicleName;

	public int getVehicleId() {
		
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(int vehicleName) {
		this.vehicleName = vehicleName;
	}

}
