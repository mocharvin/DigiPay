//abstract class sebagai parent class (superclass)
abstract class MetodePembayaran {
    private String namaMetode;

    public MetodePembayaran(String namaMetode) {
        this.namaMetode = namaMetode;
    }

    public String getNamaMetode() {
        return namaMetode;
    }

    // Abstract method yang wajib di-override oleh subclass
    public abstract void prosesPembayaran(double jumlah);
}