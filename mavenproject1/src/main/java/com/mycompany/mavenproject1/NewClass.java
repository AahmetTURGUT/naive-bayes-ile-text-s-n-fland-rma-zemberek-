/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;
import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.KelimeTipi;
import net.zemberek.yapi.Kok;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Ahmet
 */
public class NewClass {
     public static void main(String[] args) {

        // Turkiye Turkcesi icin bir adet Zemberek Nesnesi olusturalim.
        Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());

        String giris = "köpek kedilerim";
        out.println("Giris:" + giris);
         System.out.println("köpek");
        // denetleme
        if (!zemberek.kelimeDenetle(giris)) {
            out.println(giris + " kelimesi dogru yazilmamis");
            System.exit(1);
        }
        out.println(giris + " kelimesi dogru yazilmis.\n");

        // cozumleme
        Kelime[] cozumler = zemberek.kelimeCozumle(giris);
        out.println("cozumlemeler:");
        for (Kelime kelime : cozumler)
            out.println(kelime);

    }

}
