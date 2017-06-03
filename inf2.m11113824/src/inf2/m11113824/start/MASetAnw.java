package inf2.m11113824.start;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MASetAnw
{
	MASet inter;
	BufferedReader br1;

	public MASetAnw()
	{
	}

	public MASetAnw(BufferedReader br1)
	{
		inter = new MASet();
		this.br1 = br1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		MASet maset = new MASet();
		int iox;
		do {
			System.out.print(
					"wilkommen im MASetAnw Menü. Bitte treffen sie eine Auswahl:\n(1) Einlesen einer Datei\n(2) Ausgabe eines Sets\n(3)Schreiben in eine Datei");
			iox = Integer.parseInt(in.readLine());
			switch (iox) {
				case 1:

					// System.out.println("Bitte geben sie den Namen der
					// einzulesenden Datei ein.");
					//
					// try {
					// String a = in.readLine();
					// maset.br1 = new BufferedReader(new FileReader(a));
					// } catch (FileNotFoundException e) {
					// e.printStackTrace();
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					System.out.println("wollen sie die Datein in ein (1)TreeSet oder (2)HashSet einlesen?");
					switch (Integer.parseInt(in.readLine())) {
						case 1:
							maset.dat2tset(new BufferedReader(new FileReader("MASCH.TXT")));
							break;
						case 2:
							maset.dat2hset(new BufferedReader(new FileReader("MASCH.TXT")));
							break;
						default:
							System.out.println("ihre eingabe konnte nicht erkannt werden");
							break;
					}

					break;
				case 2:
					System.out.println("Bitte wählen sie die set art\n(1) TreeSet\n(2) HashSet");
					String[] set = maset.set2Stringf(Integer.parseInt(in.readLine()));
					for (int i = 0; i < set.length; i++)
						System.out.println(set[i]);
					break;
				case 3:
					System.out.println("wie soll die datei heißen?");
					String name = in.readLine();
					System.out.println("welches set wollen sie ausgeben? \n(1) TreeSet oder \n(2) HashSet");
					maschAus(maset.set2Stringf(Integer.parseInt(in.readLine())), name);
					break;
				default:
					System.out.println("ihre auswahl konnte nicht erkannt werden");
					break;
			}
		} while (iox <= 3 && iox > 0);

		MASetAnw temp = new MASetAnw();
		try {
			temp.br1 = new BufferedReader(new FileReader("MASCH.TXT"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	static int maschAus(String[] daten, String das) throws IOException
	{
		FileWriter out = new FileWriter(das);
		for (int i = 0; i < daten.length; i++)
			out.write(daten[i]);
		out.close();
		return 0;
	}
}
