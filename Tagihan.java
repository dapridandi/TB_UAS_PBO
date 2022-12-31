
import java.util.Scanner;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tagihan extends DataPelanggan {
    // block program untuk koneksi ke database
    static Connection con;
    String url = "jdbc:mysql://localhost:3306/hotel";
    Scanner input = new Scanner(System.in);

    // berikut adalah block program untuk method date
    public void timedate() {
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy || HH:mm:ss");
        String formattedDate = waktu.format(myFormatObj);
        System.out.println("Waktu : " + formattedDate);
    }

    // database
    // method tampil yg di override dri class pelanggan
    @Override
    public void tampil() throws SQLException {
        System.out.println("\n==TAMPILAN INFO PELANGGAN HOTEL==");
        // block program untuk koneksi ke database
        String sql = "SELECT * FROM tagihan_hotel";
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {// dilakukan perulangan while untuk method tampil
            System.out.print("\nNama Pelanggan\t : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nNomor Pelanggan: ");
            System.out.print(result.getInt("no_pelanggan"));
            System.out.print("\nJenis Kelamin\t : ");
            System.out.print(result.getString("jenis_kelamin"));
            System.out.print("\nAlamat\t\t : ");
            System.out.print(result.getString("alamat"));
            System.out.print("\nUmur Pelanggan\t : ");
            System.out.print(result.getInt("umur"));
            System.out.print("\nJenis Pelanggan\t : ");
            System.out.print(result.getString("jenis_pelanggan"));
            System.out.print("\nJenis Kamar: ");
            System.out.print(result.getString("jenis_kamar"));
            System.out.print("\nBiaya\t\t : ");
            System.out.print(result.getInt("biaya"));
            System.out.print("\nTagihan\t\t : ");
            System.out.print(result.getDouble("tagihan"));
            System.out.print("\nBayar\t\t : ");
            System.out.print(result.getInt("bayar"));
            System.out.print("\nKembalian\t : ");
            System.out.print(result.getDouble("kembalian"));
            System.out.print("\n");
        }
    }

    // database
    // method ubah yang di override dri class pelanggan
    @Override
    public void ubah() throws SQLException {
        System.out.println("==UPDATE DATA PELANGGAN==");
        try {
            tampil();// method tampil utk menampilkan data pelanggan
            System.out.print("\nMasukkan Nomor pelanggan yang akan di ubah : ");
            Integer noPelanggan = Integer.parseInt(input.nextLine());

            String sql = "SELECT * FROM tagihan_hotel WHERE no_pelanggan = " + noPelanggan;
            con = DriverManager.getConnection(url, "root", "");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            // percabangan if
            if (result.next()) {

                System.out.print("Nama baru [" + result.getString("nama") + "]\t: ");
                String nama = input.nextLine();

                sql = "UPDATE tagihan_hotel SET nama='" + nama + "' WHERE no_pelanggan='" + noPelanggan + "'";
                // System.out.println(sql);

                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("Berhasil memperbaharui data Pelanggan (" + noPelanggan + ")");
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");// akan muncul pesan jika terjadi exception
            System.err.println(e.getMessage());
        }

    }

    // database
    // method hapus dioverride dri class pelanggan
    @Override
    public void hapus() throws SQLException {
        System.out.println("==HAPUS DATA PELANGGAN==");

        try {
            tampil();
            System.out.print("\nInput No_Pelanggan : ");
            String keyword = input.nextLine();

            String sql = "DELETE FROM tagihan_hotel WHERE no_pelanggan LIKE '%"+keyword+"%'" ;
            con = DriverManager.getConnection(url, "root", "");
            Statement statement = con.createStatement();
            // ResultSet result = statement.executeQuery(sql);

            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Data Pelanggan Sudah Dihapus");
            }
        }
        // muncul pesan jika terjadi SQLexception
        catch (SQLException e) {
            System.out.println("Penghapusan Data Gagal");
        }
        // muncul pesan jika terjadi exception
        catch (Exception e) {
            System.out.println("Input data yang benar!");
        }
    }

    // database
    // method cari dioverride dari class pelanggan
    @Override
    public void cari() throws SQLException {
        System.out.println("==CARI DATA PELANGGAN==");

        System.out.print("Masukkan Nama Pelanggan yang ingin dilihat : ");
        String keyword = input.nextLine();// inputan user

        // block program koneksi database
        String sql = "SELECT * FROM tagihan_hotel WHERE nama LIKE '%" + keyword + "%'";
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {// perulangan while untuk method cari
            System.out.print("\nNama Pelanggan\t : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nNomor Pelanggan: ");
            System.out.print(result.getInt("no_pelanggan"));
            System.out.print("\nJenis Kelamin\t : ");
            System.out.print(result.getString("jenis_kelamin"));
            System.out.print("\nAlamat\t\t : ");
            System.out.print(result.getString("alamat"));
            System.out.print("\nUmur Pelanggan\t : ");
            System.out.print(result.getInt("umur"));
            System.out.print("\nJenis Pelanggan\t : ");
            System.out.print(result.getString("jenis_pelanggan"));
            System.out.print("\nJenis Kamar: ");
            System.out.print(result.getString("jenis_kamar"));
            System.out.print("\nBiaya\t\t : ");
            System.out.print(result.getString("biaya"));
            System.out.print("\nTagihan\t\t : ");
            System.out.print(result.getDouble("tagihan"));
            System.out.print("\nBayar\t\t : ");
            System.out.print(result.getInt("bayar"));
            System.out.print("\nKembalian\t : ");
            System.out.print(result.getDouble("kembalian"));
            System.out.print("\n");
        }
    }

}
