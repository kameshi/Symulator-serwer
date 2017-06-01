package obslugaBazy;

import java.io.*;
import java.sql.*;
import java.util.*;

import dane.Marka;
import dane.Model;
import dane.Samochod;
import dane.Spalanie;

public class ObslugaBazy {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:projektjava@//localhost:1521/xe";
	String user = "projektjava";
	String password = "projektjava";
	Connection conection;
	Statement stmt;
	private List<Samochod> samochodList = new ArrayList<Samochod>();
	private List<Marka> markaList = new ArrayList<Marka>();
	private List<Model> modelList = new ArrayList<Model>();
	private List<Spalanie> spalanieList = new ArrayList<Spalanie>();

	public ObslugaBazy() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conection = DriverManager.getConnection(url, user, password);
		stmt = conection.createStatement();
	}

	public void odczyt() throws SQLException {

		ResultSet result = stmt.executeQuery("SELECT * FROM MARKA");
		int i = 0;
		//System.out.println("Marka:");
		while (result.next()) {
			markaList.add(new Marka(result.getInt(1), result.getString(2)));
			//System.out.println(markaList.get(i).toString());
			i++;
		}
		result = stmt.executeQuery("SELECT * FROM MODEL");
		i = 0;
		//System.out.println("\nModel:");
		while (result.next()) {
			modelList.add(new Model(result.getInt(1), result.getInt(2), result.getString(3)));
			//System.out.println(modelList.get(i).toString());
			i++;
		}
		result = stmt.executeQuery("SELECT * FROM SAMOCHOD");
		i = 0;
		//System.out.println("\nSamochod:");
		while (result.next()) {
			samochodList.add(new Samochod(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)));
			//System.out.println(samochodList.get(i).toString());
			i++;
		}
		result = stmt.executeQuery("SELECT * FROM Spalanie");
		i = 0;
		//System.out.println("\nSpalanie:");
		while (result.next()) {
			spalanieList.add(new Spalanie(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4)));
			//System.out.println(spalanieList.get(i).toString());
			i++;
		}
	}
	public boolean sprawdzanieAuta(String marka ,String  model ,String  rodzajPaliwa ,String  pojemnosc ,String moc ,String rokProdukcji) {
		for (int i = 0; i < markaList.size(); i++) {
			if (markaList.get(i).getNazwa().equals(marka)) {
				for (int j = 0; j < modelList.size(); j++) {
					if (modelList.get(j).getNazwa().equals(model)) {
						for (int k = 0; k < samochodList.size(); k++) {
							if (samochodList.get(k).getRodzajPaliwa().equals(rodzajPaliwa)) {
								for (int l = 0; l < samochodList.size(); l++) {
									if (samochodList.get(l).getPojemnosc().equals(pojemnosc)) {
										for (int p = 0; p < samochodList.size(); p++) {
											if (samochodList.get(p).getMoc().equals(moc)) {
												for (int o = 0; o < samochodList.size(); o++) {
													if (samochodList.get(o).getRokProdukcji().equals(rokProdukcji)) {
														return true;
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
		}
		return false;
	}
	public int sizeMarka(){
		return markaList.size();
	}
	public int sizeModel(){
		return modelList.size();
	}
	public int sizeSamochod(){
		return samochodList.size();
	}
	public String getMarka(int i){
		return markaList.get(i).getNazwa();
	}
	public int getIdMarka(int i){
		return markaList.get(i).getIdMarka();
	}
	public int getIdModel(int i){
		return modelList.get(i).getIdModel();
	}
	public String getModel(int i){
		return modelList.get(i).getNazwa();
	}
	public int getIdMarkaModel(int i){
		return modelList.get(i).getIdMarka();
	}
	public int getIdModelSamochod(int i){
		return samochodList.get(i).getIdModel();
	}
	public String getRok(int i){
		return samochodList.get(i).getRokProdukcji();
	}
	public String getRodzajPaliwa(int i){
		return samochodList.get(i).getRodzajPaliwa();
	}
	public String getMoc(int i){
		return samochodList.get(i).getMoc();
	}
	public String getPojemnosc(int i){
		return samochodList.get(i).getPojemnosc();
	}
	public String sizeMarkaModel(Integer id){
		Integer j = 0;
		for(int i = 0; i < sizeModel(); i++){
			if(getIdMarkaModel(i) == id){
				j++;
			}
		}
		return j.toString();
	}
	public String sizeModelSamochod(Integer id){
		Integer j = 0;
		for(int i = 0; i < sizeSamochod(); i++){
			if(getIdModelSamochod(i) == id){
				j++;
			}
		}
		return j.toString();
	}
}

