package net.stanleymburu.employeemanagementbackend.repository;
import net.stanleymburu.employeemanagementbackend.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<employee, Long> {


}