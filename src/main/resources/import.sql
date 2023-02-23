drop table absensi.employee;
CREATE TABLE absensi.employee (
	employee_id serial4 NOT NULL,
	nama varchar(255) NOT NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (employee_id)
);

DROP TABLE absensi.izin_terlambat;
CREATE TABLE absensi.izin_terlambat (
	izin_id serial4 NOT NULL,
	employee_id int4 NOT NULL,
	nama_pengajuan varchar NOT NULL,
	tanggal date NOT NULL,
	alasan varchar NOT NULL,
	created_by int4 NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	updated_by int4 NOT NULL,
	status int4 NOT NULL,
	CONSTRAINT izin_terlambat_pkey PRIMARY KEY (izin_id),
	CONSTRAINT izin_terlambat_fk FOREIGN KEY (employee_id) REFERENCES absensi.employee(employee_id)
);


INSERT INTO absensi.employee (employee_id, nama) VALUES(1, 'Jajang');
INSERT INTO absensi.employee (employee_id, nama) VALUES(2, 'Kimak');

INSERT INTO absensi.izin_terlambat (izin_id, employee_id,  nama_pengajuan, tanggal, alasan, created_at, created_by,status, updated_at, updated_by) VALUES(1,  1, 'Ambil raport', '2023-02-09', 'Ambil rapot', '2023-02-09 19:49:51.007', 1,1, '2023-02-09 19:49:51.007', 1);
