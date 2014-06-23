package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import net.jbouchard.bool.BooleanExpressionSolver;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BooleanExpressionSolver_Test {

	ByteArrayOutputStream dislayResult = new ByteArrayOutputStream();
	
	
	@Test
	public void AND_Test(){
		
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		
		try{	
			System.setOut(new PrintStream(dislayResult));
			String[] args = {"-b", "-e", "A&B"};
			exp.main(args);
			String obtained= dislayResult.toString();
			String expected="A B  A&B \n0 0   0  \n0 1   0  \n1 0   0  \n1 1   1";
			Assert.assertEquals(expected, obtained.trim());
			dislayResult.close();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Not yet implemented");
			}
		
		
	}
	
	@Test
	public void OR_Test(){
		
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		
		try{	
			System.setOut(new PrintStream(dislayResult));
			String[] args = {"-b", "-e", "A|B"};
			exp.main(args);
			String obtained= dislayResult.toString();
			String expected="A B  A|B \n0 0   0  \n0 1   1  \n1 0   1  \n1 1   1";
			Assert.assertEquals(expected, obtained.trim());
			dislayResult.close();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Not yet implemented");
			}
		
		
	}
	
	
	@Test
	public void NOT_Test(){
		
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		
		try{	
			System.setOut(new PrintStream(dislayResult));
			String[] args = {"-b", "-e", "~A"};
			exp.main(args);
			String obtained= dislayResult.toString();
			String expected="A  ~A \n0  1  \n1  0";
			Assert.assertEquals(expected, obtained.trim());
			dislayResult.close();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Not yet implemented");
			}
	}

	
	@Test
	public void XOR_Test(){
		
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		
		try{	
			System.setOut(new PrintStream(dislayResult));
			String[] args = {"-b", "-e", "A+B"};
			exp.main(args);
			String obtained= dislayResult.toString();
			String expected="A B  A+B \n0 0   0  \n0 1   1  \n1 0   1  \n1 1   0";
			Assert.assertEquals(expected, obtained.trim());
			dislayResult.close();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Not yet implemented");
			}	
	}
	
	@Test
	public void IFF_Test(){
		
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		
		try{	
			System.setOut(new PrintStream(dislayResult));
			String[] args = {"-b", "-e", "A=B"};
			exp.main(args);
			String obtained= dislayResult.toString();
			String expected="A B  A=B \n0 0   1  \n0 1   0  \n1 0   0  \n1 1   1";
			Assert.assertEquals(expected, obtained.trim());
			dislayResult.close();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Not yet implemented");
			}
		
		
	}
	
	@Test
	public void IMPLIES_Test(){
		
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		
		try{	
			System.setOut(new PrintStream(dislayResult));
			String[] args = {"-b", "-e", "A>B"};
			exp.main(args);
			String obtained= dislayResult.toString();
			String expected="A B  A>B \n0 0   1  \n0 1   1  \n1 0   0  \n1 1   1";
			Assert.assertEquals(expected, obtained.trim());
			dislayResult.close();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Not yet implemented");
			}
		
		
	}
	
	@Test
	public void Expr_Test(){
		
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		
		try{	
			System.setOut(new PrintStream(dislayResult));
			String[] args = {"-b", "-e", "A|B&C"};
			exp.main(args);
			String obtained= dislayResult.toString();
			String expected="A B C  B&C  A|B&C \n0 0 0   0     0   \n0 0 1   0     0   \n0 1 0   0     0   \n0 1 1   1     1   \n1 0 0   0     1   \n1 0 1   0     1   \n1 1 0   0     1   \n1 1 1   1     1";
			Assert.assertEquals(expected, obtained.trim());
			dislayResult.close();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Not yet implemented");
			}
		
		
	}
	
	@Test
	public void Expr_Brakets_Test(){
		
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		
		try{	
			System.setOut(new PrintStream(dislayResult));
			String[] args = {"-b", "-e", "(A|B)&C"};
			exp.main(args);
			String obtained= dislayResult.toString();
			String expected="A B C  A|B  (A|B)&C \n0 0 0   0      0    \n0 0 1   0      0    \n0 1 0   1      0    \n0 1 1   1      1    \n1 0 0   1      0    \n1 0 1   1      1    \n1 1 0   1      0    \n1 1 1   1      1";
			Assert.assertEquals(expected, obtained.trim());
			dislayResult.close();
			
		} catch (Exception e) {
				// TODO Auto-generated catch block
				fail("Not yet implemented");
			}
		
		
	}

	@Rule
	  public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void UnexpectedOp_Test(){
		exception.expectMessage("At character 3: Unexpected unary operator: ~");
		BooleanExpressionSolver exp = new BooleanExpressionSolver();
		System.setOut(new PrintStream(dislayResult));
		String[] args = {"-b", "-e", "A&B~C"};
		
		try{
			exp.main(args);	
		} 
		catch (Exception e) {
			    System.out.println(e);
				fail("At character 3: Unexpected unary operator: ~");
			}
		
		
	}
	

}
