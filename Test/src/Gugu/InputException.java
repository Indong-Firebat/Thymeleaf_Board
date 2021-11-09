package Gugu;

@SuppressWarnings("serial")
public class InputException extends Exception {
	@Override
	public String getMessage() {
		return "9 이하로 입력해주세요.";
	}
}
