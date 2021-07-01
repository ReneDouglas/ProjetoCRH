package controle.classes_complementares;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class UpperCaseDocument extends PlainDocument {   
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {  
        if (str == null) {  
            return;  
        }  
        super.insertString(offs, str.toUpperCase(), a);  
    }  
}  
