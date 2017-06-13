package inf2.m11113824.start;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Mat implements Iskalierbar
{
	double matrix[][];
	int crt = 1;
	InputStreamReader docIn;

	public Mat()
	{
	}

	public Mat(BufferedReader br1)
	{
		LinkedList<String> matList = new LinkedList<String>();
		String line = "";
		try {
			while (((line = br1.readLine()) != null))
				matList.add(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		matrix = new double[matList.size()][];
		for (int i = 0; i < matList.size(); i++) {
			String[] in = matList.get(i).split(";");
			if (i > 0 && in.length != matrix[0].length)
				crt = -1;
			matrix[i] = new double[in.length];
			for (int a = in.length - 1; a >= 0; a--)
				matrix[i][a] = Integer.parseInt(in[a]);
		}
	}

	public boolean matAus(FileWriter fx)
	{
		try {
			for (int i = 0; i < matrix.length; i++) {
				for (int o = 0; o < matrix[i].length; o++)
					fx.write(matrix[i][o] + ";");
				fx.write("\n");
			}
			fx.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Mat matMul(Mat in)
	{
		Mat fin = new Mat();
		fin.matrix = new double[this.matrix[0].length][in.matrix.length];
		int temp = 0;
		if ((this.matrix[0].length) != (in.matrix.length)) {
			in.crt = -3;
			return in;
		}
		if (this.crt == -1 || in.crt == -1) {
			fin.crt = -1;
			return in;
		}
		for (int a = 0; a < this.matrix[0].length; a++)
			for (int b = 0; b < in.matrix.length; b++) {
				for (int c = 0; c < this.matrix[a].length; c++)
					temp += this.matrix[a][b] * in.matrix[c][b];
				fin.matrix[a][b] = temp;
			}
		return fin;
	}

	@Override
	public double[][] skalMult(double in)
	{
		double[][] out = new double[this.matrix.length][];
		for (int a = 0; a < this.matrix.length; a++)
			for (int b = 0; b < this.matrix[a].length; b++) {
				if (b == 0)
					out[a] = new double[this.matrix[a].length];
				out[a][b] = this.matrix[a][b] * in;
			}
		return out;
	}
}
