package tema2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import tema3.OperatiiPolinoame;
import tema1.Polinom;

public class UI extends JFrame{

	private static final long serialVersionUID = 1L;
	static OperatiiPolinoame oper = new OperatiiPolinoame();
	//primul pol
	private static JTextField Pol1 = new JTextField(50);
	private static JButton deriv1 = new JButton("derivare");
	private static JButton integr1 = new JButton("integrare");
	private static JLabel pol1 = new JLabel("Polinom 1:");
	
	// al doilea pol
	private static JTextField Pol2 = new JTextField(50);
	private static JButton deriv2 = new JButton("derivare");
	private static JButton integrarePol2 = new JButton("integrare");
	private static JLabel pol2 = new JLabel("Polinom 2:");
	
	//rez
	private static JLabel output = new JLabel("Rezultat");
	private static JTextField outputRez = new JTextField(50);
	private static JButton adunareRez = new JButton("adunare");
	private static JButton scadereRez = new JButton("scadere");
	private static JButton inmultireRez = new JButton("inmultire");
	private static JButton impartireRez = new JButton("imaprtire");
	
    public static void main( String[] args )
    {
    	JFrame frame=new JFrame("Calculator");
    	//primul pol
    			JPanel content1=new JPanel();
    			content1.setLayout(new FlowLayout());
    			content1.add(pol1);
    			content1.add(Pol1);
    			content1.add(deriv1);
    			content1.add(integr1);

    			
    			//al doiela pol;
    			JPanel content2=new JPanel();
    			content2.setLayout(new FlowLayout());
    			content2.add(pol2);
    			content2.add(Pol2);
    			content2.add(deriv2);
    			content2.add(integrarePol2);

    			
    			//rez
    			JPanel content3=new JPanel();
    			content3.setLayout(new FlowLayout());
    			content3.add(output);
    			content3.add(outputRez);
    			content3.add(adunareRez);
    			content3.add(scadereRez);
    			content3.add(inmultireRez);
    			content3.add(impartireRez);
    			
    			JPanel finalPanel = new JPanel();
    			finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.PAGE_AXIS));
    			finalPanel.add(content1);
    			finalPanel.add(content2);
    			finalPanel.add(new JSeparator());
    			finalPanel.add(content3);
    			
    			frame.setContentPane(finalPanel);
    			frame.pack();
    			frame.setTitle("Operatii pe polinoame");
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setLocation(300, 400);
    			frame.setVisible(true);
	
    //listener pentru butoane
	deriv1.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
		try {
			String rezultat = oper.derivare(new Polinom(Pol1.getText())).toString();
			outputRez.setText(rezultat);
		}catch(Exception exp) {
			JOptionPane.showMessageDialog(null, "Input introdus gresit", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
	integr1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {		
			try {
				String rezultat = oper.integrare(new Polinom(Pol1.getText())).toString();
				outputRez.setText(rezultat);
			} catch(Exception exp) {
				JOptionPane.showMessageDialog(null, "Input gresit", "eroare", 0);
			}
		}
	
	});
	
    adunareRez.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String input1 = Pol1.getText();
			String input2 = Pol2.getText();
			
			try{
				String rezultat = oper.adunare(new Polinom(input1), new Polinom(input2)).toString();
				outputRez.setText(rezultat);
			} catch(Exception exp) {
				JOptionPane.showMessageDialog(null, "input gresit", "eroare", JOptionPane.ERROR_MESSAGE);
			}
		}
    });
    
    scadereRez.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String input1 = Pol1.getText();
			String input2 = Pol2.getText();
			
			try{
				String rezultat = oper.scadere(new Polinom(input1), new Polinom(input2)).toString();
				outputRez.setText(rezultat);
			} catch(Exception exp) {
				JOptionPane.showMessageDialog(null, "input gresit", "eroare", JOptionPane.ERROR_MESSAGE);
			}
		}
    });
    
    inmultireRez.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String input1 = Pol1.getText();
			String input2 = Pol2.getText();
			
			try{
				String rezultat = oper.inmultire(new Polinom(input1), new Polinom(input2)).toString();
				outputRez.setText(rezultat);
			} catch(Exception exp) {
				JOptionPane.showMessageDialog(null, "input gresit", "eroare", JOptionPane.ERROR_MESSAGE);
			}
		}
    });
    
    impartireRez.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String input1 = Pol1.getText();
			String input2 = Pol2.getText(); 
			if(input2.equals("0"))
				JOptionPane.showMessageDialog(null, input2, "eroare", 0);
			else
			try {
				Polinom[] rez = oper.impartire(new Polinom(input1), new Polinom(input2));
				String rezultat = rez[0].toString();
				outputRez.setText(rezultat);
					if(rez[1] != null)
						JOptionPane.showMessageDialog(null, "Restul impartirii este: \n" + rez[1].toString(), "Impartire", JOptionPane.PLAIN_MESSAGE);
			} catch(Exception exp) {
				JOptionPane.showMessageDialog(null, "input gresit", "eroare", 0);
			}
		}
    });
    
    }
	
}
