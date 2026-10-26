# DigiPay
## Simulasi Sistem Pembayaran E-Commerce Menggunakan Konsep OOP (Abstraction &amp; Polymorphism)

# Class Diagram
<img width="5642" height="3670" alt="Payment Polymorphism Architecture-2026-10-26-055310" src="https://github.com/user-attachments/assets/9235b951-b961-4e99-98a0-7d51da8801b6" />

---

## Penjelasan Implementasi Kode

### 1. Abstract Class (Blueprint Utama)
Diimplementasikan pada file **`MetodePembayaran.java`**.
*   **Syntax yang digunakan:**
    ```java
    abstract class MetodePembayaran {
        // ...
        public abstract void prosesPembayaran(double jumlah);
    }
    ```
*   **Penjelasan:** `MetodePembayaran` dibuat sebagai *abstract class* yang menjadi kerangka dasar untuk semua metode pembayaran. Di dalamnya terdapat *abstract method* `prosesPembayaran()` yang tidak memiliki isi (hanya deklarasi), sehingga mewajibkan setiap class turunannya (*subclass*) untuk membuat logika pembayarannya masing-masing.

### 2. Interface (Kontrak Perilaku Tambahan)
Diimplementasikan pada file **`Diskonable.java`**.
*   **Syntax yang digunakan:**
    ```java
    interface Diskonable {
        double hitungDiskon(double jumlah);
    }
    ```
*   **Penjelasan:** *Interface* ini bertindak sebagai kontrak untuk memberikan fitur tambahan (diskon). Tidak semua metode pembayaran dapat diskon, jadi fitur ini dipisah menjadi *interface* agar hanya bisa diterapkan (di-implement) oleh metode pembayaran tertentu yang memang sedang promo.

### 3. Inheritance (Pewarisan)
Diimplementasikan pada file **`TransferBank.java`** dan **`EWallet.java`**.
*   **Syntax yang digunakan:**
    ```java
    class TransferBank extends MetodePembayaran {
        public TransferBank(String namaMetode, String nomorRekening) {
            super(namaMetode); // Memanggil constructor dari parent class
            // ...
        }
    }
    
    class EWallet extends MetodePembayaran implements Diskonable { ... }
    ```
*   **Penjelasan:** Keyword `extends` digunakan agar class `TransferBank` dan `EWallet` mewarisi sifat, atribut, dan method dari class `MetodePembayaran`. Khusus untuk `EWallet`, ditambahkan keyword `implements Diskonable` untuk mewarisi dan mengaktifkan fitur diskon.

### 4. Polymorphism (Banyak Bentuk)
Diimplementasikan pada file utama **`Payment.java`** (serta penggunaan `@Override` di subclass).
*   **Syntax yang digunakan:**
    ```java
    // 1. Deklarasi menggunakan tipe Abstract Class
    MetodePembayaran metodePilih = null; 

    // 2. Instansiasi dengan objek dari Subclass (Upcasting)
    if (pilihanMenu.equals("1")) {
        metodePilih = new TransferBank(namaBank, noRek);
    } else if (pilihanMenu.equals("2")) {
        metodePilih = new EWallet(namaEWallet, noHp);
    }

    // 3. Pemanggilan method (Dynamic Method Dispatch)
    metodePilih.prosesPembayaran(totalBelanja);
    ```
*   **Penjelasan:** Ini adalah *Polymorphism* murni. Kita menyiapkan satu wadah kosong bertipe `MetodePembayaran` (parent). Wadah ini bisa diisi dengan objek bentuk apa saja, baik itu `TransferBank` ataupun `EWallet`. Saat method `prosesPembayaran()` dipanggil, Java akan secara otomatis menjalankan output struk yang berbeda-beda, tergantung dari objek apa yang di-inputkan oleh user pada saat program berjalan (*runtime*).
