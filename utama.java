import java.text.ParseException;
import java.util.*;

public class utama {

    //inisialisasi jenis-jenis skema yang dipakai
    private static Skema syariah = new Skema("Syariah");
    private static Skema pinjaman = new Skema("Pinjaman");
    private static Skema bagiHasil = new Skema("Bagi Hasil");

    public static void tampilSemuaProyek(){
        List<Proyek> semuaProyek = new ArrayList<Proyek>();



        //add proyek skema syariah ke list
        semuaProyek.addAll(syariah.kumpulanProyek);

        //add proyek skema pinjaman ke list
        semuaProyek.addAll(pinjaman.kumpulanProyek);

        //add proyek skema bagiHasil ke list

        semuaProyek.addAll(bagiHasil.kumpulanProyek);


        //sortir all
        //List<Proyek> hasilSortir = sortByDanaTerkumpul(semuaProyek);
        //List<Proyek> hasilSortir = sortByTotalProfit(semuaProyek);
        //List<Proyek> hasilSortir = sortBylamaPemodalan(semuaProyek);
        List<Proyek> hasilSortir = sortByResiko(semuaProyek);


        System.out.println("<==========================================>");
        //tampilkan seluruh proyek dari semua skema
        System.out.println("Proyek dari Semua Skema");
        int i=1;
        for ( Proyek proyeknya : hasilSortir){
            System.out.println("==============================================================================");
            System.out.print(i+"=>");
            proyeknya.tampilData();
            System.out.println("==============================================================================");
            i++;
        }
    }

    //method untuk penyortiran suatu list

    public static void tampilProyekSyariah(){
        System.out.println("<==========================================>");
        //tampilkan seluruh proyek dari skema Syariah
        System.out.println("Proyek dari skema Syariah");
        syariah.tampilProyek();
    }

    public static void tampilProyekPinjaman(){
        System.out.println("<==========================================>");
        //tampilkan seluruh proyek dari skema Pinjaman
        System.out.println("Proyek dari skema Pinjaman");
        pinjaman.tampilProyek();
    }

    public static void tampilProyekBagiHasil(){
        System.out.println("<==========================================>");
        //tampilkan seluruh proyek dari skema Bagi Hasil
        System.out.println("Proyek dari skema Bagi Hasil");
        bagiHasil.tampilProyek();
    }

    //method sortir list proyek
    public static List<Proyek> sortByDanaTerkumpul(List<Proyek> dataProyek){
        List<Proyek> tmpProyek = dataProyek;

        Collections.sort(tmpProyek, new Comparator<Proyek>() {
            @Override
            public int compare(Proyek proyek1, Proyek proyek2) {
                return (proyek2.getPersenModal() ==  proyek1.getPersenModal()? 0 :
                        (proyek2.getPersenModal() < proyek1.getPersenModal() ? 1 : -1));      //for reverse order just change value return true with -1 and false with 1
            }
        });
        return tmpProyek;
    }

    public static List<Proyek> sortByTotalProfit(List<Proyek> dataProyek){
        List<Proyek> tmpProyek = dataProyek;

        Collections.sort(tmpProyek, new Comparator<Proyek>() {
            @Override
            public int compare(Proyek proyek1, Proyek proyek2) {
                return (proyek2.ekspetasi ==  proyek1.ekspetasi? 0 :
                        (proyek2.ekspetasi < proyek1.ekspetasi ? -1 : 1));      //for reverse order just change value return true with -1 and false with 1
            }
        });
        return tmpProyek;
    }

    public static List<Proyek> sortBylamaPemodalan(List<Proyek> dataProyek){
        List<Proyek> tmpProyek = dataProyek;

        Collections.sort(tmpProyek, new Comparator<Proyek>() {
            @Override
            public int compare(Proyek proyek1, Proyek proyek2) {
                return (proyek2.lamaProyek ==  proyek1.lamaProyek? 0 :
                        (proyek2.lamaProyek < proyek1.lamaProyek ? 1 : -1));      //for reverse order just change value return true with -1 and false with 1
            }
        });
        return tmpProyek;
    }

    public static List<Proyek> sortByResiko(List<Proyek> dataProyek){
        List<Proyek> tmpProyek = dataProyek;

        Collections.sort(tmpProyek, new Comparator<Proyek>() {
            @Override
            public int compare(Proyek proyek1, Proyek proyek2) {
                return (proyek2.lamaProyek ==  proyek1.lamaProyek? 0 :
                        (proyek2.lamaProyek < proyek1.lamaProyek ? 1 : -1));      //for reverse order just change value return true with -1 and false with 1
            }
        });
        return tmpProyek;
    }

    //method Utama
    public static void main(String[] args) throws ParseException {

        //inisilasi objek Proyek

        Proyek obj1 = new Proyek();
        obj1.nama = "Pedagang Buah untuk pengiriman jarak jauh";
        obj1.ekspetasi = 4;
        obj1.jenisResiko = 0;
        obj1.setSkema(pinjaman);    //obj1 memiliki skema pinjaman
        obj1.setWaktuProyek(17,11,2018,30);
        obj1.minimModal = 10000;
        obj1.lokasi = "Jakarta";
        obj1.danaDibutuhkan = 10000000;
        obj1.danaTerkumpul = 4000000;

        Proyek obj2 = new Proyek();
        obj2.nama = "Pedagang Bakso Granat";
        obj2.ekspetasi = 1.5;
        obj2.jenisResiko = 0;
        obj2.setSkema(pinjaman);    //obj2 memiliki skema pinjaman
        obj2.setWaktuProyek(11,10,2018,20);
        obj2.minimModal = 20000;
        obj2.lokasi = "Surabaya";
        obj2.danaDibutuhkan = 40000000;
        obj2.danaTerkumpul = 20000000;

        //membuat objek Proyek dengan skema berbeda
        Proyek obj3 = new Proyek();
        obj3.nama = "Pedagang Asongan Soto lamongan";
        obj3.ekspetasi = 1.0;
        obj3.jenisResiko = 2;
        obj3.setSkema(syariah);     //obj3 memiliki skema syariah
        obj3.setWaktuProyek(10,9,2018,40);
        obj3.minimModal = 15000;
        obj3.lokasi = "Gresik";
        obj3.danaDibutuhkan = 25000000;
        obj3.danaTerkumpul = 15000000;

        //membuat objek Proyek dengan skema berbeda
        Proyek obj4 = new Proyek();
        obj4.nama = "Pengiriman Sayur Rutin";
        obj4.ekspetasi = 1.14;
        obj4.jenisResiko = 1;
        obj4.setSkema(bagiHasil);     //obj3 memiliki skema bagiHasil
        obj4.setWaktuProyek(26,9,2018,30);
        obj4.minimModal = 10000;
        obj4.lokasi = "Malang";
        obj4.danaDibutuhkan = 22235000;
        obj4.danaTerkumpul = 15000000;

        //membuat objek Proyek dengan skema berbeda
        Proyek obj6 = new Proyek();
        obj6.nama = "Pengiriman Nangka";
        obj6.ekspetasi = 2.0;
        obj6.jenisResiko = 1;
        obj6.setSkema(bagiHasil);     //obj3 memiliki skema bagiHasil
        obj6.setWaktuProyek(23,10,2018,30);
        obj6.minimModal = 11000;
        obj6.lokasi = "Pasuruan";
        obj6.danaDibutuhkan = 10000000;
        obj6.danaTerkumpul = 1000000;

        //membuat objek Proyek dengan skema berbeda
        Proyek obj5 = new Proyek();
        obj5.nama = "Pengiriman Buah rutin";
        obj5.ekspetasi = 1.12;
        obj5.jenisResiko = 1;
        obj5.setSkema(bagiHasil);     //obj3 memiliki skema bagiHasil
        obj5.setWaktuProyek(30,9,2018,30);
        obj5.minimModal = 10000;
        obj5.lokasi = "Malang";
        obj5.danaDibutuhkan = 50000000;
        obj5.danaTerkumpul = 10000000;




        //tampilkan semua proyek
        tampilSemuaProyek();


    }

}
