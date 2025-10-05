package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.ac.bg.etf.pp1.ast.*;

public class SemanticPass extends VisitorAdaptor {
	
	boolean errorDetected = false;
	
	Logger log = Logger.getLogger(getClass());
	
	
	
	public void report_error(String message, SyntaxNode info) {
		
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
		
	}

	public void report_info(String message, SyntaxNode info) {
		
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
		
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
	//SEMANTIC PASS
	
	@Override
	public void visit(Program program) {
		report_info("Hello program", program);
		
		Tab.chainLocalSymbols(program.getProgName().obj);
		
		
	}
	
	@Override
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}
	
	@Override
	public void visit(Type type) {
		
		Obj node;
		node = Tab.find(type.getTypeName());
		//check if specified type exists in symbol table
		if( node == Tab.noObj) {
			report_error("Specified type " + type.getTypeName() + " doesn't exist in symbol table!", type);
			type.struct = Tab.noType;
		}else {
			//if type is predefined, check if the object node actually represents a type
			if(node.getKind() != Obj.Type) {
				report_error(type.getTypeName() + " doesn't represent a type!",type);
				type.struct = Tab.noType;
			}else {
				type.struct = node.getType();
			}
		}
		
		
	}
	
}
