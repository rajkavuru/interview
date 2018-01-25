
public class test {

	public static void Check(String s, int k) {
		
        
        StringBuilder sNew = new StringBuilder();
        int mask = 0;
        boolean found = false;
        for (int i = 0; i <= s.length() - k; i++) {
            found = false;
            sNew.setLength(0);
            mask = 0;
            for (int j = 0; j < k; j++) {
                int val = s.charAt(i + j);
                if ((mask & (1 << val)) > 0) {
                    if (found) {
                        sNew.setLength(0);
                        break;
                    }
                    found = true;
                } else {
                    mask |= (1 << val);
                }
                sNew.append(s.charAt(i + j));
            }
            if (found && !(sNew.toString().isEmpty())) {
                System.out.println(sNew.toString());
            }
	}
     }
	public static void main(String[] args) {
		
	Check("democracy",5);
	}
}
