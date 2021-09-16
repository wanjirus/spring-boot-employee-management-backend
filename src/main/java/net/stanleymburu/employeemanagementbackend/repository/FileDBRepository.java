package net.stanleymburu.employeemanagementbackend.repository;

import net.stanleymburu.employeemanagementbackend.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
