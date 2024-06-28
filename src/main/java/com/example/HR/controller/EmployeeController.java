package com.example.HR.controller;

import com.example.HR.service.EmployeeService;
import com.example.HR.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Bu anotasyon, bu sınıfın bir control sınıfı/RESTful web servisi olduğunu belirtir.
@RequestMapping("/api/employees") // Temel URL'ini belirtir.
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/hire") // Bu anotasyon ile işaretlenen bu metot, bir çalışanı işe almak için kullanılır.
    @Operation(summary="yeni personel kayıdı yapar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personel başarıyla kaydedildi"),
            @ApiResponse(responseCode = "400", description = "Hatalı istek")
    })
    public Employee hireEmployee(@RequestBody Employee employee) {
        return employeeService.hireEmployee(employee);


    }

    @GetMapping /* Çalışanları getirmek için service sınfımızdan oluşturduğumuz "getAllEmployees"
     metotu çağırarak döndürüyoruz.*/
    @Operation(summary="tüm personelleri getirip,listeler")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    @Operation(summary="belirli bir personeli ID numarasında göre getirir")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return  employeeService.getEmployeeById(id);
    }


    @PutMapping("/{id}") /* Belitilen kimlikteki çalışan bilgilerini bu metot
    ile update/güncelliyoruz.*/
    @Operation(summary="bir personelin bilgilerini günceller")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/fire/{id}")
    @Operation(summary="bir personeli siler")
    public void fireEmployees(@PathVariable Long id) {
        employeeService.fireEmployee(id);
    }
}


// Config ---> Configuration --> ayarlamak



