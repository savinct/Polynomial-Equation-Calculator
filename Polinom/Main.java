import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class Main extends JFrame{

	JPanel p = new JPanel();
	JTextArea a1 = new JTextArea("P1");
	
	
	JTextArea a2 = new JTextArea("P2");
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JButton plus = new JButton("+");
	JButton minus= new JButton("-");
	JButton impartire = new JButton("*");
	JButton integrare = new JButton("Integrala");
	JButton derivare = new JButton("Derivata");
	
	
	JTextField rez = new JTextField();
	
	GridBagConstraints c = new GridBagConstraints();
	
	public static void main(String[] args) {
		
		new Main();
		
		
	}
	

	public Main() {
		
		super("Polinom App");
		
		setSize(350, 300);
		setResizable(false);

		t1.setPreferredSize(new Dimension(300, 20));
		

		
		p.add(a1);
		p.add(t1);
		
		t2.setPreferredSize(new Dimension(300, 20));
		
		p.add(a2, c);
		p.add(t2, c);
		
		p.add(plus);
		p.add(minus);
		p.add(impartire);
		p.add(integrare);
		p.add(derivare);
		
		rez.setPreferredSize(new Dimension(300, 20));
		
		p.add(rez);
		
		add(p);
		setVisible(true);
		
		plus.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		    	Polinom p1 = new Polinom();
		    	p1.citirePolinom(t1.getText());

		    	
		    	Polinom p2 = new Polinom();
		    	p2.citirePolinom(t2.getText());

		    	Polinom p3 = new Polinom();
		    	
		    	p3 = p1.polinomAdunare(p2);
		    	rez.setText(p3.afisarePolinom());
		    	
		    }
		});
		
		minus.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		    	Polinom p1 = new Polinom();
		    	p1.citirePolinom(t1.getText());
		    	
		    	Polinom p2 = new Polinom();
		    	p2.citirePolinom(t2.getText());
		    	Polinom p3 = new Polinom();
		    	
		    	p3 = p1.polinomScadere(p2);
		    	rez.setText(p3.afisarePolinom());
		    	
		    }
		});
		
		derivare.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		    	Polinom p1 = new Polinom();
		    	p1.citirePolinom(t1.getText());

		    	Polinom p3 = new Polinom();
		    	
		    	p3 = p1.polinomDerivata();
		    	rez.setText(p3.afisarePolinom());
		    	
		    }
		});
		
		
		integrare.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		    	Polinom p1 = new Polinom();
		    	p1.citirePolinom(t1.getText());


		    	Polinom p3 = new Polinom();
		    	
		    	p3 = p1.polinomIntegrala();
		    	rez.setText(p3.afisarePolinom());
		    	
		    }
		});
		
		impartire.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		    	Polinom p1 = new Polinom();
		    	p1.citirePolinom(t1.getText());

		    	
		    	Polinom p2 = new Polinom();
		    	p2.citirePolinom(t2.getText());

		    	Polinom p3 = new Polinom();
		    	
		    	p3 = p1.polinomInmultire(p2);
		    	rez.setText(p3.afisarePolinom());
		    	
		    }
		});
		
	}
	
}
