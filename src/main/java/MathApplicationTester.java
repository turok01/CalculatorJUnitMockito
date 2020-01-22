
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;



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
        //add the behavior to add number
        when(calcService.add(20.0,10.0)).thenReturn(30.0);

        //add the behavior to subtract number
        when(calcService.subtract(20.0,10.0)).thenReturn(30.0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(20.0,10.0),30.0,0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(20.0,10.0),30.0,0);

        //verify call to add method to be completed within 100ms
        verify(calcService,timeout(100)).add(20.0,10.0);

        //invocation count can be added to ensure multiplication invocations
        //can be checked within given timeframe
        verify(calcService,timeout(100).times(1)).subtract(20.0,10.0);


    }
}
