package ast;

public class AstClassField extends AstNode{
    public AstVarDec varDec;
    public AstFuncDec funcDec;

    public AstClassField(AstVarDec varDec, int lineNumber) {
        super(lineNumber);
        this.varDec = varDec;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== classField -> varDec");
    }
    public AstClassField(AstFuncDec funcDec, int lineNumber) {
        super(lineNumber);
        this.funcDec = funcDec;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== classField -> funcDec");
    }

    public void printMe() {
        System.out.print("AST NODE CLASS FIELD\n");
        AstGraphviz.getInstance().logNode(
                serialNumber,
                "CLASS FIELD");
        if (varDec != null) {
            varDec.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, varDec.serialNumber);
        }
        if (funcDec != null) {
            funcDec.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, funcDec.serialNumber);
        }
    }
}
