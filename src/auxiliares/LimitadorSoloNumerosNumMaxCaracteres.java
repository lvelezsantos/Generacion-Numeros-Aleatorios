/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Autores:
 * Luis Alfonso Velez Santos
 * Carlos Yesid Hernandez Herrera
 * Jose Esteban Betin Diaz
 */

package auxiliares;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Warlock
 */
public class LimitadorSoloNumerosNumMaxCaracteres extends PlainDocument {
    private JTextField miJTextField;
    private int nroMaxCaracteres;

    public LimitadorSoloNumerosNumMaxCaracteres(JTextField mijtext, int nroMaxCaract){
        miJTextField=mijtext;
        nroMaxCaracteres=nroMaxCaract;
    }


    @Override
   public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException
   {
        for (int i=0;i<arg1.length();i++)
          // si no es digit, volvemos
          if (!(Character.isDigit(arg1.charAt(i)))||(miJTextField.getText().length()+arg1.length())>nroMaxCaracteres||arg1.charAt(i)=='-')
             return;

       // Si todos son digit, insertamos el texto en el JTextField
       super.insertString(arg0, arg1, arg2);
   }

}
