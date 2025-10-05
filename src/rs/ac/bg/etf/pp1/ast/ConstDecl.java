// generated with ast extension for cup
// version 0.8
// 5/9/2025 17:42:57


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private FirstConst FirstConst;
    private RemainingConstsList RemainingConstsList;

    public ConstDecl (FirstConst FirstConst, RemainingConstsList RemainingConstsList) {
        this.FirstConst=FirstConst;
        if(FirstConst!=null) FirstConst.setParent(this);
        this.RemainingConstsList=RemainingConstsList;
        if(RemainingConstsList!=null) RemainingConstsList.setParent(this);
    }

    public FirstConst getFirstConst() {
        return FirstConst;
    }

    public void setFirstConst(FirstConst FirstConst) {
        this.FirstConst=FirstConst;
    }

    public RemainingConstsList getRemainingConstsList() {
        return RemainingConstsList;
    }

    public void setRemainingConstsList(RemainingConstsList RemainingConstsList) {
        this.RemainingConstsList=RemainingConstsList;
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
        if(RemainingConstsList!=null) RemainingConstsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FirstConst!=null) FirstConst.traverseTopDown(visitor);
        if(RemainingConstsList!=null) RemainingConstsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FirstConst!=null) FirstConst.traverseBottomUp(visitor);
        if(RemainingConstsList!=null) RemainingConstsList.traverseBottomUp(visitor);
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

        if(RemainingConstsList!=null)
            buffer.append(RemainingConstsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
