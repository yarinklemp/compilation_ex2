package ast;

public class AstStmtAssign extends AstStmt {
	public final AstVar var;
	public final AstExp exp;

	public AstStmtAssign(AstVar var, AstExp exp, int left) {
		super(left);
		this.var = var;
		this.exp = exp;
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== stmt -> var ASSIGN exp SEMICOLON\n");
	}

	public void printMe() {
		System.out.print("AST NODE STMT ASSIGN\n");
		AstGraphviz.getInstance().logNode(serialNumber, "STMT\nASSIGN");

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
