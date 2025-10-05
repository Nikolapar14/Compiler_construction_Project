// generated with ast extension for cup
// version 0.8
// 5/9/2025 17:42:57


package rs.ac.bg.etf.pp1.ast;

public class StatementPrint extends Statement {

    private Expr Expr;
    private AnotherNumConstList AnotherNumConstList;

    public StatementPrint (Expr Expr, AnotherNumConstList AnotherNumConstList) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.AnotherNumConstList=AnotherNumConstList;
        if(AnotherNumConstList!=null) AnotherNumConstList.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public AnotherNumConstList getAnotherNumConstList() {
        return AnotherNumConstList;
    }

    public void setAnotherNumConstList(AnotherNumConstList AnotherNumConstList) {
        this.AnotherNumConstList=AnotherNumConstList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(AnotherNumConstList!=null) AnotherNumConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(AnotherNumConstList!=null) AnotherNumConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(AnotherNumConstList!=null) AnotherNumConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementPrint(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AnotherNumConstList!=null)
            buffer.append(AnotherNumConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementPrint]");
        return buffer.toString();
    }
}
