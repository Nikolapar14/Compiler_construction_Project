// generated with ast extension for cup
// version 0.8
// 4/9/2025 12:48:13


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private FirstConst FirstConst;
    private AnotherConstList AnotherConstList;

    public ConstDecl (FirstConst FirstConst, AnotherConstList AnotherConstList) {
        this.FirstConst=FirstConst;
        if(FirstConst!=null) FirstConst.setParent(this);
        this.AnotherConstList=AnotherConstList;
        if(AnotherConstList!=null) AnotherConstList.setParent(this);
    }

    public FirstConst getFirstConst() {
        return FirstConst;
    }

    public void setFirstConst(FirstConst FirstConst) {
        this.FirstConst=FirstConst;
    }

    public AnotherConstList getAnotherConstList() {
        return AnotherConstList;
    }

    public void setAnotherConstList(AnotherConstList AnotherConstList) {
        this.AnotherConstList=AnotherConstList;
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
        if(FirstConst!=null) FirstConst.accept(visitor);
        if(AnotherConstList!=null) AnotherConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FirstConst!=null) FirstConst.traverseTopDown(visitor);
        if(AnotherConstList!=null) AnotherConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FirstConst!=null) FirstConst.traverseBottomUp(visitor);
        if(AnotherConstList!=null) AnotherConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(FirstConst!=null)
            buffer.append(FirstConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AnotherConstList!=null)
            buffer.append(AnotherConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
