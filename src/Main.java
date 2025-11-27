import java.io.*;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;
import ast.*;


public class Main
{
	static public void main(String argv[])
	{
		if (argv.length != 2) {
			System.err.println("Usage: java Main <input file> <output file>");
			System.exit(1);
		}

		Lexer l;
		Parser p;
		Symbol s;
		AstProgram ast;
		FileReader fileReader;
		PrintWriter fileWriter;
		String inputFileName = argv[0];
		String outputFileName = argv[1];
		
		try
		{
			/********************************/
			/* [1] Initialize a file reader */
			/********************************/
			fileReader = new FileReader(inputFileName);

			/********************************/
			/* [2] Initialize a file writer */
			/********************************/
			fileWriter = new PrintWriter(outputFileName);
			
			/******************************/
			/* [3] Initialize a new lexer */
			/******************************/
			l = new Lexer(fileReader);
			
			/*******************************/
			/* [4] Initialize a new parser */
			/*******************************/
			p = new Parser(l, fileWriter);

			/***********************************/
			/* [5] 3 ... 2 ... 1 ... Parse !!! */
			/***********************************/
			ast = (AstProgram) p.parse().value;

			fileWriter.write("OK");
			fileWriter.flush();
			fileWriter.close();
			/*************************/
			/* [6] Print the AST ... */
			/*************************/
			ast.printMe();

			/*************************/
			/* [6.5] Write Ok msg... */
			/*************************/

			
			/*************************/
			/* [7] Close output file */
			/*************************/
	
			
			/*************************************/
			/* [8] Finalize AST GRAPHIZ DOT file */
			/*************************************/
			AstGraphviz.getInstance().finalizeFile();
    	}
			     
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
