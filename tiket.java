code: 
import java.util.Scanner;

// Class KelasPenerbangan
class KelasPenerbangan {
    String namaKelas;
    int hargaTiket;
    int tiketTersedia;

    // Constructor
    public KelasPenerbangan(String namaKelas, int hargaTiket, int tiketTersedia) {
        this.namaKelas = namaKelas;
        this.hargaTiket = hargaTiket;
        this.tiketTersedia = tiketTersedia;
    }

    // Method untuk menampilkan informasi kelas
    public void tampilkanInfoKelas() {
        System.out.println("Kelas: " + namaKelas);
        System.out.println("Harga Tiket: Rp " + hargaTiket);
        System.out.println("Tiket Tersedia: " + tiketTersedia);
    }

    // Method untuk mengecek ketersediaan tiket
    public boolean cekKetersediaan(int jumlahTiket) {
        return jumlahTiket <= tiketTersedia;
    }

    // Method untuk mengurangi tiket tersedia
    public void kurangiTiket(int jumlahTiket) {
        tiketTersedia -= jumlahTiket;
    }
}

// Class PembelianTiket
class PembelianTiket {
    String namaPembeli;
    KelasPenerbangan kelasPenerbangan;
    int jumlahTiket;

    // Constructor
    public PembelianTiket(String namaPembeli, KelasPenerbangan kelasPenerbangan, int jumlahTiket) {
        this.namaPembeli = namaPembeli;
        this.kelasPenerbangan = kelasPenerbangan;
        this.jumlahTiket = jumlahTiket;
    }

    // Method untuk menghitung total harga
    public int hitungTotalHarga() {
        return jumlahTiket * kelasPenerbangan.hargaTiket;
    }

    // Method untuk menampilkan detail pembelian
    public void tampilkanDetailPembelian() {
        System.out.println("Nama Pembeli: " + namaPembeli);
        kelasPenerbangan.tampilkanInfoKelas();
        System.out.println("Jumlah Tiket: " + jumlahTiket);
        System.out.println("Total Harga: Rp " + hitungTotalHarga());
    }
}

public class TiketPesawat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek kelas penerbangan
        KelasPenerbangan ekonomi = new KelasPenerbangan("Ekonomi", 1000000, 50);
        KelasPenerbangan bisnis = new KelasPenerbangan("Bisnis", 3000000, 30);
        KelasPenerbangan firstClass = new KelasPenerbangan("First Class", 5000000, 10);

        // Meminta pengguna memasukkan nama
        System.out.println("Masukkan nama pembeli:");
        String namaPembeli = scanner.nextLine();

        // Meminta pengguna memilih kelas penerbangan
        System.out.println("Pilih kelas penerbangan:");
        System.out.println("1. Ekonomi");
        System.out.println("2. Bisnis");
        System.out.println("3. First Class");
        int pilihanKelas = scanner.nextInt();

        // Meminta jumlah tiket yang ingin dibeli
        System.out.println("Masukkan jumlah tiket yang ingin dibeli:");
        int jumlahTiket = scanner.nextInt();

        KelasPenerbangan kelasDipilih = null;

        // Proses pemilihan kelas
        if (pilihanKelas == 1) {
            kelasDipilih = ekonomi;
        } else if (pilihanKelas == 2) {
            kelasDipilih = bisnis;
        } else if (pilihanKelas == 3) {
            kelasDipilih = firstClass;
        } else {
            System.out.println("Pilihan kelas tidak valid.");
            System.exit(0);
        }

        // Mengecek ketersediaan tiket
        if (kelasDipilih.cekKetersediaan(jumlahTiket)) {
            // Membuat objek PembelianTiket
            PembelianTiket pembelian = new PembelianTiket(namaPembeli, kelasDipilih, jumlahTiket);
            pembelian.tampilkanDetailPembelian();
            
            // Mengurangi tiket yang tersedia setelah pembelian
            kelasDipilih.kurangiTiket(jumlahTiket);
        } else {
            System.out.println("Maaf, tiket " + kelasDipilih.namaKelas + " tidak mencukupi.");
        }

        scanner.close();
    }
}
