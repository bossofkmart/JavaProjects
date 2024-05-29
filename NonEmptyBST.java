package assn04;
import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	
	
	public BST<T> insert(T element){
		if (element.compareTo(this._element) > 0) { //if this number is greater than the element to be inserted

			this._right = this._right.insert(element);

		}
		
	   if (element.compareTo(this._element) < 0) { //if this number is less than the element to be inserted

			 this._left = this._left.insert(element);
		}

		
	return this;
	}
	
	// TODO: remove
	@Override
	
	
	
	public BST<T> remove(T element) {
		if (this._element == null) {
			return null;
		}

		
		else if (element.compareTo(this._element) > 0) {
			this._right = _right.remove(element);
			
		}
		else if (element.compareTo(this._element) < 0) {

			this._left = _left.remove(element);
		}
		
		else {
			
			//here we have two children
			
		if (_left.isEmpty() && _right.isEmpty() ) {

		return new EmptyBST<T>(); 		
		}
		else if (_right.isEmpty()) {
				return _left;
			}
		else if (_left.isEmpty()) {
				return _right;
			}
			
			
			
			
			if (_left != null && _right != null ) {
				

				//here, we guarantee that the elemen on the right is
				//the minimum; since we know it is the minimum, all 
				//the elements to the right will be greater than
				
				
				if (_right.isEmpty() == false){
				this._element = _right.findMin();
				
				//deleting the duplicate
				this._right = _right.remove(this._element);
				}
				
				
				
				
				
				
			}
			
			
		}
		return this;
		
	}
	
	// TODO: remove all in range (inclusive)
	@Override
	public BST<T> remove_range(T start, T end) {

		if (this.isEmpty()){
			return this;
		}

		if (this._element.compareTo(start) > 0){
		this._left = this._left.remove_range(start, end);
		}

		if (this._element.compareTo(end) < 0){
			this._right = this._right.remove_range(start, end);
		}

		if (this._element.compareTo(start) >= 0 && this._element.compareTo(end) <= 0) {
			if (this._left.isEmpty()) {
				return this._right;
			} else if (this._right.isEmpty()) {
				return this._left;
			} else {
				T val = this._right.findMin();
				this._element = val;
				this._right = this._right.remove(val);
			}
		}
		return this;


		}
		


	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {

		System.out.print(this.getElement() + " ");
		this.getLeft().printPreOrderTraversal();
		this.getRight().printPreOrderTraversal();
		
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		
		this.getLeft().printPostOrderTraversal();
		this.getRight().printPostOrderTraversal();
		System.out.print(this.getElement() + " ");
		
	}

	// The findMin method returns the minimum value in the tree.
	@Override
	public T findMin() {
		if(_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
	}

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
