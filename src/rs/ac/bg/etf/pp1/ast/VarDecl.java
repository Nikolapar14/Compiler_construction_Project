// generated with ast extension for cup
// version 0.8
// 5/9/2025 13:26:36


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private FirstVar FirstVar;
    private AnotherVarList AnotherVarList;

    public VarDecl (FirstVar FirstVar, AnotherVarList AnotherVarList) {
        this.FirstVar=FirstVar;
        if(FirstVar!=null) FirstVar.setParent(this);
        this.AnotherVarList=AnotherVarList;
        if(AnotherVarList!=null) AnotherVarList.setParent(this);
    }

    public FirstVar getFirstVar() {
        return FirstVar;
    }

    public void setFirstVar(FirstVar FirstVar) {
        this.FirstVar=FirstVar;
    }

    public AnotherVarList getAnotherVarList() {
        return AnotherVarList;
    }

    public void setAnotherVarList(AnotherVarList AnotherVarList) {
        this.AnotherVarList=AnotherVarList;
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
        if(FirstVar!=null) FirstVar.accept(visitor);
        if(AnotherVarList!=null) AnotherVarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FirstVar!=null) FirstVar.traverseTopDown(visitor);
        if(AnotherVarList!=null) AnotherVarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FirstVar!=null) FirstVar.traverseBottomUp(visitor);
        if(AnotherVarList!=null) AnotherVarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        if(FirstVar!=null)
            buffer.append(FirstVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AnotherVarList!=null)
            buffer.append(AnotherVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
