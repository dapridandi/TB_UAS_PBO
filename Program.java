import java.util.Scanner;
import java.sql.*;

//class program tempat running aplikasi
public class Program {
    static Connection con;

    // method utama
    public static void main(String[] args) throws Exception {
        // exception
        try (Scanner input = new Scanner(System.in)) {// inputan user
            // deklarasi variabel
            String inputanPengguna;
            boolean isLanjutkan = true;// isLanjutan bernilai true
            String link = "jdbc:mysql://localhost:3306/hotel";
            // exception
            try {
                Tagihan tagihan = new Tagihan();// membuat objek baru dengan nama tagihan
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(link, "root", "");
                System.out.println("\nKONEKSI KE DATABASE SUDAH BERHASIL");
                while (isLanjutkan) { // perulangan while, akan terus dilakukan perulangan sampai isLanjutan bernilai
                                      // true
                    // string replace dari Halo menjadi Selamat Pagi
                    String sapa = "Halo";
                    String ubahkalimat = sapa.replace("Halo", "\nSelamat pagi :)\n");
                    System.out.println(ubahkalimat);

                    tagihan.timedate();
                    // berikut merupakan block program untuk menampilkan menu di konsol
                    System.out.println("===PROGRAM TAGIHAN HOTEL PELANGGAN===");
                    System.out.println("Pilihan Menu");
                    System.out.println("1. Lihat Data Pelanggan");
                    System.out.println("2. Tambah Data Pelanggan");
                    System.out.println("3. Ubah Data Pelanggan");
                    System.out.println("4. Hapus Data Pelanggan");
                    System.out.println("5. Cari Data Pelanggan");

                    System.out.print("\nSILAHKAN PILIH MENU (1-5): ");
                    inputanPengguna = input.next();// inputan user
                    // percabangan switch
                    switch (inputanPengguna) {
                        case "1":// untuk menampilkan data pelanggan
                            tagihan.tampil();
                            break;
                        case "2":// utk menambahkan data pelanggan
                            tagihan.tambah();
                            break;
                        case "3":
                            tagihan.ubah();// untuk mengubah data pelanggan
                            break;
                        case "4":
                            tagihan.hapus();// untuk menghapus data pelanggan
                            break;
                        case "5":
                            tagihan.cari();// untuk mencari data pelanggan
                            break;
                        default:
                            System.err.println("\nMOHON INPUT DENGAN BENAR!(1-5)");
                    }

                    System.out.print("\nMasih Ingin Menggunakan Program? [y/t] ");
                    inputanPengguna = input.next();
                    // method IgnoreCase digunakan untuk mengabaikan penggunaan hurup kapital atau
                    // kecil
                    isLanjutkan = inputanPengguna.equalsIgnoreCase("y");

                }

            }
            // akan menampilan DRIVER ERROR jika exceptionnya ClassNotFound
            catch (ClassNotFoundException ex) {
                System.err.println("DRIVER ERROR");
                System.exit(0);

            }
            // jika koneksi ke database gagal juga akan terjadi exception
            catch (Exception e) {
                System.err.println("KONEKSI KE DATABASE GAGAL" + e.getMessage());
            }
            // berikut adalah block program ketika program berhasil dijalankan dan selesai
            finally {
                Penutup close = new Penutup("TERIMA KASIH");
                System.out.println(close.terimakasih);
                System.out.println("PROGRAM SELESAI");
            }
        }
    }
}
