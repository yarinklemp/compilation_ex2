package ast;
public class AstExpString extends AstExp{
    public String value;
    public AstExpString(String value, int lineNumber) {
        super(lineNumber);
        this.value = value;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== exp -> STRING\n");
    }
    public void printMe() {
        System.out.format("AST NODE STRING( %s )\n", value);
        AstGraphviz.getInstance().logNode(
                serialNumber,
                String.format("STRING(%s)", value));
    }
    
}
