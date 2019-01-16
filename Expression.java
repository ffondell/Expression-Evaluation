package expr_eval;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import structure.Stack;

public class Expression {

	/**
	 * Expression to be evaluated
	 */
	String expr;                
    
	/**
	 * Populates the scalars list with simple scalar variables
	 * Scalar characters in the expression 
	 */
	ArrayList<ScalarVariable> scalars;   
	
	/**
	 * Populates the arrays list with simple array variables
	 * Array characters in the expression
	 */
	ArrayList<ArrayVariable> arrays;
    
    /**
     * String containing all delimiters (characters other than variables and constants), 
     * to be used with StringTokenizer
     */
    public static final String delims = " \t*+-/()[]";
    
    /**
     * Initializes this Expression object with an input expression. Sets all other
     * fields to null.
     * 
     * @param expr Expression
     */
    public Expression(String expr) {
        this.expr = expr;
    }

    /**
     * Populates the scalars and arrays lists with characters for scalar and array
     * variables in the expression. For every variable, a SINGLE variable is created and stored,
     * even if it appears more than once in the expression.
     * At this time, values for all variables are set to
     * zero - they will be loaded from a file in the loadVariableValues method.
     */
    public void buildVariable() {
    		/** COMPLETE THIS METHOD **/
    		/** DO NOT create new scalars and arrays **/
    }
    
    /**
     * Loads values for scalars and arrays in the expression
     * 
     * @param sc Scanner for values input
     * @throws IOException If there is a problem with the input 
     */
    public void loadVariableValues(Scanner sc) 
    throws IOException {
        while (sc.hasNextLine()) {
            StringTokenizer st = new StringTokenizer(sc.nextLine().trim());
            int numTokens = st.countTokens();
            String varl = st.nextToken();
            ScalarVariable scal = new ScalarVariable(varl);
            ArrayVariable arr = new ArrayVariable(varl);
            int scali = scalars.indexOf(scal);
            int arri = arrays.indexOf(arr);
            if (scali == -1 && arri == -1) {
            	continue;
            }
            int num = Integer.parseInt(st.nextToken());
            if (numTokens == 2) { // scalar character
                scalars.get(scali).value = num;
            } else { // array character
            	arr = arrays.get(arri);
            	arr.values = new int[num];
                // following are (index,value) pairs
                while (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    StringTokenizer stt = new StringTokenizer(tok," (,)");
                    int index = Integer.parseInt(stt.nextToken());
                    int val = Integer.parseInt(stt.nextToken());
                    arr.values[index] = val;              
                }
            }
        }
    }
    
    
    /**
     * Evaluates the expression, and can use RECURSION to evaluate subexpressions and to evaluate array 
     * subscript expressions.
     * 
     * @param scalars The scalar array list, with values for all scalar items
     * @param arrays The array array list, with values for all array items
     * 
     * @return Result of evaluation
     */

    public double evaluate() {
    		/** COMPLETE THIS METHOD **/
    		// following line just a placeholder for compilation
    		return 0;
    }

    /**
     * Utility method, prints the characters in the scalars list
     */
    public void printScalars() {
        for (ScalarVariable ss: scalars) {
            System.out.println(ss);
        }
    }
    
    /**
     * Utility method, prints the characters in the arrays list
     */
    public void printArrays() {
    		for (ArrayVariable as: arrays) {
    			System.out.println(as);
    		}
    }

}


