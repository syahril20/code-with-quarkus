package org.acme.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "jam_kerja", schema = "absensi")
public class jamKerjaModel extends PanacheEntityBase {

    @Id
    @Column (name = "id_jam")
    private int id_jam;

    @Column (name = "jam_masuk")
    private LocalTime jam_masuk;

    @Column (name = "jam_keluar")
    private LocalTime jam_keluar;

}