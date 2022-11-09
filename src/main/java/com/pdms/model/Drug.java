package com.pdms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="drug")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Drug {
	@Id
	@GeneratedValue
	private int drugId;
	

private String pname;
private String phaname;
private String orderstatus;
	private String orderDetails;
	private String quantity;
}
