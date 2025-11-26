package ast;
import java.util.ArrayList;
import java.util.List;

public class AstStmtList extends AstNode{
	public List<AstStmt> stmts = new ArrayList<AstStmt>();

	public AstStmtList(AstStmt stmt, int lineNumber) {
		super(lineNumber);
		stmts.add(stmt);
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== stmtList -> stmt\n");
	}

	public void add(AstStmt stmt) {
		stmts.add(stmt);
	}

	public void printMe() {
		System.out.print("AST NODE STMT LIST\n");
		AstGraphviz.getInstance().logNode(serialNumber, "STMT\nLIST");

		for (AstStmt stmt : stmts) {
			if (stmt != null) {
				stmt.printMe();
				AstGraphviz.getInstance().logEdge(serialNumber, stmt.serialNumber);
			}
		}
	}
}