package ast;

public class AstType extends AstNode
{
    public String type;

    public AstType(String type, int lineNumber)
    {
        super(lineNumber);
        this.type = type;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== type -> " + type + "\n");
    }

    public void printMe()
    {
        System.out.format("AST NODE TYPE: %s\n", type);
        AstGraphviz.getInstance().logNode(serialNumber, 
            String.format("TYPE (%s)" ,type));
    }
    
}


