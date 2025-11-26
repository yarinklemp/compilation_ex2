package ast;
import java.util.ArrayList;
import java.util.List;

public class AstTypeNameList extends AstNode
{
    public List<AstType> typeList = new ArrayList<AstType>();
    public List<String> nameList = new ArrayList<String>();
    
    public AstTypeNameList(AstType type, String name, int lineNumber)
    {
        super(lineNumber);
        typeList.add(type);
        nameList.add(name);
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== typeNameList -> type name\n");
    }
    
    public void add(AstType typeName, String name)
    {
        typeList.add(typeName);
        nameList.add(name);
    }
    
    public void printMe()
    {
        System.out.print("AST NODE TYPE NAME LIST\n");
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "TYPE\nNAME\nLIST");

        for (int i = 0; i < typeList.size(); i++) {
            AstType type = typeList.get(i);
            String name = nameList.get(i);
            if (type != null){
                type.printMe();
                AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
            }
            AstGraphviz.getInstance().logNode(
                serialNumber + i + 1,
                "NAME: " + name);
            AstGraphviz.getInstance().logEdge(serialNumber, serialNumber + i + 1);
        }
    }
}
