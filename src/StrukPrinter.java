public class StrukPrinter {

    private String rupiah(int nilai) {
        return "Rp" + String.format("%,d", nilai).replace(',', '.');
    }

    public void cetakKeranjang(String judul, Keranjang keranjang) {
        System.out.println("=========== " + judul + " ===========");

        for (Buku buku : keranjang.getIsi()) {
            System.out.println(buku.getJudul() + " (" +
                    buku.getPenulis() + ")");
            System.out.println("  Harga       : " + rupiah(buku.getHarga()));
            System.out.println("  Keterangan  : " + buku.getKeterangan());
            System.out.println("  Harga akhir : " + rupiah(buku.getHargaAkhir()));
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total belanja : " +
                rupiah(keranjang.hitungTotal()));
    }

    public void cetakPembayaran(int totalBelanja, MetodeBayar[] pilihan) {
        System.out.println("-------------- PEMBAYARAN ---------------");

        for (MetodeBayar metode : pilihan) {
            String hasil = rupiah(metode.totalBayar(totalBelanja));

            System.out.printf("%-20s : %s%n", metode.nama(), hasil);
        }

        System.out.println();
    }
}
