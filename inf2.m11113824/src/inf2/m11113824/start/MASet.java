package inf2.m11113824.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class MASet
{
	TreeSet<MaschineS> tmenge;
	HashSet<MaschineS> hmenge;

	public MASet()
	{
		this.tmenge = new TreeSet<MaschineS>();
		this.hmenge = new HashSet<MaschineS>();
	}

	int dat2tset(BufferedReader br1)
	{
		int zeilen = 0;
		String in;
		try {
			while ((in = br1.readLine()) != null) {
				if (new MaschineS(in).getCrt() != 1) {
					System.out.println(in + "ist rausgeflogen");
					continue;
				}
				System.out.println(tmenge.add(new MaschineS(in)));
				zeilen++;
			}
			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zeilen;
	}

	int dat2hset(BufferedReader br1)
	{
		int zeilen = 0;
		String in;
		try {
			while ((in = br1.readLine()) != null) {
				hmenge.add(new MaschineS(in));
				zeilen++;
			}
			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zeilen;
	}

	String[] set2Stringf(int iox)
	{
		Iterator<MaschineS> iter;
		String temp;
		String[] fin;
		switch (iox) {
			case 1:
				iter = tmenge.iterator();
				fin = new String[tmenge.size()];
				for (int i = 0; iter.hasNext(); i++)
					fin[i] = iter.next().ausMaschCSV();
				return fin;
			case 2:
				iter = hmenge.iterator();
				fin = new String[hmenge.size()];
				for (int i = 0; iter.hasNext(); i++)
					fin[i] = iter.next().ausMaschCSV();
				return fin;
			default:
				return null;
		}
	}
}
