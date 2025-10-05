package rs.ac.bg.etf.pp1;

import java.util.HashMap;

import org.apache.log4j.Logger;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.ac.bg.etf.pp1.ast.*;

public class SemanticPass extends VisitorAdaptor {
	
	public SemanticPass(){
		initMap();
	}
	
	private void initMap() {
		this.typeMap.put(0, "void");
		this.typeMap.put(1, "int");
		this.typeMap.put(2, "char");
		this.typeMap.put(3, "array");
		this.typeMap.put(4, "class");
		this.typeMap.put(5, "bool");
		this.typeMap.put(6, "enum");
		this.typeMap.put(7, "interface");
		this.typeMap.put(8, "bool");
	}
	
	private String getFullTypeName(int id) {
		return typeMap.get(id);
	}
	
	public static final int Set = 8;
	
	public static final Struct setType = new Struct(Set);
	public static final Struct boolType = new Struct(Struct.Bool);
	
	HashMap<Integer, String> typeMap = new HashMap<>();
	
	
	boolean errorDetected = false;
	
	//saves last processed type, for easier fetching
	Struct lastType;
	int constValue = 0;
	
	boolean isArray = false;
	
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
	
	//CONST DECLARATION
	
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
				report_error("Type: " + getFullTypeName(firstConst.getConstValueList().struct.getKind()) + " is not assignable to type " + getFullTypeName(lastType.getKind()) + "!",firstConst);
			}
			
		}
		
		
	}
	
	public void visit(RemainingConsts constant) {
		
		//check if const is already declared
		if(Tab.find(constant.getConstName()) != Tab.noObj) {
			report_error("Constant " + constant.getConstName() + " is already declared!", constant);
		}else {
			//check if variable and value are compatibile
			if(constant.getConstValueList().struct.assignableTo(lastType)) {
				
				Obj constantNew = Tab.insert(Obj.Con, constant.getConstName(), lastType);
				constantNew.setAdr(constValue);
				report_info("Constant " + constant.getConstName() + " successfully declared!",constant);
				
				
			}else {
				report_error("Type: " + getFullTypeName(constant.getConstValueList().struct.getKind()) + " is not assignable to type " + getFullTypeName(lastType.getKind()) + "!",constant);
			}
			
		}
		
	}
	
	//VAR DECLARATION
	
	public void visit(FirstVar firstVar) {
		
		//check if variable is already declared
		if(Tab.find(firstVar.getVarName()) != Tab.noObj) {
			report_error("Variable " + firstVar.getVarName() + " is already declared!", firstVar);
		}else {
			
			if(isArray) {
				Struct arr = new Struct(Struct.Array,lastType);
				Tab.insert(Obj.Var, firstVar.getVarName(), arr);
				
				report_info("Declared array: " + firstVar.getVarName(), firstVar);
				
				isArray = false;
			}else {
				report_info("Declared variable: " + firstVar.getVarName(), firstVar);
				Tab.insert(Obj.Var, firstVar.getVarName(), lastType);
			}
			
			
		}
		
		
	}
	
	public void visit(RemainingVars remaining) {
		
		//check if variable is already declared
				if(Tab.find(remaining.getRemainingVar()) != Tab.noObj) {
					report_error("Variable " + remaining.getRemainingVar() + " is already declared!", remaining);
				}else {
					
					if(isArray) {
						Struct arr = new Struct(Struct.Array,lastType);
						Tab.insert(Obj.Var, remaining.getRemainingVar(), arr);
						
						report_info("Declared array: " + remaining.getRemainingVar(), remaining);
						
						isArray = false;
					}else {
						report_info("Declared variable: " + remaining.getRemainingVar(), remaining);
						Tab.insert(Obj.Var, remaining.getRemainingVar(), lastType);
					}
					
					
				}
		
	}
	
	
	public void visit(Brackets brackets) {
		isArray = true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
