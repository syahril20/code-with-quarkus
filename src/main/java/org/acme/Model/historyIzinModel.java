package org.acme.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.acme.Controller.izinTerlambatController;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Izin_Terlambat", schema = "absensi")
public class historyIzinModel extends PanacheEntityBase {

    @Id
    @Column(name = "employee_id")
    private int employee_id = 1;

    @Column(name = "tanggal")
    public String tanggal = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    @Column(name = "nama_pengajuan")
    public String nama_pengajuan;


}

