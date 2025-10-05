// generated with ast extension for cup
// version 0.8
// 5/9/2025 13:26:36


package rs.ac.bg.etf.pp1.ast;

public class AnotherVars extends AnotherVarList {

    private AnotherVarList AnotherVarList;
    private String anotherVar;
    private BracketsList BracketsList;

    public AnotherVars (AnotherVarList AnotherVarList, String anotherVar, BracketsList BracketsList) {
        this.AnotherVarList=AnotherVarList;
        if(AnotherVarList!=null) AnotherVarList.setParent(this);
        this.anotherVar=anotherVar;
        this.BracketsList=BracketsList;
        if(BracketsList!=null) BracketsList.setParent(this);
    }

    public AnotherVarList getAnotherVarList() {
        return AnotherVarList;
    }

    public void setAnotherVarList(AnotherVarList AnotherVarList) {
        this.AnotherVarList=AnotherVarList;
    }

    public String getAnotherVar() {
        return anotherVar;
    }

    public void setAnotherVar(String anotherVar) {
        this.anotherVar=anotherVar;
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
        if(AnotherVarList!=null) AnotherVarList.accept(visitor);
        if(BracketsList!=null) BracketsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AnotherVarList!=null) AnotherVarList.traverseTopDown(visitor);
        if(BracketsList!=null) BracketsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AnotherVarList!=null) AnotherVarList.traverseBottomUp(visitor);
        if(BracketsList!=null) BracketsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AnotherVars(\n");

        if(AnotherVarList!=null)
            buffer.append(AnotherVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+anotherVar);
        buffer.append("\n");

        if(BracketsList!=null)
            buffer.append(BracketsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AnotherVars]");
        return buffer.toString();
    }
}
