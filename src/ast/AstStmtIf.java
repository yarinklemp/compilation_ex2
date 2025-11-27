package ast;

public class AstStmtIf extends AstStmt
{
	public AstExp cond;
	public AstStmtList body;
	public AstStmtElse elseStmt;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstStmtIf(AstExp cond, AstStmtList body, AstStmtElse elseStmt, int lineNumber)
	{
		super(lineNumber);
		this.cond = cond;
		this.body = body;
		this.elseStmt = elseStmt;
		serialNumber = AstNodeSerialNumber.getFresh();
		if (elseStmt == null){
			System.out.print("====================== stmt -> IF ");
		}
		else
		{
			System.out.print("====================== stmt -> IF STMT_LIST ELSE STMT_LIST\n");
		}
	}

	public void printMe()
	{
		System.out.print("AST NODE STMT IF\n");
		AstGraphviz.getInstance().logNode(serialNumber, "STMT\nIF");

		if (cond != null){
			cond.printMe();
			AstGraphviz.getInstance().logEdge(serialNumber, cond.serialNumber);
		}
		if (body != null){
			body.printMe();
			AstGraphviz.getInstance().logEdge(serialNumber, body.serialNumber);
		}
		if (elseStmt != null){
			elseStmt.printMe();
			AstGraphviz.getInstance().logEdge(serialNumber, elseStmt.serialNumber);
		}
	}
}