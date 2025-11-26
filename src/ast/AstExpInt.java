package ast;

public class AstExpInt extends AstExp
{
	public int value;
	public AstExpInt(int value, int lineNumber)
	{
		super(lineNumber);
		this.value = value;

		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== exp -> INT\n");
	}
	public void printMe()
	{
		System.out.format("AST NODE INT(%d)\n",value); 
		AstGraphviz.getInstance().logNode(
			serialNumber,
			String.format("INT(%d)",value));
	}
}
