package paren;

import java.util.Stack;

public class ParenthesesUtils {
	String showNesting(String str) {
		Stack<Pair> s = new Stack<>();
		String open = "([{<`";
		String close = ")]}>'";
		String pr = str + "\n";
		for (int i = 0; i < str.length(); i++) {
			char find = str.charAt(i);
			if (open.indexOf(find) >= 0) {
				s.push(new Pair(find, i));
			} // if
			else if (close.indexOf(find) >= 0) {
				// if it is empty or doesn't match
				if ((s.isEmpty()) || (close.indexOf(find) != open.indexOf(s.peek().c))) {
					for (int j = 0; j < i - 1; j++) {
						pr += " ";
					} // for
					pr += (find + "<- UNMATCHED\n");
				} // if
				// if it matches
				else if (close.indexOf(find) == open.indexOf(s.peek().c)) {
					Pair p = s.pop();
					for (int j = 0; j < p.i; j++) {
						pr += " ";
					} // for
					pr += p.c;
					for (int j = 0; j < i - p.i - 1; j++) {
						pr += "-";
					} // for
					pr += (find + "\n");
				} // else if
			} // else if
		} // for
			
		// if the stack still has parens left
		while (!s.isEmpty()) {
			Pair p = s.pop();
			for (int j = 0; j < p.i - 1; j++) {
				pr += " ";
			} // for
			pr += (p.c + "<- UNMATCHED\n");
		} // while
		return pr;
	} // showNesting (str)

	class Pair {

		public Pair(char c, int i) {
			super();
			this.c = c;
			this.i = i;
		} // Pair (char, int)

		char c;
		int i;
	} // class Pair
} // class ParenthesesUtils
