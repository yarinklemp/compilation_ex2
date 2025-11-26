package ast;

public class AstStmtWhile extends AstStmt
{
	public AstExp cond;
	public AstStmtList body;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtWhile(AstExp cond, AstStmtList body, int lineNumber)
	{
		super(lineNumber);
		this.cond = cond;
		this.body = body;
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== stmt -> WHILE ");
	}

	public void printMe()
	{
		System.out.print("AST NODE STMT WHILE\n");
		AstGraphviz.getInstance().logNode(serialNumber, "STMT\nWHILE");

		if (cond != null){
			cond.printMe();
			AstGraphviz.getInstance().logEdge(serialNumber, cond.serialNumber);
		}
		if (body != null){
			body.printMe();
			AstGraphviz.getInstance().logEdge(serialNumber, body.serialNumber);
		}
	}
}