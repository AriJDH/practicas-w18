package api.controller;

import api.dto.request.EmployeeRequestDTO;
import api.dto.request.ProductRequestDTO;
import api.dto.response.ResponseDTO;
import api.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private IEmployeeService iEmployeeService;

    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }


    @GetMapping("")
    public ResponseEntity<?> getEmployees() {
        return new ResponseEntity<>(iEmployeeService.getEmployees(), HttpStatus.OK);
    }
    

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody EmployeeRequestDTO request) {
        return new ResponseEntity<>(iEmployeeService.create(request), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable String id, @RequestBody EmployeeRequestDTO request) {
        return new ResponseEntity<>(iEmployeeService.update(id,request), HttpStatus.OK);
    }
}
