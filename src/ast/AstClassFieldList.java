package ast;
import java.util.List;
import java.util.ArrayList;

public class AstClassFieldList  extends AstNode  {
    public List<AstClassField> classFields = new ArrayList<AstClassField>();

    public AstClassFieldList(AstClassField classField, int lineNumber) {
        super(lineNumber);
        classFields.add(classField);
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== classFieldList -> classField\n");
    }  

    public void add(AstClassField field){
        classFields.add(field);
    }

    public void printMe() {
        System.out.print("AST NODE CLASS FIELD LIST\n");
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "CLASS\nFIELD\nLIST");
        for (AstClassField field : classFields) {
            if (field != null){ 
                field.printMe();
                AstGraphviz.getInstance().logEdge(serialNumber, field.serialNumber);
            }
        }
    }
}
