package hu.kaev.debtcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyData{
	
	private int month;
	private double outstanding;
	private double payment;
	private double interest;
	private double capital;
	private double prepayment;
	
}