package ast;

public class AstStmtCall extends AstStmt{
    public AstCallExp callExp;
    public AstStmtCall(AstCallExp callExp, int lineNumber){
        super (lineNumber);
        this.callExp = callExp;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== stmt -> callExp SEMICOLON\n");
    }

    public void printMe(){
        System.out.print("AST NODE STMT CALL\n");
        AstGraphviz.getInstance().logNode(serialNumber, "STMT\nCALL");

        if (callExp != null){
            callExp.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, callExp.serialNumber);
        }
    }
}
