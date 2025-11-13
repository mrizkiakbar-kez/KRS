
package krs;

import java.util.Scanner;

public class KRSApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nim, nama);

        while (true) {
            System.out.print("Masukkan kode MK (atau 'stop' untuk berhenti): ");
            String kode = scanner.nextLine();
            if (kode.equalsIgnoreCase("stop")) {
                break;
            }
            System.out.print("Masukkan nama MK: ");
            String namaMk = scanner.nextLine();
            System.out.print("Masukkan SKS: ");
            int sks = scanner.nextInt();
            scanner.nextLine();

            MataKuliah mk = new MataKuliah(kode, namaMk, sks);
            mahasiswa.tambahMataKuliah(mk);
        }

        cetakKRS(mahasiswa);

        scanner.close();
    }

    private static void cetakKRS(Mahasiswa mahasiswa) {
        System.out.println("\n=== KARTU RENCANA STUDI (KRS) ===");
        System.out.println("NIM: " + mahasiswa.getNim());
        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Daftar Mata Kuliah:");
        for (int i = 0; i < mahasiswa.getCount(); i++) {
            MataKuliah mk = mahasiswa.getMataKuliah()[i];
            System.out.println("- " + mk.getKode() + " - " + mk.getNama() + " - " + mk.getSks() + " SKS");
        }
        System.out.println("Total SKS: " + mahasiswa.getTotalSks());
        System.out.println("Tanda Tangan KPS: " + getTtdKPS(mahasiswa.getNim(), mahasiswa.getNama()));
    }

    private static String getTtdKPS(String nim, String nama) {
        return "KPS-" + nim + " (" + nama + ")";
    }
}