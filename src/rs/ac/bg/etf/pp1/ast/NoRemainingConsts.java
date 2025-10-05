// generated with ast extension for cup
// version 0.8
// 5/9/2025 17:42:57


package rs.ac.bg.etf.pp1.ast;

public class NoRemainingConsts extends RemainingConstsList {

    public NoRemainingConsts () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoRemainingConsts(\n");

        buffer.append(tab);
        buffer.append(") [NoRemainingConsts]");
        return buffer.toString();
    }
}
