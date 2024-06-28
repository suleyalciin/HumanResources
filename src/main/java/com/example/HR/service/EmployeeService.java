
// 1. Yeni Çalışan Alımı:


package com.example.HR.service; // com.example.HR.Service: Bu kod parçasının hangi paketin içinde olduğunu belirtir. Bu durumda, kod HR adında bir paketin Service alt paketinde yer alır.


import com.example.HR.Repository.EmployeeRepository; // com.example.HR.Repository.EmployeeRepository: Bu satır, EmployeeRepository adında bir arayüzü içeren HR paketinden bir alt paketi (Repository) kütüphanesine erişim sağlar. Bu arayüz, çalışan bilgilerini veritabanında saklamak ve almak için kullanılan metotları tanımlar.
import com.example.HR.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired // @Autowired: Bu anotasyon, employeeRepository adında bir nesnenin otomatik olarak oluşturulmasını ve bu sınıfa enjekte edilmesini sağlar. Bu nesne, çalışan bilgilerini veritabanında saklamak ve almak için kullanılır.
    // Spring bu alanı otomatik olarak inject eder
    private EmployeeRepository employeeRepository;

    public Employee hireEmployee(Employee employee) { // hireEmployee(Employee employee) yöntemi, verilen employee bilgilerini kullanarak yeni bir çalışan kaydı oluşturur.
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() { // getAllEmployees() yöntemi, veritabanındaki tüm çalışanların bir listesini getirir.
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        // getEmployeeById(Long id) yöntemi, belirli bir ID'ye (id) sahip olan çalışanı arar ve bulursa bilgilerini geri döndürür.
        return employeeRepository.findById(id);
    }


    public Employee updateEmployee(Long id, Employee employeeDetails) { // updateEmployee(Long id, Employee employeeDetails) yöntemi, verilen id ve employeeDetails'deki yeni bilgiler ile mevcut bir çalışanın bilgilerini günceller.
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        return employeeRepository.save(employee);
    }
    public void fireEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }
}



