package by.oleg.service.domain;


import by.oleg.service.enumeration.OperationName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operation {

    private OperationName operationName;
    private double argFirst;
    private double argSecond;
    private double result;
}
