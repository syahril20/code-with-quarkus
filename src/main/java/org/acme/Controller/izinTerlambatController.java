package org.acme.Controller;

import io.vertx.core.json.JsonObject;
import org.acme.Model.izinTerlambatModel;
import org.acme.Model.historyIzinModel;
import org.acme.Model.jamKerjaModel;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Path("/izin")
public class izinTerlambatController {

    LocalTime currentTime = LocalTime.now();
    LocalTime jamMasuk = LocalTime.of(3, 00, 00);

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

    public Connection connection = null;
    public izinTerlambatController() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kawah", "postgres", "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{id}")
    public Response izin(@PathParam("id")int id) {
        List<historyIzinModel> izinModels = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select izin_terlambat.tanggal, izin_terlambat.nama_pengajuan \n" +
                    "from absensi.izin_terlambat where employee_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                historyIzinModel izinTelat = new historyIzinModel();
                izinTelat.tanggal = resultSet.getString("tanggal");
                izinTelat.nama_pengajuan = resultSet.getString("nama_pengajuan");
                izinModels.add(izinTelat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.ok().entity(izinModels).build();
    }
}
