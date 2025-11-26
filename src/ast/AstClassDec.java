package ast;

public class AstClassDec extends AstDec  {
    public String className;
    public AstClassFieldList fields;
    public String superClass;

    public AstClassDec(String className, String superClass, AstClassFieldList fields, int lineNumber) {
        super(lineNumber);
        this.className = className;
        this.fields = fields;
        this.superClass = superClass;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== dec -> CLASS");
    }

    public void printMe() {
        System.out.print("AST NODE CLASS DEC\n");
        AstGraphviz.getInstance().logNode(
                serialNumber,
                String.format("CLASS DEC\n%s", className));
        if (fields != null) {
            fields.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, fields.serialNumber);
        }
    }   
}
