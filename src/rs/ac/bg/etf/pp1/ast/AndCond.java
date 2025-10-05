// generated with ast extension for cup
// version 0.8
// 5/9/2025 17:42:57


package rs.ac.bg.etf.pp1.ast;

public class AndCond extends AndCondList {

    private AndCondList AndCondList;
    private CondFact CondFact;

    public AndCond (AndCondList AndCondList, CondFact CondFact) {
        this.AndCondList=AndCondList;
        if(AndCondList!=null) AndCondList.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public AndCondList getAndCondList() {
        return AndCondList;
    }

    public void setAndCondList(AndCondList AndCondList) {
        this.AndCondList=AndCondList;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AndCondList!=null) AndCondList.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AndCondList!=null) AndCondList.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AndCondList!=null) AndCondList.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AndCond(\n");

        if(AndCondList!=null)
            buffer.append(AndCondList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AndCond]");
        return buffer.toString();
    }
}
