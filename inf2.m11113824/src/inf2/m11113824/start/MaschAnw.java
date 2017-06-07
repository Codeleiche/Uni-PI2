package inf2.m11113824.start;

import java.util.LinkedList;
import java.util.ListIterator;

public class MaschAnw
{
	static MaschineSer masch;
	static LinkedList<MaschineSer> maschList = new LinkedList<MaschineSer>();
	static ListIterator<MaschineSer> iterator;

	public static void main(String args[])
	{
		masch = new MaschineSer();

		masch.ausMasch();
		String[] temp = maschGeber();
		for (int i = 0; i < temp.length; i++)
		{
			masch = new MaschineSer(temp[i]);
			if (masch.getCrt() != 1)
				masch.ausMasch();
			if (masch.getCrt() == 1 && masch != null)
				maschList.add(masch);
		}
		iterator = maschList.listIterator(0);
		while (iterator.hasNext())
		{
			iterator.next().ausMasch();
		}

	}

	static private String[] maschGeber()
	{
		String[] temp = { "1234567;143.23;Essen;Mallorca", "2345678;300000.00;Firmenwagen;Zuhause",
				"3456789;12.30;Taschengeld;firma", "1634432;40.00;Torte;Firma", "4567890;Trinken;Sweet;Zuhause",
				"7324432;1.00;Furz;Zuhause", "6666666;2400.20;Nutte;Kunde", "6324228;2.00;32;Tibet" };
		return temp;
	}
}
