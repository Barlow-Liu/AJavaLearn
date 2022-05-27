package thread;

public interface RequestHandler<T> {
	public void handle(T result);
}
