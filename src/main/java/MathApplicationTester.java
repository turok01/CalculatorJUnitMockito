
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

//@runWith attaches a runner with the test class to initialize the test data
//To process annotations, we can use the built-in runner MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    private MathApplication mathApplication;
    private CalculatorService calcService;
    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }
    @Test
    public void testAddAndSubtract(){
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //add the behavior of calc service to subtract two numbers
        when(calcService.subtract(20.0,10.0)).thenReturn(10.00);

        //test the add functionality
        // assert that calcService.add(10,20) Equals 30
        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(20.0,10.0),10.0,0);

        //default call count is 1
        verify(calcService).add(10.0,20.0);
        verify(calcService).subtract(20.0,10.0);
    }
}
