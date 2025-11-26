package ast;
public class AstArrayTypeDef extends AstDec{
    public String name;
    public AstType type;

    public AstArrayTypeDef(String name, AstType type, int lineNumber) {
        super(lineNumber);
        this.name = name;
        this.type = type;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== dec -> TYPE ID ARRAY\n");
    }
    public void printMe() {
        System.out.format("AST NODE ARRAY TYPE DEF\n");
        if (type != null) type.printMe();
        System.out.format(" ARRAY %s\n", name);
        AstGraphviz.getInstance().logNode(
                serialNumber,
                String.format("ARRAY TYPE DEF\n%s %s", type.type, name));
    }
    
}
