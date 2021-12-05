package by.oleg.service.controller;

import by.oleg.service.domain.Operation;
import by.oleg.service.service.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/addition")
public class AdditionController {

    private AdditionService additionService;

    @Autowired
    public AdditionController(AdditionService additionService) {
        this.additionService = additionService;
    }

    @GetMapping("/{argFirst}/{argSecond}")
    public Operation addition(@PathVariable(value = "argFirst") double argFirst,
                              @PathVariable(value = "argSecond") double argSecond) {
        return additionService.getAdditionOperation(argFirst, argSecond);
    }
}
