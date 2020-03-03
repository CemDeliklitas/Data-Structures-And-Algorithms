import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
/**
 * Student ID : 041701028
 * @author Cem Deliklitas
 * @since 20/11/2019
 * 
 *
 */
public class cem_deliklitas {
/**
 * 
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {

		myStack<Character> stack = new myStack<Character>();
		File file = new File("Testcase1.java");		
//		File file = new File("Testcase2.java");
//		File file = new File("Testcase3.java");
//		File file = new File("Testcase4.java");
		
		//Case 1 and 3 are false cases.
		//Case 2 and 4 are true cases.
		
		FileReader fileread = new FileReader(file);
		BufferedReader bReader = new BufferedReader(fileread);
		int counter = 0; // counter is calculate how much parenthesis pushing to stacks
		int match = 0;	// match is keep how much parenthesis mathcing 
		int c = 0;
		while ((c = bReader.read()) != -1) {
			char character = (char) c;
			// System.out.print(character);
			if (character == '{' || character == '(') {
				stack.push(character);
				counter++;
				for (Character character1 : stack) {
					System.out.print(character1 + " ");
				}
				System.out.println("");
			} else if (!stack.isEmpty()
					&& (((character == '}' && stack.peek() == '{')) || ((character == ')' && stack.peek() == '(')))) {
				stack.pop();
				match++;
			} else if (stack.isEmpty() && ((character == '}') || character == ')')) {
				stack.push(character);
				counter++;
			} else if (!stack.isEmpty()
					&& ((character == '}' && stack.peek() == '(') || (character == ')' && stack.peek() == '{'))) {
				counter++; // This part is little tricky because if we have .java file which is stores parenthesis like that
						   //  "(}).... or {)} we will have a error and I fix this error for this case. If we have a case like that
						   // the program increased counter value but it wont push item into stack.
			}
		}
		// System.out.println(counter);
		// System.out.println(match);
		if (counter != match) {
			System.out.println("Paranthesis do not match");
		} else {
			System.out.println("Paranthesis is match");
		}
	}
}
