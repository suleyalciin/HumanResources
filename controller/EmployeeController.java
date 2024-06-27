package com.example.HR.controller;

import com.example.HR.Service.EmployeeService;
import com.example.HR.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

public class EmployeeController {

    @RestController
    @RequestMapping("/api/employees") // Bu anotasyon, bu kontrolör sınıfının hangi URL ile erişilebilir olacağını belirtir.
    // Bu durumda, /api/employees adresi ile bu servise erişilebilir

    public class employeeController {

        @Autowired // Bu anotasyon, employeeService adında bir nesnenin otomatik olarak oluşturulmasını ve bu sınıfa enjekte edilmesini sağlar.


        private EmployeeService employeeService;

        @PostMapping("/hire") // Bu metot, HTTP POST isteği ile /api/employees/hire adresine gönderilen veriyi kullanarak yeni bir çalışan kaydı oluşturur.

        public Employee hireEmployee(@RequestBody Employee employee) {
            return employeeService.hireEmployee(employee);
        }

        @GetMapping // Bu metot, HTTP GET isteği ile /api/employees adresine yapılacak tüm istekleri karşılar.



        public List<Employee> getAllEmployees() {
            return employeeService.getAllEmployees();
        }

        @GetMapping("/{id}") // @GetMapping("/{id}"): Bu metot, HTTP GET isteği ile /api/employees/{id} adresine gönderilen id değerini kullanarak belirli bir çalışanın bilgilerini getirir.
        public Optional<Employee> getEmployeeById(@PathVariable Long id) {
            return employeeService.getEmployeeById(id);
        }

        @PutMapping("/{id}")
        public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
            return employeeService.updateEmployee(id, employeeDetails);
        }

        @DeleteMapping("/fire/{id}")
        public void fireEmployee(@PathVariable Long id) {
            employeeService.fireEmployee(id);
        }
    }}










