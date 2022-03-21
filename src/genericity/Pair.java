package genericity;

public class Pair<T> {
	private T first;
	private T second;
	public Pair() {first=null;second=null;}
	public Pair(T first,T second) {this.first=first;this.second=second;}
	public T getFirst() {return first;}
	public T getSecond() {return second;}
	
	public void setFirst(T value) {this.first=value;}
	public void setSecond(T value) {this.second=value;}
	
}
