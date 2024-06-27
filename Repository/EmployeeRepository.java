package com.example.HR.Repository;

import com.example.HR.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Bu anotasyon, bu sınıfın bir Spring veritabanı deposu olduğunu belirtir
public interface EmployeeRepository extends JpaRepository <Employee,Long> {
}


// JPA ---> CRUD işlemleri için gerekli metodları sağlar
// CRUD İşlemleri:Create,Read,Delete