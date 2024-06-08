package org.example.kelimeler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KelimeIslemleri {
    String[] kelimeDizisi = {"masa", "dolap", "televizyon", "yastık", "koltuk", "lamba"};
    List<String> tekrarliKelimeListesi = new ArrayList<>();
    List<Character> harfListesi = new ArrayList<>();

    public void tekrarliKelimeBul() {
        for (String kelime : kelimeDizisi) {
            if (tekrarliHarf(kelime)) {
                tekrarliKelimeListesi.add(kelime);
                if (tekrarliKelimeListesi.size() == 2) {
                    break;
                }
            }
        }
        System.out.println("Kelime Dizisi: " + Arrays.toString(kelimeDizisi));
        System.out.println("Tekrar eden harf içeren kelimeler: " + tekrarliKelimeListesi);
    }

    public void metinOlustur() {
        if (tekrarliKelimeListesi.size() < 2) {
            System.out.println("Tekrarlı harf içeren 2 adet kelime bulunamadı.");
            return;
        }

        String kelime1 = tekrarliKelimeListesi.get(0);
        String kelime2 = tekrarliKelimeListesi.get(1);
        String sonKelime = kelime1 + kelime2;

        for (char harf : sonKelime.toCharArray()) {
            harfListesi.add(harf);
        }

        System.out.println("Harf Listesi: " + harfListesi);
        String rastgeleMetin = rastgeleMetinOlustur(harfListesi);
        System.out.println("Oluşturulan metin: " + rastgeleMetin);
    }

    public boolean tekrarliHarf(String kelime) {
        List<Character> harfListesi = new ArrayList<>();
        for (int i = 0; i < kelime.length(); i++) {
            char harf = kelime.charAt(i);
            if (harfListesi.contains(harf)) {
                return true;
            }
            harfListesi.add(harf);
        }
        return false;
    }

    public String rastgeleMetinOlustur(List<Character> harfListesi) {
        Random random = new Random();
        StringBuilder metin = new StringBuilder();
        for (int i = 0; i < harfListesi.size(); i++) {
            char rastgeleHarf = harfListesi.get(random.nextInt(harfListesi.size()));
            metin.append(rastgeleHarf);
        }
        return metin.toString();
    }
}
