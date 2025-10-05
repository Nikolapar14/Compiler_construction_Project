// generated with ast extension for cup
// version 0.8
// 5/9/2025 13:26:36


package rs.ac.bg.etf.pp1.ast;

public class NoOrCond extends OrCondList {

    public NoOrCond () {
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
        buffer.append("NoOrCond(\n");

        buffer.append(tab);
        buffer.append(") [NoOrCond]");
        return buffer.toString();
    }
}
