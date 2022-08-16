/**
* class XRef - Cross Reference Map
*
* I understand the meaning of academic dishonesty, in particular plagiarism, copyright infringement
* and collusion. I am aware of the consequences if found to be involved in these misconducts. I hereby
* declare that the work submitted for the "ITP4510 Data Structures & Algorithms" is authentic record
* of my own work.
*
* @Name : YUEN Yiu Yeung
* @StdID: 200171873
* @Class: IT114105/1C
* @2021-03-24
*/
import java.io.*;
import java.util.*;
public class XRef {
    final static String className = "X R e f";
    final static String classDATE = "24-03-2021";
    
    public static void main(String[] args) throws IOException{
        try{
            printHeader();
            String filename = args[0];
            scanFile(filename);
            processFile(filename);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\nUsage: java ReadTextFile <filename>");
            System.out.println("\nE.g  : {\"DSample.java\"} or {\"Sample.java\"}");
        }finally{
            System.out.println("XRef normally terminated.");
        }
    }

    public static void scanFile(String filename) throws IOException {
        try{
            String lines;                                               // Declare lines as the each textLine of the file
            int unitS = 1;                                              // Declare unitS as the lineNumber
            
            Scanner file = new Scanner(new File(filename));             // Read the specific file
            System.out.println("\nSOURCE FILE: " + filename);
            while (file.hasNextLine()){                                 // display SOURCE FILE contents
                lines = file.nextLine();
                if (unitS <= 9)                                         // Counting lineNumber on each lines
                   System.out.print("000" + unitS + " | ");
                else if (unitS <= 99)
                    System.out.print("00" + unitS + " | ");
                else if (unitS <= 999)
                    System.out.print("0" + unitS + " | ");
                else
                    System.out.print(unitS + " | ");
                unitS++;
                System.out.println(lines);
            }            
        } catch (FileNotFoundException e) {
            System.out.println("\nFailed to open file " + "<filename> -> " + filename);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\nUsage: java ReadTextFile <filename>");
            System.out.println("\nE.g  : {\"DSample.java\"} or {\"Sample.java\"}");
        } catch (NullPointerException e) {
            System.out.println("\nNullPointerException occurred.");
        }
    }
    
    public static void processFile(String filename) throws FileNotFoundException{
        String line;
        String[] jreservedW;
        Tokenizer take = new Tokenizer();                               // Call Tokenizer split the line to String array
        int countLine = 0;
        
        Scanner file = new Scanner(new File(filename));                 // Scan the file and read content for CROSS REFERENCE
        LinkedList crossRef = new LinkedList(new StringComparator());

        while(file.hasNextLine()){
            line = file.nextLine();
            countLine++;

            jreservedW = take.delimit(line);                            // Processing the CROSS REFERENCE
            String[] again = new String[jreservedW.length];
            int top = 0;
            char firstChara = ' ';
            boolean istJKW = false;

            for(int i = 0; i < jreservedW.length; i++){
                if(!jreservedW[i].equals("")){
                    for(int c = 0; c < JRWord.length; c++)
                        if(jreservedW[i].matches(JRWord[c]))
                            istJKW =  true;
                    firstChara = jreservedW[i].charAt(0);

                    if(!istJKW)
                        if(firstChara == '$' || firstChara == '_')
                            again[top++] = jreservedW[i];
                        else if(firstChara >= 'a' && firstChara <= 'z')
                            again[top++] = jreservedW[i];
                        else if(firstChara >= 'A' && firstChara <= 'Z')
                            again[top++] = jreservedW[i];
                }
                istJKW = false;
            }

            for(String word: again)
                if(word != null)
                    crossRef.insertInOrder(word,countLine);
        }
        System.out.println("\nCROSS REFERENCE:");
        System.out.println(crossRef.toString());
    } 

    private static String[] JRWord = {                                 // Storing Reserved word in array
        "abstract", "assert", "boolean", "break",
        "byte", "case", "catch", "char", "class", "const", "continue",
        "default", "do", "double", "else", "enum", "extends", "false",
        "final", "finally", "float", "for", "goto", "if", "implements",
        "import", "instanceof", "int", "interface", "long", "native",
        "new", "null", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch",
        "synchronized", "this", "throw", "throws", "transient", "true",
        "try", "void", "volatile", "while"
    };
    
    private static void printHeader(){
        System.out.println(className);
        System.out.println("==================================================");
        System.out.println("Program created by YUEN Yiu Yeung, " + classDATE);
    }
    
    private static void printFooter() {
        System.out.println("\nXRef normally terminated.");
    }
}