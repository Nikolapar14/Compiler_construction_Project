// generated with ast extension for cup
// version 0.8
// 5/9/2025 13:26:36


package rs.ac.bg.etf.pp1.ast;

public class ExprWithoutDash extends Expr {

    private Express Express;

    public ExprWithoutDash (Express Express) {
        this.Express=Express;
        if(Express!=null) Express.setParent(this);
    }

    public Express getExpress() {
        return Express;
    }

    public void setExpress(Express Express) {
        this.Express=Express;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Express!=null) Express.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Express!=null) Express.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Express!=null) Express.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprWithoutDash(\n");

        if(Express!=null)
            buffer.append(Express.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprWithoutDash]");
        return buffer.toString();
    }
}
