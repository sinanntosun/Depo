package Depo;

import javax.swing.*;
import java.util.*;

public class UrunService{
    Depo.Urun obj1;
    static Scanner inp = new Scanner(System.in);

    static Scanner stringScanner = new Scanner(System.in);

    public static  Map<Integer, Urun> mapUrun = new HashMap<>();




    public UrunService() {
        obj1 = new Depo.Urun();
        Urun s1 = new Urun("Örisim","ÖrMarka","Örbirim",0,"Örraf");
        mapUrun.put(s1.urunId, s1);
    }




    public void tanimlama() {
        System.out.println("Ürünün ismini giriniz :");
        String name = stringScanner.nextLine();
        System.out.println("Ürün üreticisi giriniz :");
        String uretici = stringScanner.nextLine();
        System.out.println("Ürünün birimini giriniz : \n(Kg,Lt,Koli,Adet,Çuval)");
        String birim = stringScanner.nextLine();
        Collection<Urun>degerler=mapUrun.values();
        List<Urun> listeElemanlari = new ArrayList<>();
        listeElemanlari.addAll(degerler);
        boolean isTrue=true;
        for (Urun w : listeElemanlari) {
            isTrue=(w.getUrunIsmi().equalsIgnoreCase(name)&&w.getUretici().equalsIgnoreCase(uretici)&&w.getUrunBirimi().equalsIgnoreCase(birim));
        }
        if (!isTrue){
            int defaultMiktar = 0;
            String defaultRaf = "Yerleştirilmedi";
            Urun obj1 = new Urun(name, uretici, birim, defaultMiktar, defaultRaf);
            mapUrun.put(obj1.urunId, obj1);
        }else System.out.println("!! Girilen ürün zaten mevcuttur \nÜrün bilgilerini menüden güncelleyebilirsiniz");
        mapUrun.remove(100);
    }


    public void urunGiris(){
        System.out.println("--------- ÜRÜN GİRİŞ SAYFASI ---------");
        System.out.println("İşlem seçiniz : \n1:Ürünü Ekleme \n0:Çıkış");
        String secim = inp.next();
        switch (secim){
            case "1": System.out.println("Lütfen ürün ID giriniz :");
                try{
                    int id = inp.nextInt();
                    boolean idCheck= mapUrun.containsKey(id);
                    if (idCheck){
                        System.out.println("Lütfen ürün miktarı giriniz  : ");
                        int miktar =inp.nextInt();
                        int sumMiktar =mapUrun.get(id).getUrunMiktar();
                        mapUrun.get(id).setUrunMiktar(miktar+sumMiktar);
                    }else System.out.println("Girilen ID de ürün bulunmamaktadır !! ");
                }catch (InputMismatchException e ){
                    System.out.println("Hatalı giriş yaptınız lütfen miktar için pozitif sayı giriniz :");
                    urunGiris();
                }
                break;
            case "0":
                System.out.println("Menüye Yönlendiriliyor...");
                break;
            default:    System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyiniz ");
                urunGiris();
        }
    }

    public static void urunYazdirma (){

        System.out.println("                       ***** QA-03 DEPO ÜRÜNLERİ *****                    ");
        System.out.printf("%-3s      %-10s      %-10s      %-3s     %-5s    %-3s \n", "Id", "Ürün Adı ", "Üretici Adı", "Ürün Birimi", "Ürün Miktarı", "Ürün Raf");
        System.out.println("--------------------------------------------------------------------------------------");
        Collection<Urun> values = mapUrun.values();
        List<Urun> listele = new ArrayList<>();
        listele.addAll(values);
        for (Urun w : listele) {
            System.out.printf("%-3s      %-10s      %-11s      %-10s       %-12s     %-3s \n", w.getUrunId(), w.getUrunIsmi(), w.getUretici(), w.getUrunBirimi(), w.getUrunMiktar(), w.getRaf());
            System.out.println();
        }
    }

    public void urunRafaYerlestir() {

        System.out.println("--------- ÜRÜN RAF SAYFASI ---------");
        System.out.println("İşlem seçiniz : \n1:Ürün Rafa yerleştir \n2:Ürün Raftan çıkar  \n0:Çıkış");
        String secim1 = inp.next();
        switch (secim1) {
            case "1":
                System.out.println("Lütfen ürün ID giriniz :");
                try{int id = inp.nextInt();
                    boolean idCheck = mapUrun.containsKey(id);
                    if (idCheck) {
                        System.out.println("Lütfen Ürün Rafını giriniz  : \n(!Raf bilgisini boşluk olmadan giriniz!)");
                        String raf = inp.next();
                        mapUrun.get(id).setRaf(raf);
                    } else System.out.println("Girilen ID de ürün bulunmamaktadır !! ");
                }catch(InputMismatchException e ){
                    System.out.println("Hatalı giriş yaptınız lütfen miktar için pozitif sayı giriniz :");
                    urunRafaYerlestir();
                }break;
            case "2":
                System.out.println("Lütfen ürün ID giriniz :");
                try{int id1 = inp.nextInt();
                    boolean idCheck1 = mapUrun.containsKey(id1);
                    if (idCheck1) {
                        mapUrun.get(id1).setRaf("Yerleştirilmedi");
                    } else System.out.println("Girilen ID de ürün bulunmamaktadır !! ");
                }catch (InputMismatchException e ){
                    System.out.println("Hatalı giriş yaptınız lütfen miktar için pozitif sayı giriniz :");
                    urunGiris();
                }break;
            case "0":
                System.out.println("Ana menüye yönlendiriliyor...");
                break;
            default:
                System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyiniz ");
                urunRafaYerlestir();
        }

    }public void urunCikisi() {
        System.out.println("--------- ÜRÜN ÇIKIŞ SAYFASI ---------");
        System.out.println("İşlem seçiniz : \n1:Ürünü Çıkartma \n0:Çıkış");
        String secim2=inp.next();
        switch (secim2){
            case "1":
                System.out.println("Lütfen çıkış yapmak istediğiniz urun ID giriniz");
                try{  int urunID=inp.nextInt();
                    if (mapUrun.containsKey(urunID)){
                        System.out.println("Lütfen miktar giriniz");
                        int exit=inp.nextInt();
                        int adet=mapUrun.get(urunID).getUrunMiktar();
                        if (exit>adet){
                            System.out.println("Depoda çıkış yapmak istediğiniz miktarda ürün yok.");
                            System.out.println("Çıkış yapmak istediğiniz üründen depoda  "+mapUrun.get(urunID).getUrunMiktar()+" "+
                                    mapUrun.get(urunID).getUrunBirimi()+" var");
                        }else mapUrun.get(urunID).setUrunMiktar(adet-exit);
                    }else System.out.println("Çıkış yapmak istediğiniz ürün listede yok");
                }catch (InputMismatchException e ) {
                    System.out.println("Hatalı giriş yaptınız lütfen miktar için pozitif sayı giriniz :");
                    urunGiris();
                }break;
            case "0": break;
            default:
                System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyiniz ");
                urunCikisi();
        }



    }
}