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
    @Column(name = "izin_id")
    private int izin_id;

    @Column(name = "name")
    private String name;


}