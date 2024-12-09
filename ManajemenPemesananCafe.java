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
        String namaPelanggan, nomorMeja;
        int hargaKeseluruhan = 0;
        String detailPesanan = "";
        
        System.out.print("Masukkan nama pelanggan: ");
        namaPelanggan = input.nextLine();

        boolean mejaTersedia;
        do {
            mejaTersedia = true;
            System.out.print("Masukkan nomor meja: ");
            nomorMeja = input.nextLine();
            
            for (int i = 0; i < pesananTercatat; i++) {
                if (pesanan[i][1].equals(nomorMeja)) {
                    System.out.println("Maaf, meja " + nomorMeja + " sudah terisi. Silakan pilih meja lain.");
                    mejaTersedia = false;
                    break;
                }
            }
        } while (mejaTersedia == false);
        


        System.out.println("===== MENU =====");
        for (int i = 0; i < daftarMenu.length; i++) {
            System.out.println((i + 1) + ". " + daftarMenu[i] + " - Rp " + hargaDaftarMenu[i]);
        }

        int pilihMenu;
        do {
            System.out.print("Pilih nomor menu (atau 0 untuk selesai): ");
            pilihMenu = input.nextInt();

            if (pilihMenu < 0 || pilihMenu > daftarMenu.length) {
                System.out.println("Menu tidak ditemukan!");
                continue;
            }

            if (pilihMenu != 0) {
                System.out.print("Masukkan jumlah " + daftarMenu[pilihMenu - 1] + ": ");
                int jumlah = input.nextInt();

                if (jumlah <= 0) {
                    System.out.println("Jumlah harus lebih dari 0!");
                    continue;
                }

                int totalHargaItem = hargaDaftarMenu[pilihMenu - 1] * jumlah;
                hargaKeseluruhan += totalHargaItem;

                detailPesanan += "- " + daftarMenu[pilihMenu - 1] + " x " + jumlah + " = Rp " + totalHargaItem + "\n";

            }
            
        } while (pilihMenu != 0);

        pesanan[pesananTercatat][0] = namaPelanggan;
        pesanan[pesananTercatat][1] = nomorMeja;
        pesanan[pesananTercatat][2] = detailPesanan;
        pesanan[pesananTercatat][3] = String.valueOf(hargaKeseluruhan);
        
        pesananTercatat++;

        System.out.println("Pesanan telah ditambahkan!");
    }

    static void lihatSemuaPesanan() {
            if (pesananTercatat == 0) {
                System.out.println("Belum ada pesanan.");
            } else {
                System.out.println("===== SEMUA PESANAN =====");
                for (int i = 0; i < pesananTercatat; i++) {
                    System.out.println("Nama: " + pesanan[i][0]);
                    System.out.println("Nomor Meja: " + pesanan[i][1]);
                    System.out.println("Rincian Pesanan:");
                    System.out.println(pesanan[i][2]);
                    System.out.println("Total Harga: Rp " + pesanan[i][3]);
                    System.out.println("--------------------------");
                }
            }
        }
    }