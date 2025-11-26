package ast;

public class AstNewExp extends AstExp
{
    public AstType type;
    public AstExp subscript;

    public AstNewExp(AstType type, AstExp subscript, int lineNumber)
    {
        super(lineNumber);
        this.type = type;
        this.subscript = subscript;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== exp -> NEW type\n");
    }

    public void printMe()
    {
        System.out.print("AST NODE NEW EXP\n");
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "NEW EXP"
        );

        if (type != null) {
            type.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
        }
        if (subscript != null){
            subscript.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, subscript.serialNumber);
        }
    }
    
}
