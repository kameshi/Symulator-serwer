package komunikacja;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.*;

import obslugaBazy.ObslugaBazy;
import przeliczanie.Przeliczanie;

public class ObslugaKlienta implements Runnable{
	BufferedReader czytelnik;
	Socket gniazdo;
	ArrayList<PrintWriter> strumien;
	
	private void getList(){
		ArrayList<PrintWriter> strumien = new ArrayList<PrintWriter>();
		this.strumien = strumien;
	}
	public ObslugaKlienta(Socket gniazdoKlienta, PrintWriter pisarz){
		try{
			gniazdo = gniazdoKlienta;
			InputStreamReader isReader = new InputStreamReader(gniazdo.getInputStream());
			czytelnik= new BufferedReader(isReader);
			getList();
			strumien.add(pisarz);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void rozeslanie(String wiadomosc){
		Iterator<PrintWriter> it = strumien.iterator();
		while(it.hasNext()){
			try{
				PrintWriter pisarz = (PrintWriter) it.next();
				pisarz.println(wiadomosc);
				pisarz.flush();
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
	public void run() {
		String semafor;

		try{
			while( (semafor = czytelnik.readLine()) != null) {
				if(!semafor.equals("stare")){
					noweAuto();
				}else if(semafor.equals("stare")){
					stareAuto();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void stareAuto() throws SQLException, ClassNotFoundException, IOException {
		ObslugaBazy baza = new ObslugaBazy();
		baza.odczyt();
		Integer id = 0,sizeI = baza.sizeMarka();
		rozeslanie(sizeI.toString());//wysyłanie marki
		for(int i = 0; i < baza.sizeMarka(); i++){
			rozeslanie(baza.getMarka(i));
		}//wysyłanie marki koniec
		String wiadomosc;//wysyłanie modelu
		while ((wiadomosc = czytelnik.readLine()) != null) {
			for(int i = 0; i < baza.sizeMarka(); i++){
				if(baza.getMarka(i).equals(wiadomosc)){
					id = baza.getIdMarka(i);
					break;
				}
			}
			rozeslanie(baza.sizeMarkaModel(id));
			for(int i = 0; i < baza.sizeModel(); i++){
				if(baza.getIdMarkaModel(i) == id){
					rozeslanie(baza.getModel(i));
				}
			}//wysyłanie modelu koniec
			while ((wiadomosc = czytelnik.readLine()) != null) {//wysyłanie rodzaju paliwa
				for (int i = 0; i < baza.sizeModel(); i++) {
					if (baza.getModel(i).equals(wiadomosc)) {
						id = baza.getIdModel(i);
						break;
					}
				}
				rozeslanie(baza.sizeModelSamochod(id));
				for(int i = 0; i < baza.sizeSamochod(); i++){
					if(baza.getIdModelSamochod(i) == id){
						rozeslanie(baza.getRodzajPaliwa(i));
					}
				}//wysyłanie rodzaju paliwa koniec
				/*
				while ((wiadomosc = czytelnik.readLine()) != null) {
					for (int i = 0; i < baza.sizeModel(); i++) {
						if (baza.getModel(i).equals(wiadomosc)) {
							id = baza.getIdModel(i);
							break;
						}
					}
					rozeslanie(baza.sizeModelSamochod(id));
					for(int i = 0; i < baza.sizeSamochod(); i++){
						if(baza.getIdModelSamochod(i) == id){
							rozeslanie(baza.getRodzajPaliwa(i));
						}
					}
				}
				*/
			}
		}
	}
	private void noweAuto() throws IOException, SQLException, ClassNotFoundException {
		String marka , model , moc , rok , rodzajPaliwa , pojemnosc , srPredkosc , km;
		while ((marka = czytelnik.readLine()) != null) {
			while ((model = czytelnik.readLine()) != null) {
				while ((moc = czytelnik.readLine()) != null) {
					while ((rok = czytelnik.readLine()) != null) {
						while ((rodzajPaliwa = czytelnik.readLine()) != null) {
							while ((pojemnosc = czytelnik.readLine()) != null) {
								while ((srPredkosc = czytelnik.readLine()) != null) {
									while ((km = czytelnik.readLine()) != null) {
										ObslugaBazy baza = new ObslugaBazy();
										baza.odczyt();
										if(baza.sprawdzanieAuta(marka , model , rodzajPaliwa , pojemnosc , moc , rok)){
											//auto jest przelicz wyslij
										}else {
											//auta nie ma przelicz zapisz dane wyslij
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
