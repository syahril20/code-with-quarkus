package org.acme.Model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;


public class historyIzinModel extends PanacheEntityBase {

    @Column (name = "tanggal")
    public LocalDate tanggal;

    @Column (name = "nama_pengajuan")
    public String nama_pengajuan;
}

