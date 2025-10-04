// generated with ast extension for cup
// version 0.8
// 4/9/2025 12:48:13


package rs.ac.bg.etf.pp1.ast;

public class FormPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private String I2;
    private BracketsList BracketsList;
    private AnotherFormParamList AnotherFormParamList;

    public FormPars (Type Type, String I2, BracketsList BracketsList, AnotherFormParamList AnotherFormParamList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.BracketsList=BracketsList;
        if(BracketsList!=null) BracketsList.setParent(this);
        this.AnotherFormParamList=AnotherFormParamList;
        if(AnotherFormParamList!=null) AnotherFormParamList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public BracketsList getBracketsList() {
        return BracketsList;
    }

    public void setBracketsList(BracketsList BracketsList) {
        this.BracketsList=BracketsList;
    }

    public AnotherFormParamList getAnotherFormParamList() {
        return AnotherFormParamList;
    }

    public void setAnotherFormParamList(AnotherFormParamList AnotherFormParamList) {
        this.AnotherFormParamList=AnotherFormParamList;
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
        if(BracketsList!=null) BracketsList.accept(visitor);
        if(AnotherFormParamList!=null) AnotherFormParamList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(BracketsList!=null) BracketsList.traverseTopDown(visitor);
        if(AnotherFormParamList!=null) AnotherFormParamList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(BracketsList!=null) BracketsList.traverseBottomUp(visitor);
        if(AnotherFormParamList!=null) AnotherFormParamList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPars(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(BracketsList!=null)
            buffer.append(BracketsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AnotherFormParamList!=null)
            buffer.append(AnotherFormParamList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPars]");
        return buffer.toString();
    }
}
