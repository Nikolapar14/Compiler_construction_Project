package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.ac.bg.etf.pp1.ast.*;

public class SemanticPass extends VisitorAdaptor {
	
	public static final int Set = 8;
	
	public static final Struct setType = new Struct(Set);
	public static final Struct boolType = new Struct(Struct.Bool);
	
	boolean errorDetected = false;
	
	//saves last processed type, for easier fetching
	Struct lastType;
	int constValue = 0;
	
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
		
		lastType = type.struct;
		
	}
	
	//CONST
	
	@Override
	public void visit(NumberConst numberConst) {
		
		numberConst.struct = Tab.intType;
		constValue = numberConst.getN1();
		
	}
	
	@Override
	public void visit(CharConst charConst) {
		
		charConst.struct = Tab.charType;
		constValue = charConst.getC1();
	}
	
	@Override
	public void visit(BoolTrue bt) {
		
		bt.struct = boolType;
		constValue = 1;
		
	}
	
	@Override
	public void visit(BoolFalse bt) {
		
		bt.struct = boolType;
		constValue = 0;
		
	}
	
	public void visit(FirstConst firstConst) {
		
		
		//check if const is already declared
		if(Tab.find(firstConst.getConstName()) != Tab.noObj) {
			report_error("Constant " + firstConst.getConstName() + " is already declared!", firstConst);
		}else {
			
			//check if variable and value are compatibile
			if(firstConst.getConstValueList().struct.assignableTo(firstConst.getType().struct)) {
				
				Obj constant = Tab.insert(Obj.Con, firstConst.getConstName(), lastType);
				constant.setAdr(constValue);
				report_info("Constant " + firstConst.getConstName() + " successfully declared!",firstConst);
			}else {
				report_error("Type: " + firstConst.getConstValueList().struct.getKind() + " is not assignable to type " + lastType.getKind() + "!",firstConst);
			}
			
		}
		
		
	}
	
}
