//import Package untuk kebutuhan List
import java.util.ArrayList;
import java.util.List;

//membuat class Skema
public class Skema {

    //inisialisasi atribut
    String nama;
    public List<Proyek> kumpulanProyek = new ArrayList<Proyek>();


    //inisialisasi constructor untuk mengisi atribut nama
    public Skema(String jenisskema){
        this.nama = jenisskema;
    }


    //list proyek-proyek dari objek Skema
    void tampilProyek(){
        int i=1;
        for ( Proyek proyeknya : kumpulanProyek){
            System.out.println("==============================================================================");
            System.out.print(i+"=>");
            proyeknya.tampilData();
            System.out.println("==============================================================================");
            i++;
        }
    }

}

