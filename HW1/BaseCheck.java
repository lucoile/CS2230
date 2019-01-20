
public class BaseCheck {

	public static void main(String[] args) {
        char[] seqA1 = "ATCGATTGAGCTCTAGCG".toCharArray();
		char[] seqB1 = "TAGCTAACTCGAGATCGC".toCharArray();
		if (!base_check(seqA1, seqB1)) {
            System.out.println("FAILED TEST 1");
            System.exit(1);
		}
        
		char[] seqA2 = "ATCGATGGAGCTGTAGCG".toCharArray();
		char[] seqB2 = "TAGCTAACTCGAGATCGA".toCharArray();
		if (base_check(seqA2, seqB2)) {
            System.out.println("FAILED TEST 2");
            System.exit(1);
		}
        
		char[] seqA3 = "ATCGATTGAGCT".toCharArray();
		char[] seqB3 = "TAGCTAACTCGAGATCGC".toCharArray();
		if (base_check(seqA3, seqB3)) {
            System.out.println("FAILED TEST 3");
            System.exit(1);
		}
		
        char[] seqA4 = "ATCGATTGAGCTCTAGCG".toCharArray();
		char[] seqB4 = "TAGCTAACTCGAGATC".toCharArray();
		if (base_check(seqA4, seqB4)) {
            System.out.println("FAILED TEST 4");
            System.exit(1);
		}
        
		char[] seqA5 = "ATCGATTGAGCTCTAGCG".toCharArray();
		char[] seqB5 = "ATCGATTGAGCTCTAGCG".toCharArray();
		if (base_check(seqA5, seqB5)) {
            System.out.println("FAILED TEST 5");
            System.exit(1);
		}
        
		char[] seqA6 = "GGGG".toCharArray();
		char[] seqB6 = "CCCC".toCharArray();
		if (!base_check(seqA6, seqB6)) {
            System.out.println("FAILED TEST 6");
            System.exit(1);
		}
        
        /* We will test your code on additional test
        cases, so make sure it really works. (e.g., you can
        add more of your own test cases, just copy one of the
		above ones and modify it).
        */
        
        System.out.println("Tests passed");
    }
    
    public static boolean base_check(char[] seq1, char[] seq2) {
        if (seq1.length == seq2.length) {
            
            
            for (int i = 0; i < seq1.length; i++) {
                switch(seq1[i]) {
                    case 'A':
                        if (seq2[i] != 'T') return false;
                    case 'T':
                        if (seq2[i] != 'A') return false;
                    case 'G':
                        if (seq2[i] != 'C') return false;
                    case 'C':
                        if (seq2[i] != 'G') return false;
                }
            }
        return true;
        }
    return false;
    }

}
