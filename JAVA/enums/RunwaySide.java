package enums;

public enum RunwaySide {
	L, C, R;
	
	public RunwaySide opposite() {
		switch(this) {
			case L:
				return R;
			case R:
				return L;
			case C:
				return C;
			default:
				return null;
		}
	}
}