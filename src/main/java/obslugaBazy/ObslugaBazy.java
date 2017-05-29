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
		System.out.println("Marka:");
		while (result.next()) {
			markaList.add(new Marka(result.getInt(1), result.getString(2)));
			System.out.println(markaList.get(i).toString());
			i++;
		}
		result = stmt.executeQuery("SELECT * FROM MODEL");
		i = 0;
		System.out.println("\nModel:");
		while (result.next()) {
			modelList.add(new Model(result.getInt(1), result.getInt(2), result.getString(3)));
			System.out.println(modelList.get(i).toString());
			i++;
		}
		result = stmt.executeQuery("SELECT * FROM SAMOCHOD");
		i = 0;
		System.out.println("\nSamochod:");
		while (result.next()) {
			samochodList.add(new Samochod(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)));
			System.out.println(samochodList.get(i).toString());
			i++;
		}
		result = stmt.executeQuery("SELECT * FROM Spalanie");
		i = 0;
		System.out.println("\nSpalanie:");
		while (result.next()) {
			spalanieList.add(new Spalanie(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4)));
			System.out.println(spalanieList.get(i).toString());
			i++;
		}
	}
}

