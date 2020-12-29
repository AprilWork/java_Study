package stacks_queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
		Stack<HtmlTag> openStack = new Stack<HtmlTag> ();
		if (tags.isEmpty()) return openStack; 

		HtmlTag newTag;
		Iterator<HtmlTag> iterator = tags.iterator();

		while (iterator.hasNext()) {
			newTag = iterator.next();

			if (newTag.isOpenTag()) {
				openStack.push(newTag);
			} else  {
				if (openStack.isEmpty()) {
					if (!newTag.isSelfClosing()) {
						return null;
					} 
				} else {
					if (newTag.matches(openStack.peek())) {
						openStack.pop();
					} else {
						if (!newTag.isSelfClosing()) {
							return openStack;
						}
					}
				}

			}	
		}
		return openStack; 
	}

}

