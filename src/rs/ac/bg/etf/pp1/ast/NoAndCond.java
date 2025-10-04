// generated with ast extension for cup
// version 0.8
// 4/9/2025 12:48:13


package rs.ac.bg.etf.pp1.ast;

public class NoAndCond extends AndCondList {

    public NoAndCond () {
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
        buffer.append("NoAndCond(\n");

        buffer.append(tab);
        buffer.append(") [NoAndCond]");
        return buffer.toString();
    }
}
