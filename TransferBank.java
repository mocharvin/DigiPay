//subclass 1 (inheritance dari MetodePembayaran)
class TransferBank extends MetodePembayaran {
    private String nomorRekening;

    public TransferBank(String namaMetode, String nomorRekening) {
        super(namaMetode);
        this.nomorRekening = nomorRekening;
    }

    @Override
    public void prosesPembayaran(double jumlah) {
        System.out.println("\n==============================================");
        System.out.println("              STRUK PEMBAYARAN");
        System.out.println("==============================================");
        System.out.println("Metode      : Transfer " + getNamaMetode());
        System.out.println("No. Rekening: " + nomorRekening);
        System.out.println("Total Bayar : Rp " + (long) jumlah);
        System.out.println("Status      : LUNAS / BERHASIL!");
        System.out.println("==============================================\n");
    }
}