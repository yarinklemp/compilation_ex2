package ast;
public class AstExpNil extends  AstExp{
    public AstExpNil(int lineNumber) {
        super(lineNumber);
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== exp -> NIL\n");
    }
    public void printMe() {
        System.out.format("AST NODE NIL\n");
        AstGraphviz.getInstance().logNode(
                serialNumber,
                "NIL");
    }
}
