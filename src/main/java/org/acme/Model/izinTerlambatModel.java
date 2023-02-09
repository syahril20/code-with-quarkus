package org.acme.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.inject.Inject;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Izin_Terlambat", schema = "absensi")
public class izinTerlambatModel extends PanacheEntityBase {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column(name = "izin_id")
    private int izin_id;

    @Column(name = "employee_id")
    private int employee_id = 1;

    @Column(name = "nama_pengajuan")
    public String nama_pengajuan;

    @Column(name = "tanggal")
    public LocalDate tanggal = LocalDate.now();

    @Column(name = "alasan")
    public String alasan;

    @Column(name = "created_by")
    private int created_by = employee_id;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updated_at = LocalDateTime.now();

    @Column(name = "updated_by")
    private int updated_by = employee_id;

    @Column(name = "status")
    private int status = 1;



}

