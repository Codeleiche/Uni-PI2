package inf2.m11113824.start;

public class MaschineS implements Comparable<MaschineS>
{

	private int manr;
	private double preis;
	private String maBez;
	private String stao;
	private int crt = 1;

	MaschineS()
	{
	}

	MaschineS(String in)
	{
		String[] temp = in.split(";");
		boolean leuft[] = new boolean[temp.length - 2];
		try {
			setManr((setManr(Integer.parseInt(temp[0]))) ? Integer.parseInt(temp[0]) : 1);
			setPreis((setPreis(Double.parseDouble(temp[1]))) ? Double.parseDouble(temp[1]) : 2);
		} catch (NumberFormatException fehler) {
			crt = 2;
		}
		leuft[0] = setMaBez(temp[2]);
		leuft[1] = setStao(temp[3]);
		for (int i = 0; i < leuft.length; i++) {
			if (leuft[i] == false)
				crt = 3;
		}
	}

	public int getManr()
	{
		return manr;
	}

	public boolean setManr(int manr)
	{
		this.manr = (manr > 0) ? manr : 0;
		return (manr > 0) ? true : false;
	}

	public double getPreis()
	{
		return preis;
	}

	public boolean setPreis(double preis)
	{
		this.preis = (preis > 1) ? preis : 2;
		return (preis > 1) ? true : false;
	}

	public String getMaBez()
	{
		return maBez;
	}

	public boolean setMaBez(String maBez)
	{
		if (maBez.charAt(0) < 91 && maBez.charAt(0) > 64)
			this.maBez = maBez;
		return ((this.maBez == null) ? false : true) ? ((this.maBez == maBez) ? true : false) : false;
	}

	public String getStao()
	{
		return stao;
	}

	public boolean setStao(String stao)
	{
		if (stao.charAt(0) < 91 && stao.charAt(0) > 64)
			this.stao = stao;
		return ((this.stao == null) ? false : true) ? ((this.stao == stao) ? true : false) : false;
	}

	public int getCrt()
	{
		return crt;
	}

	@SuppressWarnings("boxing")
	public String toString()
	{
		String temp = "";
		String.format(
				"Artikelnummer:\t %d %nPreis:\t\t %.2f %nName:\t\t %s %nStandort:\t %s %n"
						+ ((crt == 1) ? "Instanz ist OK%n%n"
								: ((crt == 2) ? "Bitte Überprüfen sie die Zahlen%n%n"
										: "Bitte überprüfen sie den Standort und die Bezeichnung%n%n")),
				manr, preis, maBez, stao);
		return temp;
	}

	public String ausMaschCSV()
	{
		return manr + ";" + preis + ";" + maBez + ";" + stao;
	}

	public double abschreibung(int laufzeit)
	{
		return preis / laufzeit;
	}

	public int compareTo(MaschineS comp, int iox)
	{

		switch (iox) {
			case 1:
				return this.manr - comp.manr;
			case 2:
				return (int) (this.preis - comp.preis);
			case 3:
				return this.maBez.compareTo(comp.maBez);
			case 4:
				return this.stao.compareTo(comp.stao);
			default:
				return 0;
		}
	}

	@SuppressWarnings("cast")
	public int compareTo(MaschineS comp)
	{
		System.out
				.println(this.manr + "--" + comp.manr + ((this.manr == comp.manr) ? "ist gleich" : "ist nicht gleich"));
		return (int) ((this.manr == comp.manr)
				? (this.preis == comp.preis) ? (this.stao.compareTo(comp.stao) == 0) ? 0 : 1 : 1 : 1);
	}

}
