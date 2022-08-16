/*
 * Class : T o k e n i z e r
 * 
 * @Name : YUEN Yiu Yeung
 * @StdID: 200171873
 * @Class: IT114105/1C
 * @2021-03-24
 */
public class Tokenizer {
    private static final String DELIMITER = "\"(?:\\\\\"|[^\"])*?\"|[\\s.,;:+*/|!=><@?#%&(){}\\-\\^\\[\\]\\&&]+";
    
    public static String[] delimit(String javaStmt) {
        String[] tokens = javaStmt.split(DELIMITER); 
        return tokens;
    }
}