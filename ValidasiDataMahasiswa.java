// Lidia Trifosa Simangunsong - 245150701111020

import java.util.Scanner;

// Custom exception untuk input NIM yang bukan bentuk angka
class NimNotNumberException extends Exception {
    public NimNotNumberException(String message) {
        super(message);
    }
}

// Custom exception untuk IPK yang tidak valid(jika tidak berupa angka dan tidak dalam rentang 0-4)
class InvalidIPKException extends Exception {
    public InvalidIPKException(String message) {
        super(message);
    }
}

public class ValidasiDataMahasiswa {

    // Method untuk validasi NIM, melempar exception jika bukan angka
    public static void validasiNIM(String nim) throws NimNotNumberException {
        try {
            Long.parseLong(nim); // coba convert ke angka
        } catch (NumberFormatException e) {
            // lempar exception custom jika gagal parsing
            throw new NimNotNumberException("Error: NIM harus berupa angka.");
        }
    }

    // Method untuk validasi IPK, melempar exception jika bukan angka atau tidak di rentang 0-4
    public static void validasiIPK(String ipkStr) throws InvalidIPKException {
        double ipk;
        try {
            ipk = Double.parseDouble(ipkStr); // coba convert ke double
        } catch (NumberFormatException e) {
            // lempar exception jika gagal parsing
            throw new InvalidIPKException("Error: IPK harus berupa angka.");
        }

        // cek apakah ipk dalam rentang 0 sampai 4
        if (ipk < 0 || ipk > 4) {
            throw new InvalidIPKException("Error: IPK harus di antara 0 sampai 4.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            System.out.print("Masukkan IPK: ");
            String ipk = scanner.nextLine();

            // validasi NIM dan IPK
            validasiNIM(nim);
            validasiIPK(ipk);

            // jika validasi sukses, menampilkan kembali data mahasiswa
            System.out.println("");
            System.out.println("Data mahasiswa yang di-input valid.");
            System.out.println("Berikut datanya:");
            System.out.println("NIM: " + nim);
            System.out.println("IPK: " + ipk);
        } catch (NimNotNumberException | InvalidIPKException e) {
            // tangkap dan cetak pesan error exception custom
            System.out.println(e.getMessage());
        }
    }
}
