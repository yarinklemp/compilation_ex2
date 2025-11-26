package ast;

public class AstExpVar extends AstExp
{
	public AstVar var;
	public AstExpVar(AstVar var, int lineNumber)
	{
		super(lineNumber);
		this.var = var;
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== exp -> var\n");
	}

	public void printMe()
	{
		System.out.format("AST NODE EXP VAR\n"); 
		AstGraphviz.getInstance().logNode(
			serialNumber,
			"EXP\nVAR");
		
		if (var != null) {
			var.printMe();
			AstGraphviz.getInstance().logEdge(serialNumber,var.serialNumber);
		}
	}
}
