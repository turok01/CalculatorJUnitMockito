
import org.junit.Assert;
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

//@runWith attaches a runner with the test class to initialize the test data
//To process annotations, we can use the built-in runner MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd(){
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //add the behavior of calc service to subtract two numbers
        when(calcService.subtract(20.0,10.0)).thenReturn(10.00);

        //add the behavior of calc service to divide two numbers
        when(calcService.divide(20.0,10.0)).thenReturn(2.00);



        //test the add functionality
        // assert that calcService.add(10,20) Equals 30
        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);
        //Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);
        //Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(20.0,10.0),10.0,0);

        //default call count is 1
        verify(calcService).subtract(20.0,10.0);

        //check if add function is called three times
        //verify(calcService,times(3)).add(10.0,20.0);

        //verify that method was never called on a mock
        verify(calcService,never()).multiply(10.0,20.0);

        //add the behavior to throw exception
        //doThrow(new RuntimeException("divide operation not implemented")).when(calcService).divide(20.0,10.0);

        //test the divide functionality
        Assert.assertEquals(mathApplication.divide(20.0,10.0),2.0,0);

        //create an Inorder verifier for a single mock
        InOrder orderVerifier = inOrder(calcService);

        //orderVerifier.verify(calcService).add(10.0,20.0);
        orderVerifier.verify(calcService).add(10.0,20.0);
        //orderVerifier.verify(calcService).add(10.0,20.0);
        orderVerifier.verify(calcService).subtract(20.0,10.0);
        orderVerifier.verify(calcService).divide(20.0,10.0);




    }
}
