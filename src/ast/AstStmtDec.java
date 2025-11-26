package ast;

public class AstStmtDec extends AstStmt {
    public AstVarDec varDec;

    public AstStmtDec(AstVarDec varDec, int lineNumber) {
        super(lineNumber);
        this.varDec = varDec;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== stmt -> varDec SEMICOLON\n");
    }

    public void printMe() {
        System.out.print("AST NODE STMT DEC\n");
        AstGraphviz.getInstance().logNode(serialNumber, "STMT\nDEC");

        if (varDec != null){
            varDec.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, varDec.serialNumber);
        }
    }
}
