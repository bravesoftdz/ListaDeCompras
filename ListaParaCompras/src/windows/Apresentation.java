package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import models.Produto;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class Apresentation extends JFrame {

	private JPanel contentPane;
	private static FazerListaWindow flw;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentation frame = new Apresentation();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Apresentation() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFazerLista = new JButton("Fazer Lista");
		btnFazerLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FazerListaWindow frame = new FazerListaWindow();
				Apresentation.this.dispose();
				frame.setVisible(true);
				frame.setResizable(false);
				
			}
		});
		btnFazerLista.setFont(new Font("Dialog", Font.BOLD, 18));
		btnFazerLista.setBounds(50, 189, 147, 59);
		contentPane.add(btnFazerLista);
		
		JLabel lblListaDeCompras = new JLabel("Lista de Compras");
		lblListaDeCompras.setFont(new Font("Dialog", Font.BOLD, 35));
		lblListaDeCompras.setBounds(150, 11, 312, 52);
		contentPane.add(lblListaDeCompras);
		
		JLabel lblfoto = new JLabel("");
		lblfoto.setBackground(SystemColor.menu);
		lblfoto.setBounds(145, 24, 469, 406);
		contentPane.add(lblfoto);
		ImageIcon icon = new ImageIcon(Apresentation.class.getResource("/imgs/family.jpg"));
		Image ima = icon.getImage();
		Image imagem = ima.getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
		Icon ico = new ImageIcon(imagem);
		lblfoto.setIcon(ico);
	}
}
