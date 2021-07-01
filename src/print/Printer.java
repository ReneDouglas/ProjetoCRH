package print;

import java.awt.*;  
import javax.swing.*;  
import java.awt.print.*;  
  
  
/** A simple utility class that lets you very simply print 
*  an arbitrary component. Just pass the component to the 
*  Printer.printComponent. The component you want to 
*  print doesn't need a print method and doesn't have to 
*  implement any interface or do anything special at all. 
*  If you are going to be printing many times, it is 
*  marginally more efficient to first do the following: 
*  <code> 
*  Printer printHelper = new Printer(theComponent); 
*  </code> 
*  then later do <code>printHelper.print()</code>. But 
*  this is a very tiny difference, so in most cases 
*  just do the simpler:  
*  <code> 
*  Printer.printComponent(componentToBePrinted). 
*  </code> 
*/  
public class Printer implements Printable {  
    
  private Component componentToBePrinted;  
    
  private PrinterJob printJob;  
    
  private PageFormat page;  
    
  public Printer(Component componentToBePrinted) {  
      
    this.componentToBePrinted = componentToBePrinted;  
      
    this.printJob = PrinterJob.getPrinterJob();  
      
    page = printJob.defaultPage();  
      
  }//method()  
    
    
  public Printer(Component componentToBePrinted, String jobName) {  
      
    this(componentToBePrinted);  
      
    this.setJobName(jobName);  
      
  }//method()  
    
    
  public static void printComponent(Component c) {  
      
    new Printer(c).print();  
      
  }//method()  
    
    
  public void print() {  
      
    printJob.setPrintable(this, page);  
      
    if (printJob.printDialog())  
        
      try {  
          
        printJob.print();  
          
      } catch(PrinterException pe) {  
          
        System.out.println("Error printing: " + pe);  
          
      }  
        
  }//method()  
    
    
  /** 
   * Este metodo eh invocado por PrintJob para imprimir 
   * a instância de <code>Printable</code>. 
   */  
  public int print(Graphics g, PageFormat pageFormat, int pageIndex) {  
      
    if (pageIndex > 0) {  
        
      return(NO_SUCH_PAGE);  
        
    } else {  
        
      Graphics2D g2d = (Graphics2D)g;  
        
      g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());  
        
      disableDoubleBuffering(componentToBePrinted);  
        
      componentToBePrinted.paint(g2d);  
        
      enableDoubleBuffering(componentToBePrinted);  
        
      return(PAGE_EXISTS);  
        
    }//if-else  
      
  }//method()  
    
    
  public void setJobName(String jobName) {  
      
    printJob.setJobName(jobName);  
      
  }//method()  
    
    
  public void pageSetup() {  
      
    page = printJob.pageDialog(page);  
      
  }//method()  
    
    
  /** The speed and quality of printing suffers dramatically if 
   *  any of the containers have double buffering turned on. 
   *  So this turns if off globally. 
   *  @see enableDoubleBuffering 
   */  
  public static void disableDoubleBuffering(Component c) {  
      
    RepaintManager currentManager = RepaintManager.currentManager(c);  
      
    currentManager.setDoubleBufferingEnabled(false);  
      
  }//method()  
    
    
  /** Re-enables double buffering globally. */  
  public static void enableDoubleBuffering(Component c) {  
      
    RepaintManager currentManager = RepaintManager.currentManager(c);  
      
    currentManager.setDoubleBufferingEnabled(true);  
      
  }//method()  
    
}//class  