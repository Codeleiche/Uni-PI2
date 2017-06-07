package inf2.m11113824.start;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;

public class MaschSerAnw
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		String fileName = "MASCH.TXT", fileSerName = "MASCH.SER";
		LinkedList<MaschineSer> liste = new LinkedList<MaschineSer>();
		ListIterator<MaschineSer> iter;
		maschSerAus(new BufferedReader(new FileReader(fileName)),
				new ObjectOutputStream(new FileOutputStream(fileSerName)));
		maschSerEin(liste, new ObjectInputStream(new FileInputStream("MASCH.SER")));
		System.out.println("hi " + liste.size());
		iter = liste.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().ausMaschCSV());
		}
	}

	@SuppressWarnings("finally")
	public static int maschSerEin(LinkedList<MaschineSer> out, ObjectInputStream os1)
	{
		int lines = 0;
		ListIterator<MaschineSer> iter = out.listIterator();
		System.out.println("maschSerEin");
		try {
			MaschineSer temp = new MaschineSer();
			while ((temp = (MaschineSer) os1.readObject()) != null) {
				System.out.println("Hallo");
				out.add(temp);
				lines++;

			}
			os1.close();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("es wurden " + lines + " Objekte iengelesen");

		} finally {
			return lines;
		}
	}

	@SuppressWarnings("finally")
	public static int maschSerAus(BufferedReader br1, ObjectOutputStream os1)
	{

		int lines = 0;
		String in = "";
		try {
			while ((in = br1.readLine()) != null) {
				os1.writeObject(new MaschineSer(in));
				lines++;
			}
			os1.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return lines;
		}
	}
}
