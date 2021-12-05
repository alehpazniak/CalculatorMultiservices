package by.oleg.service.service;

import by.oleg.service.calculator.engine.CalculatorEngine;
import by.oleg.service.service.DivisionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DivisionServiceTest {

    @Autowired
    DivisionService service;

    @MockBean
    CalculatorEngine calculatorEngine;

    @Test
    void shouldGetDivisionOperationFromCache() {

        double argFirst = 1.0;
        double argSecond = 2.0;
        when(calculatorEngine.div(argFirst, argSecond))
                .thenReturn(argFirst / argSecond);
        var firstOp = service.getDivisionOperation(argFirst, argSecond);
        var secondOp = service.getDivisionOperation(argFirst, argSecond);

        Mockito.verify(calculatorEngine, times(1)).div(argFirst, argSecond);

        Assertions.assertSame(firstOp, secondOp);
    }
}