package Depo;

public class Urun {
    //POJO

    //  List<String> urunIsmi =new ArrayList<>();
    //  List<Integer> urunId =new ArrayList<>();
    //  List<String> urunIsmi =new ArrayList<>();
    //  List<String> urunBirimi =new ArrayList<>();

    public static int count=99;
    public int urunId;

    private String urunIsmi;

    private String uretici;

    private String urunBirimi;

    private int urunMiktar;

    private String raf;

    public Urun() {
    }

    public Urun(String urunIsmi, String uretici, String urunBirimi,int urunMiktar,String raf) { //Parametreli constructor
        count++;
        this.urunId=count;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.urunBirimi = urunBirimi;
        this.urunMiktar=urunMiktar;
        this.raf=raf;

    }

    public int getUrunId() {
        // count++;
        urunId=urunId;
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public String getUrunIsmi() {   //ürünleri listelerken private oluşturduğumuz için getter ve setter
        return urunIsmi.toLowerCase();
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi.toLowerCase();
    }

    public String getUretici() {
        return uretici.toLowerCase();
    }

    public void setUretici(String uretici) {
        this.uretici = uretici.toLowerCase();
    }

    public String getUrunBirimi() {
        return urunBirimi.toLowerCase();
    }

    public void setUrunBirimi (String urunBirimi) {

        this.urunBirimi = urunBirimi.toLowerCase();
    }

    public int getUrunMiktar() {
        return urunMiktar;
    }

    public void setUrunMiktar(int urunMiktar) {
        if (urunMiktar<0){
            System.out.println("Ürün miktarı negatif olamaz");
        }else {
            this.urunMiktar = urunMiktar;
        }
    }

    public String getRaf() {
        return raf.toUpperCase();
    }

    public void setRaf(String raf) {
        this.raf = raf.toUpperCase();
    }


    @Override
    public String toString() {
        return "urunListeleme{" +
                "urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", urunBirimi='" + urunBirimi + '\'' +
                ", urunMiktar='" + urunMiktar + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }
}