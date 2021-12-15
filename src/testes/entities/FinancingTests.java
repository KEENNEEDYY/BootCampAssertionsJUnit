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
		Assertions.assertEquals(100000.0, financing.getTotalAmount());
		Assertions.assertEquals(2000.0, financing.getIncome());
		Assertions.assertEquals(80, financing.getMonths());
		
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
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer mouth = 80;
		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, mouth);
		Double newAmount = 200000.0;
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
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
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 90;
		Double invalidIncome = 1000.0;		
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			financing.setIncome(invalidIncome);
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
		
		Double totalAmount = 100000.0;
		Double income = 2000.0;
		Integer months = 90;
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
		Integer invalidMonth = 2;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {		
			financing.setMonths(invalidMonth);
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
