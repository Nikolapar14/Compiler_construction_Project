// generated with ast extension for cup
// version 0.8
// 5/9/2025 17:42:57


package rs.ac.bg.etf.pp1.ast;

public class RemainingVars extends RemainingVarsList {

    private RemainingVarsList RemainingVarsList;
    private String remainingVar;
    private BracketsList BracketsList;

    public RemainingVars (RemainingVarsList RemainingVarsList, String remainingVar, BracketsList BracketsList) {
        this.RemainingVarsList=RemainingVarsList;
        if(RemainingVarsList!=null) RemainingVarsList.setParent(this);
        this.remainingVar=remainingVar;
        this.BracketsList=BracketsList;
        if(BracketsList!=null) BracketsList.setParent(this);
    }

    public RemainingVarsList getRemainingVarsList() {
        return RemainingVarsList;
    }

    public void setRemainingVarsList(RemainingVarsList RemainingVarsList) {
        this.RemainingVarsList=RemainingVarsList;
    }

    public String getRemainingVar() {
        return remainingVar;
    }

    public void setRemainingVar(String remainingVar) {
        this.remainingVar=remainingVar;
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
        if(RemainingVarsList!=null) RemainingVarsList.accept(visitor);
        if(BracketsList!=null) BracketsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RemainingVarsList!=null) RemainingVarsList.traverseTopDown(visitor);
        if(BracketsList!=null) BracketsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RemainingVarsList!=null) RemainingVarsList.traverseBottomUp(visitor);
        if(BracketsList!=null) BracketsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RemainingVars(\n");

        if(RemainingVarsList!=null)
            buffer.append(RemainingVarsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+remainingVar);
        buffer.append("\n");

        if(BracketsList!=null)
            buffer.append(BracketsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RemainingVars]");
        return buffer.toString();
    }
}
