package inf2.m11113824.start;

public class testMethod
{

	public static void main(String[] args)
	{
		test(2, 2.0);
		test(2.2, 2);
	}

	static void test(int h, double c)
	{
		System.out.println(h - c);
	}

	static void test(double c, int h)
	{
		System.out.println(h - c);
	}

}
