
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
    public void testAdd(){
        //Given
        given(calcService.add(10.0,20.0)).willReturn(30.0);

        //when
        double result =calcService.add(10.0,20.0);

        //then
        Assert.assertEquals(result,30.0,0);
    }
}
