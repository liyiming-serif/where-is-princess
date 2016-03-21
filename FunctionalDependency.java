
public class FunctionalDependency {
	public AttributeSet left;
	public Attribute right;
	
	public FunctionalDependency(AttributeSet l, Attribute r) {
		left = l;
		right = r;
	}
	
	@Override
	public boolean equals(Object other) {
	if(other == null || !(other instanceof FunctionalDependency))
		return false;
	FunctionalDependency otherfd = (FunctionalDependency)other;
	return left.equals(otherfd.left) && right.equals(otherfd.right);
	}
}
