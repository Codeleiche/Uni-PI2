/**
 * 
 */
package inf2.m11113824.start;

import java.util.ListIterator;

/**
 * @author David
 *
 */
public class ZDatAnw
{
	public static void main(String[] args)
	{
		ZDatM temp = new ZDatM("MASCH.TXT", 1);
		temp.einlesen();
		temp.direkteAuswahl(1);
		// temp.direkteAuswahl(2);
		// temp.direkteAuswahl(3);
		// temp.direkteAuswahl(4);
		temp.sort(1);
		// temp.sort(2);
		// temp.sort(3);
		// temp.sort(4);
		ListIterator<MaschineSer> iter = temp.dsliste.listIterator(0);
		while (iter.hasNext())
			iter.next().ausMasch();
		ZDatM temp2 = new ZDatM("MASCHT.TXT", 2);
		temp2.dsliste = temp.dsliste;
		temp2.list2Dat();
	}
}
