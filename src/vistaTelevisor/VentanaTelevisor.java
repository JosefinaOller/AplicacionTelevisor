package vistaTelevisor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class VentanaTelevisor extends JFrame {

	private JPanel contentPane;
	//Textos
	private JTextPane boxEmpleado;
	private JTextPane documentoUsuario;
	

	

	/**
	 * Create the frame.
	 */
	public VentanaTelevisor() {
		setTitle("TELEVISOR");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 314);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1);
		panel_1.setBackground(SystemColor.control);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea txtrDocumento = new JTextArea();
		txtrDocumento.setBackground(new Color(255, 240, 245));
		txtrDocumento.setFont(new Font("Monospaced", Font.PLAIN, 40));
		txtrDocumento.setEditable(false);
		txtrDocumento.setText("DOCUMENTO");
		panel_1.add(txtrDocumento, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_2.add(panel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.control);
		panel_2.add(panel_5);
		
		JTextArea txtrBox = new JTextArea();
		txtrBox.setBackground(new Color(255, 245, 238));
		txtrBox.setFont(new Font("Monospaced", Font.PLAIN, 40));
		txtrBox.setText("BOX");
		panel_5.add(txtrBox);
		
		JPanel panel_6CENTRAL = new JPanel();
		contentPane.add(panel_6CENTRAL, BorderLayout.CENTER);
		panel_6CENTRAL.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(UIManager.getBorder("Tree.editorBorder"));
		panel_6CENTRAL.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		documentoUsuario= new JTextPane();
		documentoUsuario.setEditable(false);
		documentoUsuario.setBackground(new Color(255, 240, 245));
		documentoUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 35));
		panel_4.add(documentoUsuario, BorderLayout.CENTER);
		
		JPanel panel_3_1 = new JPanel();
		panel_6CENTRAL.add(panel_3_1);
		panel_3_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(SystemColor.control);
		panel_3_1.add(panel_5_1);
		panel_5_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(UIManager.getBorder("Tree.editorBorder"));
		panel_7.setBackground(Color.BLACK);
		panel_3_1.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		boxEmpleado = new JTextPane();
		boxEmpleado.setEditable(false);
		boxEmpleado.setBackground(new Color(255, 245, 238));
		boxEmpleado.setForeground(new Color(255, 0, 0));
		boxEmpleado.setFont(new Font("Microsoft YaHei", Font.BOLD, 36));
		panel_7.add(boxEmpleado, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setMaximumSize(this.getSize());
	}
	
	
	
	public void limpiar() {
		this.boxEmpleado.setText("");
		this.documentoUsuario.setText("");
	}
	
	public void setBox(String box) {
		this.boxEmpleado.setText(box);
	}
	
	public void setDocumento(String documento) {
		this.documentoUsuario.setText(documento);
	}

}