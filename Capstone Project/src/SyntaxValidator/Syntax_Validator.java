package SyntaxValidator;

import java.io.IOException;
import java.io.*;
import java.util.*;

import ServicesImpl.serviceImpl;

public class Syntax_Validator
{
	public static void main(String Args[]) throws IOException
	{
		File f1= new File("C:\\Users\\tkukkala\\Desktop\\sample1.java");
		File f2= new File("C:\\Users\\tkukkala\\Desktop\\sample2.java");
		f1.createNewFile();
		if(f2.exists())
		{
			f2.delete();
			f2.createNewFile();
		}
		else
		{
			f2.createNewFile();
		}
		String str="""
				public class sample1
				{
	        		public static void main (String args[]) 
	        		{
	        		     		System.out.println("Hello World!") ;
	        		}
				}
				""";
		HashSet<String> hset=new HashSet<>(); 
		hset.add("public");hset.add("static");hset.add("void");hset.add("main");hset.add("String");hset.add("System");
		hset.add("try");hset.add("catch");hset.add("out");hset.add("float");hset.add("int");hset.add("double");hset.add("char");
		hset.add("new");hset.add("switch");hset.add("default");hset.add("for");hset.add("case");hset.add("while");hset.add("do");
		hset.add("final");hset.add("break");hset.add("boolean");hset.add("import");hset.add("super");hset.add("throw");
		hset.add("throws");hset.add("interface");hset.add("implements");hset.add("finally");hset.add("extends");hset.add("abstract");
		hset.add("continue");hset.add("private");hset.add("protected");hset.add("package");hset.add("const");hset.add("else");
		hset.add("if");hset.add("long");hset.add("goto");hset.add("class");

		serviceImpl si =new serviceImpl();
		try 
		{
			si.filewrite(str);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			si.fileread(f1,str,hset);
		}
		catch(Exception q)
		{
			System.out.println(q.getMessage());
		}
	}
}
