package hu.kaev.debtcalculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.kaev.debtcalculator.model.Calculation;
import hu.kaev.debtcalculator.model.MonthlyData;

@Service
public class CalculationService {
	
	public Calculation getCalculation(Calculation request) {
		
		int a = request.getAmount();
		int p = request.getPeriods();
		double ir = request.getInterestRate();
		
		MonthlyData monthlyData = new MonthlyData();
		
		monthlyData.setMonth(1);
		monthlyData.setOutstanding(a);
		monthlyData.setPayment(a / (Math.pow(1+ir,p)-1) / (ir*Math.pow(1+ir,p)));
		monthlyData.setInterest(a*(ir/365)*30);
		monthlyData.setCapital(monthlyData.getPayment()-monthlyData.getInterest());
		
		List<MonthlyData> normalData = new ArrayList<MonthlyData>();
		
		normalData.add(monthlyData);
		
		for(int i=2; i<=p; i++) {
			
			monthlyData.setMonth(i);
			monthlyData.setOutstanding(normalData.get(i-1).getOutstanding()-normalData.get(i-1).getCapital());
			//payment-et nem kell átállítani, mert az nem változik annuitásos hitel esetén
			monthlyData.setInterest(normalData.get(i-1).getOutstanding()*(ir/365)*30);
			monthlyData.setCapital(monthlyData.getPayment()-monthlyData.getInterest());
			
			normalData.add(monthlyData);
			
		}
		
		Calculation result = new Calculation();
		
		result.setAmount(a);
		result.setPeriods(p);
		result.setInterestRate(ir);
		result.setNormalData(normalData);
		
		return result;
		
	}
	
}