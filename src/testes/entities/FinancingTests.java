package testes.entities;
// <ação> should <when>

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.Factory.FinancingFactory;

public class FinancingTests {
	
	@Test
	public void newFinancingWhenDatasIsValid() { 
		
		Financing financing = FinancingFactory.createFinancing(100000.0, 2000.0, 80); 
		
		Assertions.assertNotNull(financing);
		
	}
	
	@Test
	public void throwExceptionWhenNewFinancingIsNotValid()	{
			
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			Financing financing = new Financing(100000.0, 2000.0, 20);
		});
		
	}
	
	@Test
	public void setTotalAmountWhenDatasIsValid() {
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer mouth = 80;
		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, mouth);
		Double newAmount = 80000.0;
		financing.setTotalAmount(newAmount);
		Assertions.assertEquals(newAmount, financing.getTotalAmount());			
		
	}
	
	@Test
	public void throwExceptionWhenSetTotalAmountNotValid() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			Double totalAmount = 100000.0;
			Double income = 2000.0;
			Integer mouth = 80;
			
			Financing financing = FinancingFactory.createFinancing(totalAmount, income, mouth);
			Double newAmount = 200000.0;
			financing.setTotalAmount(newAmount);
		});
		
	}
	
	@Test
	public void setIncomeWhenDatasIsValid() {
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 90;
		Double expected = 30000.0;		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		financing.setIncome(expected);
		Assertions.assertEquals(expected, financing.getIncome());
		
	}
	
	@Test
	public void throwExceptionWhenSetIncomeNotValid() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Double totalAmount = 100000.0;
			Double income = 1000.0;
			Integer months = 90;
			Double expected = 30000.0;		
			Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
			financing.setIncome(expected);
			Assertions.assertEquals(expected, financing.getIncome());
		});
		
		
	}
	
	@Test
	public void setMonthsWhenDatasIsValid() {
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 90;
		Double expected = 20000.0;		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);		
		Assertions.assertEquals(expected, financing.entry());
				
	}
	
	@Test
	public void throwExceptionWhenSetMonthNotValid() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Double totalAmount = 100000.0;
			Double income = 2000.0;
			Integer months = 2;
			Double expected = 20000.0;		
			Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);		
			Assertions.assertEquals(expected, financing.entry());
		});
		
	}
	
	@Test
	public void calculeteEntryWhenDataIsRight() {
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Double expected = 20000.0;		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		Assertions.assertEquals(expected, financing.entry());
		
		
	}
	
	@Test 
	public void calculeteQuotaWhenDataIsRight() {
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 80;
		Double expected = 1000.0;
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		Assertions.assertEquals(expected, financing.quota());
		
		
	}

}
