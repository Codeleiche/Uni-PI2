package inf2.m11113824.start;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class ZDatM
{
	FileReader fr1;
	BufferedReader br1;
	FileWriter fw1;
	PrintWriter pr1;
	LinkedList<Maschine> dsliste;
	ListIterator<Maschine> iter, r, l;

	public ZDatM(String dsn, int mod)
	{
		switch (mod) {
			case 1:
				try {
					fr1 = new FileReader(dsn);
					br1 = new BufferedReader(fr1);
					dsliste = new LinkedList<Maschine>();
					fw1 = null;
					pr1 = null;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("Geb doch bitte nen namen ein den es auch gibt du spasti");
				}
				break;
			case 2:
				try {
					fw1 = new FileWriter(dsn, true);
					pr1 = new PrintWriter(fw1);
					fr1 = null;
					br1 = null;
					dsliste = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.print("Bitte geben sie einen gültigen Modus ein(1,2)");
				break;
		}
	}

	public int einlesen()
	{
		int zeilen = 0;
		String in;
		try {
			while ((in = br1.readLine()) != null) {

				dsliste.add(new Maschine(in));
				zeilen++;
			}
			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zeilen;
	}

	public void list2Dat()
	{
		iter = dsliste.listIterator(0);
		while (iter.hasNext()) {
			pr1.println(iter.next().ausMaschCSV());
		}

		pr1.close();
	}

	/*
	 * public int sort(int iox) { switch (iox) { case 1: break; case 2: break;
	 * case 3: break; case 4: break; default: break; } }
	 */

	public int sort(int iox)
	{
		int round = 0;
		Maschine[] unsortiert = new Maschine[dsliste.size()];
		for (int a = 0; a < dsliste.size(); a++)
			unsortiert[a] = dsliste.get(a);
		switch (iox) {
			case 1:
				for (int i = 0; i < unsortiert.length; i++) {
					Maschine temp = new Maschine();
					for (int b = i + 1; b < unsortiert.length; b++) {
						round++;
						if (unsortiert[i].getManr() > unsortiert[b].getManr()) {
							temp = unsortiert[i];
							unsortiert[i] = unsortiert[b];
							unsortiert[b] = temp;
						}
					}
				}
				break;
			case 2:
				for (int i = 0; i < unsortiert.length; i++) {
					Maschine temp = new Maschine();
					for (int b = i + 1; b < unsortiert.length; b++) {
						round++;
						if (unsortiert[i].getPreis() > unsortiert[b].getPreis()) {
							temp = unsortiert[i];
							unsortiert[i] = unsortiert[b];
							unsortiert[b] = temp;
						}
					}
				}
				break;
			case 3:
				for (int i = 0; i < unsortiert.length; i++) {
					Maschine temp = new Maschine();
					for (int b = i + 1; b < unsortiert.length; b++) {
						round++;
						if (unsortiert[i].getMaBez().compareTo(unsortiert[b].getMaBez()) > 0) {
							temp = unsortiert[i];
							unsortiert[i] = unsortiert[b];
							unsortiert[b] = temp;
						}
					}
				}
				break;
			case 4:
				for (int i = 0; i < unsortiert.length; i++) {
					Maschine temp = new Maschine();
					for (int b = i + 1; b < unsortiert.length; b++) {
						round++;
						if (unsortiert[i].getStao().compareTo(unsortiert[b].getStao()) > 0) {
							temp = unsortiert[i];
							unsortiert[i] = unsortiert[b];
							unsortiert[b] = temp;
						}
					}
				}
				break;
			default:
				System.out.println("Bitte wählen sie zwischen " + "/n(1) Nach Maschinen Nummer sortieren"
						+ "\n(2) Nach Preis sortieren" + "\n(3) Nach Maschinenbezeichnung sortieren"
						+ "\n(4) Nach Stantort sortieren");
				// hier erneut aufrufen
				break;
		}
		for (int i = 0; i < unsortiert.length; i++)
			dsliste.set(i, unsortiert[i]);
		return round;
	}

	public int direkteAuswahl(int iox)
	{
		int round = 0;
		LinkedList<Maschine> hlist = new LinkedList<Maschine>();
		ListIterator<Maschine> iter = dsliste.listIterator(0);
		Maschine temp = new Maschine();
		int i = 0;
		switch (iox) {
			case 1:
				while (hlist.size() != dsliste.size())// änderung
				{
					if (iter.hasNext())
						temp = iter.next();
					else
						break;
					if (hlist.size() == 0) {
						round++;
						hlist.add(temp);// änderung
					} else if (hlist.get(hlist.size() - 1).getManr() < temp.getManr())// änderung
					{
						round++;
						hlist.add(temp);
					} else {
						while (hlist.get(i++).getManr() < temp.getManr()) {
							round++;
						}
						hlist.add(--i, temp);// änderung
						i = 0;// änderung
					}
				}
				break;
			case 2:
				while (hlist.size() != dsliste.size())// änderung
				{
					if (iter.hasNext())
						temp = iter.next();
					else
						break;
					if (hlist.size() == 0) {
						round++;
						hlist.add(temp);// änderung
					} else if (hlist.get(hlist.size() - 1).getPreis() < temp.getPreis())// änderung
					{
						round++;
						hlist.add(temp);
					} else {
						while (hlist.get(i++).getPreis() < temp.getPreis()) {
							round++;
						}
						hlist.add(--i, temp);// änderung
						i = 0;// änderung
					}
				}
				break;
			case 3:
				while (hlist.size() != dsliste.size())// änderung
				{
					if (iter.hasNext())
						temp = iter.next();
					else
						break;
					if (hlist.size() == 0) {
						round++;
						hlist.add(temp);// änderung
					} else if (hlist.get(hlist.size() - 1).getMaBez().compareTo(temp.getMaBez()) < 0)// änderung
					{
						round++;
						hlist.add(temp);
					} else {
						while (hlist.get(i++).getMaBez().compareTo(temp.getMaBez()) < 0) {
							round++;
						}
						hlist.add(--i, temp);// änderung
						i = 0;// änderung
					}
				}
				break;
			case 4:
				while (hlist.size() != dsliste.size())// änderung
				{
					if (iter.hasNext())
						temp = iter.next();
					else
						break;
					if (hlist.size() == 0) {
						round++;
						hlist.add(temp);// änderung
					} else if (hlist.get(hlist.size() - 1).getStao().compareTo(temp.getStao()) < 0)// änderung
					{
						round++;
						hlist.add(temp);
					} else {
						while (hlist.get(i++).getStao().compareTo(temp.getStao()) < 0) {
							round++;
						}
						hlist.add(--i, temp);// änderung
						i = 0;// änderung
					}
				}
				break;
			default:
				System.out.println("Bitte wählen sie zwischen " + "/n(1) Nach Maschinen Nummer sortieren"
						+ "\n(2) Nach Preis sortieren" + "\n(3) Nach Maschinenbezeichnung sortieren"
						+ "\n(4) Nach Stantort sortieren");
				// hier erneut aufrufen
				break;
		}

		for (i = 0; i < hlist.size(); i++)
			dsliste.set(i, hlist.get(i));
		return round;
	}

	// public void sort(int iox)
	// {
	// // MASCHINEN AUSGEBEN TEST!!!!!
	// System.out.println("start:");
	// iter = dsliste.listIterator(0);
	// while (iter.hasNext())
	// System.out.println(iter.next().ausMaschCSV());
	// System.out.println("-----------------------");
	// ListIterator<Maschine> l = dsliste.listIterator(0);
	// ListIterator<Maschine> r = dsliste.listIterator(dsliste.size());
	// int round = 0, lschran = l.nextIndex(), rschran = r.previousIndex(), size
	// = rschran - lschran;
	// Maschine pivot = r.previous();
	// Maschine temp = new Maschine();
	// Maschine templ = new Maschine();
	// Maschine tempr = new Maschine();
	//
	// switch (iox) {
	// case 1:
	// break;
	// case 2:
	// while (l.nextIndex() < r.nextIndex())
	// {
	// while (l.nextIndex() < rschran && (templ = l.next()).getPreis() <
	// pivot.getPreis()
	// && l.nextIndex() < r.nextIndex()) // NEU
	// {
	// round++;
	// }
	// while (r.previousIndex() > lschran && (tempr = r.previous()).getPreis() >
	// pivot.getPreis()
	// && l.nextIndex() < r.nextIndex())
	// {
	// round++;
	// }
	// if (l.nextIndex() < r.previousIndex())
	// {
	// l.set(tempr);
	// r.set(templ);
	// // MASCHINEN AUSGEBEN TEST!!!!!
	// iter = dsliste.listIterator(0);
	// while (iter.hasNext())
	// System.out.println(iter.next().ausMaschCSV());
	// System.out.println("-----------------------");
	// }
	//
	// }
	// if (templ.getPreis() > pivot.getPreis())
	// { // Das Pivot (Schlüssel) Element an die richtige stelle setzen
	// l.set(pivot);
	// iter = dsliste.listIterator(rschran);
	// iter.next();
	// iter.set(templ);
	// }
	// // MASCHINEN AUSGEBEN TEST!!!!!
	// iter = dsliste.listIterator(0);
	// while (iter.hasNext())
	// System.out.println(iter.next().ausMaschCSV());
	// System.out.println("-----------------------");
	//
	// /******************************************************************************************/
	// iter = dsliste.listIterator(lschran);
	// if (lschran > l.previousIndex() && !(iter.nextIndex() ==
	// l.previousIndex()))
	// sort(iox, iter, l);
	// iter = dsliste.listIterator(rschran);
	// if (rschran != l.nextIndex() && !(iter.previousIndex() == l.nextIndex()))
	// sort(iox, l, iter);
	// break;
	// }
	// }
	//
	// public void sort(int iox, ListIterator<Maschine> l,
	// ListIterator<Maschine> r)
	// {
	//
	// int round = 0, lschran = l.nextIndex(), rschran = r.previousIndex(), size
	// = rschran - lschran;// ist
	//
	// System.out.println("+++++++++++++++++++++++l=" + (lschran + 1) + "r=" +
	// (rschran + 1)); // der
	// // Itter
	// // an
	// // der
	// // richtigen
	// // stelle??
	// Maschine pivot = r.previous();
	// Maschine temp = new Maschine();
	// Maschine templ = new Maschine();
	// Maschine tempr = new Maschine();
	// switch (iox) {
	// case 1:
	// break;
	// case 2:
	// while (l.nextIndex() < r.nextIndex())
	// {
	// while (l.nextIndex() < rschran && (templ = l.next()).getPreis() <
	// pivot.getPreis()
	// && l.nextIndex() < r.nextIndex()) // NEU
	// {
	// round++;
	// }
	// while (r.previousIndex() > lschran && (tempr = r.previous()).getPreis() >
	// pivot.getPreis()
	// && l.nextIndex() < r.nextIndex())
	// {
	// round++;
	// }
	// if (l.nextIndex() < r.previousIndex())
	// {
	// l.set(tempr);
	// r.set(templ);
	// // MASCHINEN AUSGEBEN TEST!!!!!
	// iter = dsliste.listIterator(0);
	// while (iter.hasNext())
	// System.out.println(iter.next().ausMaschCSV());
	// System.out.println("-----------------------");
	// }
	// }
	// if (templ.getPreis() > pivot.getPreis())
	// { // Das Pivot (Schlüssel) Element an die richtige stelle setzen
	// l.set(pivot);
	// iter = dsliste.listIterator(rschran);
	// iter.next();
	// iter.set(templ);
	// }
	// // MASCHINEN AUSGEBEN TEST!!!!!
	// iter = dsliste.listIterator(0);
	// while (iter.hasNext())
	// System.out.println(iter.next().ausMaschCSV());
	// System.out.println("-----------------------");
	//
	// /******************************************************************************************/
	// iter = dsliste.listIterator(lschran);
	// if (lschran > l.previousIndex() && !(iter.nextIndex() ==
	// l.previousIndex()))
	// sort(iox, iter, l);
	// iter = dsliste.listIterator(rschran);
	// if (rschran != l.nextIndex() && !(iter.previousIndex() == l.nextIndex()))
	// sort(iox, l, iter);
	// break;
	// }
	// }

}
