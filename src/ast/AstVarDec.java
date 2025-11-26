package ast;

public class AstVarDec extends AstDec
{
    public String name;
    public AstType type;
    public AstExp initExp;
    public AstNewExp newExp;


    public AstVarDec(AstType type, String name, AstExp initExp,  int lineNumber)
    {
        super(lineNumber);
        this.name = name;
        this.type = type;
        this.initExp = initExp;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== varDec -> type ID ASSIGN exp\n");
    }
        public AstVarDec(AstType type, String name, AstNewExp newExp,  int lineNumber)
    {
        super(lineNumber);
        this.name = name;
        this.type = type;
        this.newExp = newExp;
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== varDec -> type ID ASSIGN newExp\n");
    }

    public void printMe()
    {
        System.out.format("AST VAR DEC name (%s)\n", name);
        AstGraphviz.getInstance().logNode(
            serialNumber,
            String.format("VAR DEC\nname (%s)", name));
        if (type != null){
            type.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber,type.serialNumber);
        }
        if (initExp != null){
            initExp.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber,initExp.serialNumber);
        }
        if (newExp != null){
            newExp.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber,newExp.serialNumber);
        }
    }
    
}