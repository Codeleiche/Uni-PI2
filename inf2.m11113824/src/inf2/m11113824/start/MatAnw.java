package inf2.m11113824.start;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MatAnw
{

	public static void main(String[] args)
	{
		Mat test1 = new Mat();
		Mat test2 = new Mat();
		Mat fin = new Mat();

		try {
			FileReader fr1 = new FileReader("MatrixCSV1.txt");
			test1 = new Mat(new BufferedReader(fr1));
			fr1.close();
			fr1 = new FileReader("MatrixCSV2.txt");
			test2 = new Mat(new BufferedReader(fr1));
			fr1.close();
		} catch (FileNotFoundException e) {

			System.out.println("Eine oder mehrere Dateien konnten nicht gefunden werden");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fin = test1.matMul(test2);
		try {
			FileWriter fw = new FileWriter("Ergebniss.txt");
			fin.matAus(fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
