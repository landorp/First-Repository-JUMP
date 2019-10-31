import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
@SuppressWarnings("serial")
public class CalculatorBuild2 extends JFrame 
{
	//declaring the buttons
    private JButton jbt1;
    private JButton jbt2;
    private JButton jbt3;
    private JButton jbt4;
    private JButton jbt5;
    private JButton jbt6;
    private JButton jbt7;
    private JButton jbt8;
    private JButton jbt9;
    private JButton jbt0;
    private JButton jbtA;
    private JButton jbtB;
    private JButton jbtC;
    private JButton jbtD;
    private JButton jbtE;
    private JButton jbtF;
    private JButton jbtEqual;
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtSolve;
    private JButton jbtClear;
    private JButton jbtPlusMinus;
    private JButton jbtDot;
    private JRadioButton hexa;
    private JRadioButton octa;
    private JRadioButton dec;
    private JRadioButton bin;
    private JRadioButton qWord;
    private JRadioButton Bword;
    private JRadioButton Word;
    private JRadioButton Byte;
    private double TEMP;
    private double SolveTEMP;
    private JTextField jtfResult;
    private JTextArea jtaBits;
    int saved, subtractChosen, multiplyChosen, divideChosen;
	int addChosen;
    //;booleans for the action listeners
	Boolean hexaBool = false;
	Boolean octaBool = false;
	Boolean decBool = false;
	Boolean binBool = false;
    Boolean addBool = false ;
    Boolean subBool = false ;
    Boolean divBool = false ;
    Boolean mulBool = false ;
    Boolean plusMinus = false;
    
    String display = "";
	public CalculatorBuild2()
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame frame = new JFrame("Calculator");
		frame.setVisible(true);
		frame.setSize(400, 200);
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(jtaBits = new JTextArea());
		jtaBits.setSize(2,44);
		jtaBits.setEditable(false);
		//create frame and panel1 for all buttons
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel1 = new JPanel(); 
		panel1.setLayout(new GridLayout(6, 4));
		panel1.add(jbtA = new JButton("A"));
		panel1.add(new JButton(""));
		panel1.add(new JButton(""));
		panel1.add(new JButton(""));
		panel1.add(new JButton(""));
		panel1.add(jbtB = new JButton("B"));
		panel1.add(new JButton("<-"));
		panel1.add(new JButton("CE"));
		panel1.add(jbtClear = new JButton("c"));
		panel1.add(jbtAdd = new JButton("+"));
		panel1.add(jbtC = new JButton("C"));
		panel1.add(jbt7 = new JButton("7"));
		panel1.add(jbt8 = new JButton("8"));
		panel1.add(jbt9 = new JButton("9"));
		panel1.add(jbtSubtract = new JButton("-"));
		panel1.add(jbtD = new JButton("D"));
		panel1.add(jbt4 = new JButton("4"));
		panel1.add(jbt5 = new JButton("5"));
		panel1.add(jbt6 = new JButton("6"));
		panel1.add(jbtMultiply = new JButton("*"));
		panel1.add(jbtE = new JButton("E"));
		panel1.add(jbt1 = new JButton("1"));
		panel1.add(jbt2 = new JButton("2"));
		panel1.add(jbt3 = new JButton("3"));
		panel1.add(jbtDivide = new JButton("/"));
		panel1.add(jbtF = new JButton("F"));
		panel1.add(jbtDot = new JButton("."));
		panel1.add(jbt0 = new JButton("0"));
		panel1.add(jbtPlusMinus = new JButton("+/-"));
		panel1.add(jbtSolve = new JButton("="));

		//create panel2 for display on top of calculator
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(jtfResult = new JTextField());
	    jtfResult.setHorizontalAlignment(JTextField.RIGHT);
	    jtfResult.setEditable(false);
	    
	    JPanel panel3 = new JPanel();
	    panel3.setLayout(new GridLayout(4,1));
	    panel3.setBorder(BorderFactory.createLineBorder(null,3));
	    panel3.add(hexa = new JRadioButton("hexa"));
	    panel3.add(octa = new JRadioButton("octa"));
	    panel3.add(dec = new JRadioButton("dec"));
	    panel3.add(bin = new JRadioButton("bin"));
	    JPanel panel4 = new JPanel();
	    panel4.setLayout(new GridLayout(4,1));
	    panel4.setBorder(BorderFactory.createLineBorder(null,3));
	    panel4.add(qWord = new JRadioButton("qWord"));
	    panel4.add(Bword = new JRadioButton("Bword"));
	    panel4.add(Word = new JRadioButton("Word"));
	    panel4.add(Byte = new JRadioButton("Byte"));
	    JPanel panel5 = new JPanel();
	    panel5.setLayout(new GridLayout(2,1));	   
	    panel5.add(panel3);
	    panel5.add(panel4);
	    JPanel panel6 = new JPanel();
	    panel6.setLayout(new GridLayout(2,1));
	    panel6.add(panel2);
	    panel6.add(panel);
		frame.add(panel1, BorderLayout.EAST);
		frame.add(panel6, BorderLayout.NORTH);
		frame.add(panel5, BorderLayout.WEST);

		frame.pack();
		frame.setVisible(true);
	    
		//action listener for all buttons
	    jbt1.addActionListener(new ListenToOne());
	    jbt2.addActionListener(new ListenToTwo());
	    jbt3.addActionListener(new ListenToThree());
	    jbt4.addActionListener(new ListenToFour());
	    jbt5.addActionListener(new ListenToFive());
	    jbt6.addActionListener(new ListenToSix());
	    jbt7.addActionListener(new ListenToSeven());
	    jbt8.addActionListener(new ListenToEight());
	    jbt9.addActionListener(new ListenToNine());
	    jbt0.addActionListener(new ListenToZero());

	    jbtAdd.addActionListener(new ListenToAdd());
	    jbtSubtract.addActionListener(new ListenToSubtract());
	    jbtMultiply.addActionListener(new ListenToMultiply());
	    jbtDivide.addActionListener(new ListenToDivide());
	    jbtSolve.addActionListener(new ListenToSolve());
	    jbtClear.addActionListener(new ListenToClear());
	    jbtPlusMinus.addActionListener(new ListenToPlusMinus());
	    jbtDot.addActionListener(new ListenToDot());
	    
	    hexa.addActionListener(new ListenToHexa());
	    octa.addActionListener(new ListenToOcta());
	    dec.addActionListener(new ListenToDec());
	    bin.addActionListener(new ListenToBin());
	    
	    
	}

	
	class ListenToHexa implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			jtfResult.setText(Long.toHexString(Long.parseLong(jtfResult.getText())));
			hexaBool = true;
			
		}
	}
	class ListenToOcta implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			jtfResult.setText(Long.toOctalString(Long.parseLong(jtfResult.getText())));
			hexaBool = true;
		}
	}
	class ListenToDec implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	class ListenToBin implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			jtfResult.setText(Long.toBinaryString(Long.parseLong(jtfResult.getText())));
			hexaBool = true;
		}
	}


	class ListenToDot implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
	        display = jtfResult.getText();
	        jtfResult.setText(display + ".");	
		}
	}
	//classes for buttons and tell what to do
	class ListenToPlusMinus implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
	        double plusMinus = Double.parseDouble(String.valueOf(jtfResult.getText()));
	        plusMinus = plusMinus*(-1);
	        jtfResult.setText(String.valueOf(plusMinus));
		}
	}

	class ListenToClear implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        //display = jtfResult.getText();
	        jtfResult.setText("");
	        addBool = false ;
	        subBool = false ;
	        mulBool = false ;
	        divBool = false ;

	        TEMP = 0;
	        SolveTEMP =0 ;
	    }
	}

	class ListenToOne implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "1");
	    }
	}
	class ListenToTwo implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "2");
	    }
	}
	class ListenToThree implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "3");
	    }
	}
	class ListenToFour implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "4");
	    }
	}
	class ListenToFive implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "5");
	    }
	}
	class ListenToSix implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "6");
	    }
	}
	class ListenToSeven implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "7");
	    }
	}
	class ListenToEight implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "8");
	    }
	}
	class ListenToNine implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "9");
	    }
	}
	class ListenToZero implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "0");
	    }
	}

	class ListenToAdd implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        TEMP = Double.parseDouble(jtfResult.getText());
	        jtfResult.setText("");
	        addBool = true ;

	    }
	}
	class ListenToSubtract implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        TEMP = Double.parseDouble(jtfResult.getText());
	        jtfResult.setText("");
	        subBool =true;
	    }
	}
	class ListenToMultiply implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        TEMP = Double.parseDouble(jtfResult.getText());
	        jtfResult.setText("");
	        mulBool = true;

	    }
	}
	class ListenToDivide implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	        TEMP = Double.parseDouble(jtfResult.getText());
	        jtfResult.setText("");
	        divBool =true;
	    }
	}
	class ListenToSolve implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	                    SolveTEMP = Double.parseDouble(jtfResult.getText());
	                    if (addBool == true)
	                    	SolveTEMP = TEMP + SolveTEMP;
	                    else if (subBool == true)
	                        SolveTEMP = TEMP - SolveTEMP;
	                    else if (mulBool == true)
	                        SolveTEMP = SolveTEMP * TEMP;
	                    else if (divBool == true)
	                    	if(TEMP == 0)
	                    		jtfResult.setText("Error");
	                    	else
	                    		SolveTEMP = TEMP / SolveTEMP;
	                  
	        jtfResult.setText(Double.toString(SolveTEMP));

	        addBool = false ;
	        subBool = false ;
	        mulBool = false ;
	        divBool = false ;
	        plusMinus = false;
	    }
	}
}	