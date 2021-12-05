package by.oleg.service.controller;

import by.oleg.service.domain.Operation;
import by.oleg.service.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/division")
public class DivisionController {

    private DivisionService divisionService;

    @Autowired
    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping("/{argFirst}/{argSecond}")
    public Operation division(@PathVariable(value = "argFirst") double argFirst,
                              @PathVariable(value = "argSecond") double argSecond) {
        return divisionService.getDivisionOperation(argFirst, argSecond);
    }
}
