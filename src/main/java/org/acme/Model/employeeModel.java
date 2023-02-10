package org.acme.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.inject.Inject;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee", schema = "absensi")
public class employeeModel extends PanacheEntityBase {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "employee_id")
    private int employee_id;

    @Column(name = "nama")
    private String nama;


}