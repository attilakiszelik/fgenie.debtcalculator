package hu.kaev.debtcalculator.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculation {
	
	private int amount;
	private int periods;
	private double interestRate;
	private boolean tolerationPeriod;
	List<MonthlyData> normalData;
	List<MonthlyData> toleratedData;
	
}