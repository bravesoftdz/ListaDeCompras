package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import models.Produto;
import models.ProdutoComida;
import models.ProdutoLimpeza;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.List;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

@SuppressWarnings({ "serial", "unused" })
public class FazerListaWindow extends JFrame {

	private static JPanel contentPane;
	private static JTextField txtProduto;
	private static JTextField txtQuantidade;
	private static JTextField txtLista;
	private static String tituloLista;
	private static int contTitulo = 0;
	static String[] tipos = {"","COMIDA","BEBIDA","LIMPEZA"};
	
	@SuppressWarnings("rawtypes")
	private ArrayList comidas = new ArrayList();
	@SuppressWarnings("rawtypes")
	private ArrayList todos = new ArrayList();
	@SuppressWarnings("rawtypes")
	private ArrayList bebidas = new ArrayList();
	@SuppressWarnings("rawtypes")
	private ArrayList limpezas = new ArrayList();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FazerListaWindow frame = new FazerListaWindow();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ListaCadastrada(@SuppressWarnings("rawtypes") ArrayList lista){
		lista = todos;
		
	}

	@SuppressWarnings("rawtypes")
	public FazerListaWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLista = new JTextField();
		txtLista.setBounds(33, 81, 290, 37);
		contentPane.add(txtLista);
		txtLista.setColumns(10);
		
		if(contTitulo < 0){
			txtLista.setText(tituloLista);
			txtLista.setEditable(false);
		}
		
		txtProduto = new JTextField();
		txtProduto.setText("");
		txtProduto.setBounds(33, 158, 290, 37);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(33, 235, 136, 37);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblNomeDoProduto = DefaultComponentFactory.getInstance().createTitle("Nome do Produto");
		lblNomeDoProduto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNomeDoProduto.setBounds(33, 130, 136, 16);
		contentPane.add(lblNomeDoProduto);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Quantidade");
		lblNewJgoodiesTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewJgoodiesTitle.setBounds(33, 207, 105, 16);
		contentPane.add(lblNewJgoodiesTitle);
		
		@SuppressWarnings("unchecked")
		JComboBox cBoxTipo = new JComboBox(tipos);
		cBoxTipo.setBounds(193, 235, 130, 37);
		contentPane.add(cBoxTipo);
		cBoxTipo.setEditable(false);
		
		JLabel lblTipo = DefaultComponentFactory.getInstance().createTitle("Tipo");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTipo.setBounds(193, 207, 105, 16);
		contentPane.add(lblTipo);
		
		JLabel lblCarrinho = new JLabel("");
		lblCarrinho.setBounds(351, 6, 267, 329);
		contentPane.add(lblCarrinho);
		ImageIcon icon = new ImageIcon(FazerListaWindow.class.getResource("/imgs/lista.jpg"));
		Image ima = icon.getImage();
		Image imagem = ima.getScaledInstance(lblCarrinho.getWidth(), lblCarrinho.getHeight(), Image.SCALE_DEFAULT);
		Icon ico = new ImageIcon(imagem);
		lblCarrinho.setIcon(ico);
		
		
		JButton btnAdicionarALista = new JButton("Adicionar a Lista");
		btnAdicionarALista.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					contTitulo = 5;
					tituloLista = txtLista.getText();
					
				String tipo = (String) cBoxTipo.getSelectedItem();
				
				switch(tipo){
				
				case "COMIDA":
					
					String nomeProdC = txtProduto.getText();
					String quantProdC = txtQuantidade.getText();
					String tpC = (String) cBoxTipo.getSelectedItem();
					
					Produto comida = new ProdutoComida(nomeProdC,quantProdC,tpC);
					comidas.add(comida);
					todos.add(comida);
					
					break;
					
				case "BEBIDA":
					
					String nomeProdB = txtProduto.getText();
					String quantProdB = txtQuantidade.getText();
					String tpB = (String) cBoxTipo.getSelectedItem();
					
					Produto bebida = new ProdutoComida(nomeProdB,quantProdB,tpB);
					bebidas.add(bebida);
					todos.add(bebida);
					
					break;
					
				case "LIMPEZA":
					
					String nomeProdL = txtProduto.getText();
					String quantProdL = txtQuantidade.getText();
					String tpL = (String) cBoxTipo.getSelectedItem();
					
					Produto limpeza = new ProdutoLimpeza(nomeProdL,quantProdL,tpL);
					limpezas.add(limpeza);
					todos.add(limpeza);
					
					break;	
					
				default: 
					String defaulty = "Faltou o tipo";
					JOptionPane.showMessageDialog(null, "Faltou Escolher o tipo!!");
					txtLista.setText("");
					txtProduto.setText("");
					txtQuantidade.setText("");
				}
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "Xii deu Erro meu fi.. Corra logo e pessa ajuda!");
			}
				
				if(todos.isEmpty()){
					
					JOptionPane.showMessageDialog(null, "Xii gravou o produto na lista n�o visse.. Pede ajuda ao Caba que fez essa baga�a");
					
				}else{
					
				txtLista.setEditable(false);
				txtProduto.setText("");
				txtQuantidade.setText("");
				}
			}
		});
		btnAdicionarALista.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAdicionarALista.setBounds(145, 295, 167, 28);
		contentPane.add(btnAdicionarALista);
		
		JButton btnPronto = new JButton("Pronto!");
		btnPronto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
			
				//String caminho = "teste.txt";  
	            //FileWriter writer = new FileWriter(caminho);  
	           //BufferedWriter escr = new BufferedWriter(writer);
				
				String home = System.getProperty("user.desktop");
				File arquivo = new File(home, tituloLista +".txt");
				FileWriter file = new FileWriter(arquivo); 
				BufferedWriter escr = new BufferedWriter(file); 
				
	            escr.write("\t\t\t"+tituloLista);
	            escr.newLine();
	            escr.newLine();
				for(int i = 0; i < todos.size(); i++){
				Produto aux = (Produto) todos.get(i);
				escr.write(aux.getNome() +"     \t       |\t     Quantidade:     " + aux.getQuantidade() + "     \t|\t     Tipo:     " +aux.getCategoria());
				escr.newLine();
				
				}
				
				escr.flush();
				escr.close();  
				file.close(); 
				
				Desktop desktop = Desktop.getDesktop();
				if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.OPEN)) {
				    desktop.open(arquivo);
				}
			
			} catch (IOException exc) {
				JOptionPane.showMessageDialog(null, "Xii deu Erro meu fi.. Umbora arrumar isso ai logo homi!!");
			}
			
			JOptionPane.showMessageDialog(null, "Pronto agora � so ir fazer a feira.. Que o programa ainda num faz a feira sozinho n�o..");
			txtLista.setText("");
			txtProduto.setText("");
			txtQuantidade.setText("");
			txtLista.setEditable(true);
		}	
		});
		
		btnPronto.setFont(new Font("Dialog", Font.BOLD, 15));
		btnPronto.setBounds(48, 295, 90, 28);
		contentPane.add(btnPronto);
		
		JLabel lblAdicioneProdutosA = DefaultComponentFactory.getInstance().createTitle("Adicione Produtos a lista de Compras");
		lblAdicioneProdutosA.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAdicioneProdutosA.setBounds(6, 6, 333, 16);
		contentPane.add(lblAdicioneProdutosA);
		
		JLabel lblNomeDaLista = DefaultComponentFactory.getInstance().createTitle("Nome da Lista");
		lblNomeDaLista.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNomeDaLista.setBounds(33, 53, 105, 16);
		contentPane.add(lblNomeDaLista);
		
	}
}
