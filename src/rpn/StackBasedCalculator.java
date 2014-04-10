package rpn;

public interface StackBasedCalculator {
	
	/**
	 * Computes result on internal model using operation given
	 * 
	 * Communicates with caller using exceptions
	 * 
	 * @param op, a character
	 * @throws Exception
	 */
	void calculate(char op) throws Exception;
	
	/**
	 * Adds specified number to internal model
	 * @param num
	 */
	void addNumber(Double num);
}
