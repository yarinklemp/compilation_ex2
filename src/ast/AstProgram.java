package ast;

public class AstProgram extends AstNode
{
    public AstDecList decList;

    public AstProgram(AstDecList decList, int lineNumber)
    {
        super(lineNumber);
        this.decList = decList;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== program -> decList\n");
    }

    public void printMe()
    {
        System.out.print("AST PROGRAM\n");
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "PROGRAM\n");
        if (decList != null){
            decList.printMe();
            AstGraphviz.getInstance().logEdge(
                serialNumber,
                decList.serialNumber);
        }
    }   
    
}
