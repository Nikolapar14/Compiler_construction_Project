// generated with ast extension for cup
// version 0.8
// 5/9/2025 13:26:36


package rs.ac.bg.etf.pp1.ast;

public class AnotherExpr extends AnotherExprList {

    private AnotherExprList AnotherExprList;
    private Expr Expr;

    public AnotherExpr (AnotherExprList AnotherExprList, Expr Expr) {
        this.AnotherExprList=AnotherExprList;
        if(AnotherExprList!=null) AnotherExprList.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public AnotherExprList getAnotherExprList() {
        return AnotherExprList;
    }

    public void setAnotherExprList(AnotherExprList AnotherExprList) {
        this.AnotherExprList=AnotherExprList;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AnotherExprList!=null) AnotherExprList.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AnotherExprList!=null) AnotherExprList.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AnotherExprList!=null) AnotherExprList.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AnotherExpr(\n");

        if(AnotherExprList!=null)
            buffer.append(AnotherExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AnotherExpr]");
        return buffer.toString();
    }
}
