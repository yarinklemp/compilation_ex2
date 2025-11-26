package ast;

public class AstStmtAssignNew extends AstStmt {
	public final AstVar var;
	public final AstNewExp exp;

	public AstStmtAssignNew(AstVar var, AstNewExp exp, int lineNumber) {
		super(lineNumber);
		this.var = var;
		this.exp = exp;
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== stmt -> var ASSIGN newExp SEMICOLON\n");
	}

	public void printMe() {
		System.out.print("AST NODE STMT ASSIGN NEW\n");
		AstGraphviz.getInstance().logNode(serialNumber, "STMT\nASSIGN\nNEW");

		if (var != null){
			var.printMe();
			AstGraphviz.getInstance().logEdge(serialNumber, var.serialNumber);
		}
		if (exp != null){
			exp.printMe();
			AstGraphviz.getInstance().logEdge(serialNumber, exp.serialNumber);
		}
	}
}