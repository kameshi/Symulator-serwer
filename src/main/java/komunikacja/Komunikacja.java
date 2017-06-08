package komunikacja;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

import bazaDanych.BazaDanych;
import bazaDanych.DaneAut;
import bazaDanych.ObslugaBazyDanych;

public class Komunikacja implements Runnable{
    ObjectInputStream czytelnik;
    Socket gniazdo;
    ObjectOutputStream pisarz;
    BazaDanych baza = new BazaDanych();
    ObslugaBazyDanych obslugaBazy = new ObslugaBazyDanych();

    public Komunikacja(Socket gniazdoKlienta){
        try{
            gniazdo = gniazdoKlienta;
            czytelnik = new ObjectInputStream(gniazdo.getInputStream());
            pisarz = new ObjectOutputStream(gniazdo.getOutputStream());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void run() {
        String semafor = null;
        try{
            semafor =(String) czytelnik.readObject();
                if(semafor.equals("nowe")){
                    noweAuto();
                }else if(semafor.equals("stare")){
                    stareAuto();
                }else if(semafor.equals("historia")){
                    historia();
                }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void stareAuto() throws SQLException, ClassNotFoundException, IOException {
        ListaPomocnicza list = new ListaPomocnicza();
        //baza = obslugaBaza.odczyt();
        for(int i = 0; i<baza.size(); i++) {
            list.set(baza.getNumerRej(i));
        }
        //rozeslanie(list);
        String komunikat;
        Double kiloMetry;
        int j = 0;
        komunikat =(String) czytelnik.readObject();
        kiloMetry =(Double) czytelnik.readObject();
        DaneAut auto = new DaneAut();
        for(int i = 0; i<baza.size(); i++) {
            if (baza.getNumerRej(i) == komunikat) {
                auto = baza.getObject(i);
                j = i;
            }
        }
        //Obliczania wynik = new Obliczenie(auto);
        //rozeslanie(wynik.dzialanie(kiloMetry));
        //baza.setPrzejechaneKM(auto.getPrzejechaneKM(), j);
        //obslugaBaza.zapis(baza);
    }
    private void noweAuto() throws IOException, SQLException, ClassNotFoundException {
        DaneAut auto; //= new DaneAut();
        auto =(DaneAut) czytelnik.readObject();
        Boolean kontrol = true;
        //baza = obslugaBaza.odczyt();;
        for(int i = 0; i<baza.size(); i++) {
            if (baza.getObject(i).equals(auto)) {
                kontrol = false;
            }
        }
        if(kontrol){
            //baza.add(auto);
            //obslugaBaza.zapis(baza);
        }
    }
    private void historia(){
        //baza = obslugaBaza.odczyt();;
        //rozeslanie(baza)
    }
    private void rozeslanie(Double liczba){
            try{
                pisarz.writeObject(liczba);
            }catch(Exception ex){ex.printStackTrace();}
    }
    private void rozeslanie(BazaDanych baza){
            try{
                pisarz.writeObject(baza);
            }catch(Exception ex){ex.printStackTrace();}
    }
    private void rozeslanie(ListaPomocnicza list){
            try{
                pisarz.writeObject(list);
            }catch(Exception ex){ex.printStackTrace();}
    }
}