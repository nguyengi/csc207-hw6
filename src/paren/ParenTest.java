package paren;

public class ParenTest {
	public static void main(String[] args) {
		ParenthesesUtils utils = new ParenthesesUtils();
		System.out.println(utils.showNesting("{oh [boy] (I am having) (<so> much) fun matching `symbols'}"));
		System.out.println(utils.showNesting("(Hello (world)"));
		System.out.println(utils.showNesting("(Hello (world))}  ]"));
	}
}
