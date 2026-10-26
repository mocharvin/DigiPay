//subclass 2 (inheritance dari MetodePembayaran & implement interface Diskonable)
class EWallet extends MetodePembayaran implements Diskonable {
    private String nomorHP;

    public EWallet(String namaMetode, String nomorHP) {
        super(namaMetode);
        this.nomorHP = nomorHP;
    }

    @Override
    public double hitungDiskon(double jumlah) {
        return jumlah * 0.10; //diskon 10%
    }

    @Override
    public void prosesPembayaran(double jumlah) {
        double diskon = hitungDiskon(jumlah);
        double totalAkhir = jumlah - diskon;
        
        System.out.println("\n==============================================");
        System.out.println("              STRUK PEMBAYARAN");
        System.out.println("==============================================");
        System.out.println("Metode      : E-Wallet " + getNamaMetode());
        System.out.println("No. HP      : " + nomorHP);
        System.out.println("Subtotal    : Rp " + (long) jumlah);
        System.out.println("Diskon 10%  : -Rp " + (long) diskon);
        System.out.println("Total Bayar : Rp " + (long) totalAkhir);
        System.out.println("Status      : LUNAS / BERHASIL!");
        System.out.println("==============================================\n");
    }
}