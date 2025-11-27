package ast;

public class AstStmtElse extends AstStmt
{
    public AstStmtList stmtList;
    
    /******************/
    /* CONSTRUCTOR(S) */
    /******************/
    public AstStmtElse(AstStmtList stmtList, int lineNumber)
    {
        super(lineNumber);
        this.stmtList = stmtList;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.format("====================== stmt -> ELSE LBRACE stmtList RBRACE\n");
    }

    public void printMe()
    {
        System.out.print("AST NODE STMT ELSE\n");
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "STMT\nELSE");
        if (stmtList != null){
            stmtList.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, stmtList.serialNumber);
        }
    }
}