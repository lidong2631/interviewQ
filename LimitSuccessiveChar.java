public class LimitSuccessiveChar {
	public static void main(String[] args) {
		LimitSuccessiveChar lsc = new LimitSuccessiveChar();
		String str = "a";
		System.out.println(lsc.limit(str, 10));
	}

	public String limit(String str, int limit) {
		StringBuilder sb = new StringBuilder();
		if(str==null || str.length()==0 || limit==0)
			return sb.toString();
		char curr = str.charAt(0);
		sb.append(curr);
		int count = 1;
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i)!=curr) {
				curr = str.charAt(i);
				sb.append(curr);
				count=1;
			} else if(str.charAt(i)==curr && count<limit) {
				sb.append(curr);
				count++;
			}
		}
		return sb.toString();
	}
}