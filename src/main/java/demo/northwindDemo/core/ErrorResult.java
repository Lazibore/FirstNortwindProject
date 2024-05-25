package demo.northwindDemo.core;

public class ErrorResult extends Result {

	public ErrorResult(boolean isSuccess, String message) {
		super(false, message);
	}
	
	public ErrorResult(boolean isSuccess) {
		super(false);
	}
}
