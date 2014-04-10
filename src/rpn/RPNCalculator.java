package rpn;

import java.util.Iterator;
import java.util.Stack;

/**
 * An implementation of an RPN calculator using stacks
 * 
 * Citation: some code taken from own previous assignment on Calculator
 * 
 * @author Giang
 * 
 */
public class RPNCalculator implements StackBasedCalculator {
	/**
	 * A stack to keep track of all added numbers
	 */
	Stack<Double> s = new Stack<Double>();

	@Override
	public void calculate(char op) throws Exception {
		switch (op) {
		case 'c':
			s.clear();
			return;
		case 'r':
			if (!s.isEmpty())
				s.pop();
			return;
		case 'p':
			throw new Exception(s.peek() + "");
		case 's':
			String str = "";
			for (Double num : s) {
				str += num + "\n";
			} // for
			throw new Exception(str);
		} // switch
		Iterator<Double> it = s.iterator();
		try {
			it.next();
			it.next();
		} // try
		catch (Exception e) {
			throw new Exception("Stack is empty.");
		} // catch
		switch (op) {
		case '+':
			s.push(s.pop() + s.pop());
			break;
		case '-':
			s.push(s.pop() - s.pop());
			break;
		case '*':
			s.push(s.pop() * s.pop());
			break;
		case '/':
			s.push(s.pop() / s.pop());
			break;
		default:
			throw new Exception("Calculator does not recognize this operation.");
		} // switch
	} // calculate (char)

	@Override
	public void addNumber(Double num) {
		s.push(num);
	} // addNumber(Double)
} // class RPNCalculator
