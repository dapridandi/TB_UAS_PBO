import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.*;
import java.util.HashMap;

//class DataPelanggan merupakan implementasi dari class pelanggan
public class DataPelanggan implements Pelanggan {
    // deklarasi variabel
    static Connection con;
    String url = "jdbc:mysql://localhost:3306/hotel";
    String nama;
    int noPelanggan;
    String alamat;
    int nojenisKelamin;
    String jenisKelamin;
    int noKamar;
    String jeniskamar;
    int umur;
    int biaya;
    int noJenisPelanggan;
    String jenisPelanggan;
    double totalBiaya;
    int bayar;
    double kembalian;

    // constructor kosong
    public DataPelanggan() {

    }

    // membuat objek baru dengan nama input
    Scanner input = new Scanner(System.in);

    // override method dari interface
    // method tampil dari class pelanggan
    @Override
    public void tampil() throws SQLException {

    }

    // method tambah dari class pelanggan
    @Override
    public void tambah() throws SQLException {
        System.out.println("==INPUT DATA PELANGGAN");
        // exception
        try {
            // menginputkan nama pelanggan
            System.out.println("Inputkan Nama : ");
            this.nama = input.nextLine();

            // no pelanggan
            int fail = 0;
            // berikut adalah block program untuk exception
            do {
                try {
                    System.out.println("Inputkan no Pelanggan : ");
                    this.noPelanggan = input.nextInt();// inputan user
                    input.nextLine();
                    if (this.noPelanggan < 1) {// jika inputan < 1, maka akan muncul pesan dibawah
                        System.out.println("Mohon Inputkan angka dengan baik dan benar");
                    }
                } catch (Exception e) {
                    fail += 1;
                    if (fail > 2) {// jika fail > 2, maka akan muncul pesan berikut
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {// kemudian else akan muncul pesan dibawah
                        System.out.println("Mohon inputkan angka");
                    }
                    input.nextLine();
                }
            } while (this.noPelanggan < 1); // perulangan akan terus dilakukan selama noPelanggan < 1

            // untuk menginputkan alamat
            System.out.println("Inputkan Alamat : ");
            this.alamat = input.nextLine();

            // jenis kelamin
            // exception
            do {
                try {
                    // MENGGUNAKAN COLLECTION HASHMAP
                    HashMap<String, String> daftargender = new HashMap<String, String>();// membuat objek HashMap dengan
                                                                                         // nama daftargender
                    daftargender.put("1", "PRIA");
                    daftargender.put("2", "WANITA");
                    System.out.println(daftargender);
                    System.out.println("Inputkan Jenis Kelamin  : ");
                    this.nojenisKelamin = input.nextInt();// inputan user berupa angka
                    input.nextLine();
                    if (this.nojenisKelamin < 1 || this.nojenisKelamin > 2)// jika inputan < 1 dan > 2 maka akan muncul
                                                                           // pesan seperti dibawah
                    {
                        System.out.println("Inputan harus angka 1 atau 2");
                    }
                } catch (Exception e) {
                    fail += 1;
                    if (fail > 2) {// jika fail > 2, maka muncul pesan
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                        System.out.println("Mohon Inputkan inputan berupa angka!");
                    }
                    input.nextLine();
                }

            } while (this.nojenisKelamin < 1 || this.nojenisKelamin > 2); // perulangan akan terus dilakukan jika
                                                                          // inputan < dan > 2
            if (this.nojenisKelamin == 1) {// jika inputan = 1, maka jenisKelamin diisi dengan Pria
                this.jenisKelamin = "Pria";
            } else if (this.nojenisKelamin == 2) {// else if inputan = 2 akan diisi dengan Wanita
                this.jenisKelamin = "Wanita";
            }

            // untuk jenis kamar
            // COLLECTION HASHMAP
            HashMap<String, String> daftarkamar = new HashMap<String, String>();// membuat objek baru dg nama daftar
                                                                                // kamar
            // terdapat 5 jenis daftar periksa spt berikut
            daftarkamar.put("1", "Standard");
            daftarkamar.put("2", "Superior");
            daftarkamar.put("3", "Deluxe");
            daftarkamar.put("4", "Suite");
            daftarkamar.put("5", "Presidential");
            System.out.println(daftarkamar);
            // exception
            do {
                try {
                    System.out.println("Inputkan Jenis Kamar : ");
                    this.noKamar = input.nextInt();// inputan user
                    input.nextLine();
                    if (this.noKamar < 1 || this.noKamar > 5)// jika inputan < 1 dan > 5 maka akan
                                                             // muncul pesan spt dibawah
                    {
                        System.out.println("Inputan harus angka 1-5");
                    }
                } catch (Exception e) {
                    fail += 1;
                    if (fail > 2) {
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                        System.out.println("Mohon Inputkan inputan berupa angka!");
                    }
                    input.nextLine();
                }
            } while (this.noKamar < 1 || this.noKamar > 5); // perulangan akan terus dilakukan
                                                            // jika inputan bernilai <1 dan > 5
            if (this.noKamar == 1) {// jika yang diinputkan angka 1, maka jenis kamarnya standard
                this.jeniskamar = "Standard";
            } else if (this.noKamar == 2) {
                this.jeniskamar = "Superior";
            } else if (noKamar == 3) {
                this.jeniskamar = "Deluxe";
            } else if (noKamar == 4) {
                this.jeniskamar = "Suite";
            } else if (noKamar == 5) {
                this.jeniskamar = "Presidential";
            }

            // untukumur
            // exception
            do {
                try {
                    System.out.println("Inputkan Umur : ");
                    this.umur = input.nextInt();
                    input.nextLine();
                    if (this.umur < 0) {// jika umur < 0, maka akan ditampilkan pesan
                        System.out.println("Mohon Inputkan angka dengan baik dan benar");
                    }
                } catch (Exception e) {
                    fail += 1;
                    if (fail > 2) {// jika inoutan > 2, maka akan muncul pesan berikut
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {// jika tidak ada angka yang diinputkan maka akan ditampilkan pesan
                        System.out.println("Mohon inputkan angka");
                    }
                    input.nextLine();
                }
            } while (this.umur < 1); // perulangan akan terus dilakukan jika inputan umur < 1

            // untuk jenis pelanggan
            // exception
            do {
                try {
                    // COLLECTION HASHMAP
                    HashMap<String, String> daftarjenispelanggan = new HashMap<String, String>();// membuat objek baru
                                                                                                 // dg
                                                                                                 // nama
                                                                                                 // daftarjenispelanggan
                    // terdapat 3 pilihan
                    daftarjenispelanggan.put("1", "ORDINARY");
                    daftarjenispelanggan.put("2", "VIP");
                    daftarjenispelanggan.put("3", "MEMBER");
                    System.out.println(daftarjenispelanggan);

                    System.out.println("Inputkan Jenis Pelanggan : ");
                    this.noJenisPelanggan = input.nextInt();// inputan user
                    input.nextLine();
                    if (this.noJenisPelanggan < 1 || this.noJenisPelanggan > 3)// jika inputan bernilai <1 dan >3 maka
                                                                               // akan
                    // ditampilkan pesan
                    {
                        System.out.println("Inputan harus angka 1 -3 ");
                    }
                } catch (Exception e) {
                    fail += 1;
                    // percabangan if untuk pengecekan apakah data yg diinputkan benar
                    if (fail > 2) {
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                        System.out.println("Mohon Inputkan inputan berupa angka!");
                    }
                    input.nextLine();
                }
            } while (this.noJenisPelanggan < 1 || this.noJenisPelanggan > 3); // perulangan akan terus dilakukan jika
                                                                              // inputan
            // bernilai <1 dan >3
            // percabangan if
            if (this.noJenisPelanggan == 1) {
                this.jenisPelanggan = "ORDINARY";
            } else if (this.noJenisPelanggan == 2) {
                this.jenisPelanggan = "VIP";
            } else if (this.noJenisPelanggan == 3) {
                this.jenisPelanggan = "MEMBER";
            }

            // untuk biaya
            // percabangan switch dg beberapa case
            switch (jeniskamar) {
                case "Standard":
                    this.biaya = 500000;
                    System.out.println("Tagihan : " + this.biaya);
                    break;
                case "Superior":
                    this.biaya = 100000;
                    System.out.println("Tagihan : " + this.biaya);
                    break;
                case "Deluxe":
                    this.biaya = 2500000;
                    System.out.println("Tagihan : " + this.biaya);
                    break;
                case "Suite":
                    this.biaya = 3500000;
                    System.out.println("Tagihan : " + this.biaya);
                    break;
                case "Presidential":
                    this.biaya = 6000000;
                    System.out.println("Tagihan : " + this.biaya);
                    break;
            }

            // tagihan
            // percabangan if else dan proses matematika
            if (noJenisPelanggan == 1) { // untuk ordinary
                this.totalBiaya = 0;
                System.out.println("Total Tagihan : " + this.totalBiaya);
            } else if (noJenisPelanggan == 2) { // untuk vip
                this.totalBiaya = this.biaya;
                System.out.println("Total Tagihan : " + this.totalBiaya);
            } else if (noJenisPelanggan == 3) {// unutk member
                this.totalBiaya = 0.7 * this.biaya; // proses matematika diskon 30 persen (member)
                System.out.println("Total Tagihan : " + this.totalBiaya + "(DISKON 30%)");
            }

            // untuk bayar
            // exception
            do {
                try {
                    System.out.println("Inputkan Bayar : ");
                    bayar = input.nextInt();// inputan user
                    input.nextLine();
                    if (bayar < totalBiaya) {
                        System.out.println("Mohon Inputkan angka dengan baik dan benar");
                    }
                } catch (Exception e) {
                    fail += 1;
                    if (fail > 2) {
                        System.out.println("Mohon perhatikan lagi inputan");
                    } else {
                        System.out.println("Mohon inputkan angka");
                    }
                    input.nextLine();
                }
            } while (bayar < totalBiaya); // perulangan akan terus dilakukan jika bayar<totalBiaya

            // kembalian
            // proses matematika untuk kembalian
            this.kembalian = this.bayar - totalBiaya;
            System.out.println("Kembalian = " + this.kembalian);

            // berikut adalah block program untuk koneksi database
            String sql = "INSERT INTO tagihan_hotel (nama,no_pelanggan,jenis_kelamin,alamat,umur, jenis_pelanggan,jenis_kamar,biaya, tagihan, bayar, kembalian) VALUES ('"
                    + nama + "','" + noPelanggan + "','" + jenisKelamin + "','" + alamat + "','" + umur + "','"
                    + jenisPelanggan + "','" + jeniskamar + "','" + biaya + "','" + totalBiaya + "','" + bayar
                    + "','" + kembalian + "')";
            con = DriverManager.getConnection(url, "root", "");
            Statement statement = con.createStatement();
            statement.execute(sql);
            System.out.println("DATA BERHASIL DIINPUT!");
        } catch (SQLException e) {
            System.err.println("DATA GAGAL DIINPUT");
            System.err.println(e.getMessage());

        } catch (InputMismatchException e) {
            System.err.println("Inputan harus berupa angka");

        }
    }

    // method ubah dari class pelanggan     
    @Override
    public void ubah() throws SQLException {

    }

    // method hapus dari class pelanggan
    @Override
    public void hapus() throws SQLException {

    }

    // method cari dari class pelanggan
    @Override
    public void cari() throws SQLException {

    }

}