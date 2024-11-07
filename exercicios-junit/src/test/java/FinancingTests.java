import org.junit.Assert;
import org.junit.Test;
import entities.Financing;

public class FinancingTests {
    @Test
    public void validateInputsInConstructor() {
        Double totalAmount = 100000.00;
        Double income = 2000.00;
        Integer months = 80;
        Financing financing = new Financing(totalAmount,income,months);

        Assert.assertEquals(totalAmount, financing.getTotalAmount());
        Assert.assertEquals(income, financing.getIncome());
        Assert.assertEquals(months, financing.getMonths());
    }

    @Test
    public void throwExceptionWhenInputsAreNotValids()
    {
        Assert.assertThrows(IllegalArgumentException.class,     
            ()->{
                new Financing(100000.00, 2000.00, 20);
            });

    }

    @Test
    public void shouldUpdateValueTotalAmountWhenTheValueIsValid(){
        Double totalAmount = 100000.00;
        Double income = 2000.00;
        Integer months = 80;
        Financing financing = new Financing(totalAmount,income,months);
        financing.setTotalAmount(90000.00);
        Assert.assertTrue(financing.getTotalAmount() == 90000.00);
    }
    @Test
    public void shouldThrowExceptionWhenTotalAmountValueIsNotValid(){
        Assert.assertThrows(IllegalArgumentException.class,
        () -> new Financing(100000.00, 2000.00, 20));
    }

    @Test
    public void shouldUpdateIncomeValueWhenTheValueIsValid(){
        Double totalAmount = 100000.00;
        Double income = 2000.00;
        Integer months = 80;
        Financing financing = new Financing(totalAmount,income,months);
        financing.setIncome(2500.00);
        Assert.assertTrue(financing.getIncome() == 2500.00);
    }

    @Test 
    public void shouldThrowExceptionWhenIncomeValueIsNotValid(){    
        Assert.assertThrows(IllegalArgumentException.class,
        () -> new Financing(100000.00, 1000.00, 20));
    }

    @Test 
    public void shouldUpdateMonthsWhenValueIsValid(){
        Double totalAmount = 100000.00;
        Double income = 2000.00;
        Integer months = 80;
        Financing financing = new Financing(totalAmount,income,months);
        financing.setMonths(90);
        Assert.assertTrue(financing.getMonths() == 90);
    }

    @Test
    public void shouldThrowExceptionWhenMonthsValueIsNotValid(){
        Assert.assertThrows(IllegalArgumentException.class,
        () -> new Financing(100000.00, 1000.00, 20));
    }

    @Test
    public void shouldCalculateTheValueOfEntry(){
        Double totalAmount = 100000.00;
        Double income = 2000.00;
        Integer months = 80;
        Financing financing = new Financing(totalAmount,income,months);
        Assert.assertTrue(financing.entry() == 0.2*totalAmount);
    }

    @Test
    public void ShouldCalculateTheOfParcel(){
        Double totalAmount = 100000.00;
        Double income = 2000.00;
        Integer months = 80;
        Financing financing = new Financing(totalAmount,income,months);
        Assert.assertTrue(financing.quota() == (totalAmount - financing.entry()) / months);
    }
}