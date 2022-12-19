package api.service;

import api.dto.request.EmployeeRequestDTO;
import api.dto.request.ProductRequestDTO;
import api.dto.response.ResponseDTO;
import api.entity.Employee;
import api.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

import api.entity.Product;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository iEmployeeRepository;

    public EmployeeService(IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
    }


    public List<Employee> getEmployees() {
        List<Employee> list = iEmployeeRepository.findAll();
        return list;
    }


    @Override
    public ResponseDTO create(EmployeeRequestDTO request) {

        Employee employee = new Employee();

        employee.setAge(request.getAge());
        employee.setName(request.getName());
        employee.setLastName(request.getLastName());
        employee.setCity(request.getCity());
        employee.setDepartment(request.getDepartment());


        iEmployeeRepository.save(employee);

        return new ResponseDTO("Employee saved", 200);
    }

    @Override
    public ResponseDTO update(String id, EmployeeRequestDTO request) {

        Employee employee = iEmployeeRepository.findById(id).orElse(null);

        employee.setAge(request.getAge());
        employee.setName(request.getName());
        employee.setLastName(request.getLastName());
        employee.setCity(request.getCity());
        employee.setDepartment(request.getDepartment());


        iEmployeeRepository.save(employee);

        return new ResponseDTO("Employee updated", 200);
    }
}
