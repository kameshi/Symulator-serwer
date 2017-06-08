package bazaDanych;

public class DaneAut {
    String numerRej, marka, model;
    Double przejechaneKM;
    Integer moc, rok, pojemnosc;

    public DaneAut(){}
    public DaneAut(String numerRej, String marka, String model, Double przejechaneKM, Double spalanie, Integer moc, Integer rok, Integer pojemnosc){
        this.numerRej = numerRej;
        this.marka = marka;
        this.model = model;
        this.przejechaneKM = przejechaneKM;
        this.moc = moc;
        this.rok = rok;
        this.pojemnosc = pojemnosc;
    }
    public void setPrzejechaneKM(Double przejechaneKM) {
        this.przejechaneKM = przejechaneKM;
    }
    public String getNumerRej(){
        return numerRej;
    }
    public String getMarka(){
        return marka;
    }
    public String getModel(){
        return model;
    }
    public Double getPrzejechaneKM(){
        return przejechaneKM;
    }
    public Integer getMoc(){
        return moc;
    }
    public Integer getRok(){
        return rok;
    }
    public Integer getPojemnosc(){
        return pojemnosc;
    }
}
