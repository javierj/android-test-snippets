package testsnippets.asserts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.test.MoreAsserts;
import junit.framework.TestCase;

/**
 * Examples of the class android.test.MoreAsserts
 * @author Javier J.
 *
 */
public class TestMoreAsserts extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	
	public void testStringMatchesRegEx() {
		MoreAsserts.assertContainsRegex("a+", "aaa");
		// fail -- MoreAsserts.assertContainsRegex("b+", "aaa");
	}
	
	public void testAllElementsAreContentInAnyOrder() {
		List<Integer> org = Arrays.asList(1, 2, 3, 4);
		MoreAsserts.assertContentsInAnyOrder(org, 4, 3, 2, 1);
		// fail -- MoreAsserts.assertContentsInAnyOrder(org, 4, 3, 2);
		// fail -- MoreAsserts.assertContentsInAnyOrder(org, 4, 3, 2, 1, 5);
	}
	
	public void testCollectionIsEmpty() {
		List<Integer> org = new ArrayList<Integer>();
		MoreAsserts.assertEmpty(org);
		org.add(1);
		// fail -- MoreAsserts.assertEmpty(org);
	}
	
	public void testContentsInTheSameOrder() {
		List<Integer> actual = Arrays.asList(1, 2, 3, 4);
		MoreAsserts.assertContentsInOrder(actual, 1, 2, 3, 4);
		// fail -- MoreAsserts.assertContentsInOrder(actual, 4, 3, 2, 1);
	}

	public void testCollectionIsNotEmpty() {
		List<Integer> actual = Arrays.asList(1, 2, 3, 4);
		MoreAsserts.assertNotEmpty(actual);
	}

	
}
