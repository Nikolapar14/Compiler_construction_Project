package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class MJParserTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		
		Logger log = Logger.getLogger(MJParserTest.class);
		
		Reader br = null;
		try {
			File sourceCode = new File("test/program.mj");
			log.info("Compiling source file: " + sourceCode.getAbsolutePath());
			
			br = new BufferedReader(new FileReader(sourceCode));
			Yylex lexer = new Yylex(br);
			
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	        
	        Program prog = (Program)(s.value);
	        
	        //Tabela simbola - inicijalizacija
	        
	        Tab.init();
	        
	        Obj set = Tab.insert(Obj.Type, "set", SemanticPass.setType);
			set.setAdr(-1);
			set.setLevel(-1);
			Obj bool = Tab.insert(Obj.Type, "bool", SemanticPass.boolType);
			bool.setLevel(-1);
			bool.setAdr(-1);
			
			//dodamo metodu add
			Obj add = Tab.insert(Obj.Meth,"add",Tab.noType);
			add.setLevel(2);
			Tab.openScope();
			Obj a = Tab.insert(Obj.Var,"a",SemanticPass.setType);
			a.setAdr(0);
			a.setLevel(1);
			Obj b= Tab.insert(Obj.Var, "b", Tab.intType);
			b.setAdr(1);
			b.setLevel(1);
			Tab.chainLocalSymbols(add);
			Tab.closeScope();
			
			//dodamo metodu addAll
			Obj addAll = Tab.insert(Obj.Meth, "addAll", Tab.noType);
			addAll.setLevel(2);
			Tab.openScope();
			a = Tab.insert(Obj.Var, "a",  SemanticPass.setType);
			a.setAdr(0);
			a.setLevel(1);
			b = Tab.insert(Obj.Var, "b", new Struct(Struct.Array,Tab.intType));
			b.setAdr(1);
			b.setLevel(1);
			Tab.chainLocalSymbols(addAll);
			Tab.closeScope();
	        
	        
	        
			// ispis sintaksnog stabla
			log.info(prog.toString(""));
			log.info("===================================");

			// oblizak apstraktnog sintaksnog stabla
			SemanticPass sem = new SemanticPass();
			prog.traverseBottomUp(sem); 
			
			
			//ispis tabele simbola
			Tab.dump();
	      
			//log.info(" Print count calls = " + sem.printCallCount);
			//log.info(" Deklarisanih promenljivih ima = " + v.varDeclCount);
			
			if(!sem.errorDetected && sem.passed()) {
				log.info("Parsiranje uspesno zavrseno!");
			}else {
				log.error("Parsiranje NIJE uspesno zavrseno");
			}
			
		} 
		finally {
			if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
		}

	}
	
	
}
