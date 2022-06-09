
public class Divisao implements IOperacao
{
	private double num1;
	private double num2;
	
	public double calcula()
	{
		double div = num1 / num2;
		return div;
	}
	
	public double getNum1()
	{
		return num1;
	}

	public void setNum1(double num1)
	{
		this.num1 = num1;
	}

	public double getNum2()
	{
		return num2;
	}

	public void setNum2(double num2)
	{
		this.num2 = num2;
	}
}
