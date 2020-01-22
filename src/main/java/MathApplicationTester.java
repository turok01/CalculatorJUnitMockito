
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
import static org.mockito.Mockito.spy;

//@runWith attaches a runner with the test class to initialize the test data
//To process annotations, we can use the built-in runner MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    private MathApplication mathApplication;
    private CalculatorService calcService;
    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        Calculator calculator = new Calculator();
        calcService = spy(calculator);
        mathApplication.setCalculatorService(calcService);
    }
    @Test
    public void testAdd(){
        //perform operation on real object
        // test the add functionality
        // assert that calcService.add(10,20) Equals 30
        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);
    }
    class Calculator implements CalculatorService{
        @Override
        public double add(double input1, double input2){
            return input1 + input2;
        }
        @Override
        public double subtract(double input1, double input2){
            throw new UnsupportedOperationException("Method not implemented yet!");
        }
        @Override
        public double multiply(double input1, double input2){
            throw new UnsupportedOperationException("Method not implemented yet!");
        }
        @Override
        public double divide(double input1, double input2){
            throw new UnsupportedOperationException("Method not implemented yet!");
        }
    }
}
