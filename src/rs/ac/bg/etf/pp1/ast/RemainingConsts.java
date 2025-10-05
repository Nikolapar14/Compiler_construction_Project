// generated with ast extension for cup
// version 0.8
// 5/9/2025 17:42:57


package rs.ac.bg.etf.pp1.ast;

public class RemainingConsts extends RemainingConstsList {

    private RemainingConstsList RemainingConstsList;
    private String constName;
    private ConstValueList ConstValueList;

    public RemainingConsts (RemainingConstsList RemainingConstsList, String constName, ConstValueList ConstValueList) {
        this.RemainingConstsList=RemainingConstsList;
        if(RemainingConstsList!=null) RemainingConstsList.setParent(this);
        this.constName=constName;
        this.ConstValueList=ConstValueList;
        if(ConstValueList!=null) ConstValueList.setParent(this);
    }

    public RemainingConstsList getRemainingConstsList() {
        return RemainingConstsList;
    }

    public void setRemainingConstsList(RemainingConstsList RemainingConstsList) {
        this.RemainingConstsList=RemainingConstsList;
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RemainingConstsList!=null) RemainingConstsList.accept(visitor);
        if(ConstValueList!=null) ConstValueList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RemainingConstsList!=null) RemainingConstsList.traverseTopDown(visitor);
        if(ConstValueList!=null) ConstValueList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RemainingConstsList!=null) RemainingConstsList.traverseBottomUp(visitor);
        if(ConstValueList!=null) ConstValueList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RemainingConsts(\n");

        if(RemainingConstsList!=null)
            buffer.append(RemainingConstsList.toString("  "+tab));
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
        buffer.append(") [RemainingConsts]");
        return buffer.toString();
    }
}
