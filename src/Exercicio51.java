import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.NotActiveException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Exercicio51 {
	static JFrame MenuInicial;
	static JFrame TelaCadastro;
	static JFrame TelaConsulta;
	static JFrame TelaEditarExcluir;
	
	static JButton BotaoSair;
	static JButton BotaoEditar;
	static JButton BotaoAdicionar;
	static JButton BotaoExcluir;
	static JButton BotaoConsultar;
	static JButton BotaoPesquisar;
	static JButton BotaoSairPesq;
	static JButton BotaoSalvar;
	static JButton BotaoCancelar;
	static JButton BotaoSairPesquisa;
	static JButton BotaoOk;
	static JButton BotaoCancel;
	static JButton BotaoSalvarEdicao;
	static JButton BotaoExcluirRegistro;
	
	static JPanel painelPrincipal;
	static JPanel PainelCadastro;
	static JPanel painelconsulta;
	static JPanel painelEditarExcluir;
	
	static JRadioButton RbNome;
	static JRadioButton RbCodigo;
	static JRadioButton RbTodos;
	
	static JTable Tabela;
	static JTable ResultadoPesquisa;
	
	static JTextField CampoNome;
	static JTextField CampoEmail;
	static JTextField CampoTelefone;
	static JTextField CampoCodigo;
	static JTextField CampoCpf;
	static JTextField CampoRg;
	static JTextField CampoPesquisar;
	static JTextField CampoEditarExcluir;
	
	static String[] campos = new String[]{"Código","Nome","e-mail","Telefone","CPF","RG"};
	static DefaultTableModel colunas = new DefaultTableModel(null,campos);
	static String[][] lista = new String[100][6];
	static String[] Posicoes = new String[100];
	static String[] Dados = new String[8];
	
	static JLabel titulo;
	static JLabel msg;
	static JLabel LbNome;
	static JLabel LbCodigo;
	static JLabel LbEmail;
	static JLabel LbTelefone;
	static JLabel LbCpf;
	static JLabel LbRg;
	static JLabel LbPesquisa;
	static JLabel LbMsgEditarExcluir;
	
	static int i = 0;
	static int j = 0;
	static int k = 0;
	static int l = 0;
	static int cod = 0;
	static int QtdeCad = 0;
	static int QtdeLivre = 100;
	static boolean editando = false;
	static boolean excluindo = false;
	
	public static void main(String[] args) {
		LiberarPosicoes();
		InicializarLista();
		CriarMenu();
	}
	
	static void LiberarPosicoes(){
		for(int g=0;g<100;g++){
			Posicoes[g]="Livre";
		}
	}
	
	static int VerificarPosicaoLivre(){
		int Pos = 0;
		for(int a=0;a<100;a++){
			String Conteudo = Posicoes[a];
			if(Conteudo.equals("Livre")){
				Pos = a;
				break;
			}
		}
		return Pos;
	}
	
	static void InicializarLista(){
		for (int f = 0; f < 100; f++) {
			for (int h = 0; h < 6; h++) {
				lista[f][h] = "0"; 
			}
		}
	}
	//funcoes que criam e exibem o menu principal e seus componentes

	static void CriarMenu(){
		MenuInicial = new JFrame("Menu");
	    MenuInicial.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    TravarTela(MenuInicial,600,600);
	    IniciarComponentesMenu();
	}
	
	static void IniciarComponentesMenu(){
		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(null);
		painelPrincipal.setVisible(true);
		painelPrincipal.setBackground(Color.lightGray);
		
		BotaoAdicionar = new JButton("Adicionar");
		BotaoAdicionar.setLayout(null);
		BotaoAdicionar.setVisible(true);
		BotaoAdicionar.setSize(100, 20);
		BotaoAdicionar.setLocation(17, 500);
		HabilitarBotao(BotaoAdicionar,100);
		
		BotaoEditar = new JButton("Editar");
		BotaoEditar.setLayout(null);
		BotaoEditar.setVisible(true);
		BotaoEditar.setSize(100, 20);
		BotaoEditar.setLocation(134, 500);
		//HabilitarBotao(BotaoEditar,0);
		
		BotaoConsultar = new JButton("Consultar");
		BotaoConsultar.setLayout(null);
		BotaoConsultar.setVisible(true);
		BotaoConsultar.setSize(100, 20);
		BotaoConsultar.setLocation(251, 500);
		//HabilitarBotao(BotaoConsultar,0);
		
		BotaoExcluir = new JButton("Excluir");
		BotaoExcluir.setLayout(null);
		BotaoExcluir.setVisible(true);
		BotaoExcluir.setSize(100, 20);
		BotaoExcluir.setLocation(368, 500);
		//HabilitarBotao(BotaoExcluir,0);
		
		BotaoSair = new JButton("Sair");
		BotaoSair.setLayout(null);
		BotaoSair.setVisible(true);
		BotaoSair.setSize(100, 20);
		BotaoSair.setLocation(485, 500);	
		
		Tabela = new JTable();
		Tabela.setLayout(null);
		Tabela.setBounds(10, 70, 575, 400);
		Tabela.setVisible(true);		
		Tabela.setModel(colunas);
		
		titulo = new JLabel("Clientes Cadastrados");
		titulo.setBounds(10,30,250,30);
		titulo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 14));
		titulo.setVisible(true);
		
		msg = new JLabel("Você possui "+QtdeCad+" Clientes cadastrados. Você ainda pode cadastrar "+QtdeLivre+" Clientes");
		msg.setBounds(10,465,500,30);
		msg.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		msg.setVisible(true);
		
		MostrarMenu();
	}
	
	static void MostrarMenu(){
		MenuInicial.getContentPane().setBackground(Color.BLACK); 
    	MenuInicial.setVisible(true);
    	MenuInicial.add(painelPrincipal);
    	painelPrincipal.add(BotaoAdicionar);
    	painelPrincipal.add(BotaoEditar);
    	painelPrincipal.add(BotaoConsultar);
    	painelPrincipal.add(BotaoExcluir);
    	painelPrincipal.add(BotaoSair);
    	painelPrincipal.add(Tabela);
    	painelPrincipal.add(titulo);
    	painelPrincipal.add(msg);
    	ChamarAcoesMenu();
    	CriarTelaCadastro();
    	CriarTelaConsulta();
    	CriarTelaEditarExcluir();
	}
	
	static void AtualizarTelaInicial(){		
		for (int r = 0; r < 100; r++) {
			System.out.println("Posição "+r+" "+Posicoes[r]+"  ");
		}
		
		MenuInicial.dispose();
		CriarMenu();
	}
	//funcoes que criam e exibem a tela de cadastro e seus componentes
	static void CriarTelaCadastro(){
		TelaCadastro = new JFrame("Ficha de Cadastro");
		TelaCadastro.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE);
	    TravarTela(TelaCadastro,600,600);
	    IniciarComponentesCadastro();
	}
	
	static void IniciarComponentesCadastro(){
		PainelCadastro = new JPanel();
		PainelCadastro.setLayout(null);
		PainelCadastro.setVisible(true);
		PainelCadastro.setBackground(Color.lightGray);
		
		BotaoSalvar = new JButton("Salvar");
		BotaoSalvar.setLayout(null);
		BotaoSalvar.setVisible(true);
		BotaoSalvar.setSize(100, 20);
		BotaoSalvar.setLocation(67, 500);
		
		BotaoCancelar = new JButton("Cancelar");
		BotaoCancelar.setLayout(null);
		BotaoCancelar.setVisible(true);
		BotaoCancelar.setSize(100, 20);
		BotaoCancelar.setLocation(447, 500);
		
		CampoCodigo = new JTextField();
		CampoCodigo.setLayout(null);
		CampoCodigo.setBounds(10, 50, 50, 20);
		CampoCodigo.setBackground(Color.red);
		CampoCodigo.setEnabled(false);
		CampoCodigo.setVisible(true);
		
		LbCodigo = new JLabel("Código");
		LbCodigo.setBounds(10,20,50,30);
		LbCodigo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		LbCodigo.setVisible(true);		
		
		CampoNome = new JTextField();
		CampoNome.setLayout(null);
		CampoNome.setBounds(10, 110, 570, 20);		
		CampoNome.setVisible(true);
		
		LbNome = new JLabel("Nome");
		LbNome.setBounds(10,80,50,30);
		LbNome.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		LbNome.setVisible(true);
		
		CampoEmail = new JTextField();
		CampoEmail.setLayout(null);
		CampoEmail.setBounds(10, 180, 570, 20);
		CampoEmail.setVisible(true);
		
		LbEmail = new JLabel("E-mail");
		LbEmail.setBounds(10,160,570,30);
		LbEmail.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		LbEmail.setVisible(true);		
				
		CampoTelefone = new JTextField();
		CampoTelefone.setLayout(null);
		CampoTelefone.setBounds(10, 250, 570, 20);
		CampoTelefone.setVisible(true);
		
		LbTelefone = new JLabel("Telefone(Apenas números)");
		LbTelefone.setBounds(10,230,200,30);
		LbTelefone.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		LbTelefone.setVisible(true);
		
		CampoCpf = new JTextField();
		CampoCpf.setLayout(null);
		CampoCpf.setBounds(10, 320, 570, 20);
		CampoCpf.setVisible(true);
		CampoCpf.setEnabled(false);
		
		LbCpf = new JLabel("CPF(Apenas números)");
		LbCpf.setBounds(10,300,200,30);
		LbCpf.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		LbCpf.setVisible(true);
		
		CampoRg = new JTextField();
		CampoRg.setLayout(null);
		CampoRg.setBounds(10, 390, 570, 20);
		CampoRg.setVisible(true);
		CampoRg.setEnabled(false);
		
		LbRg = new JLabel("RG(Apenas números)");
		LbRg.setBounds(10,370,200,30);
		LbRg.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		LbRg.setVisible(true);
		
		BotaoSalvarEdicao = new JButton("Salvar Edição");
		BotaoSalvarEdicao.setLayout(null);
		BotaoSalvarEdicao.setVisible(false);
		BotaoSalvarEdicao.setSize(200, 20);
		BotaoSalvarEdicao.setLocation(67, 500);
		
		BotaoExcluirRegistro = new JButton("Excluir Registro");
		BotaoExcluirRegistro.setLayout(null);
		BotaoExcluirRegistro.setVisible(false);
		BotaoExcluirRegistro.setSize(200, 20);
		BotaoExcluirRegistro.setLocation(67, 500);
		
		MostrarCadastro();
	}	
	
	static void MostrarCadastro(){
		TelaCadastro.setVisible(false);
		TelaCadastro.add(PainelCadastro);
		PainelCadastro.add(BotaoSalvar);
		PainelCadastro.add(BotaoCancelar);
		PainelCadastro.add(CampoCodigo);
		PainelCadastro.add(LbCodigo);
		PainelCadastro.add(CampoNome);
		PainelCadastro.add(LbNome);
		PainelCadastro.add(CampoEmail);
		PainelCadastro.add(LbEmail);
		PainelCadastro.add(CampoTelefone);
		PainelCadastro.add(LbTelefone);
		PainelCadastro.add(CampoCpf);
		PainelCadastro.add(LbCpf);
		PainelCadastro.add(CampoRg);
		PainelCadastro.add(LbRg);
		ChamaAcoesCadastro();
	}
	//funcoes que criam e exibem a tela de consulta e seus componentes
	
	static void CriarTelaConsulta(){
		TelaConsulta = new JFrame("Consultar");
		TelaConsulta.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
	    TravarTela(TelaConsulta,600,600);
		
		IniciarComponentesConsulta();
	}
	
	static void IniciarComponentesConsulta(){
		painelconsulta = new JPanel();
		painelconsulta.setLayout(null);
		painelconsulta.setVisible(true);
		painelconsulta.setBackground(Color.lightGray);
		
		LbPesquisa = new JLabel("Selecione um filtro para a pesquisa");
		LbPesquisa.setBounds(10,20,300,30);
		LbPesquisa.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		LbPesquisa.setVisible(true);
		
		RbTodos = new JRadioButton("Listar Todos");
		RbTodos.setLayout(null);
		RbTodos.setSelected(false);
		RbTodos.setBounds(10, 50, 100, 20);
		RbTodos.setVisible(true);
		
		RbCodigo = new JRadioButton("Código");
		RbCodigo.setSelected(false);
		RbCodigo.setLayout(null);
		RbCodigo.setBounds(130, 50, 100, 20);
		RbCodigo.setVisible(true);
		
		RbNome = new JRadioButton("Nome");
		RbNome.setSelected(false);
		RbNome.setLayout(null);
		RbNome.setBounds(260, 50, 100, 20);
		RbNome.setVisible(true);
		
		CampoPesquisar = new JTextField();
		CampoPesquisar.setLayout(null);
		CampoPesquisar.setBounds(10, 100, 570, 20);
		CampoPesquisar.setVisible(true);
		
		BotaoPesquisar = new JButton("Pesquisar");
		BotaoPesquisar.setLayout(null);
		BotaoPesquisar.setVisible(true);
		BotaoPesquisar.setSize(100, 20);
		BotaoPesquisar.setLocation(10, 140);
		
		BotaoSairPesquisa = new JButton("Sair");
		BotaoSairPesquisa.setLayout(null);
		BotaoSairPesquisa.setVisible(true);
		BotaoSairPesquisa.setSize(100, 20);
		BotaoSairPesquisa.setLocation(490, 140);
		
		ResultadoPesquisa = new JTable();
		ResultadoPesquisa.setLayout(null);
		ResultadoPesquisa.setBounds(10, 165, 575, 400);
		ResultadoPesquisa.setVisible(true);		
		ResultadoPesquisa.setModel(colunas);
		
		MostrarConsulta();
	}
	
	static void MostrarConsulta(){
		TelaConsulta.add(painelconsulta);
		painelconsulta.add(LbPesquisa);
		painelconsulta.add(RbTodos);
		painelconsulta.add(RbCodigo);
		painelconsulta.add(RbNome);
		painelconsulta.add(CampoPesquisar);
		painelconsulta.add(BotaoPesquisar);
		painelconsulta.add(ResultadoPesquisa);
		painelconsulta.add(BotaoSairPesquisa);
		TelaConsulta.setVisible(false);
		ChamarAcoesConsulta();		
	}
	
	static void CriarTelaEditarExcluir(){
		TelaEditarExcluir = new JFrame("Selecione um registro");
		TelaEditarExcluir.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		IniciarComponentesTelaEditarExcluir();
	}
	
	static void IniciarComponentesTelaEditarExcluir(){
		painelEditarExcluir = new JPanel();
		painelEditarExcluir.setLayout(null);
		painelEditarExcluir.setVisible(true);
		painelEditarExcluir.setBackground(Color.lightGray);
			
		CampoEditarExcluir = new JTextField();
		CampoEditarExcluir.setLayout(null);
		CampoEditarExcluir.setBounds(10, 50, 270, 20);
		CampoEditarExcluir.setVisible(true);
		
		BotaoOk = new JButton("Ok");
		BotaoOk.setLayout(null);
		BotaoOk.setVisible(true);
		BotaoOk.setSize(100, 20);
		BotaoOk.setLocation(10, 100);
		
		BotaoCancel = new JButton("Cancelar");
		BotaoCancel.setLayout(null);
		BotaoCancel.setVisible(true);
		BotaoCancel.setSize(100, 20);
		BotaoCancel.setLocation(180, 100);
		
		LbMsgEditarExcluir = new JLabel("Informe o Código para busca.");
		LbMsgEditarExcluir.setBounds(10,10,300,30);
		LbMsgEditarExcluir.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		LbMsgEditarExcluir.setVisible(true);
		
		MostrarTelaEditarExcluir();
	}
	
	static void MostrarTelaEditarExcluir(){
		TelaEditarExcluir.add(painelEditarExcluir);
		painelEditarExcluir.add(LbMsgEditarExcluir);
		painelEditarExcluir.add(CampoEditarExcluir);
		painelEditarExcluir.add(BotaoOk);
		painelEditarExcluir.add(BotaoCancel);
		TelaEditarExcluir.setVisible(false);
		TravarTela(TelaEditarExcluir, 300, 180);
		ChamarAcoesEditarExcluir();
	}
	
	static void HabilitarBotao(JButton b, int valor){
		if(cod==valor){
			b.setEnabled(false);
		}else{
			b.setEnabled(true);
		}
	}
	
	static void ChamarAcoesMenu(){
		painelPrincipal.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_F1){
					BotaoAdicionar.doClick();
					System.out.println("Testando");
				}
				
			}
		});
		
		BotaoAdicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoAdicionar.isEnabled()){
					CampoCodigo.setText(String.valueOf(VerificarPosicaoLivre()+1));
					i = VerificarPosicaoLivre();
					j = 0;
					TelaCadastro.setVisible(true);
					MenuInicial.setVisible(false);
				}
				
			}
		});
		
		BotaoConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoConsultar.isEnabled()){
					TelaConsulta.setVisible(true);					
					MenuInicial.setVisible(false);
				}
				
			}
		});		
		
		BotaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoSair.isEnabled()){
					FecharTelas();
				}
			}
		});
		
		BotaoEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoEditar.isEnabled()){
					MenuInicial.setEnabled(false);
					TelaEditarExcluir.setVisible(true);
					editando = true;
				}
			}
		});
		
		BotaoExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoExcluir.isEnabled()){
					MenuInicial.setEnabled(false);
					TelaEditarExcluir.setVisible(true);
					excluindo = true;
				}
			}
		});
		
	}
	
	static void ChamaAcoesCadastro(){
		TelaCadastro.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				editando = false;
				excluindo = false;
				AtualizarTelaInicial();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		BotaoCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoCancelar.isEnabled()){
					TelaCadastro.setVisible(false);
					editando = false;
					excluindo = false;
					AtualizarTelaInicial();
				}
				
			}
		});
		
		BotaoSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoSalvar.isEnabled()){
					Gravar();
					TelaCadastro.setVisible(false);
					AtualizarTelaInicial();
				}	
				
			}
		});	
		
		BotaoSalvarEdicao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (BotaoSalvarEdicao.isEnabled() && BotaoSalvarEdicao.isVisible()) {
					Editar(k, l);
					TelaCadastro.setVisible(false);
					editando = false;
					AtualizarTelaInicial();
				}
				
			}
		});
		
		BotaoExcluirRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoExcluirRegistro.isEnabled() && BotaoExcluirRegistro.isVisible()){
					Excluir(k,l);
					TelaCadastro.setVisible(false);
					excluindo = false;
					AtualizarTelaInicial();
				}
			}
		});
		
		CampoNome.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoNome.setBackground(Color.white);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoNome.setBackground(Color.yellow);
			}
		});
		
		CampoEmail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoEmail.setBackground(Color.white);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoEmail.setBackground(Color.yellow);
			}
		});
		
		CampoTelefone.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoTelefone.setBackground(Color.white);
				String a = CampoTelefone.getText();
				if(ValidarNumeros(a)==false){
					JOptionPane.showMessageDialog(null,"Valor inválido, o campo telefone só pode conter números");
					CampoTelefone.requestFocus();					
				}else{
					CampoCpf.setEnabled(true);
					CampoCpf.requestFocus();
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoTelefone.setBackground(Color.yellow);
				
			}
		});
		
		CampoCpf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoCpf.setBackground(Color.white);
				String a = CampoCpf.getText();
				if(CampoCpf.isEnabled()){
					if(ValidarNumeros(a)==false){
						JOptionPane.showMessageDialog(null,"Valor inválido, o campo CPF só pode conter números");
						CampoCpf.requestFocus();
					}else{
						CampoRg.setEnabled(true);
						CampoRg.requestFocus();
					}
			
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoCpf.setBackground(Color.yellow);
			}
		});
		
		CampoRg.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoRg.setBackground(Color.white);
				String a = CampoCpf.getText();
				if(CampoRg.isEnabled()){
					if(ValidarNumeros(a)==false){
						JOptionPane.showMessageDialog(null,"Valor inválido, o campo RG só pode conter números");
						CampoRg.requestFocus();
					}
					
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoRg.setBackground(Color.yellow);
			}
		});
		
	}
	
	static void ChamarAcoesConsulta(){
		TelaConsulta.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				editando = false;
				excluindo = false;
				AtualizarTelaInicial();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		BotaoSairPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(BotaoSairPesquisa.isEnabled()){
					TelaConsulta.setVisible(false);	
					AtualizarTelaInicial();
				}
			}
		});
		
		RbCodigo.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				RbCodigo.setToolTipText("Buscar pelo código do cliente.");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				RbCodigo.setSelected(true);
				RbNome.setSelected(false);
				RbTodos.setSelected(false);
				CampoPesquisar.setBackground(Color.white);
				CampoPesquisar.setEnabled(true);
			}
		});
		RbNome.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				RbNome.setToolTipText("Buscar pelo nome do cliente");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				RbCodigo.setSelected(false);
				RbNome.setSelected(true);
				RbTodos.setSelected(false);
				CampoPesquisar.setBackground(Color.white);
				CampoPesquisar.setEnabled(true);
				
			}
		});
		
		RbTodos.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				RbTodos.setToolTipText("Listar todos os clientes cadastrados.");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				RbCodigo.setSelected(false);
				RbNome.setSelected(false);
				RbTodos.setSelected(true);
				CampoPesquisar.setBackground(Color.lightGray);
				CampoPesquisar.setEnabled(false);;
			}
		});
		
		CampoPesquisar.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(CampoPesquisar.isEnabled()){
					CampoPesquisar.setBackground(Color.white);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(CampoPesquisar.isEnabled()){
					CampoPesquisar.setBackground(Color.yellow);
				}
			}
		});
	}
	
	static void ChamarAcoesEditarExcluir(){
		TelaEditarExcluir.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				editando = false;
				excluindo = false;
				AtualizarTelaInicial();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		BotaoCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaEditarExcluir.setVisible(false);;
				AtualizarTelaInicial();
			}
		});
		
		BotaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Cd = CampoEditarExcluir.getText();
				BuscarRegistro(Cd);
				MenuInicial.setEnabled(true);
				if(editando){
					String CdReturn = Dados[0];
					if(CdReturn.equals("0")){
						CampoEditarExcluir.hasFocus();
					}else{
						TelaCadastro.setVisible(true);
						CampoCodigo.setText(Dados[0]);
						CampoNome.setText(Dados[1]);
						CampoEmail.setText(Dados[2]);
						CampoTelefone.setText(Dados[3]);
						CampoCpf.setText(Dados[4]);
						CampoRg.setText(Dados[5]);
						k = Integer.parseInt(Dados[6]);
						l = Integer.parseInt(Dados[7]);
						BotaoSalvar.setVisible(false);
						BotaoSalvar.setEnabled(false);
						BotaoSalvarEdicao.setEnabled(true);
						BotaoSalvarEdicao.setVisible(true);
						PainelCadastro.add(BotaoSalvarEdicao);
						TelaEditarExcluir.setVisible(false);
					}
				}else if(excluindo){
					String CdReturn = Dados[0];
					if(CdReturn.equals("0")){
						CampoEditarExcluir.hasFocus();
					}else{
						TelaCadastro.setVisible(true);
						CampoCodigo.setText(Dados[0]);
						CampoNome.setText(Dados[1]);
						CampoEmail.setText(Dados[2]);
						CampoTelefone.setText(Dados[3]);
						CampoCpf.setText(Dados[4]);
						CampoRg.setText(Dados[5]);
						BotaoSalvar.setVisible(false);
						BotaoSalvar.setEnabled(false);
						BotaoExcluirRegistro.setEnabled(true);
						BotaoExcluirRegistro.setVisible(true);
						PainelCadastro.add(BotaoExcluirRegistro);
						TelaEditarExcluir.setVisible(false);
					}
					
				}
			}
		});
		
		CampoEditarExcluir.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoEditarExcluir.setBackground(Color.white);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				CampoEditarExcluir.setBackground(Color.yellow);
			}
		});
		
	}
	
	static void Gravar(){
		lista[i][j]   = CampoCodigo.getText();
		lista[i][j+1] = CampoNome.getText();
		lista[i][j+2] = CampoEmail.getText();
	    lista[i][j+3] = CampoTelefone.getText();
	    lista[i][j+4] = CampoCpf.getText();
	    lista[i][j+5] = CampoRg.getText();
	    Posicoes[i] = "Ocupado";
	    QtdeCad++;
	    QtdeLivre--;
	    cod++;
	    TelaCadastro.setVisible(false);	    
	    MenuInicial.setVisible(true);
	}
	
	static void Editar(int x, int y){
		lista[x][y]   = CampoCodigo.getText();
		lista[x][y+1] = CampoNome.getText();
		lista[x][y+2] = CampoEmail.getText();
	    lista[x][y+3] = CampoTelefone.getText();
	    lista[x][y+4] = CampoCpf.getText();
	    lista[x][y+5] = CampoRg.getText();
	    Posicoes[x] = "Ocupado";
	    TelaCadastro.setVisible(false);
	    MenuInicial.setVisible(true);
	}
	
	static void Excluir(int x, int y){
		lista[x][y]   = "0";
		lista[x][y+1] = "0";
		lista[x][y+2] = "0";
	    lista[x][y+3] = "0";
	    lista[x][y+4] = "0";
	    lista[x][y+5] = "0";
	    Posicoes[x] = "Livre";
	    TelaCadastro.setVisible(false);
	    MenuInicial.setVisible(true);
	    QtdeCad--;
	    QtdeLivre++;
	    cod--;
	}
	
	static void BuscarRegistro(String c){
		boolean achou = false;
		for(int x=0;x<100;x++){
			for(int y=0;y<6;y++){
				String a = lista[x][y];
				System.out.println(a);
				if(y==0){
					if(a.equals(c)){
						achou = true;
						Dados[0] = lista[x][y];
						Dados[1] = lista[x][y+1];
						Dados[2] = lista[x][y+2];
						Dados[3] = lista[x][y+3];
						Dados[4] = lista[x][y+4];
						Dados[5] = lista[x][y+5];
						Dados[6] = String.valueOf(x);
						Dados[7] = String.valueOf(y);
						System.out.println(Dados[0]);
						break;
					}
				}
			}
		}
		if(achou==false){
			JOptionPane.showMessageDialog(null,"Código não encotrado!\n Por favor tente novamente.");
			Dados[0] = "0";
			Dados[1] = "0";
			Dados[2] = "0";
			Dados[3] = "0";
			Dados[4] = "0";
			Dados[5] = "0";
			Dados[6] = "0";
			Dados[7] = "0";
		}
	}
	
	static boolean ValidarNumeros(String e){
		String numeros ="0123456789";
		boolean ENumero = true;
		for(int x =0; x<e.length();x++){
			char c = e.charAt(x);
			for (int z = 0; z < numeros.length(); z++) {
				if(Character.isDigit(c)==false){
					ENumero = false;
				}
			}
		}
		return ENumero;
	}
	
	static boolean VerificarDadosDigitados(Container c){
		boolean LiberadoParaGravar = false;
		for (int contComp = 0; contComp < c.getComponentCount(); contComp++) {
			if(c.getComponent(contComp) instanceof JTextField){
				String nome = c.getName();
				if(nome.equals("CampoTelefone")||nome.equals("CampoCpf")||nome.equals("CampoRg")){
					String txt = "";
				}
			}
		}
		return LiberadoParaGravar;
	}
	static void FecharTelas(){
		System.exit(0);
	}
	
	static void TravarTela(JFrame tela, int l, int a){
		/**/
		Insets in = Toolkit.getDefaultToolkit().getScreenInsets(tela.getGraphicsConfiguration());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        /*recupera a largura  e altura do monitor*/
        int width = d.width - (in.left + in.top);      
        int height = d.height - (in.top + in.bottom); 
        /*Define largura e altura da tela*/
        int largura = l;
        int altura = a;                
        /*Centraliza a tela no monitor*/
        tela.setLocation(((width-largura)/2), ((height-altura)/2));
        /*Cria a tela com o tamanho definido*/
        tela.setSize(largura, altura);
        /*define que o tamanho da tela não poderá ser alterado pelo usuário*/
        tela.setResizable(false);
        tela.addComponentListener(/**/
        	
        	new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
            	tela.setEnabled(true);            	
            }
        }/**/);	
	}
}
