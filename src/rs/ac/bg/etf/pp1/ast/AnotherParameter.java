// generated with ast extension for cup
// version 0.8
// 5/9/2025 13:26:36


package rs.ac.bg.etf.pp1.ast;

public class AnotherParameter extends AnotherFormParamList {

    private AnotherFormParamList AnotherFormParamList;
    private Type Type;
    private String I3;
    private BracketsList BracketsList;

    public AnotherParameter (AnotherFormParamList AnotherFormParamList, Type Type, String I3, BracketsList BracketsList) {
        this.AnotherFormParamList=AnotherFormParamList;
        if(AnotherFormParamList!=null) AnotherFormParamList.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I3=I3;
        this.BracketsList=BracketsList;
        if(BracketsList!=null) BracketsList.setParent(this);
    }

    public AnotherFormParamList getAnotherFormParamList() {
        return AnotherFormParamList;
    }

    public void setAnotherFormParamList(AnotherFormParamList AnotherFormParamList) {
        this.AnotherFormParamList=AnotherFormParamList;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI3() {
        return I3;
    }

    public void setI3(String I3) {
        this.I3=I3;
    }

    public BracketsList getBracketsList() {
        return BracketsList;
    }

    public void setBracketsList(BracketsList BracketsList) {
        this.BracketsList=BracketsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AnotherFormParamList!=null) AnotherFormParamList.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(BracketsList!=null) BracketsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AnotherFormParamList!=null) AnotherFormParamList.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(BracketsList!=null) BracketsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AnotherFormParamList!=null) AnotherFormParamList.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(BracketsList!=null) BracketsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AnotherParameter(\n");

        if(AnotherFormParamList!=null)
            buffer.append(AnotherFormParamList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I3);
        buffer.append("\n");

        if(BracketsList!=null)
            buffer.append(BracketsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AnotherParameter]");
        return buffer.toString();
    }
}
