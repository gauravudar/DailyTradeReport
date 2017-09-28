package test.java.com.jpmorgan;

import org.joda.time.LocalDate;

import main.java.com.jpmorgan.BusinessDateProvider;
import junit.framework.TestCase;

public class BusinessDateProviderTest extends TestCase{
   private BusinessDateProvider businessDateProvider;
   
   public void setUp() throws Exception {
		super.setUp();
		businessDateProvider = new BusinessDateProvider();
   }
   
   public void testValidateBusinessDateForWeekendAED() throws Exception{
	   LocalDate result = businessDateProvider.validateBusinessDateForWeekend("AED", new LocalDate(2017,9,30));
	   assertEquals(result.toString(),new LocalDate(2017,10,1).toString());
   }
   
   public void testValidateBusinessDateForWeekendUSD() throws Exception{
	   LocalDate result = businessDateProvider.validateBusinessDateForWeekend("USD", new LocalDate(2017,9,30));
	   assertEquals(result.toString(),new LocalDate(2017,10,2).toString());
   }
}
