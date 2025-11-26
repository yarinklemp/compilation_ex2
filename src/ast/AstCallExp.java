package ast;

public class AstCallExp extends AstNode{
    public AstVar var;
    public String funcName;
    public AstExpList args;
    
    public AstCallExp(AstVar var, String funcName, AstExpList args, int lineNumber){
        super(lineNumber);
        this.var = var;
        this.funcName = funcName;
        this.args = args;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== exp -> var . ID ( expList ) | var(ID (expList))\n");
    }
    public void printMe(){
        System.out.print("AST NODE CALL EXP\n");
        if (var != null) var.printMe();
        if (funcName != null) System.out.print("FUNCTION NAME: " + funcName + "\n");
        if (args != null) args.printMe();
        
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "CALL EXP\n" + funcName
        );
        
        if (var != null) {
            AstGraphviz.getInstance().logEdge(serialNumber, var.serialNumber);
        }
        if (args != null) {
            AstGraphviz.getInstance().logEdge(serialNumber, args.serialNumber);
        }
    }
}
