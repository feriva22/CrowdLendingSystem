import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class Proyek {

    //inisialisasi atribut
    DateFormat formatTanggal = new SimpleDateFormat("dd MM yyyy");

    String nama;
    double ekspetasi;
    int lamaProyek;
    String lokasi;
    Skema jenisSkema;
    int jenisResiko;
    double minimModal;
    double danaDibutuhkan;
    double danaTerkumpul;
    Date proyekMulai;
    Date proyekSelesai;
    int totPemodal;


    //set skema untuk objek dari Proyek
    public void setSkema(Skema jenisSkema){
        this.jenisSkema = jenisSkema;
        //set Proyek untuk skema
        jenisSkema.kumpulanProyek.add(this);
    }

    //proyek mulai adalah timeline proyek akan dilakukan , dan pemodalan harus berada di waktu sebelum proyek dimulai
    public void setWaktuProyek(int tanggal,int bulan, int tahun, int lamaproyek) throws ParseException {
        //Build tanggal Mulai
        String tanggalMulaiStr = tanggal+"/"+bulan+"/"+tahun;
        //convert string tanggalMulai ke Date
        Date tanggalMulai = new SimpleDateFormat("dd/MM/yyyy").parse(tanggalMulaiStr);

        this.proyekMulai = tanggalMulai;
        //set lama proyek
        this.lamaProyek = lamaproyek;

        //buat objek Calendar untuk convert Date ke Calendar
        Calendar c = Calendar.getInstance();
        c.setTime(this.proyekMulai);

        //tambah tanggal sekarang dengan tothari
        c.add(Calendar.DATE, lamaproyek);

        //convert Calendar c ke Date
        Date tanggalSelesai = c.getTime();
        //set attribut proyekSelesai
        this.proyekSelesai = tanggalSelesai;

    }

    public double getPersenModal(){
        return (danaTerkumpul/danaDibutuhkan)*100;
    }

    public int getSisaHari(){
        Date tgglSkarang = new Date();
        long diff = this.proyekMulai.getTime() - tgglSkarang.getTime();
        float days = (diff / (1000*60*60*24));
        if (days < 0){
            return -1;
        }
        else if(days == 0){
            return 0;
        }
        else {
            return (int)days;
        }
    }

    public String getJenisResiko(){
        return (jenisResiko == 0 ) ? "Rendah" : (jenisResiko == 1) ? "Sedang" : "Tinggi";
    }

    //tampilkan detail data objek dari Proyek

    public void tampilData(){

        System.out.println("Nama Proyek : "+nama);
        System.out.printf("mulai dari : %.0f\n",minimModal);
        System.out.println("Ekspetasi : "+ekspetasi + " %");
        System.out.println("Lama proyek : "+lamaProyek+" hari");
        System.out.println("Resiko : "+ getJenisResiko());
        System.out.println("Skema : "+this.jenisSkema.nama);
        System.out.printf("Persentase terkumpul  : %.0f %%\n", this.getPersenModal());
        System.out.printf("Dana terkumpul : Rp.%s,-\n",String.format("%,.0f",danaTerkumpul).replace(',','.'));
        System.out.printf("Kebutuhan Dana : Rp.%s,-\n",String.format("%,.0f",danaDibutuhkan).replace(',','.'));
        System.out.println("Sisa Hari Pemodalan: "+(getSisaHari() != -1 ? getSisaHari()+" hari" : "selesai"));
        System.out.println("Timeline proyek  : "+this.formatTanggal.format(this.proyekMulai) + " - " +this.formatTanggal.format(this.proyekSelesai));
    }


}
