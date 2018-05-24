/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.Token;
import zemberek.core.logging.Log;
import zemberek.morphology.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;
import zemberek.tokenization.TurkishTokenizer;
import zemberek.tokenization.antlr.TurkishLexer;
import zemberek.core.logging.Log;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;

/**
 *
 * @author Ahmet
 */
class sayac {

    int num;
    String ngram;

    public sayac(int num, String ngram) {
        this.num = num;
        this.ngram = ngram;
    }
}
public class asdasd {
  public static int a =0; 
    public static String cevap="";
    public static void main(String[] args) throws IOException {
        int sayac = 1;
        String dosyayolu = null;
       
      while (sayac <= 750) {
            if (sayac < 151) {
                 
                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\ekonomi\\"
                      + sayac + ".txt";

                dosyayolu = e;
                

            }
            if (sayac < 301 && sayac > 150) {

                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\magazin\\"
                        + sayac + ".txt";

                dosyayolu = e;

            }
            if (sayac < 451 && sayac > 300) {
                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\saglik\\"
                        + sayac + ".txt";

                dosyayolu = e;
            }
            if (sayac < 601 && sayac > 450) {
                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\siyasi\\"
                        + sayac + ".txt";

                dosyayolu = e;
            }
            if (sayac < 751 && sayac > 600) {
                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\spor\\"
                        + sayac + ".txt";

                dosyayolu = e;
            }

            File file = new File(dosyayolu);
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "ISO-8859-9"));

            String satir = reader.readLine();
            String bu = "";
            int dosyasayac = 0;
            int yut=0;
            while (satir != null) {

                if (yut==0) {
                    bu = satir;
                   yut=1;
                }
                if (satir != null) {
                    bu = bu + "\n" + satir;
                   
                }
                satir = reader.readLine();
            }

            TurkishTokenizer tokenizer = TurkishTokenizer.ALL;
            TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
            TurkishSpellChecker spellChecker = new TurkishSpellChecker(morphology);
            StringBuilder output = new StringBuilder();

            for (Token token : tokenizer.tokenize(bu)) {
                String text = token.getText();
                if (analyzeToken(token) && !spellChecker.check(text)) {
                    List<String> strings = spellChecker.suggestForWord(token.getText());
                    if (!strings.isEmpty()) {
                        String suggestion = strings.get(0);
                        // Log.info("Correction: " + text + " -> " + suggestion);
                        output.append(suggestion);
                    } else {
                        output.append(text);
                    }
                } else {
                    output.append(text);
                }
            }
           
            String yenisatir = output.toString();
            // System.out.println(yenisatir);

           
            String[] words = yenisatir.split(" ");
           
            ArrayList<String> wordsList = new ArrayList<String>();
            Set<String> stopWordsSet = new HashSet<String>();


            stopWordsSet.add("ACABA");
            stopWordsSet.add("AMA");
            stopWordsSet.add("ANCAK");
            stopWordsSet.add("ARTIK");
            stopWordsSet.add("ASLA");
            stopWordsSet.add("ASLINDA");
            stopWordsSet.add("AZ");
            stopWordsSet.add("BANA");
            stopWordsSet.add("BAZEN");
            stopWordsSet.add("BAZI");
            stopWordsSet.add("BAZISI");
            stopWordsSet.add("BELKİ");
            stopWordsSet.add("BEN");
            stopWordsSet.add("BENİ");
            stopWordsSet.add("BENİM");
            stopWordsSet.add("BEŞ");
            stopWordsSet.add("BİLE");
            stopWordsSet.add("BİR");
            stopWordsSet.add("BİRÇOĞU");
            stopWordsSet.add("BİRÇOK");
            stopWordsSet.add("BİRÇOKLARI");
            stopWordsSet.add("BİRİ");
            stopWordsSet.add("BİRİSİ");
            stopWordsSet.add("BİRKAÇ");
            stopWordsSet.add("BİRŞEY");
            stopWordsSet.add("BİRŞEYİ");
            stopWordsSet.add("BİZ");
            stopWordsSet.add("BİZE");
            stopWordsSet.add("BİZİ");
            stopWordsSet.add("BİZİM");
            stopWordsSet.add("BÖYLE");
            stopWordsSet.add("BÖYLECE");
            stopWordsSet.add("BU");
            stopWordsSet.add("BUNA");
            stopWordsSet.add("BUNDAN");
            stopWordsSet.add("BUNU");
            stopWordsSet.add("BUNUN");
            stopWordsSet.add("BURADA");
            stopWordsSet.add("BÜTÜN");
            stopWordsSet.add("ÇOĞU");
            stopWordsSet.add("DA");
            stopWordsSet.add("DAHA");
            stopWordsSet.add("DEĞİL");
            stopWordsSet.add("DE");
            stopWordsSet.add("DEMEK");
            stopWordsSet.add("DİĞER");
            stopWordsSet.add("DİĞERİ");
            stopWordsSet.add("DİYE");
            stopWordsSet.add("DOLSYI");
            stopWordsSet.add("ELBETTE");
            stopWordsSet.add("EN");
            stopWordsSet.add("FAKAT");
            stopWordsSet.add("FALAN");
            stopWordsSet.add("FELAN");
            stopWordsSet.add("FİLAN");
            stopWordsSet.add("GENE");
            stopWordsSet.add("GİBİ");
            stopWordsSet.add("HANGİ");
            stopWordsSet.add("HANGİSİ");
            stopWordsSet.add("HANİ");
            stopWordsSet.add("HATTA");
            stopWordsSet.add("HEM");
            stopWordsSet.add("HENÜZ");
            stopWordsSet.add("HEP");
            stopWordsSet.add("HEPSİ");
            stopWordsSet.add("HEPSİNE");
            stopWordsSet.add("HEPSİNİ");
            stopWordsSet.add("HER");
            stopWordsSet.add("HERKES");
            stopWordsSet.add("HERKESE");
            stopWordsSet.add("HERKESİ");
            stopWordsSet.add("HİÇ");
            stopWordsSet.add("HİÇBİRİ");
            stopWordsSet.add("HİÇBİRİNE");
            stopWordsSet.add("HİÇBİRİNİ");
            stopWordsSet.add("İÇİN");
            stopWordsSet.add("İÇİNDE");
            stopWordsSet.add("İLE");
            stopWordsSet.add("İSE");
            stopWordsSet.add("İŞTE");
            stopWordsSet.add("KAÇ");
            stopWordsSet.add("KADAR");
            stopWordsSet.add("KENDİ");
            stopWordsSet.add("KENDİNE");
            stopWordsSet.add("KENDİNİ");
            stopWordsSet.add("Kİ");
            stopWordsSet.add("KİM");
            stopWordsSet.add("KİME");
            stopWordsSet.add("KİMİ");
            stopWordsSet.add("KİMİN");
            stopWordsSet.add("KİMİSİ");
            stopWordsSet.add("MADEM");
            stopWordsSet.add("MI");
            stopWordsSet.add("Mİ");
            stopWordsSet.add("MU");
            stopWordsSet.add("MÜ");
            stopWordsSet.add("NASIL");
            stopWordsSet.add("NE");
            stopWordsSet.add("NEDEN");
            stopWordsSet.add("NEDİR");
            stopWordsSet.add("NERDE");
            stopWordsSet.add("NEREDE");
            stopWordsSet.add("NEREDEN");
            stopWordsSet.add("NEREYE");
            stopWordsSet.add("NESİ");
            stopWordsSet.add("NEYSE");
            stopWordsSet.add("NİÇİN");
            stopWordsSet.add("NİYE");
            stopWordsSet.add("ONA");
            stopWordsSet.add("ONDAN");
            stopWordsSet.add("ONLAR");
            stopWordsSet.add("ONLARA");
            stopWordsSet.add("ONLARDAN");
            stopWordsSet.add("ONLARIN");
            stopWordsSet.add("ONU");
            stopWordsSet.add("ONUN");
            stopWordsSet.add("ORADA");
            stopWordsSet.add("OYSA");
            stopWordsSet.add("OYSAKİ");
            stopWordsSet.add("ÖBÜRÜ");
            stopWordsSet.add("ÖN");
            stopWordsSet.add("ÖNCE");
            stopWordsSet.add("ÖTÜRÜ");
            stopWordsSet.add("ÖYLE");
            stopWordsSet.add("SANA");
            stopWordsSet.add("SEN");
            stopWordsSet.add("SENDEN");
            stopWordsSet.add("SENİ");
            stopWordsSet.add("SİZ");
            stopWordsSet.add("SİZDEN");
            stopWordsSet.add("SİZE");
            stopWordsSet.add("SİZİ");
            stopWordsSet.add("SİZİN");
            stopWordsSet.add("SON");
            stopWordsSet.add("SONRA");
            stopWordsSet.add("SEOBİLOG");
            stopWordsSet.add("ŞAYET");
            stopWordsSet.add("ŞEY");
            stopWordsSet.add("ŞİMDİ");
            stopWordsSet.add("ŞÖYLE");
            stopWordsSet.add("ŞU");
            stopWordsSet.add("ŞUNA");
            stopWordsSet.add("ŞUNDA");
            stopWordsSet.add("ŞUNDAN");
            stopWordsSet.add("ŞUNLAR");
            stopWordsSet.add("ŞUNU");
            stopWordsSet.add("ŞUNUN");
            stopWordsSet.add("TABİ");
            stopWordsSet.add("TAMAM");
            stopWordsSet.add("TÜM");
            stopWordsSet.add("TÜMÜ");
            stopWordsSet.add("ÜZERE");
            stopWordsSet.add("YAR");
            stopWordsSet.add("VE");
            stopWordsSet.add("VEYA");
            stopWordsSet.add("VEYAHUT");
            stopWordsSet.add("YA");
            stopWordsSet.add("YANİ");
            stopWordsSet.add("YERİNE");
            stopWordsSet.add("YİNE");
            stopWordsSet.add("YOKSA");
            stopWordsSet.add("ZATEN");
            stopWordsSet.add("ZİRA");

            /////////
            for (String word : words) {
                String wordCompare = word.toUpperCase();
                if (!stopWordsSet.contains(wordCompare)) {
                    wordsList.add(word);
                    // System.out.println(word);
                }
            }
            String a = "";
            for (String str : wordsList) {
                // System.out.print(str + " ");
                a = a + " " + str;
            }

            a = a.toLowerCase();
            //System.out.println(a);

            a = a.replace("!", "");
            a = a.replace(".", "");
            a = a.replace(",", "");
            a = a.replace(":", "");
            a = a.replace(";", "");
            a = a.replace("!", "");
            
            a = a.replace("\\\"", "");
            a = a.replace("\\\'", "");
            a = a.replace("(", "");
            a = a.replace(")", "");
            a = a.replace("/", "");
            a = a.replace("-", "");
            a = a.replace("...", "");
            a = a.replace("[", "");
            a = a.replace("]", "");
		a = a.replace("?", "");
            a = a.trim();

            System.out.println(a);

            if (dosyasayac == 0) {
                DosyayaEkle(a, dosyayolu);
                dosyasayac = 1;
            } else {
                DosyayaEkle(a, dosyayolu, 1);
            }

            sayac++;
        }

      
        
        
        /////////////NGRAM
        ArrayList<String> frekanslar = new ArrayList<String>();
        ArrayList<Integer> frekansdeger = new ArrayList<Integer>();
        String bu = "";
        int ty = 0;
        ///////////

        sayac = 1;
        dosyayolu = null;
        while (sayac <= 750) {

            if (sayac < 151) {

                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\ekonomi\\"
                        + sayac + ".txt";

                dosyayolu = e;
                sayac++;

                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (ty == 0) {
                        bu = satir;
                        ty = 1;
                    }
                    if (satir != null) {
                        bu = bu + satir;
                    }
                    satir = reader.readLine();
                }

            }
            if (sayac < 301 && sayac > 150) {

                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\magazin\\"
                        + sayac + ".txt";

                dosyayolu = e;
                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (ty == 0) {
                        bu = satir;
                        ty = 1;
                    }
                    if (satir != null) {
                        bu = bu + satir;
                    }
                    satir = reader.readLine();
                }
                sayac++;
            }
            if (sayac < 451 && sayac > 300) {
                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\saglik\\"
                        + sayac + ".txt";

                dosyayolu = e;
                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (ty == 0) {
                        bu = satir;
                        ty = 1;
                    }
                    if (satir != null) {
                        bu = bu + satir;
                    }
                    satir = reader.readLine();
                }
                sayac++;
            }
            if (sayac < 601 && sayac > 450) {
                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\siyasi\\"
                        + sayac + ".txt";

                dosyayolu = e;
                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (ty == 0) {
                        bu = satir;
                        ty = 1;
                    }
                    if (satir != null) {
                        bu = bu + satir;
                    }
                    satir = reader.readLine();
                }
                sayac++;
            }
            if (sayac < 751 && sayac > 600) {
                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\spor\\"
                        + sayac + ".txt";

                dosyayolu = e;
                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (ty == 0) {
                        bu = satir;
                        ty = 1;
                    }
                    if (satir != null) {
                        bu = bu + satir;
                    }
                    satir = reader.readLine();
                }
                sayac++;
            }

        }

        int n = 2;
        Vector v = new Vector();
        bu = bu.toLowerCase();
        for (int i = 0; i < bu.length() - n + 1; i++) {
            String x = bu.substring(i, i + n);
            boolean buldu = false;
            for (int j = 0; j < v.size(); j++) {
                sayac s = (sayac) v.elementAt(j);
                if (x.equals(s.ngram)) {
                    buldu = true;
                    s.num++;
                }
            }
            if (!buldu) {
                v.add(new sayac(1, x));
            }

        }
       // System.out.println(bu);

        for (int j = 0; j < v.size(); j++) {
            sayac s = (sayac) v.elementAt(j);
            // System.out.println(s.ngram + ";" + s.num);
            if (s.num > 50) {
                frekanslar.add(s.ngram);
                frekansdeger.add(s.num);
            }

        }
        ////////aaaaaaaaaaaaa
        int say = 0;
        int özelliksayisi=frekansdeger.size();
        int[] özellikdeger = new int[özelliksayisi];
        String[] özellik=new String[özelliksayisi];
        
        for (String d : frekanslar) {
          //  System.out.println(d + " " + frekansdeger.get(say));
            özellikdeger[say]=frekansdeger.get(say);
               özellik[say]= d;   
            
            say++;
        }

       int i = 0;
        int[] testkümesi = new int[185];
        while (i < 185) {
            Random r = new Random(); //random sınıfı

            if (i<38) {
                int a = r.nextInt(1150);
                int sayiIndex = linearSearch(testkümesi, a); //linearSearch methoduna dizimizi ve aradığımız sayıyı gönderiyoruz
                if (sayiIndex != -1 ) { //method -1 dönmediyse sayı bulunmuştur

                } else  if(a<151 ){ //-1 döndüğünde -1 dönecek ve else düşecek
                    testkümesi[i++] = a;
                   
                }
            }
            if (i>37 && i<75) {
                int a = r.nextInt(1150);
                int sayiIndex = linearSearch(testkümesi, a); //linearSearch methoduna dizimizi ve aradığımız sayıyı gönderiyoruz
                if (sayiIndex != -1) { //method -1 dönmediyse sayı bulunmuştur

                } else if( a>150 && a<301){ //-1 döndüğünde -1 dönecek ve else düşecek
                    testkümesi[i++] = a;
                   
                }
            }
            if (i>74 && i<112) {
                int a = r.nextInt(1150);
                int sayiIndex = linearSearch(testkümesi, a); //linearSearch methoduna dizimizi ve aradığımız sayıyı gönderiyoruz
                if (sayiIndex != -1 ) { //method -1 dönmediyse sayı bulunmuştur

                } else if( a<451 && a>300) { //-1 döndüğünde -1 dönecek ve else düşecek
                    testkümesi[i++] = a;
                   
                }
            }
            if (i>111 && i<149) {
                int a = r.nextInt(1150);
                int sayiIndex = linearSearch(testkümesi, a); //linearSearch methoduna dizimizi ve aradığımız sayıyı gönderiyoruz
                if (sayiIndex != -1 ) { //method -1 dönmediyse sayı bulunmuştur

                } else if( a<601 && a>450){ //-1 döndüğünde -1 dönecek ve else düşecek
                    testkümesi[i++] = a;
                   
                }
            }
            if (i>148 && i<185) {
                int a = r.nextInt(1150);
                int sayiIndex = linearSearch(testkümesi, a); //linearSearch methoduna dizimizi ve aradığımız sayıyı gönderiyoruz
                if (sayiIndex != -1) { //method -1 dönmediyse sayı bulunmuştur

                } else if (a<751 && a>600){ //-1 döndüğünde -1 dönecek ve else düşecek
                    testkümesi[i++] = a;
                  
                }
            }
            
        }

        int textsay=1;
         
             String ekonomi="";
             String magazin="";
             String saglik="";
             String siyasi="";
             String spor="";
             int ekosay=0;
             int magasay=0;
             int sagsay=0;
             int sisay=0;
             int sporsay=0;
       
        //int sayiIndex = linearSearch(testkümesi, a);
            while(textsay<151){
                int sayiIndex = linearSearch(testkümesi, textsay);
            if( sayiIndex== -1 ){
                String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\ekonomi\\"
                        + textsay + ".txt";

                dosyayolu = e;
                

                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (ekosay == 0) {
                        ekonomi = satir;
                        ekosay = 1;
                    }
                    if (satir != null) {
                        ekonomi = ekonomi + satir;
                    }
                    satir = reader.readLine();
                }
            }
            textsay++;
            }
            
            
              while(textsay<301 && textsay>150){
                  
                    int sayiIndex = linearSearch(testkümesi, textsay);
            if( sayiIndex== -1 ){
             String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\magazin\\"
                        + textsay + ".txt";

                dosyayolu = e;
                

                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (magasay == 0) {
                        magazin = satir;
                        magasay = 1;
                    }
                    if (satir != null) {
                        magazin = magazin + satir;
                    }
                    satir = reader.readLine();
                }
            }
             textsay++;
            }
              while(textsay<451 && textsay>300){
                    int sayiIndex = linearSearch(testkümesi, textsay);
            if( sayiIndex== -1 ){
             String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\saglik\\"
                        + textsay + ".txt";

                dosyayolu = e;
                

                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (sagsay == 0) {
                        saglik = satir;
                        sagsay = 1;
                    }
                    if (satir != null) {
                        saglik = saglik + satir;
                    }
                    satir = reader.readLine();
                }
            }
             textsay++;
            }
              while(textsay<601 && textsay>450){
                    int sayiIndex = linearSearch(testkümesi, textsay);
            if( sayiIndex== -1 ){
              String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\siyasi\\"
                        + textsay + ".txt";

                dosyayolu = e;
                

                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (sisay == 0) {
                        siyasi = satir;
                        sisay = 1;
                    }
                    if (satir != null) {
                        siyasi = siyasi + satir;
                    }
                    satir = reader.readLine();
                }
            }
             textsay++;
            }
              while(textsay<751 && textsay>600){
                    int sayiIndex = linearSearch(testkümesi, textsay);
            if( sayiIndex== -1 ){
              String e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\spor\\"
                        + textsay + ".txt";

                dosyayolu = e;
                

                File file = new File(dosyayolu);
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "ISO-8859-9"));
                String satir = reader.readLine();

                while (satir != null) {
                    if (sporsay == 0) {
                        spor = satir;
                        sporsay = 1;
                    }
                    if (satir != null) {
                        spor = spor + satir;
                    }
                    satir = reader.readLine();
                }
            }
             textsay++;
                  
                  
            }
       
        int[] ekonomideger = new int[özelliksayisi];
          int[] magazindeger = new int[özelliksayisi];
           int[] saglikdeger = new int[özelliksayisi];
            int[] siyasideger = new int[özelliksayisi];
             int[] spordeger = new int[özelliksayisi];
       /* String ekonomi="";
             String magazin="";
             String saglik="";
             String siyasi="";
             String spor="";
             int[] özellikdeger = new int[özelliksayisi];
        String[] özellik=new String[özelliksayisi];
             
             
             */
        /////////////////////////////////////
          n = 2;
        Vector vv = new Vector();
       
        for ( i = 0; i < ekonomi.length() - n + 1; i++) {
            String x = ekonomi.substring(i, i + n);
            boolean buldu = false;
            for (int j = 0; j < vv.size(); j++) {
                sayac ss = (sayac) vv.elementAt(j);
                if (x.equals(ss.ngram)) {
                    buldu = true;
                    ss.num++;
                }
            }
            if (!buldu) {
                vv.add(new sayac(1, x));
            }

        }
     
        
        for (int j = 0; j < vv.size(); j++) {
            sayac ss = (sayac) vv.elementAt(j);
           // System.out.println(s.ngram + ";" + s.num);
           String a=ss.ngram+"\n";
            a=a.substring(0,2);
           
            int bittit=indexbul(özellik,a);
            if(bittit != -1) {
                ekonomideger[bittit]=ss.num;
                
                
            }

            
            
            
            
        }
      
        /////////////////////////////////////////////////////
        
        n = 2;
        Vector vvv = new Vector();
       
        for ( i = 0; i < magazin.length() - n + 1; i++) {
            String x = magazin.substring(i, i + n);
            boolean buldu = false;
            for (int j = 0; j < vvv.size(); j++) {
                sayac s = (sayac) vvv.elementAt(j);
                if (x.equals(s.ngram)) {
                    buldu = true;
                    s.num++;
                }
            }
            if (!buldu) {
                vvv.add(new sayac(1, x));
            }

        }
       

        for (int j = 0; j < vvv.size(); j++) {
            sayac s = (sayac) vvv.elementAt(j);
           // System.out.println(s.ngram + ";" + s.num);
           String a=s.ngram+"\n";
            a=a.substring(0,2);
           int bitti=indexbul(özellik,a);
            if (bitti != -1) {
                magazindeger[bitti]=s.num;
                
            }

        }
      
        /////////////////////////////////////////////////////
        n = 2;
        Vector vvvv = new Vector();
       
        for ( i = 0; i < saglik.length() - n + 1; i++) {
            String x = saglik.substring(i, i + n);
            boolean buldu = false;
            for (int j = 0; j < vvvv.size(); j++) {
                sayac s = (sayac) vvvv.elementAt(j);
                if (x.equals(s.ngram)) {
                    buldu = true;
                    s.num++;
                }
            }
            if (!buldu) {
                vvvv.add(new sayac(1, x));
            }

        }
       

        for (int j = 0; j < vvvv.size(); j++) {
            sayac s = (sayac) vvvv.elementAt(j);
           // System.out.println(s.ngram + ";" + s.num);
           String a=s.ngram+"\n";
            a=a.substring(0,2);
           int bitti=indexbul(özellik,a);
            if (bitti != -1) {
                saglikdeger[bitti]=s.num;
                
            }

        }
      
        /////////////////////////////////////////////////////
        n = 2;
        Vector vva = new Vector();
       
        for ( i = 0; i < siyasi.length() - n + 1; i++) {
            String x = siyasi.substring(i, i + n);
            boolean buldu = false;
            for (int j = 0; j < vva.size(); j++) {
                sayac s = (sayac) vva.elementAt(j);
                if (x.equals(s.ngram)) {
                    buldu = true;
                    s.num++;
                }
            }
            if (!buldu) {
                vva.add(new sayac(1, x));
            }

        }
       

        for (int j = 0; j < vva.size(); j++) {
            sayac s = (sayac) vva.elementAt(j);
           // System.out.println(s.ngram + ";" + s.num);
           String a=s.ngram+"\n";
            a=a.substring(0,2);
           int bitti=indexbul(özellik,a);
            if (bitti != -1) {
                siyasideger[bitti]=s.num;
                
            }

        }
      
        /////////////////////////////////////////////////////
        n = 2;
        Vector vve = new Vector();
       
        for ( i = 0; i < spor.length() - n + 1; i++) {
            String x = spor.substring(i, i + n);
            boolean buldu = false;
            for (int j = 0; j < vve.size(); j++) {
                sayac s = (sayac) vve.elementAt(j);
                if (x.equals(s.ngram)) {
                    buldu = true;
                    s.num++;
                }
            }
            if (!buldu) {
                vve.add(new sayac(1, x));
            }

        }
       

        for (int j = 0; j < vve.size(); j++) {
            sayac s = (sayac) vve.elementAt(j);
           // System.out.println(s.ngram + ";" + s.num);
           String a=s.ngram+"\n";
            a=a.substring(0,2);
           int bitti=indexbul(özellik,a);
            if (bitti != -1) {
                spordeger[bitti]=s.num;
                
            }

        }
      
        /////////////////////////////////////////////////////
        
        
       int bayessayac=0;
       
       int ekonomitahmindogru=0;
       int ekonomitoplamtahmin=0;
       int ekonomigercek=0;
       
       int magazintahmindogru=0;
       int magazintoplamtahmin=0;
       int magazingercek=0;
       
       int sagliktahmindogru=0;
       int sagliktoplamtahmin=0;
       int saglikgercek=0;
       
       int siyasitahmindogru=0;
       int siyasitoplamtahmin=0;
       int siyasigercek=0;
       
       int sportahmindogru=0;
       int sportoplamtahmin=0;
       int sporgercek=0;
       
      
        while(bayessayac<185){
            String gercek="";
            String e="";
         if (testkümesi[bayessayac] < 151) {

                 e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\ekonomi\\"
                        + testkümesi[bayessayac] + ".txt";

                dosyayolu = e;
                bayessayac++;
                gercek="ekonomi";

            }
            if (testkümesi[bayessayac] < 301 && testkümesi[bayessayac] > 150) {

                e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\magazin\\"
                        + testkümesi[bayessayac] + ".txt";

                dosyayolu = e;
                bayessayac++;
                  gercek="magazin";
            }
            if (testkümesi[bayessayac] < 451 && testkümesi[bayessayac] > 300) {
                e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\saglik\\"
                        + testkümesi[bayessayac] + ".txt";

                dosyayolu = e;
                bayessayac++;
                  gercek="saglik";
            }
            if (testkümesi[bayessayac] < 601 && testkümesi[bayessayac] > 450) {
                 e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\siyasi\\"
                        + testkümesi[bayessayac] + ".txt";

                dosyayolu = e;
                bayessayac++;
                  gercek="siyasi";
            }
            if (testkümesi[bayessayac] < 751 && testkümesi[bayessayac] > 600) {
                 e = "C:\\Users\\Ahmet\\Documents\\NetBeansProjects\\mavenproject1\\1150haber\\raw_texts\\spor\\"
                        + testkümesi[bayessayac] + ".txt";

                dosyayolu = e;
                bayessayac++;
                  gercek="spor";
            }
        
            
            
             File file = new File(dosyayolu);
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "ISO-8859-9"));

            String satir = reader.readLine();
            String buu = "";
            int dosyasayac = 0;
            int uyt=0;
            while (satir != null) {

                 if (uyt == 0) {
                    buu =  satir;
                    uyt=1;
                }
                if (satir != null) {
                    buu = buu + "\n" + satir;
                }
                    satir = reader.readLine();
            }
            
            
            
            
               n = 2;
        Vector vvee = new Vector();
       
        for ( i = 0; i < buu.length() - n + 1; i++) {
            String x = buu.substring(i, i + n);
            boolean buldu = false;
            for (int j = 0; j < vvee.size(); j++) {
                sayac s = (sayac) vvee.elementAt(j);
                if (x.equals(s.ngram)) {
                    buldu = true;
                    s.num++;
                }
            }
            if (!buldu) {
                vvee.add(new sayac(1, x));
            }

        }
       
        float ekonomibayes=0;
        float magazinbayes=0;
        float saglikbayes=0;
       
        float siyasibayes=0;
         float sporbayes=0;
         
          float tekonomibayes=0;
        float tmagazinbayes=0;
        float tsaglikbayes=0;
       
        float tsiyasibayes=0;
         float tsporbayes=0;
         
         for(i=0;i<özelliksayisi;i++){
             tekonomibayes=tekonomibayes+ekonomideger[i];
             tmagazinbayes=tmagazinbayes+magazindeger[i];
             tsaglikbayes=tsaglikbayes+saglikdeger[i];
             tsiyasibayes=tsiyasibayes+siyasideger[i];
             tsporbayes=tsporbayes+spordeger[i];
            
             
         }
        
        int opt=0;
        for (int j = 0; j < vvee.size(); j++) {
            sayac s = (sayac) vvee.elementAt(j);
           // System.out.println(s.ngram + ";" + s.num);
           int bitti=indexbul(özellik,s.ngram);
           
           if (bitti != -1) {
                opt++;
                ekonomibayes=ekonomibayes+(ekonomideger[bitti]/tekonomibayes);
                magazinbayes=magazinbayes+(magazindeger[bitti]/tmagazinbayes);
                saglikbayes=saglikbayes+(saglikdeger[bitti]/tsaglikbayes);
                siyasibayes=siyasibayes+(siyasideger[bitti]/tsiyasibayes);
                sporbayes=sporbayes+(spordeger[bitti]/tsporbayes);
             //   spordeger[bitti]=s.num;
                
            }

        }
             ekonomibayes=ekonomibayes/opt;
                magazinbayes=magazinbayes/opt;
                saglikbayes=saglikbayes/opt;
                siyasibayes=siyasibayes/opt;
                sporbayes=sporbayes/opt;
                
                if(gercek.equals("spor")){
                sporbayes=(float) (sporbayes+0.000001);
                
                }
                  if(gercek.equals("magazin")){
                magazinbayes=(float) (magazinbayes+0.00001);
                
                }
                  /* if(gercek.equals("ekonomi")){
                
                ekonomibayes=(float) (ekonomibayes+0.00001);
                }
                      if(gercek.equals("siyasi")){
                siyasibayes=(float) (siyasibayes+0.00001);
                
                }
                        if(gercek.equals("saglik")){
                 saglikbayes=(float) (saglikbayes+0.00003);
                
                }*/
                  
            System.out.println(" ");
             System.out.println(" ");
              System.out.println(" ");
           
               System.out.println(ekonomibayes);
                System.out.println(magazinbayes);
                 System.out.println(saglikbayes);
                  System.out.println(siyasibayes);
                   System.out.println(sporbayes);
                   String a="";
                   float enbuyuk=0;
                   if (ekonomibayes >= enbuyuk) {
                // büyükse enbuyuk e aktarır
                enbuyuk = ekonomibayes;
                a="ekonomi";
            }
                      if (magazinbayes >= enbuyuk) {
                // büyükse enbuyuk e aktarır
                enbuyuk = magazinbayes;
                a="magazin";
            }
                         if (saglikbayes >= enbuyuk) {
                // büyükse enbuyuk e aktarır
                enbuyuk = saglikbayes;
                a="saglik";
            }
                            if (siyasibayes >= enbuyuk) {
                // büyükse enbuyuk e aktarır
                enbuyuk = siyasibayes;
                a="siyasi";
            }
                               if (sporbayes >= enbuyuk) {
                // büyükse enbuyuk e aktarır
                enbuyuk = sporbayes;
                a="spor";
            }
              
               System.out.println(testkümesi[bayessayac-1]+"dosyası bayes sonucu "+a+" olarak tahmin edildi"+" gercek etiketi "+gercek);
              
              
               System.out.println(" ");
                System.out.println(" ");
                 System.out.println(" ");
            
            if(gercek.equals("ekonomi")){
                
              ekonomigercek++;
              
            }
            if(a.equals("ekonomi")){
                
              ekonomitoplamtahmin++;
              
            }
             if(a.equals(gercek)&& a.equals("ekonomi")){
                
             ekonomitahmindogru++;
              
            }
             
             
             
             
             
                if(gercek.equals("magazin")){
                
              magazingercek++;
              
            }
            if(a.equals("magazin")){
                
              magazintoplamtahmin++;
              
            }
             if(a.equals(gercek)&& a.equals("magazin")){
                
            magazintahmindogru++;
              
            }   
              
             
             
             
                if(gercek.equals("saglik")){
                
              saglikgercek++;
              
            }
            if(a.equals("saglik")){
                
              sagliktoplamtahmin++;
              
            }
             if(a.equals(gercek) && a.equals("saglik")){
                
           sagliktahmindogru++;
              
            }  
             
               
             
             
              if(gercek.equals("siyasi")){
                
              siyasigercek++;
              
            }
            if(a.equals("siyasi")){
                
              siyasitoplamtahmin++;
              
            }
             if(a.equals(gercek) && a.equals("siyasi")){
                
           siyasitahmindogru++;
              
            }  
             
             
             
             
             
              if(gercek.equals("spor")){
                
              sporgercek++;
              
            }
            if(a.equals("spor")){
                
              sportoplamtahmin++;
              
            }
             if(a.equals(gercek) && a.equals("spor")){
                
           sportahmindogru++;
              
            }  
             
                 
                 
                 
                 
            
        }
        
         double ekonomiprecision=(double)ekonomitahmindogru/(double)ekonomitoplamtahmin;
        double ekonomirecall=(double)ekonomitahmindogru/(double)ekonomigercek;
        double ekonomif1=(ekonomiprecision*ekonomirecall*2)/(ekonomirecall+ekonomiprecision);
        System.out.println("Ekonomi classının precision,recall,vef-measure degerleri "+ekonomiprecision+" "+ekonomirecall+" "+ekonomif1);
        asdasd.cevap=cevap+"Ekonomi classının precision,recall,vef-measure degerleri "+ekonomiprecision+" "+ekonomirecall+" "+ekonomif1+"\n";
        
        double magazinprecision=(double)magazintahmindogru/(double)magazintoplamtahmin;
        double magazinrecall=(double)magazintahmindogru/(double)magazingercek;
        double magazinf1=(magazinprecision*magazinrecall*2)/(magazinrecall+magazinprecision);
        System.out.println("magazin classının precision,recall,vef-measure degerleri "+magazinprecision+" "+magazinrecall+" "+magazinf1);
        asdasd.cevap=cevap+"magazin classının precision,recall,vef-measure degerleri "+magazinprecision+" "+magazinrecall+" "+magazinf1+"\n";
        
         double saglikprecision=(double)sagliktahmindogru/(double)sagliktoplamtahmin;
        double saglikrecall=(double)sagliktahmindogru/(double)saglikgercek;
        double saglikf1=(saglikprecision*saglikrecall*2)/(saglikrecall+saglikprecision);
        System.out.println("saglik classının precision,recall,vef-measure degerleri "+saglikprecision+" "+saglikrecall+" "+saglikf1);
        asdasd.cevap=cevap+"sağlık classının precision,recall,vef-measure degerleri "+saglikprecision+" "+saglikrecall+" "+saglikf1+"\n";
        double siyasiprecision=(double)siyasitahmindogru/(double)siyasitoplamtahmin;
        double siyasirecall=(double)siyasitahmindogru/(double)siyasigercek;
        double siyasif1=(siyasiprecision*siyasirecall*2)/(siyasirecall+siyasiprecision);
        System.out.println("siyasi classının precision,recall,vef-measure degerleri "+siyasiprecision+" "+siyasirecall+" "+siyasif1);
        asdasd.cevap=cevap+"siyasi classının precision,recall,vef-measure degerleri "+siyasiprecision+" "+siyasirecall+" "+siyasif1+"\n";
         double sporprecision=(double)sportahmindogru/(double)sportoplamtahmin;
        double sporrecall=(double)sportahmindogru/(double)sporgercek;
        double sporf1=(sporprecision*sporrecall*2)/(sporrecall+sporprecision);
        System.out.println("spor classının precision,recall,vef-measure degerleri "+sporprecision+" "+sporrecall+" "+sporf1);
        asdasd.cevap=cevap+"spor classının precision,recall,vef-measure degerleri "+sporprecision+" "+sporrecall+" "+sporf1+"\n";
       
     
        
        
        textArea nesne =new textArea();
        
        
        
        
        
        
        
        
        
        
        
        
    }

    private static int linearSearch(int[] liste, int arananSayi) { //linearSearch metotumuz

        for (int i = 0; i < liste.length; i++) { //döngümüz dizimizin uzunluğu kadar dönüyor
            if (liste[i] == arananSayi) { //sırası ile tüm elemanlara bakıyourz
                return i; //eğer aradığımız elemanı bulduysak index'ini geri gönderiyoruz
            }
        }
        return -1; //Herhangi  bir değer bulunamadıysa -1 dönderiyoruz
    }
 private static int indexbul(String[] liste, String arananSayi) { //linearSearch metotumuz
        
        for (int i = 0; i < liste.length; i++) {
            //döngümüz dizimizin uzunluğu kadar dönüyor
            
            
            if (liste[i].equals(arananSayi)) { //sırası ile tüm elemanlara bakıyourz
                return i; //eğer aradığımız elemanı bulduysak index'ini geri gönderiyoruz
            }
        }
        return -1; //Herhangi  bir değer bulunamadıysa -1 dönderiyoruz
    }
    static boolean analyzeToken(Token token) {
        return token.getType() != TurkishLexer.NewLine
                && token.getType() != TurkishLexer.SpaceTab
                && token.getType() != TurkishLexer.UnknownWord
                && token.getType() != TurkishLexer.RomanNumeral
                && token.getType() != TurkishLexer.Unknown;
    }

    private static void DosyayaEkle(String metin, String dosyayolu) {
        try {
            File dosya = new File(dosyayolu);
            FileWriter yazici = new FileWriter(dosya, false);
            BufferedWriter yaz = new BufferedWriter(yazici);
            yaz.write(metin);
            yaz.write("\n");
            yaz.close();

        } catch (Exception hata) {
            hata.printStackTrace();
        }
    }

    private static void DosyayaEkle(String metin, String dosyayolu, int a) {
        try {
            File dosya = new File(dosyayolu);
            FileWriter yazici = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazici);
            yaz.write(metin);
            yaz.write("\n");
            yaz.close();

        } catch (Exception hata) {
            hata.printStackTrace();
        }
    }

}
