// File: krs/Mahasiswa.java
package krs;

class Mahasiswa {
    private String nim;
    private String nama;
    private MataKuliah[] mataKuliah;
    private int count;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.mataKuliah = new MataKuliah[10];
        this.count = 0;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public MataKuliah[] getMataKuliah() {
        return mataKuliah;
    }

    public int getCount() {
        return count;
    }

    public void tambahMataKuliah(MataKuliah mk) {
        int totalSks = getTotalSks() + mk.getSks();
        if (totalSks <= 24 && count < mataKuliah.length) {
            mataKuliah[count] = mk;
            count++;
            System.out.println("Mata kuliah berhasil ditambahkan.");
        } else {
            System.out.println("Total SKS melebihi 24 atau kapasitas penuh. Tidak dapat menambah mata kuliah.");
        }
    }

    public int getTotalSks() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += mataKuliah[i].getSks();
        }
        return total;
    }
}