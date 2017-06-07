package inf2.m11113824.start;

import java.io.Serializable;

public class MaschineSer implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int manr;
	private double preis;
	private String maBez;
	private String stao;
	private int crt = 1;

	MaschineSer()
	{
	}

	MaschineSer(String in)
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
		this.preis = (preis > 1.0) ? preis : 2.0;
		return (preis > 1.0) ? true : false;
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
	public void ausMasch()
	{
		System.out.printf(
				"Artikelnummer:\t %d %nPreis:\t\t %.2f %nName:\t\t %s %nStandort:\t %s %n"
						+ ((crt == 1) ? "Instanz ist OK%n%n"
								: ((crt == 2) ? "Bitte Überprüfen sie die Zahlen%n%n"
										: "Bitte überprüfen sie den Standort und die Bezeichnung%n%n")),
				manr, preis, maBez, stao);
	}

	public String ausMaschCSV()
	{
		return manr + ";" + preis + ";" + maBez + ";" + stao;
	}

	public double abschreibung(int laufzeit)
	{
		return preis / laufzeit;
	}
}
