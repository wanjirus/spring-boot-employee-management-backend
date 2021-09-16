package net.stanleymburu.employeemanagementbackend.model;
import lombok.Data;
import net.stanleymburu.employeemanagementbackend.Audit.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="employees")
public class Employee extends Auditable {


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    public Employee(){

    }
}
