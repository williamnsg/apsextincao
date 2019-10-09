import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimiteJTextArea extends PlainDocument {
  private int limite;

  LimiteJTextArea(int limite) {
   super();
   this.limite = limite;
   }

  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) return;

    if ((getLength() + str.length()) <= limite) {
      super.insertString(offset, str, attr);
    }
  }
}