package Spring.hw2_6.Controller;

import Spring.hw2_6.Service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeController(){
    }
}
