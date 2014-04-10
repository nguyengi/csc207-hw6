package rpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Interface for an RPN calculator
 * @author Giang
 *
 */

public class RPNInterface {
	public static void main(String[] args) throws IOException {
		
	    StackBasedCalculator calc = new RPNCalculator();
	    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter pen = new PrintWriter(System.out);
	    
	    pen.println("RPN calculator supports + - * / p(rint) s(how) c(lear) r(emove)");
	    pen.println("Q to quit");
	    String input = "";
	    
	    while (true)
	      {
	    	pen.flush();
	        input = eyes.readLine();
	        if (input.equalsIgnoreCase("Q"))
	          {
	        	pen.close();
	            return;
	          } // if
	        String[] vals = input.split(" ");
	        for (int i = 0; i < vals.length; i++) {
				try {
					Double num = Double.parseDouble(vals[i]);
					calc.addNumber(num);
				} // try
				catch (Exception e) {
					try
			          {
			            calc.calculate(vals[i].charAt(0));
			          } // try
			        catch (Exception e1)
			          {
			            pen.println(e1.getMessage());
			          } // catch 
				} // catch
			} // for
	      } // while 
	} // main (String[])
} // class RPNInterface
