package org.acme.Controller;

import io.vertx.core.json.JsonObject;
import org.acme.Model.historyIzinModel;
import org.acme.Model.izinTerlambatModel;

import org.acme.Model.jamKerjaModel;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Path("/izin")
public class izinTerlambatController {

    LocalTime currentTime = LocalTime.now();
    LocalTime jamMasuk = LocalTime.of(03, 00, 00);

    @POST
    @Transactional
    public Object list(JsonObject payload) {
        izinTerlambatModel telat = new izinTerlambatModel();
        String accepted = "Okee Bisa Cuk";
        String rejected = "Telat Cuk";
        telat.nama_pengajuan = payload.getString("nama_pengajuan");
        telat.alasan = payload.getString("alasan");
        if (jamMasuk.plusMinutes(60).compareTo(currentTime) >= 0){
            telat.persist();
            return accepted;
        }else {
            return rejected;
        }
    }

    public Connection conn = null;
    public izinTerlambatController() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawah", "postgres", "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @GET
    @Path("/{izin_id}")
    public Response izin(@PathParam("izin_id")int izin_id) {
        List<historyIzinModel> izinModels = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select izin_terlambat.tanggal, izin_terlambat.nama_pengajuan \n" +
                    "from absensi.izin_terlambat where employee_id = ?");
            preparedStatement.setInt(1, izin_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                historyIzinModel izinTelat = new historyIzinModel();
                izinTelat.tanggal = LocalDate.parse(resultSet.getString("tanggal"));
                izinTelat.nama_pengajuan = resultSet.getString("nama_pengajuan");
                izinModels.add(izinTelat);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return Response.ok().entity(izinModels).build();
    }
}
