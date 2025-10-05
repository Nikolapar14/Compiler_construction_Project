// generated with ast extension for cup
// version 0.8
// 5/9/2025 13:26:36


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private Type Type;
    private FactorNewList FactorNewList;

    public FactorNew (Type Type, FactorNewList FactorNewList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FactorNewList=FactorNewList;
        if(FactorNewList!=null) FactorNewList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FactorNewList getFactorNewList() {
        return FactorNewList;
    }

    public void setFactorNewList(FactorNewList FactorNewList) {
        this.FactorNewList=FactorNewList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FactorNewList!=null) FactorNewList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FactorNewList!=null) FactorNewList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FactorNewList!=null) FactorNewList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorNewList!=null)
            buffer.append(FactorNewList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
