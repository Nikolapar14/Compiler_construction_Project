// generated with ast extension for cup
// version 0.8
// 5/9/2025 17:42:57


package rs.ac.bg.etf.pp1.ast;

public class FirstConst implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String constName;
    private ConstValueList ConstValueList;

    public FirstConst (Type Type, String constName, ConstValueList ConstValueList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.constName=constName;
        this.ConstValueList=ConstValueList;
        if(ConstValueList!=null) ConstValueList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public ConstValueList getConstValueList() {
        return ConstValueList;
    }

    public void setConstValueList(ConstValueList ConstValueList) {
        this.ConstValueList=ConstValueList;
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
        if(Type!=null) Type.accept(visitor);
        if(ConstValueList!=null) ConstValueList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstValueList!=null) ConstValueList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstValueList!=null) ConstValueList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FirstConst(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(ConstValueList!=null)
            buffer.append(ConstValueList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FirstConst]");
        return buffer.toString();
    }
}
