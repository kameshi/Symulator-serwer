package bazaDanych;

import java.util.ArrayList;

public class BazaDanych {
    ArrayList<DaneAut> auto = new ArrayList<DaneAut>();
    public BazaDanych(){}
    public BazaDanych(String numerRej, String marka, String model, Double przejechaneKM, Double spalanie, Integer moc, Integer rok, Integer pojemnosc){
        auto.add(new DaneAut(numerRej, marka, model, przejechaneKM, spalanie, moc, rok, pojemnosc));
    }
    public int size(){
        return auto.size();
    }
    public DaneAut getObject(int i){
        return auto.get(i);
    }
    public void add(DaneAut dane){
        auto.add(dane);
    }
    public void setPrzejechaneKM(Double przejechaneKM ,int i){
        auto.get(i).setPrzejechaneKM(przejechaneKM);
    }
    public String getNumerRej(int i) {
        return auto.get(i).getNumerRej();
    }
}
