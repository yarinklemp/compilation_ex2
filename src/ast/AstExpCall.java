package ast;

public class AstExpCall extends AstExp {
    public AstCallExp call; //the actual call expression
    public AstExpCall(AstCallExp call, int lineNumber){
        super(lineNumber);
        this.call = call;
    }
    public void printMe(){
        call.printMe();
    }
}
