import java.util.Scanner;

public class Payment {
    public static void bersihkan() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalBelanja = 250000; //data dummy tagihan

        String[] dataBank = {"BankA", "BankB", "BankC", "BankD", "BankE"};
        String[] dataEWallet = {"Danu", "GoPal", "OvvO", "Wowo"};

        System.out.println("==============================================");
        System.out.println("         SISTEM PEMBAYARAN E-COMMERCE");
        System.out.println("==============================================");
        System.out.println("Total Tagihan Anda: Rp " + (long) totalBelanja);
        System.out.println("\n*** Dapatkan diskon 10% dengan menggunakan E-Wallet! ***\n");
        
        System.out.println("Pilih Metode Pembayaran:");
        System.out.println("1. Transfer Bank");
        System.out.println("2. E-Wallet");
        System.out.print("Pilihan Anda (1/2): ");
        String pilihanMenu = input.nextLine();

        MetodePembayaran metodePilih = null; //penampung objek untuk polymorphism

        if (pilihanMenu.equals("1")) {
            bersihkan();
            System.out.println("\n--- Pilih Bank ---");
            for (int i = 0; i < dataBank.length; i++) {
                System.out.println((i + 1) + ". " + dataBank[i]);
            }
            System.out.print("Pilih Bank (1-5): ");
            int idxBank = Integer.parseInt(input.nextLine()) - 1;
            String namaBank = dataBank[idxBank];

            String noRek;
            do {
                System.out.print("Masukkan No. Rekening (wajib 10 digit angka): ");
                noRek = input.nextLine();
                if (!noRek.matches("\\d{10}")) {
                    System.out.println("[!] Format salah. Harus 10 digit angka.");
                }
            } while (!noRek.matches("\\d{10}"));

            String pin;
            do {
                System.out.print("Masukkan 6 Digit PIN Bank: ");
                pin = input.nextLine();
                if (!pin.matches("\\d{6}")) {
                    System.out.println("[!] Format salah. PIN harus 6 digit angka.");
                }
            } while (!pin.matches("\\d{6}"));

            //instansiasi subclass Transfer Bank ke variabel Abstract
            metodePilih = new TransferBank(namaBank, noRek);

        } else if (pilihanMenu.equals("2")) {
            bersihkan();
            System.out.println("\n--- Pilih E-Wallet ---");
            for (int i = 0; i < dataEWallet.length; i++) {
                System.out.println((i + 1) + ". " + dataEWallet[i]);
            }
            System.out.print("Pilih E-Wallet (1-4): ");
            int idxEWallet = Integer.parseInt(input.nextLine()) - 1;
            String namaEWallet = dataEWallet[idxEWallet];

            String noHp;
            do {
                System.out.print("Masukkan No. Telepon (wajib 12 digit angka): ");
                noHp = input.nextLine();
                if (!noHp.matches("\\d{12}")) {
                    System.out.println("[!] Format salah. Harus 12 digit angka.");
                }
            } while (!noHp.matches("\\d{12}"));

            String pin;
            do {
                System.out.print("Masukkan 6 Digit PIN E-Wallet: ");
                pin = input.nextLine();
                if (!pin.matches("\\d{6}")) {
                    System.out.println("[!] Format salah. PIN harus 6 digit angka.");
                }
            } while (!pin.matches("\\d{6}"));

            //instansiasi subclass E-Wallet ke variabel Abstract
            metodePilih = new EWallet(namaEWallet, noHp);

        } else {
            System.out.println("Pilihan tidak valid. Program berhenti.");
            System.exit(0);
        }

        //efek loading buatan
        try {
            System.out.println("\nMemverifikasi PIN dan memproses pembayaran...");
            Thread.sleep(1500); //jeda 1,5 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //polymorphism manggil method yang sama tapi hasil struk beda tergantung tipe objek
        if (metodePilih != null) {
            metodePilih.prosesPembayaran(totalBelanja);
        }

        input.close();
    }
}