package demoparams.controller;

import demoparams.DTO.EmployeeDTO;
import demoparams.model.Employee;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadosController {

    @GetMapping({"/employee/{name}/{lastname}"})
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastname){
        Employee employee = new Employee(name, lastname);

        byte[] a = {0011,1,0,0,0,0,1,0};
        String b = "";

        return employee;
    }

    @GetMapping("/employee")
    public Employee findEmployee(@RequestParam String name, @RequestParam String lastname) {
        Employee employee = new Employee(name,lastname);
        return employee;
    }

    /* @PostMapping("/crear")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setName("Tincho");
        return employee;
    }*/

    @PostMapping("/crear")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
        employee.setMessage("El empleado fue creado exitosamente");
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
}
