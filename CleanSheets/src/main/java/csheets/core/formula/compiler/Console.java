/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * ATB (April, 2014): Updated to use antlr3 generated parser and lexer
 */
package csheets.core.formula.compiler;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.Expression;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

/**
 * A test-class for processing formulas from an input stream.
 *
 * @author Einar Pehrson
 */
public class Console {

	/**
	 * Creates a new console for the given input stream.
	 *
	 * @param in the input stream from which formulas are read
	 * @param out the output stream to which messages are written
	 */
	public Console(InputStream in, OutputStream out) {
		// Wraps the output stream
		PrintStream printer;
		if (out instanceof PrintStream) {
			printer = (PrintStream) out;
		} else {
			printer = new PrintStream(out);
		}

		// Fetches a cell
		Workbook workbook = new Workbook(1);
		Spreadsheet sheet = workbook.getSpreadsheet(0);
		Cell cell = sheet.getCell(new Address(0, 0));

		// Reads and compiles input
		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				ANTLRStringStream input = new ANTLRStringStream(line);

				// create the buffer of tokens between the lexer and parser
				FormulaLexer lexer = new FormulaLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);

				FormulaParser parser = new FormulaParser(tokens);
				try {
					CommonTree ast = (CommonTree) parser.expression().getTree();
					if (ast != null) {
						printer.println("AST: " + ast.toStringTree());
						// new antlr.debug.misc.ASTFrame("Formula Viewer", ast).setVisible(true);
						Expression expression = compiler.convert(cell, ast);
						printer.
							println("Formula: " + expression + " = " + expression.
								evaluate());
					}
				} catch (RecognitionException e) {
					//String message="Fatal recognition exception " + e.getClass().getName()+ " : " + e;
					String message = parser.
						getErrorMessage(e, parser.tokenNames);
					//printer.
						//println("At (" + e.line + ";" + e.charPositionInLine + "): " + message);
				} catch (Exception e) {
					// System.err.println(e);
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	/**
	 * Creates a new console for the command-line.
	 *
	 * @param args the command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		new Console(System.in, System.out);
	}
}
