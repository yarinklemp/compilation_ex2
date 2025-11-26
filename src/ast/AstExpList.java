package ast;
import java.util.ArrayList;
import java.util.List;

public class AstExpList extends AstNode{

    public List<AstExp> exps;
    
    public AstExpList(AstExp exp, int lineNumber){
        super(lineNumber);
        exps = new ArrayList<AstExp>();
        exps.add(exp);
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== expList -> exp\n");
    }
    
    public void add(AstExp exp){
        exps.add(exp);
    }

    public void printMe(){
        System.out.print("AST NODE EXP LIST\n");
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "EXP\nLIST");
        for (AstExp exp : exps) {
            if (exp != null) {
                exp.printMe();
                AstGraphviz.getInstance().logEdge(serialNumber, exp.serialNumber);
            }
        }
    }
}