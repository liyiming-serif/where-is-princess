import java.util.*;

public class FDChecker {

	/**
	 * Checks whether a decomposition of a table is dependency
	 * preserving under the set of functional dependencies fds
	 * 
	 * @param t1 one of the two tables of the decomposition
	 * @param t2 the second table of the decomposition
	 * @param fds a complete set of functional dependencies that apply to the data
	 * 
	 * @return true if the decomposition is dependency preserving, false otherwise
	 **/
	public static boolean checkDepPres(AttributeSet t1, AttributeSet t2, Set<FunctionalDependency> fds) {
		//your code here
		//a decomposition is dependency preserving, if local functional dependencies are
		//sufficient to enforce the global properties
		//To check a particular functional dependency a -> b is preserved, 
		//you can run the following algorithm
		//result = a
		//while result has not stabilized
		//	for each table in the decomposition
		//		t = result intersect table 
		//		t = closure(t) intersect table
		//		result = result union t
		//if b is contained in result, the dependency is preserved
		return false;
	}

	/**
	 * Checks whether a decomposition of a table is lossless
	 * under the set of functional dependencies fds
	 * 
	 * @param t1 one of the two tables of the decomposition
	 * @param t2 the second table of the decomposition
	 * @param fds a complete set of functional dependencies that apply to the data
	 * 
	 * @return true if the decomposition is lossless, false otherwise
	 **/
	public static boolean checkLossless(AttributeSet t1, AttributeSet t2, Set<FunctionalDependency> fds) {
		//your code here
		//Lossless decompositions do not lose information, the natural join is equal to the 
		//original table.
		//a decomposition is lossless if the common attributes for a superkey for one of the
		//tables.

		//naive implementation
//		if (t1.containsAll(t2) || t2.containsAll(t1)) return true;
		
		AttributeSet inter = (AttributeSet) t1.clone();
		inter.retainAll(t2);
		
		for (Attribute a: t1) {
			FunctionalDependency fd = new FunctionalDependency(inter, a);
			AttributeSet aself = new AttributeSet();
			aself.add(a);
			if (!inter.equals(aself) &&!fds.contains(fd)) {
				for (Attribute b: t2) {
					FunctionalDependency fd2 = new FunctionalDependency(inter, b);
					//check if b->b happens
					AttributeSet bself = new AttributeSet();
					bself.add(b);
					System.out.println(""+ fd.left+fd.right + fd2.left + fd2.right);
					if (!inter.equals(bself) && !fds.contains(fd2)) return false;
				}
			}
		}
		return true;
	}

	//recommended helper method
	//finds the total set of attributes implied by attrs
	private static AttributeSet closure(AttributeSet attrs, Set<FunctionalDependency> fds) {
		return null;
	}
}
