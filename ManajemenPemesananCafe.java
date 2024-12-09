import java.util.Scanner;

public class ManajemenPemesananCafe {
    static Scanner input = new Scanner(System.in);

    static String[] daftarMenu = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng", "Nasi Goreng"};
    static int[] hargaDaftarMenu = {15000, 22000, 12000, 18000, 25000};

    static String[][] pesanan = new String[100][4];
    // DOKUMENTASI KOLOM PESANAN
    // 0. Nama Pelanggan
    // 1. Nomor Meja
    // 2. Detail Pesanan
    // 3. Total Harga

    static int pesananTercatat = 0;

    public static void main(String[] args) {
        int opsi;

        do {
            System.out.println("===== PILIHAN UTAMA =====");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Keluar");
            
            System.out.print("Pilih opsi: ");
            opsi = input.nextInt();
            input.nextLine();

            switch (opsi) {
                case 1:
                    tambahPesanan();
                    break;
                case 2:
                    lihatSemuaPesanan();
                    break;
                case 3:
                    System.out.println("Terima kasih sudah menggunakan layanan kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (opsi != 3);
    }

    static void tambahPesanan() {

    }

    static void lihatSemuaPesanan() {

    }
}