package api.service;

import api.dto.request.EmployeeRequestDTO;
import api.dto.response.ResponseDTO;
import api.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployees();

    ResponseDTO create(EmployeeRequestDTO request);

    ResponseDTO update(String id, EmployeeRequestDTO request);
}
