package ast;

public class AstFuncDec extends AstDec
{
    public String name;
    public AstType returnType;
    public AstStmtList funcBody;
    public AstTypeNameList params;

    public AstFuncDec(AstType returnType, String name, AstTypeNameList params, AstStmtList funcBody, int lineNumber)
    {
        super(lineNumber);
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.funcBody = funcBody;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== dec -> funcDec\n");
    }

    public void printMe()
    {
        System.out.format("AST NODE FUNC DEC( %s )\n", name);
        AstGraphviz.getInstance().logNode(
                serialNumber,
                String.format("FUNC DEC(%s)", name));

        if (returnType != null) {
            returnType.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, returnType.serialNumber);
        }

        if (params != null) {
            params.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, params.serialNumber);
        }

        if (funcBody != null) {
            funcBody.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, funcBody.serialNumber);
        }
    }
    
}