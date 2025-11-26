package ast;
import java.util.ArrayList;
import java.util.List;

public class AstDecList extends AstNode
{
    public List<AstDec> decs = new ArrayList<>();

    public AstDecList(int lineNumber)
    {
        super(lineNumber);
        serialNumber = AstNodeSerialNumber.getFresh();
    }

    public AstDecList(AstDec dec, int lineNumber)
    {
        super(lineNumber);
        decs.add(dec);
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== decList -> dec\n");
    }

    public void add(AstDec dec)
    {
        decs.add(dec);
    }

    public void printMe()
    {
        System.out.print("AST NODE DEC LIST\n");
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "DEC\nLIST\n");

        for (AstDec dec : decs) {
            if (dec != null){
                dec.printMe();
                AstGraphviz.getInstance().logEdge(serialNumber, dec.serialNumber);
            }
        }
    }
}
