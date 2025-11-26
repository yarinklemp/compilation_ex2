package ast;

public class AstStmtReturn extends AstStmt {
    public AstExp exp;
    public AstStmtReturn(AstExp exp, int lineNumber) {
        super(lineNumber);
        this.exp = exp;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== stmt -> RETURN exp SEMICOLON\n");
    }

    public void printMe() {
        System.out.print("AST NODE STMT RETURN\n");
        AstGraphviz.getInstance().logNode(serialNumber, "STMT\nRETURN");

        if (exp != null){
            exp.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, exp.serialNumber);
        }
    }
}
