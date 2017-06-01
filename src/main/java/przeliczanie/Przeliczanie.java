package przeliczanie;

import obslugaBazy.ObslugaBazy;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Przeliczanie {
/*
	private ObslugaBazy baza = new ObslugaBazy();
    private String wynik;
    public Przeliczanie() throws SQLException, ClassNotFoundException {
        baza.odczyt();
    }
    private String konwersja(Double liczba){
        return liczba.toString();
    }
    private Double konwersja(String napis){
        return Double.valueOf(napis);
    }
    private String srednie(String rodzajPaliwa , String rodzajSilnika){
        double pom;
        if(rodzajPaliwa.equals("gaz")){
            pom = konwersja(rodzajSilnika) * 3;
            return konwersja(pom);
        }else if(rodzajPaliwa.equals("benzyna")){
            pom = konwersja(rodzajSilnika) * 2;
            return konwersja(pom);
        }else if(rodzajPaliwa.equals("diesel")){
            pom = konwersja(rodzajSilnika);
            return konwersja(pom);
        }else if(rodzajPaliwa.equals("hybryda")){
            pom = konwersja(rodzajSilnika)/2;
            return konwersja(pom);
        }else{
            return null;
        }
    }
/*
	public String dzialanie(String marka , String model , String iloscKM , String rodzajPaliwa , String rodzajSilnika) throws FileNotFoundException{
		p.odczyt();
		double pom;
		if((pom = p.wyszukanie(marka, model , rodzajPaliwa , konwersja(rodzajSilnika))) == -1){
			String srednieSpalanie = srednie(rodzajPaliwa, rodzajSilnika);
			p.zapis(marka, model , rodzajPaliwa , konwersja(rodzajSilnika) , konwersja(srednieSpalanie));
			return konwersja((konwersja(srednieSpalanie)/konwersja(iloscKM))*100);
		}else{
			return konwersja((pom/konwersja(iloscKM))*100);
		}
	}
	private String srednie(String rodzajPaliwa , String rodzajSilnika){
		double pom;
		if(rodzajPaliwa.equals("gaz")){
			pom = konwersja(rodzajSilnika) * 3;
			return konwersja(pom);
		}else if(rodzajPaliwa.equals("benzyna")){
			pom = konwersja(rodzajSilnika) * 2;
			return konwersja(pom);
		}else if(rodzajPaliwa.equals("diesel")){
			pom = konwersja(rodzajSilnika);
			return konwersja(pom);
		}else if(rodzajPaliwa.equals("hybryda")){
			pom = konwersja(rodzajSilnika)/2;
			return konwersja(pom);
		}else{
			return null;
		}
	}
	*/
}
