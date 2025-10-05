// generated with ast extension for cup
// version 0.8
// 5/9/2025 17:42:57


package rs.ac.bg.etf.pp1.ast;

public class ActPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Expr Expr;
    private AnotherExprList AnotherExprList;

    public ActPars (Expr Expr, AnotherExprList AnotherExprList) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.AnotherExprList=AnotherExprList;
        if(AnotherExprList!=null) AnotherExprList.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public AnotherExprList getAnotherExprList() {
        return AnotherExprList;
    }

    public void setAnotherExprList(AnotherExprList AnotherExprList) {
        this.AnotherExprList=AnotherExprList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(AnotherExprList!=null) AnotherExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(AnotherExprList!=null) AnotherExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(AnotherExprList!=null) AnotherExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActPars(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AnotherExprList!=null)
            buffer.append(AnotherExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActPars]");
        return buffer.toString();
    }
}
