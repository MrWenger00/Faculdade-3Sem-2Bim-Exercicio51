import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exercicio51 {
	static JFrame menuInicial;
	static JFrame telaCadastro;
	static JFrame telaConsulta;
	static JFrame telaEditarExcluir;
	static JFrame telaTelefones;
	
	static JButton botaoSair;
	static JButton botaoEditar;
	static JButton botaoAdicionar;
	static JButton botaoExcluir;//IMPLEMENTAR
	static JButton botaoConsultar;
	static JButton botaoPesquisar;
	static JButton botaoSairPesq;
	static JButton botaoSalvar;
	static JButton botaoCancelar;
	static JButton botaoSairPesquisa;
	static JButton botaoOk;
	static JButton botaoCancel;
	static JButton botaoSalvarEdicao;
	static JButton botaoExcluirRegistro;
	static JButton botaoAjuda;
	static JButton botaoAdicionarTelefone;
	static JButton botaoSalvarTelefone;
	static JButton botaoCancelarTelefone;
	static JButton botaoAddTelefone;
	static JButton botaoEditarTelefone;/*IMPLEMENTAR ESSES BOTÕES*/
	static JButton botaoExcluirTelefone;
	
	static JPanel painelPrincipal;
	static JPanel painelCadastro;
	static JPanel painelconsulta;
	static JPanel painelEditarExcluir;
	static JPanel painelTelefones;
	
	static JRadioButton rbNome;
	static JRadioButton rbCodigo;
	static JRadioButton rbTodos;
	
	static JTable tabela;
	static JTable resultadoPesquisa;
	static JTable telefones;
	
	static JPopupMenu menuOpcoes;
	static JPopupMenu menuTelefones;
	
	static JTextField campoNome;
	static JTextField campoEmail;
	static JTextField campoCodigo;
	static JTextField campoCpf;
	static JTextField campoRg;
	static JTextField campoPesquisar;
	static JTextField campoEditarExcluir;
	static JTextField campoTelefone;
	
	static JMenuItem editar;
	static JMenuItem excluir;
	static JMenuItem adicionarTelefone;
	static JMenuItem editarTelefone;
	static JMenuItem excluirTelefone;
	
	static int i                       = 0;
	static int j                       = 0;
	static int k                       = 0;
	static int l                       = 0;
	static int cod                     = 0;
	static int qtdeCad                 = 0;
	static int qtdeLivre               = 100;
	static int cdTelefone              = 1;
	static int tamanhoTotal            = 100;
	static int camposLista             = 5;
	static int tamanhoTel              = 6;
	static int qtdeTel                 = 0;
	static boolean editando            = false;
	static boolean excluindo           = false;
	static boolean adicionandoTelefone = false;
	static boolean atualizarTelefone   = false;
	static boolean cancelando          = false;  
	static String telefone             = "";
	static String cdPesq               = "";
	
	static String[] campos             = new String[]{"Código","Nome","e-mail","CPF","RG"};
	static String[] colunaTelefones    = new String[]{"Código","Telefone"};
	static DefaultTableModel modelo;
	static DefaultTableModel tel;
	static String[][] lista            = new String[tamanhoTotal][camposLista];
	static String[][] telefonesCliente = new String[tamanhoTotal][tamanhoTel];
	static String[] posicoes           = new String[tamanhoTotal];
	static String[] dados              = new String[7];
	
	static JLabel titulo;
	static JLabel msg;
	static JLabel lbNome;
	static JLabel lbCodigo;
	static JLabel lbEmail;
	static JLabel lbTelefone;
	static JLabel lbCpf;
	static JLabel lbRg;
	static JLabel lbPesquisa;
	static JLabel lbMsgEditarExcluir;
	static JLabel lbMsgTelefones;
	static JLabel lbCliente;
	
	public static void main(String[] args) {
		liberarposicoes();
		inicializarLista();
		criarMenu();
	}
	
	static void liberarposicoes(){
		for(int g=0;g<tamanhoTotal;g++){
			posicoes[g]="livre";
		}
	}
	
	static int verificarPosicaoLivre(){
		int pos = 0;
		for(int a=0;a<tamanhoTotal;a++){
			String conteudo = posicoes[a];
			if(conteudo.equals("livre")){
				pos = a;
				break;
			}
		}
		return pos;
	}
	
	static void inicializarLista(){
		for (int f = 0; f < tamanhoTotal; f++) {
			for (int h = 0; h < tamanhoTel; h++) {
				if(h<camposLista){
					lista[f][h] = "*";
				}	
				telefonesCliente[f][h] = "*";
			}
		}
	}
	//funcoes que criam e exibem o menu principal e seus componentes

	static void criarMenu(){
		menuInicial = new JFrame("Menu");
	    menuInicial.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    travarTela(menuInicial,600,600);
	    iniciarComponentesMenu();
	}
	
	static void iniciarComponentesMenu(){
		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(null);
		painelPrincipal.setVisible(true);
		painelPrincipal.setBackground(Color.lightGray);
		
		botaoAjuda = new JButton("Ajuda");
		botaoAjuda.setSize(100,20);
		botaoAjuda.setLocation(485,40);
		botaoAjuda.setVisible(true);
		
		botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.setLayout(null);
		botaoAdicionar.setVisible(true);
		botaoAdicionar.setSize(100, 20);
		botaoAdicionar.setLocation(17, 500);
		habilitarBotao(botaoAdicionar,100);
		
		botaoEditar = new JButton("Editar");
		botaoEditar.setLayout(null);
		botaoEditar.setVisible(true);
		botaoEditar.setSize(100, 20);
		botaoEditar.setLocation(134, 500);
		habilitarBotao(botaoEditar,0);
		
		botaoConsultar = new JButton("Consultar");
		botaoConsultar.setLayout(null);
		botaoConsultar.setVisible(true);
		botaoConsultar.setSize(100, 20);
		botaoConsultar.setLocation(251, 500);
		botaoConsultar.setEnabled(false);
		//habilitarBotao(botaoConsultar,0);//DESABILITADO TEMPORARIAMENTE
		
		botaoExcluir = new JButton("Excluir");
		botaoExcluir.setLayout(null);
		botaoExcluir.setVisible(true);//IMPLEMENTAR
		botaoExcluir.setSize(100, 20);
		botaoExcluir.setLocation(368, 500);
		botaoExcluir.setEnabled(false);
		//habilitarBotao(botaoExcluir,0);//DESABILITADO TEMPORARIAMENTE
		
		botaoSair = new JButton("Sair");
		botaoSair.setLayout(null);
		botaoSair.setVisible(true);
		botaoSair.setSize(100, 20);
		botaoSair.setLocation(485, 500);	
		
		modelo = new DefaultTableModel(campos, 0);		
		modelo.addRow(campos);
		
		editar = new JMenuItem("Editar");
		excluir = new JMenuItem("Excluir");
		adicionarTelefone = new JMenuItem("Adicionar um Telefone");
		
		menuOpcoes = new JPopupMenu();
		menuOpcoes.add(editar);
		menuOpcoes.add(excluir);
		menuOpcoes.add(adicionarTelefone);
		
		tabela = new JTable();
		tabela.setLayout(null);
		tabela.setBounds(10, 70, 575, 400);
		tabela.setVisible(true);
		tabela.setModel(modelo);
		
		titulo = new JLabel("Clientes Cadastrados");
		titulo.setBounds(10,30,250,30);
		titulo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 14));
		titulo.setVisible(true);
		
		msg = new JLabel("Você possui "+qtdeCad+" Clientes cadastrados. Você ainda pode cadastrar "+qtdeLivre+" Clientes");
		msg.setBounds(10,465,500,30);
		msg.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		msg.setVisible(true);
		
		mostrarMenu();
	}
	
	static void mostrarMenu(){
		menuInicial.getContentPane().setBackground(Color.BLACK); 
    	menuInicial.setVisible(true);
    	menuInicial.add(painelPrincipal);
    	painelPrincipal.add(botaoAdicionar);
    	painelPrincipal.add(botaoEditar);
    	painelPrincipal.add(botaoConsultar);
    	painelPrincipal.add(botaoExcluir);
    	painelPrincipal.add(botaoSair);
    	painelPrincipal.add(tabela);
    	tabela.add(menuOpcoes);
    	painelPrincipal.add(titulo);
    	painelPrincipal.add(msg);
    	painelPrincipal.add(botaoAjuda);
    	adicionardadosJTable();
    	chamarAcoesMenu();
    	criarTelaCadastro();
    	criarTelaConsulta();
    	criarTelaEditarExcluir();
    	acoesMenuOpcoes();
    	criarTelaTelefone();
	}
	
	static void atualizarTelaInicial(){	
		editando            = false;
		excluindo           = false;
		adicionandoTelefone = false;
		atualizarTelefone   = false;
		cancelando          = false;
		cdTelefone          = 1;
		cdPesq              = "";
		menuInicial.dispose();
		criarMenu();
	}
	//funcoes que criam e exibem a tela de cadastro e seus componentes
	static void criarTelaCadastro(){
		telaCadastro = new JFrame("Ficha de Cadastro");
		telaCadastro.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE);
	    travarTela(telaCadastro,600,600);
	    iniciarComponentesCadastro();
	}
	
	static void iniciarComponentesCadastro(){
		painelCadastro = new JPanel();
		painelCadastro.setLayout(null);
		painelCadastro.setVisible(true);
		painelCadastro.setBackground(Color.lightGray);
		
		botaoAdicionarTelefone = new JButton("Adicionar Telefone");
		botaoAdicionarTelefone.setLayout(null);
		botaoAdicionarTelefone.setVisible(false);
		botaoAdicionarTelefone.setSize(200, 20);
		botaoAdicionarTelefone.setLocation(10, 380);
		botaoAdicionarTelefone.setEnabled(false);//IMPLEMENTAR ESSA FUNÇÃO
		
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setLayout(null);
		botaoSalvar.setVisible(true);
		botaoSalvar.setSize(100, 20);
		botaoSalvar.setLocation(67, 500);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setLayout(null);
		botaoCancelar.setVisible(true);
		botaoCancelar.setSize(100, 20);
		botaoCancelar.setLocation(447, 500);
		
		campoCodigo = new JTextField();
		campoCodigo.setLayout(null);
		campoCodigo.setBounds(10, 50, 50, 20);
		campoCodigo.setBackground(Color.red);
		campoCodigo.setEnabled(false);
		campoCodigo.setEditable(false);
		campoCodigo.setVisible(true);
		campoCodigo.setName("campoCodigo");
		
		lbCodigo = new JLabel("Código");
		lbCodigo.setBounds(10,20,50,30);
		lbCodigo.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbCodigo.setVisible(true);		
		
		campoNome = new JTextField();
		campoNome.setLayout(null);
		campoNome.setBounds(10, 110, 570, 20);		
		campoNome.setVisible(true);
		campoNome.setName("campoNome");
		
		lbNome = new JLabel("Nome");
		lbNome.setBounds(10,80,50,30);
		lbNome.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbNome.setVisible(true);
		
		campoEmail = new JTextField();
		campoEmail.setLayout(null);
		campoEmail.setBounds(10, 180, 570, 20);
		campoEmail.setVisible(true);
		campoEmail.setName("campoEmail");
		
		lbEmail = new JLabel("E-mail");
		lbEmail.setBounds(10,160,570,30);
		lbEmail.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbEmail.setVisible(true);		
		
		campoCpf = new JTextField();
		campoCpf.setLayout(null);
		campoCpf.setBounds(10, 250, 570, 20);
		campoCpf.setVisible(true);
		campoCpf.setName("campoCpf");
		
		lbCpf = new JLabel("CPF(Apenas números)");
		lbCpf.setBounds(10,230,200,30);
		lbCpf.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbCpf.setVisible(true);
		
		campoRg = new JTextField();
		campoRg.setLayout(null);
		campoRg.setBounds(10, 320, 570, 20);
		campoRg.setVisible(true);
		campoRg.setName("campoRg");
		
		lbRg = new JLabel("RG(Apenas números)");
		lbRg.setBounds(10,300,200,30);
		lbRg.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbRg.setVisible(true);
		
		botaoSalvarEdicao = new JButton("Atualizar");
		botaoSalvarEdicao.setLayout(null);
		botaoSalvarEdicao.setVisible(false);
		botaoSalvarEdicao.setSize(100, 20);
		botaoSalvarEdicao.setLocation(67, 500);
		
		botaoExcluirRegistro = new JButton("Excluir Registro");
		botaoExcluirRegistro.setLayout(null);
		botaoExcluirRegistro.setVisible(false);
		botaoExcluirRegistro.setSize(200, 20);
		botaoExcluirRegistro.setLocation(67, 500);
		
		mostrarCadastro();
	}	
	
	static void mostrarCadastro(){
		telaCadastro.setVisible(false);
		telaCadastro.add(painelCadastro);
		painelCadastro.add(botaoSalvar);
		painelCadastro.add(botaoCancelar);
		painelCadastro.add(campoCodigo);
		painelCadastro.add(lbCodigo);
		painelCadastro.add(campoNome);
		painelCadastro.add(lbNome);
		painelCadastro.add(campoEmail);
		painelCadastro.add(lbEmail);
		painelCadastro.add(campoCpf);
		painelCadastro.add(lbCpf);
		painelCadastro.add(campoRg);
		painelCadastro.add(lbRg);
		painelCadastro.add(botaoAdicionarTelefone);
		chamarAcoesCadastro();
	}
	//funcoes que criam e exibem a tela de consulta e seus componentes
	
	static void criarTelaConsulta(){
		telaConsulta = new JFrame("Consultar");
		telaConsulta.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
	    travarTela(telaConsulta,600,600);
		
		iniciarComponentesConsulta();
	}
	
	static void iniciarComponentesConsulta(){
		painelconsulta = new JPanel();
		painelconsulta.setLayout(null);
		painelconsulta.setVisible(true);
		painelconsulta.setBackground(Color.lightGray);
		
		lbPesquisa = new JLabel("Selecione um filtro para a pesquisa");
		lbPesquisa.setBounds(10,20,300,30);
		lbPesquisa.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbPesquisa.setVisible(true);
		
		rbTodos = new JRadioButton("Listar Todos");
		rbTodos.setLayout(null);
		rbTodos.setSelected(false);
		rbTodos.setBounds(10, 50, 100, 20);
		rbTodos.setVisible(true);
		
		rbCodigo = new JRadioButton("Código");
		rbCodigo.setSelected(false);
		rbCodigo.setLayout(null);
		rbCodigo.setBounds(130, 50, 100, 20);
		rbCodigo.setVisible(true);
		
		rbNome = new JRadioButton("Nome");
		rbNome.setSelected(false);
		rbNome.setLayout(null);
		rbNome.setBounds(260, 50, 100, 20);
		rbNome.setVisible(true);
		
		campoPesquisar = new JTextField();
		campoPesquisar.setLayout(null);
		campoPesquisar.setBounds(10, 100, 570, 20);
		campoPesquisar.setVisible(true);
		
		botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setLayout(null);
		botaoPesquisar.setVisible(true);
		botaoPesquisar.setSize(100, 20);
		botaoPesquisar.setLocation(10, 140);
		
		botaoSairPesquisa = new JButton("Sair");
		botaoSairPesquisa.setLayout(null);
		botaoSairPesquisa.setVisible(true);
		botaoSairPesquisa.setSize(100, 20);
		botaoSairPesquisa.setLocation(490, 140);
		
		resultadoPesquisa = new JTable();
		resultadoPesquisa.setLayout(null);
		resultadoPesquisa.setBounds(10, 165, 575, 400);
		resultadoPesquisa.setVisible(true);		
		resultadoPesquisa.setModel(modelo);
		
		mostrarConsulta();
	}
	
	static void mostrarConsulta(){
		telaConsulta.add(painelconsulta);
		painelconsulta.add(lbPesquisa);
		painelconsulta.add(rbTodos);
		painelconsulta.add(rbCodigo);
		painelconsulta.add(rbNome);
		painelconsulta.add(campoPesquisar);
		painelconsulta.add(botaoPesquisar);
		painelconsulta.add(resultadoPesquisa);
		resultadoPesquisa.add(menuOpcoes);
		painelconsulta.add(botaoSairPesquisa);
		telaConsulta.setVisible(false);
		chamarAcoesConsulta();		
	}
	
	static void criarTelaEditarExcluir(){
		telaEditarExcluir = new JFrame("Selecione um registro");
		telaEditarExcluir.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		iniciarComponentestelaEditarExcluir();
	}
	
	static void iniciarComponentestelaEditarExcluir(){
		painelEditarExcluir = new JPanel();
		painelEditarExcluir.setLayout(null);
		painelEditarExcluir.setVisible(true);
		painelEditarExcluir.setBackground(Color.lightGray);
			
		campoEditarExcluir = new JTextField();
		campoEditarExcluir.setLayout(null);
		campoEditarExcluir.setBounds(10, 50, 270, 20);
		campoEditarExcluir.setVisible(true);
		
		botaoOk = new JButton("Ok");
		botaoOk.setLayout(null);
		botaoOk.setVisible(true);
		botaoOk.setSize(100, 20);
		botaoOk.setLocation(10, 100);
		
		botaoCancel = new JButton("Cancelar");
		botaoCancel.setLayout(null);
		botaoCancel.setVisible(true);
		botaoCancel.setSize(100, 20);
		botaoCancel.setLocation(180, 100);
		
		lbMsgEditarExcluir = new JLabel("Informe o Código para busca.");
		lbMsgEditarExcluir.setBounds(10,10,300,30);
		lbMsgEditarExcluir.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbMsgEditarExcluir.setVisible(true);
		
		mostrarTelaEditarExcluir();
	}
	
	static void mostrarTelaEditarExcluir(){
		telaEditarExcluir.add(painelEditarExcluir);
		painelEditarExcluir.add(lbMsgEditarExcluir);
		painelEditarExcluir.add(campoEditarExcluir);
		painelEditarExcluir.add(botaoOk);
		painelEditarExcluir.add(botaoCancel);
		telaEditarExcluir.setVisible(false);
		travarTela(telaEditarExcluir, 300, 180);
		chamarAcoesEditarExcluir();
	}
	
	static void criarTelaTelefone(){
		telaTelefones = new JFrame("Cadastre Telefones para o cliente");
		telaTelefones.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		iniciarComponentesTelefone();
	}
	
	static void iniciarComponentesTelefone(){
		painelTelefones = new JPanel();
		painelTelefones.setLayout(null);
		painelTelefones.setVisible(true);
		painelTelefones.setBackground(Color.lightGray);
		
		lbTelefone = new JLabel("Telefone");
		lbTelefone.setBounds(10,30,100,20);
		lbTelefone.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbTelefone.setVisible(true);
		
		lbCliente = new JLabel();
		lbCliente.setBounds(10,05,300,20);
		lbCliente.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 12));
		lbCliente.setVisible(true);
		
		campoTelefone = new JTextField();
		campoTelefone.setLayout(null);
		campoTelefone.setBounds(10, 50, 270, 20);
		campoTelefone.setVisible(true);
		
		botaoAddTelefone = new JButton("Adcionar");
		botaoAddTelefone.setLayout(null);
		botaoAddTelefone.setVisible(true);
		botaoAddTelefone.setSize(100, 20);
		botaoAddTelefone.setLocation(10, 90);
		
		botaoSalvarTelefone = new JButton("Salvar");
		botaoSalvarTelefone.setLayout(null);
		botaoSalvarTelefone.setVisible(true);
		botaoSalvarTelefone.setSize(100, 20);
		botaoSalvarTelefone.setLocation(10, 330);
		
		botaoCancelarTelefone = new JButton("Cancelar");
		botaoCancelarTelefone.setLayout(null);
		botaoCancelarTelefone.setVisible(true);
		botaoCancelarTelefone.setSize(100, 20);
		botaoCancelarTelefone.setLocation(180, 330);
		
		tel = new DefaultTableModel(colunaTelefones, 0);
		tel.addRow(colunaTelefones);
		
		telefones = new JTable();
		telefones.setLayout(null);
		telefones.setBounds(10, 120, 475, 200);
		telefones.setVisible(true);
		telefones.setModel(tel);
		
		editarTelefone = new JMenuItem("Editar");
		excluirTelefone = new JMenuItem("Excluir");
		
		menuTelefones = new JPopupMenu();
		menuTelefones.add(editarTelefone);
		menuTelefones.add(excluirTelefone);
		
		//sadasdasdas
		mostrarTelaTelefone();
	}
	
	static void mostrarTelaTelefone(){
		travarTela(telaTelefones, 500, 400);
		telaTelefones.setVisible(false);
		telaTelefones.add(painelTelefones);
		painelTelefones.add(botaoAddTelefone);
		painelTelefones.add(botaoSalvarTelefone);
		painelTelefones.add(botaoCancelarTelefone);
		painelTelefones.add(campoTelefone);
		painelTelefones.add(telefones);
		painelTelefones.add(lbTelefone);
		chamarAcoesTelatelefones();
	}
	
	static void habilitarBotao(JButton b, int valor){
		if(cod==valor){
			b.setEnabled(false);
		}else{
			b.setEnabled(true);
		}
	}
	
	static void chamarAcoesMenu(){
		menuInicial.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void keyReleased(KeyEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode() == KeyEvent.VK_F1){
					botaoAdicionar.doClick();
				}
				
			}
		});
		
		botaoAjuda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				/*Método não ainda implementado */
			}
		});
		
		tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3 && cod>0) {
					menuOpcoes.show(tabela, e.getX(), e.getY());					
				}
			}
		});
		botaoAdicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoAdicionar.isEnabled()){
					campoCodigo.setText(String.valueOf(verificarPosicaoLivre()+1));
					i = verificarPosicaoLivre();
					j = 0;
					telaCadastro.setVisible(true);
					menuInicial.setVisible(false);
				}
				
			}
		});
		
		botaoConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				if(botaoConsultar.isEnabled()){
					telaConsulta.setVisible(true);					
					menuInicial.setVisible(false);
				}
				
			}
		});		
		
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoSair.isEnabled()){
					if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?","Confirmar ação Sair.",  
						    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)  == JOptionPane.YES_OPTION){
						fecharTelas();
					}
				}
			}
		});
		
		botaoEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoEditar.isEnabled()){
					menuInicial.setEnabled(false);
					telaEditarExcluir.setVisible(true);
					editando = true;
				}
			}
		});
		
		botaoExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoExcluir.isEnabled()){
					menuInicial.setEnabled(false);
					telaEditarExcluir.setVisible(true);
					excluindo = true;
				}
			}
		});
		
	}
	/*ações do popupmenu*/
	static void acoesMenuOpcoes(){
		/*IMPLANTAR FUNÇÃO EDITAR****************************************************************/
		editar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int linha = tabela.getSelectedRow();
				if(linha>0){ 
					editando = true;					
					telaCadastro.setVisible(true);
					cdPesq = (String) tabela.getValueAt(linha,0);
					pesquisarRegistro(cdPesq);
					campoCodigo.setText(dados[0]);
					campoNome.setText(dados[1]);
					campoEmail.setText(dados[2]);
					campoCpf.setText(dados[3]);
					campoRg.setText(dados[4]);
					k = Integer.parseInt((String) tabela.getValueAt(linha,0))-1;
					l = 0;
					botaoSalvar.setVisible(false);
					botaoSalvar.setEnabled(false);
					botaoSalvarEdicao.setEnabled(true);
					botaoSalvarEdicao.setVisible(true);
					painelCadastro.add(botaoSalvarEdicao);
				}else{
					JOptionPane.showMessageDialog(null,"Linha selecionada inválida.");
				}
			}
		});
		/*IMPLANTAR EXCLIUR**********************************************************************/
		excluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int linha = tabela.getSelectedRow();
				if(linha>0){
					excluindo = true;
					telaCadastro.setVisible(true);
					campoCodigo.setText((String) tabela.getValueAt(linha,0));
					campoNome.setText((String) tabela.getValueAt(linha, 1));
					campoEmail.setText((String) tabela.getValueAt(linha, 2));
					campoCpf.setText((String) tabela.getValueAt(linha, 3));
					campoRg.setText((String) tabela.getValueAt(linha, 4));
					k = Integer.parseInt((String) tabela.getValueAt(linha, 0))-1;
					l = 0;
					botaoSalvar.setVisible(false);
					botaoSalvar.setEnabled(false);
					botaoExcluirRegistro.setEnabled(true);
					botaoExcluirRegistro.setVisible(true);
					painelCadastro.add(botaoExcluirRegistro);
				}else{
					JOptionPane.showMessageDialog(null,"Linha selecionada inválida.");
				}
			}
		});
		
		adicionarTelefone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int linha = tabela.getSelectedRow();
				if(linha>0){
					editando = true;
					String cdCliente = (String) tabela.getValueAt(linha,0);
					String nomeCliente = (String) tabela.getValueAt(linha, 1);
					cdPesq =cdCliente;
					adicionandoTelefone = true;
					
				    chamarTelaEditarTelefones(cdCliente, nomeCliente);
					//IMPLEMENTAR BUSCAR TELEFONES
					//sada
				}
			}
		});
	}
	
	static void chamarAcoesCadastro(){
		telaCadastro.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				if(editando){
					botaoAdicionarTelefone.setEnabled(false);//IMPLEMENTAR FUNÇÃO ADICIONAR TELEFONE
				}else{
					
					campoEmail.setEnabled(false);
					campoCpf.setEnabled(false);
					campoRg.setEnabled(false);
				}
			}
			
			@Override
			public void windowIconified(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowClosing(WindowEvent e) {

				editando = false;
				excluindo = false;
				atualizarTelaInicial();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowActivated(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
		});
		
		botaoCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoCancelar.isEnabled()){
					cancelando = true;
					if(JOptionPane.showConfirmDialog(null, "Deseja cancelar?","Confirmar ação Cancelar.",  
						    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)  == JOptionPane.YES_OPTION){
						telaCadastro.setVisible(false);
						campoCpf.setEnabled(false);
						campoRg.setEnabled(false);
						atualizarTelaInicial();
						tabela.clearSelection();
						tabela.changeSelection(tabela.getRowCount() - 2, 0, false, false);
					}else{
						cancelando = false;
					}
				}
				
			}
		});
		
		botaoSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoSalvar.isEnabled()){
					if(verificarDadosDigitados(painelCadastro)){
						if(JOptionPane.showConfirmDialog(null, "Deseja salvar o registro?","Confirmar ação salvar",  
							    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)  == JOptionPane.YES_OPTION){
								gravarRegistros();
								telaCadastro.setVisible(false);
								atualizarTelaInicial();
						}
					}else{
						JOptionPane.showMessageDialog(null, "Não foi possível salvar o regitro!\n Todos os campo devem ser preenchidos, verifique os dados informados e tente novamente.");
						campoNome.requestFocus();
					}
				}	
				
			}
		});	
		
		botaoSalvarEdicao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (botaoSalvarEdicao.isEnabled() && botaoSalvarEdicao.isVisible()) {
					if(verificarDadosDigitados(painelCadastro)){
						if(JOptionPane.showConfirmDialog(null, "Deseja salvar o registro?","Confirmar ação salvar",  
							    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)  == JOptionPane.YES_OPTION){
							editarRegistros(k, l);
							telaCadastro.setVisible(false);
							atualizarTelaInicial();
						}
					}
				}
				
			}
		});
		
		botaoExcluirRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoExcluirRegistro.isEnabled() && botaoExcluirRegistro.isVisible()){
					if(JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?","Confirmar ação excluir.",  
						    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)  == JOptionPane.YES_OPTION){
						excluirRegistros(k,l);
						telaCadastro.setVisible(false);
						atualizarTelaInicial();
					}
				}
			}
		});
		
		botaoAdicionarTelefone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(botaoAdicionarTelefone.isEnabled()){
					String cdCliente = campoCodigo.getText();
					String nome = campoNome.getText();
					chamarTelaEditarTelefones(cdCliente,nome);
				}
			}
		});
		
		campoNome.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(campoNome.isEnabled() && !cancelando){
					if(campoNome.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"O campo nome é obrigatório");
						campoNome.requestFocus();						
					}else{
						campoNome.setBackground(Color.white);
						campoEmail.setEnabled(true);
						if(!editando){
							campoEmail.requestFocus();
						}
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {

				campoNome.setBackground(Color.yellow);
			}
		});
		
		campoEmail.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {

				if(campoEmail.isEnabled() && !cancelando){
					if(campoEmail.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"O campo e-mail é obrigatório");
						campoEmail.requestFocus();						
					}else{
						campoEmail.setBackground(Color.white);
						campoCpf.setEnabled(true);
						if(!editando){						
							campoCpf.requestFocus();
						}
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {

				campoEmail.setBackground(Color.yellow);
			}
		});
		
		campoCpf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {

				campoCpf.setBackground(Color.white);
				String a = campoCpf.getText();

				if(campoCpf.isEnabled() && campoCpf.getText().isEmpty() && !cancelando){
					JOptionPane.showMessageDialog(null,"Valor inválido, o campo CPF é obrigatório");
					campoCpf.requestFocus();
				}else{
					if(editando){
						if(validarNumeros(a)){
							if(validarCpf(a)){
								campoRg.setEnabled(true);	
							}else{
								JOptionPane.showMessageDialog(null,"CPF já cadastrado.");
								campoCpf.requestFocus();
							}
						}else{
							JOptionPane.showMessageDialog(null,"Valor inválido, o campo CPF só pode conter números");
							campoCpf.requestFocus();
						}
					}else{
						if(validarNumeros(a)){
							if(validarCpf(a)){		
								campoRg.setEnabled(true);
								campoRg.requestFocus();
							}else{
								JOptionPane.showMessageDialog(null,"CPF já cadastrado.");
								campoCpf.requestFocus();
							}
						}else{
							JOptionPane.showMessageDialog(null,"Valor inválido, o campo CPF só pode conter números");
							campoCpf.requestFocus();
						}
					}
				}					
			}
			@Override
			public void focusGained(FocusEvent e) {
				campoCpf.setBackground(Color.yellow);
			}
		});
		
		campoRg.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {

				campoRg.setBackground(Color.white);
				String a = campoRg.getText();			
				if(campoRg.isEnabled() && campoRg.getText().isEmpty() && !cancelando){
					JOptionPane.showMessageDialog(null,"Valor inválido, o campo RG é obrigatório");
					campoRg.requestFocus();
				}else{
					if(editando){
						if(validarNumeros(a)){
							if(validarCpf(a)){
								botaoAdicionarTelefone.setEnabled(false);//IMPLEMENTAR ESSA FUNÇÃO
								botaoAdicionarTelefone.requestFocus();	
							}else{
								JOptionPane.showMessageDialog(null,"RG já cadastrado.");
								campoRg.requestFocus();
							}
						}else{
							JOptionPane.showMessageDialog(null,"Valor inválido, o campo RG só pode conter números");
							campoRg.requestFocus();
						}
					}else{
						if(validarNumeros(a)){
							if(validarCpf(a)){		
								botaoAdicionarTelefone.setEnabled(false);//IMPLEMENTAR ESSA FUNÇÃO
								botaoAdicionarTelefone.requestFocus();
							}else{
								JOptionPane.showMessageDialog(null,"RG já cadastrado.");
								campoRg.requestFocus();
							}
						}else{
							JOptionPane.showMessageDialog(null,"Valor inválido, o campo RG só pode conter números");
							campoRg.requestFocus();
						}
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {

				campoRg.setBackground(Color.yellow);
			}
		});
		
	}
	
	static void chamarAcoesConsulta(){
		telaConsulta.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowClosing(WindowEvent e) {

				atualizarTelaInicial();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowActivated(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
		});
		
		resultadoPesquisa.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3 && resultadoPesquisa.getRowCount()>1) {
					menuOpcoes.show(resultadoPesquisa, e.getX(), e.getY());
				}
			}
		});
		
		botaoSairPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoSairPesquisa.isEnabled()){
					telaConsulta.setVisible(false);	
					atualizarTelaInicial();
				}
			}
		});
		botaoPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				pesquisar();
			}
		});
		
		rbCodigo.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				rbCodigo.setToolTipText("Buscar pelo código do cliente.");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				rbCodigo.setSelected(true);
				rbNome.setSelected(false);
				rbTodos.setSelected(false);
				campoPesquisar.setBackground(Color.white);
				campoPesquisar.setEnabled(true);
			}
		});
		rbNome.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				rbNome.setToolTipText("Buscar pelo nome do cliente");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				rbCodigo.setSelected(false);
				rbNome.setSelected(true);
				rbTodos.setSelected(false);
				campoPesquisar.setBackground(Color.white);
				campoPesquisar.setEnabled(true);
				
			}
		});
		
		rbTodos.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mousePressed(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseExited(MouseEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

				rbTodos.setToolTipText("Listar todos os clientes cadastrados.");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				rbCodigo.setSelected(false);
				rbNome.setSelected(false);
				rbTodos.setSelected(true);
				campoPesquisar.setBackground(Color.lightGray);
				campoPesquisar.setEnabled(false);;
			}
		});
		
		campoPesquisar.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {

				if(campoPesquisar.isEnabled()){
					campoPesquisar.setBackground(Color.white);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {

				if(campoPesquisar.isEnabled()){
					campoPesquisar.setBackground(Color.yellow);
				}
			}
		});
	}
	
	static void chamarAcoesEditarExcluir(){
		telaEditarExcluir.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowIconified(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowClosing(WindowEvent e) {

				editando = false;
				excluindo = false;
				atualizarTelaInicial();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
			
			@Override
			public void windowActivated(WindowEvent e) {

				/*Método sem implementação necessária*/
			}
		});
		
		botaoCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				telaEditarExcluir.setVisible(false);;
				atualizarTelaInicial();
			}
		});
		
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cdPesq = campoEditarExcluir.getText();
				pesquisarRegistro(cdPesq);
				menuInicial.setEnabled(true);
				if(editando){
					String cdReturn = dados[0];
					if(cdReturn.equals("*")){
						campoEditarExcluir.requestFocus();
					}else{
						telaCadastro.setVisible(true);
						campoCodigo.setText(dados[0]);
						campoNome.setText(dados[1]);
						campoEmail.setText(dados[2]);					
						campoCpf.setText(dados[3]);
						campoRg.setText(dados[4]);
						k = Integer.parseInt(dados[5]);
						l = Integer.parseInt(dados[6]);
						botaoSalvar.setVisible(false);
						botaoSalvar.setEnabled(false);
						botaoSalvarEdicao.setEnabled(true);
						botaoSalvarEdicao.setVisible(true);
						painelCadastro.add(botaoSalvarEdicao);
						telaEditarExcluir.setVisible(false);
					}
				}else if(excluindo){
					String cdReturn = dados[0];
					if(cdReturn.equals("*")){
						campoEditarExcluir.hasFocus();
					}else{
						telaCadastro.setVisible(true);
						campoCodigo.setText(dados[0]);
						campoNome.setText(dados[1]);
						campoEmail.setText(dados[2]);
						campoCpf.setText(dados[4]);
						campoRg.setText(dados[5]);
						botaoSalvar.setVisible(false);
						botaoSalvar.setEnabled(false);
						botaoExcluirRegistro.setEnabled(false);//IMPLEMENTAR
						botaoExcluirRegistro.setVisible(true);
						painelCadastro.add(botaoExcluirRegistro);
						telaEditarExcluir.setVisible(false);
					}
					
				}
			}
		});
		
		campoEditarExcluir.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {

				campoEditarExcluir.setBackground(Color.white);
			}
			
			@Override
			public void focusGained(FocusEvent e) {

				campoEditarExcluir.setBackground(Color.yellow);
			}
		});
		
	}
	static void chamarAcoesTelatelefones(){
		telefones.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				/*Método sem implementação necessária*/
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3 && cdTelefone>1) {
					menuTelefones.show(telefones, e.getX(), e.getY());					
				}
			}
		});

		campoTelefone.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				campoTelefone.setBackground(Color.white);				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				campoTelefone.setBackground(Color.yellow);
			}
		});
		botaoCancelarTelefone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(botaoCancelarTelefone.isEnabled()){
					if(JOptionPane.showConfirmDialog(null, "Deseja cancelar?","Confirmar ação Cancelar.",  
						    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)  == JOptionPane.YES_OPTION){
						telaTelefones.setVisible(false);
						editando = false;
						excluindo = false;
						telefones.clearSelection();
						telefones.changeSelection(telefones.getRowCount() - 2, 0, false, false);
					}
				}
			}
		});
		
		botaoAddTelefone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(cdTelefone<=5){
					String num = campoTelefone.getText();
					if(!validarNumeros(num) || campoTelefone.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Telefone inválido! verifique os dados informados e tente novamente.");
						campoTelefone.requestFocus();
					}else{
						campoTelefone.setBackground(Color.white);					
						telefone = campoTelefone.getText();
						String[] addTable = new String[]{Integer.toString(cdTelefone),telefone};
						tel.addRow(addTable);
						campoTelefone.setText("");
						campoTelefone.requestFocus();
						cdTelefone++;
						qtdeTel++;
					}
				}else{
					JOptionPane.showMessageDialog(null,"O número limite de Telefones para esse cliente foi atingido.");
				}
			}
			
		});
		
		botaoSalvarTelefone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(JOptionPane.showConfirmDialog(null, "Deseja Salvar?","Confirmar ação Salvar.",  
					    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)  == JOptionPane.YES_OPTION){
					int qtde = telefones.getRowCount();
					String[] telefonesCadastrados = new String[qtde];
					for(int x=0;x<qtde;x++){
						if(x>0){
							telefonesCadastrados[x] = (String) telefones.getValueAt(x,1);
						}
					}					
					gravarTelefone(qtde, telefonesCadastrados);
					telaTelefones.setVisible(false);					
					if(adicionandoTelefone){
						atualizarTelaInicial();
					}
					
				}
			}
		});
	}
	
	static int contarTelefonesCliente(String cdCliente) {
		int contTel = 0;
		String vazio = "*";
		for(int x = 0; x<tamanhoTotal;x++){
			for(int y=0;y<tamanhoTel;y++){
				String conteudo = telefonesCliente[x][y];
				if(y==0 && conteudo.equals(cdCliente)){
					for(int z=0;z<tamanhoTel;z++){
						conteudo = telefonesCliente[x][z];
						if(z>0 && !conteudo.equals(vazio)){
							contTel++;
						}
					}
				}
			}
		}
		return contTel;
	}
	
	static void gravarRegistros(){
		lista[i][j]   = campoCodigo.getText();
		lista[i][j+1] = campoNome.getText();
		lista[i][j+2] = campoEmail.getText();
	    lista[i][j+3] = campoCpf.getText();
	    lista[i][j+4] = campoRg.getText();
	    posicoes[i]   = "ocupado";
	    qtdeCad++;
	    qtdeLivre--;
	    cod++;	    		
	    telaCadastro.setVisible(false);	
	}
	
	static void gravarTelefone(int quantidade, String[] dadosParaGravar){
		telefonesCliente[i][j]   = campoCodigo.getText();
		for(int x=0;x<quantidade;x++){
			if(x>0){
				telefonesCliente[i][x] = dadosParaGravar[x];
			}
		}
	}
	
	static void editarRegistros(int x, int y){
		lista[x][y]   = campoCodigo.getText();
		lista[x][y+1] = campoNome.getText();
		lista[x][y+2] = campoEmail.getText();
	    lista[x][y+3] = campoCpf.getText();
	    lista[x][y+4] = campoRg.getText();
	    posicoes[x]   = "ocupado";
	    telaCadastro.setVisible(false);
	    atualizarTelaInicial();
	}
	
	static void excluirRegistros(int x, int y){
		lista[x][y]   = "*";
		lista[x][y+1] = "*";
		lista[x][y+2] = "*";
	    lista[x][y+3] = "*";
	    lista[x][y+4] = "*";
	    posicoes[x] = "Livre";
	    telaCadastro.setVisible(false);
	    qtdeCad--;
	    qtdeLivre++;
	    cod--;
	    atualizarTelaInicial();
	}
	
	static void pesquisarRegistro(String c){
		boolean achou = false;
		for(int x=0;x<tamanhoTotal;x++){
			for(int y=0;y<camposLista;y++){
				String a = lista[x][y];
				if(y==0){
					if(a.equals(c)){
						achou = true;
						dados[0] = lista[x][y];
						dados[1] = lista[x][y+1];
						dados[2] = lista[x][y+2];
						dados[3] = lista[x][y+3];
						dados[4] = lista[x][y+4];
						dados[5] = String.valueOf(x);
						dados[6] = String.valueOf(y);
						break;
					}
				}
			}
		}
		if(!achou){
			JOptionPane.showMessageDialog(null,"Código não encotrado!\n Por favor tente novamente.");
			dados[0] = "*";
			dados[1] = "*";
			dados[2] = "*";
			dados[3] = "*";
			dados[4] = "*";
			dados[5] = "*";
			dados[6] = "*";
		}
	}
	
	static boolean validarNumeros(String e){
		String numeros ="0123456789";
		boolean eNumero = true;
		for(int x =0; x<e.length();x++){
			char c = e.charAt(x);
			for (int z = 0; z < numeros.length(); z++) {
				if(Character.isDigit(c)){
					eNumero = true;
				}else{
					eNumero = false;
				}
			}
		}
		return eNumero;
	}
	
	static void adicionardadosJTable(){
		String[] addTable = new String[6];
		int qtdeRegistros = 0;
		int x=0;
		for (x = 0 ;x<tamanhoTotal;x++){
			String conteudo = posicoes[x];
			if (conteudo.equals("ocupado")) {
				qtdeRegistros++;
			}
		}
		for (int i = 0; i < qtdeRegistros; i++) {
			x= 0;
			for (int j = 0; j < camposLista; j++) {
				if(!lista[i][j].equals("*")){
					addTable[x] = lista[i][j];
					x++;
				}
			}
			modelo.addRow(addTable);
		}
	}
	
	static boolean verificarDadosDigitados(Container c){
		boolean liberadoParagravar = true;
		Component comp;
		String nome;
		for (int contComp = 0; contComp < c.getComponentCount(); contComp++) {
			comp = c.getComponent(contComp);
			if(comp instanceof JTextField){
				nome = ((JTextField)comp ).getName();				
				if(((JTextField)comp ).getText().isEmpty()){					
					liberadoParagravar = false;
				}else if((nome.equals("campoCpf"))||(nome.equals("campoRg"))){
					String txt = ((JTextField)comp ).getText();
					if (validarNumeros(txt)) {
						if(nome.equals("campoCpf") && !validarCpf(txt)){
							liberadoParagravar = false;							
						}else if(nome.equals("campoRg") && !validarRg(txt)){
							liberadoParagravar = false;
						}						
					}else{
						liberadoParagravar = false;
					}
				}
			}
		}
		return liberadoParagravar;
	}
	
	static boolean validarCpf(String cpf){
		boolean cpfValido = true;
		for (int x = 0; x < tamanhoTotal; x++) {
			for (int y = 0; y < camposLista; y++) {
				String conteudo = lista[x][y];
				if(y==4 && cpf.equals(conteudo)){					
					cpfValido = false;
				}
			}
		}
		return cpfValido;
	}
	
	static boolean validarRg(String rg){
		boolean rgValido = true;
		for (int x = 0; x < tamanhoTotal; x++) {
			for (int y = 0; y < camposLista; y++) {
				String conteudo = lista[x][y];
				if(y==5){
					if(conteudo.equals(rg)){
						rgValido = false;
					}
				}
			}
		}
		return rgValido;
	}
	
	static void chamarTelaEditarTelefones(String cdCliente, String nomeCliente){
		lbCliente.setText("Tefones de contato do cliente: "+cdCliente+" - "+nomeCliente);
		painelTelefones.add(lbCliente);
		telaTelefones.setVisible(true);
		campoTelefone.requestFocus();
		if(!editando){						
			i = verificarPosicaoLivre();
			j = 0;
			menuInicial.setVisible(false);			
		}else{
			cdTelefone = contarTelefonesCliente(cdCliente)+1;
			carregarTelefonesCliente(cdCliente);
		}
	}
	
	static void carregarTelefonesCliente(String cd){
		String[] addTable = new String[6];
		for(int x =0;x<tamanhoTotal;x++ ){			
			for (int i = 0; i < tamanhoTel; i++) {
				String conteudo = telefonesCliente[x][i];				
				if(i ==0 && conteudo.equals(cd)){
					addTable[0]=telefonesCliente[x][i];
					addTable[1]=telefonesCliente[x][i+1];
					addTable[2]=telefonesCliente[x][i+2];
					addTable[3]=telefonesCliente[x][i+3];
					addTable[4]=telefonesCliente[x][i+4];
					addTable[5]=telefonesCliente[x][i+5];
				}
			}
		}
		String vazio = "*";
		int cdTel = 1;
		for(int x= 0; x<tamanhoTel;x++){			
			if(!addTable[x].equals(vazio) && x>0){
				String[] add =  new String[2];
				add[0] = String.valueOf(cdTel);
				add[1] = addTable[x];
				tel.addRow(add);
				cdTel++;
			}
		}
	}
	
	static void pesquisar(){
		/*Método a ser implementado*/
	}
	
	static void fecharTelas(){
		System.exit(1);
	}
	
	static void travarTela(JFrame tela, int l, int a){
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
        	@Override	
            public void componentMoved(ComponentEvent e) {
            	tela.setEnabled(true);            	
            }
        }/**/);	
	}
}
