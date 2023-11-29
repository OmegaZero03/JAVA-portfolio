package imobiliaria;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import usuarios.Arrendador;
import usuarios.Cliente;

public class Corretor implements ActionListener{

									/*Toda a lógica das janelas*/
								/*********////////////////**********/
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
		/**Váriavies**/
	
	//tamanho das janelas
	private static int WIDTH = 400;
	private static int HEIGHT = 400;
	
	//Janelas
	private JFrame frame1, 
			frame2_a,
			frame2_c,
			frame2_5_a,
			frame3_c,
			frame3_5_a,
			frame4,
			frame5;
	
	//Botoes
	private JButton botaoRetorno,
					botaoCliente,
					botaoArrendador,
					botaoGetAll_c,
					botaoGetAll_a,
					botaoCadastroImovel,
					botaoVer,
					botaoGetImovel,
					botaoVerCasa,
					botaoVerPredio,
					botaoVerCustom,
					botaoAlugar,
					botaoComprar;
	
	//Botoes de escolher se é prédio ou casa
	private JRadioButton isPredio_input,
						 isCasa_input;
	
	//Campos de input em texto dos usuarios
	private JTextField nome_input,
					   telefone_input,
					   cpf_input,
					   saldo_input;	
	
	//Campos de input em texto dos imoveis
	private JTextField cidade_input,
	   				   estado_input,
	   				   rua_input,
	   				   numero_input,
	   				   tamanho_input,
	   				   preco_alugel_input,
	   				   preco_compre_input;	
	
	
	//Strings que guardam os dados do cliente para cadastra-lo
	private String nome_cliente,
				   telefone_cliente,
				   cpf_cliente,
				   saldo_cliente;
	//váriavel que guarda o saldo trasformado de String para INT (Ver linha 905 )
	private int intSaldo;
	
	//Strings que guardam os dados do arrendador para cadastra-lo
	private String nome_arrendador,
				   telefone_arrendador,
				   cpf_arrendador;
	
	private String nomeArren,
				   telefoneArren;
	
	//String que guardam os dados do imovel
	private String cidade_imovel,
	   			   estado_imovel,
	   			   rua_imovel,
	   			   numero_imovel,
	   			   tamanho_imovel,
	   			   preco_aluguel_imovel,
	   			   preco_compre_imovel;
	
	//váriavel que guarda o tamanho trasformado de String para FLOAT (Ver linha 906)
	private int intTamanho,
				intPreco_aluguel,
				intPreco_compre;
	
	private boolean isPredio_imovel;
	
	private JLabel custom_text;
	
	private boolean vendoCasa,
					vendoPredio,
					vendoCustom,
					comprando,
					alugando;
	
	//Objetos dos usuarios
	private Cliente cliente;
	private Arrendador arrendador;
	
	//Array de Imvóeis
	private static List <Imovel> imoveis;
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	//Construtor
	public Corretor() {
		iniciaFrame_1();
		
		
		imoveis = new ArrayList<Imovel>();
		
		//Instanciando 2 imoveis padrões
		Imovel casa_1 = new Imovel("Florianópolis", "Santa Catarina", "Rio vermelho", "N° 103", false, 25, 800, 300000);
		imoveis.add(casa_1);
		
		Imovel predio_1 = new Imovel("Rio de Janeiro", "Rio de Janeiro", "Zonal SUL", "N° 314", true, 30, 3000, 600000);
		imoveis.add(predio_1);
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	//Inicia a primeira janela.
	public void iniciaFrame_1() {
		botaoCliente = new JButton("Cliente");
		botaoArrendador = new JButton("Arrendador");
		botaoCliente. setBounds(90,80, 200, 70);
		botaoArrendador.setBounds(90,200, 200, 70);
		botaoCliente.addActionListener(this);
		botaoArrendador.addActionListener(this);
		
		frame1 = new JFrame("Imobiliaria");	

		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(WIDTH, HEIGHT);
		frame1.setResizable(false);
		frame1.setLayout(null);
		frame1.setVisible(true);
		frame1.setLocationRelativeTo(null);
		frame1.add(botaoCliente);
		frame1.add(botaoArrendador);

	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	//Inicia janela caso for cliente.
	public void iniciaFrame_2_cliente() {
		
		frame2_c = new JFrame("Imobiliaria - Cliente");

		JLabel label_cliente = new JLabel("CADASTRO DO CLIENTE: ");
		
		label_cliente.setBounds(0, 0, 800, 30);
		JLabel label_nome = new JLabel("Escreva seu nome abaixo, somente letras");
		label_nome.setBounds(90, 50, 800, 30);
		JLabel label_telefone = new JLabel("Escreva seu telefone abaixo, somente números");
		label_telefone.setBounds(90, 140, 800, 30);
		JLabel label_cpf = new JLabel("Escreva seu CPF abaixo");
		label_cpf.setBounds(90, 230, 800, 30);
		JLabel label_saldo = new JLabel("Escreva seu saldo abaixo, somente números [CAMPO OBRIGATÓRIO] ");
		label_saldo.setBounds(90, 320, 800, 30);
		

		nome_input = new JTextField();
		nome_input.setBounds(90, 80, 200, 30);
		
		telefone_input = new JTextField("( ) ");
		telefone_input.setBounds(90, 170, 200, 30);
		
		cpf_input = new JTextField();
		cpf_input.setBounds(90, 260, 200, 30);
		
		saldo_input = new JTextField();
		saldo_input.setBounds(90, 350, 200, 30);
		
		
		botaoGetAll_c = new JButton("Concluir");
		botaoGetAll_c.addActionListener(this);
		botaoGetAll_c.setBounds(200, 500, 100, 30);
		
		frame2_c.add(label_cliente);
		frame2_c.add(label_nome);
		frame2_c.add(label_telefone);
		frame2_c.add(label_cpf);
		frame2_c.add(label_saldo);
		
		frame2_c.add(nome_input);
		frame2_c.add(telefone_input);
		frame2_c.add(cpf_input);
		frame2_c.add(saldo_input);
		
		frame2_c.add(botaoGetAll_c);

		botaoRetorno = new JButton("Trocar Usuário");
		botaoRetorno.setBounds(450, 10, 120, 30);
		botaoRetorno.addActionListener(this);
		frame2_c.add(botaoRetorno);
		
		frame2_c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2_c.setSize(WIDTH + 200, HEIGHT + 200);
		frame2_c.setResizable(false);
		frame2_c.setLayout(null);
		frame2_c.setVisible(true);
		frame2_c.setLocationRelativeTo(null);
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	//Inicia janela caso for arrendador.
	public void iniciaFrame_2_arrendador() {
		frame2_a = new JFrame("Imobiliaria - Arrendador");

		JLabel label_arrendador = new JLabel("CADASTRO DO ARRENDADOR: ");
		label_arrendador.setBounds(0, 0, 800, 30);
		JLabel label_nome = new JLabel("Escreva seu nome abaixo, somente letras");
		label_nome.setBounds(90, 50, 800, 30);
		JLabel label_telefone = new JLabel("Escreva seu telefone abaixo, somente números");
		label_telefone.setBounds(90, 140, 800, 30);
		JLabel label_cpf = new JLabel("Escreva seu CPF abaixo");
		label_cpf.setBounds(90, 230, 800, 30);
		

		nome_input = new JTextField();
		nome_input.setBounds(90, 80, 200, 30);
		
		telefone_input = new JTextField("( ) ");
		telefone_input.setBounds(90, 170, 200, 30);
		
		cpf_input = new JTextField();
		cpf_input.setBounds(90, 260, 200, 30);
		
		saldo_input = new JTextField();
		saldo_input.setBounds(90, 350, 200, 30);
		
		botaoGetAll_a = new JButton("Concluir");
		botaoGetAll_a.addActionListener(this);
		botaoGetAll_a.setBounds(200, 380, 100, 30);
		
		frame2_a.add(label_arrendador);
		frame2_a.add(label_nome);
		frame2_a.add(label_telefone);
		frame2_a.add(label_cpf);
		
		frame2_a.add(nome_input);
		frame2_a.add(telefone_input);
		frame2_a.add(cpf_input);
		
		frame2_a.add(botaoGetAll_a);
		
		botaoRetorno = new JButton("Trocar Usuário");
		botaoRetorno.setBounds(450, 10, 120, 30);
		botaoRetorno.addActionListener(this);
		frame2_a.add(botaoRetorno);

		
		frame2_a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2_a.setSize(WIDTH + 200, HEIGHT + 200);
		frame2_a.setResizable(false);
		frame2_a.setLayout(null);
		frame2_a.setVisible(true);
		frame2_a.setLocationRelativeTo(null);
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	//EXCLUSIVA PARA ARRENDADOR
	//Janela de cadastro de imóveis / ver imóveis
	public void iniciaFrame_2_5_arrendador() {
		
		frame2_5_a = new JFrame("Imobiliaria - Arrendador: " + arrendador.getNome());	

		botaoCadastroImovel = new JButton("Cadastrar Imóvel");
		botaoCadastroImovel.setBounds(90,200, 200, 70);
		botaoCadastroImovel.addActionListener(this);
		botaoVer = new JButton("Ver Imóveis");
		botaoVer.setBounds(90,100, 200, 70);
		botaoVer.addActionListener(this);
		
		botaoRetorno = new JButton("Trocar Usuário");
		botaoRetorno.setBounds(250, 8, 120, 30);
		botaoRetorno.addActionListener(this);
		frame2_5_a.add(botaoRetorno);
		
		frame2_5_a.add(botaoCadastroImovel);
		frame2_5_a.add(botaoVer);
	
		frame2_5_a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2_5_a.setSize(WIDTH, HEIGHT);
		frame2_5_a.setResizable(false);
		frame2_5_a.setLayout(null);
		frame2_5_a.setVisible(true);
		frame2_5_a.setLocationRelativeTo(null);
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	//Inicia janela pós cadastro tanto do cliente, quanto do arrendador
	public void iniciaFrame_3_all() {
	
		if(cliente != null) {
			frame3_c = new JFrame("Imobiliaria - Cliente: " + cliente.getNome());	
		}
		else if(arrendador!=null) {
			frame3_c = new JFrame("Imobiliaria - Arrendador: " + arrendador.getNome());	
			nomeArren = arrendador.getNome();
			telefoneArren = arrendador.getTelefone();
		}
		JLabel casa_padrao = new JLabel("🏠");
		casa_padrao.setFont(new Font("Noto Color Emoji", Font.PLAIN, 30));
		casa_padrao.setBounds(90,100, 200, 70);
		JLabel casa_text = new JLabel("<html> Cidade: " + imoveis.get(0).getCidade() + "<br/> Estado: " + imoveis.get(0).getEstado() + "<br/> Dono: Yuri" + "</html>");
		casa_text.setBounds(50, 145 , 200, 70);
		JLabel predio_padrao = new JLabel("🏢");
		predio_padrao.setFont(new Font("Noto Color Emoji", Font.PLAIN, 30));
		predio_padrao.setBounds(290,100, 200, 70);
		JLabel predio_text = new JLabel("<html> Cidade: " + imoveis.get(1).getCidade() + "<br/> Estado: " + imoveis.get(1).getEstado() + "<br/> Dono: Wesley" + "</html>");
		predio_text.setBounds(250, 145 , 200, 70);
		
		for(int i = 0; i < imoveis.size(); i++) {
			
			if(i > 1) {
				
				custom_text = new JLabel("<html> Cidade: " + imoveis.get(2).getCidade() + "<br/> Estado: " + imoveis.get(2).getEstado() + "<br/> Dono: " + nomeArren + "</html>");
				custom_text.setBounds(160, 345 , 200, 70);
				frame3_c.add(custom_text);
				

				
				if(isPredio_imovel) {
					JLabel imovel_custom = new JLabel("🏢");
					imovel_custom.setFont(new Font("Noto Color Emoji", Font.PLAIN, 30));
					imovel_custom.setBounds(200,300, 200, 70);
					frame3_c.add(imovel_custom);
					botaoVerCustom = new JButton("VER");
					botaoVerCustom.setBounds(160, 430 , 120, 30);
					botaoVerCustom.addActionListener(this);
					frame3_c.add(botaoVerCustom);
				}else{
					JLabel imovel_custom = new JLabel("🏠");
					imovel_custom.setFont(new Font("Noto Color Emoji", Font.PLAIN, 30));
					imovel_custom.setBounds(200,300, 200, 70);
					frame3_c.add(imovel_custom);
					botaoVerCustom = new JButton("VER");
					botaoVerCustom.setBounds(160, 430 , 120, 30);
					botaoVerCustom.addActionListener(this);
					frame3_c.add(botaoVerCustom);
				}
			}
			else {
				custom_text = null;
			}

		}
		
		
		JLabel aviso = new JLabel("<html>APENAS CLIQUE EM 'VER' COMO CLIENTE " + "</html>");
		aviso.setBounds(400, -40, 200, 200);
		
		botaoVerCasa = new JButton("VER");
		botaoVerCasa.setBounds(50, 230 , 120, 30);
		botaoVerCasa.addActionListener(this);
		botaoVerPredio = new JButton("VER");
		botaoVerPredio.setBounds(250, 230 , 120, 30);
		botaoVerPredio.addActionListener(this);
		botaoRetorno = new JButton("Trocar Usuário");
		botaoRetorno.setBounds(450, 10, 120, 30);
		botaoRetorno.addActionListener(this);
		
		frame3_c.add(botaoVerCasa);
		frame3_c.add(botaoVerPredio);
		frame3_c.add(botaoRetorno);
		
		frame3_c.add(aviso);
		frame3_c.add(casa_padrao);
		frame3_c.add(predio_padrao);
		frame3_c.add(predio_text);
		frame3_c.add(casa_text);
		
		
		frame3_c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3_c.setSize(WIDTH + 200, HEIGHT + 200);
		frame3_c.setResizable(false);
		frame3_c.setLayout(null);
		frame3_c.setVisible(true);
		frame3_c.setLocationRelativeTo(null);
		
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	//Inicia janela de cadastro de Imóveis
	public void iniciaFrame_3_5_arrendador() {
		
		frame3_5_a = new JFrame("Imobiliaria - Arrendador: " + arrendador.getNome());
		
		JLabel label_imovel = new JLabel("CADASTRO DO IMOVEL: ");
		label_imovel.setBounds(0, 0, 800, 30);
		JLabel label_cidade = new JLabel("Escreva a cidade do imóvel abaixo");
		label_cidade.setBounds(90, 50, 800, 30);
		JLabel label_estado = new JLabel("Escreva o estado do imóvel abaixo");
		label_estado.setBounds(90, 140, 800, 30);
		JLabel label_rua = new JLabel("Escreva a rua do imóvel abaixo");
		label_rua.setBounds(90, 230, 800, 30);
		JLabel label_numero = new JLabel("Escreva o numero do imóvel abaixo");
		label_numero.setBounds(90, 320, 800, 30);
		JLabel label_tamanho = new JLabel("Escreva o tamanho do imóvel abaixo");
		label_tamanho.setBounds(90, 410, 800, 30);
		JLabel label_escolha = new JLabel("Escolha entre prédio ou casa");
		label_escolha.setBounds(370, 160, 800, 30);
		JLabel label_obr = new JLabel("<html> [CAMPO OBRIGATÓRIO] " + "<br/> (apenas números)" + "</html>");
		label_obr.setBounds(120, 470, 800, 30);
		JLabel label_aluguel = new JLabel("<html> Escreva o preço do aluguel"+ "<br/> (apenas números)" + "</html>");
		label_aluguel.setBounds(380, 300, 800, 30);
		JLabel label_compra = new JLabel("<html> Escreva o preço de venda"+ "<br/> (apenas números)" + "</html>");
		label_compra.setBounds(380, 390, 800, 30);
		
		
		cidade_input = new JTextField();
		cidade_input.setBounds(90, 80, 200, 30);
		estado_input = new JTextField();
		estado_input.setBounds(90, 170, 200, 30);
		rua_input = new JTextField();
		rua_input.setBounds(90, 260, 200, 30);
		numero_input = new JTextField();
		numero_input.setBounds(90, 350, 200, 30);
		tamanho_input = new JTextField();
		tamanho_input.setBounds(90, 440, 200, 30);
		
		preco_alugel_input = new JTextField();
		preco_alugel_input.setBounds(370, 350, 200, 30);
		preco_compre_input = new JTextField();
		preco_compre_input.setBounds(370, 440, 200, 30);
		
		
		isPredio_input = new JRadioButton("Prédio");
		isPredio_input.setBounds(370, 200, 100, 30);
		isPredio_input.addActionListener(this);
		isCasa_input = new JRadioButton("Casa");
		isCasa_input.setBounds(470, 200, 100, 30);
		isCasa_input.addActionListener(this);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(isPredio_input);
		grupo.add(isCasa_input);
		
		botaoGetImovel = new JButton("Cadastrar");
		botaoGetImovel.setBounds(200, 520, 100, 30);
		botaoGetImovel.addActionListener(this);
		
		
		frame3_5_a.add(label_imovel);
		frame3_5_a.add(label_cidade);
		frame3_5_a.add(label_estado);
		frame3_5_a.add(label_rua);
		frame3_5_a.add(label_numero);
		frame3_5_a.add(label_tamanho);
		frame3_5_a.add(label_escolha);
		frame3_5_a.add(label_obr);
		frame3_5_a.add(label_compra);
		frame3_5_a.add(label_aluguel);
		
		frame3_5_a.add(botaoGetImovel);
		
		frame3_5_a.add(cidade_input);
		frame3_5_a.add(estado_input);
		frame3_5_a.add(rua_input);
		frame3_5_a.add(numero_input);
		frame3_5_a.add(tamanho_input);
		frame3_5_a.add(preco_alugel_input);
		frame3_5_a.add(preco_compre_input);
		
		frame3_5_a.add(isPredio_input);
		frame3_5_a.add(isCasa_input);
		
		botaoRetorno = new JButton("Trocar Usuário");
		botaoRetorno.setBounds(450, 10, 120, 30);
		botaoRetorno.addActionListener(this);
		frame3_5_a.add(botaoRetorno);
		
		
		frame3_5_a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3_5_a.setSize(WIDTH + 200, HEIGHT + 200);
		frame3_5_a.setResizable(false);
		frame3_5_a.setLayout(null);
		frame3_5_a.setVisible(true);
		frame3_5_a.setLocationRelativeTo(null);
	}
	
	public void inicia_frame_4() {

		if(cliente != null) {
			frame4 = new JFrame("Imobiliaria - Cliente: " + cliente.getNome());	
		}
		else if(arrendador!=null) {
			frame4 = new JFrame("Imobiliaria - Arrendador: " + arrendador.getNome());	
		}
		
		botaoRetorno = new JButton("Trocar Usuário");
		botaoRetorno.setBounds(250, 8, 120, 30);
		botaoRetorno.addActionListener(this);
		
		frame4.add(botaoRetorno);
		
		if(vendoCasa) {
			JLabel casa_padrao = new JLabel("🏠");
			casa_padrao.setFont(new Font("Noto Color Emoji", Font.PLAIN, 30));
			casa_padrao.setBounds(90,10, 200, 70);
			JLabel casa_info = new JLabel("<html> Cidade: " + imoveis.get(0).getCidade() + "<br/> Estado: " + imoveis.get(0).getEstado() + "<br/> Rua: " + imoveis.get(0).getRua() + "<br/> Numero: " + imoveis.get(0).getNume() + "<br/> Tamanho: " + imoveis.get(0).getTamanho() + "</html>");
			casa_info.setBounds(90,100, 300, 100);
			JLabel alugar_casa = new JLabel("Preço de aluguel: " + imoveis.get(0).getPreco_aluguel());
			alugar_casa.setBounds(90, 160, 300, 100);
			JLabel comprar_casa = new JLabel("Preço de compra: " + imoveis.get(0).getPreco_compre());
			comprar_casa.setBounds(90, 220, 300, 100);
			
			
			if(cliente != null) {
				
				JLabel saldo = new JLabel("Saldo: " + cliente.getSaldo());
				saldo.setBounds(0, -30, 100, 100);
				
				botaoAlugar = new JButton("Alugar");
				botaoAlugar.setBounds(90, 220, 100, 30);
				botaoComprar = new JButton("Comprar");
				botaoComprar.setBounds(90, 280, 100, 30);
				botaoAlugar.addActionListener(this);
				botaoComprar.addActionListener(this);
				
				frame4.add(saldo);
				frame4.add(botaoAlugar);
				frame4.add(botaoComprar);
			}
			
			frame4.add(casa_padrao);
			frame4.add(casa_info);
			frame4.add(alugar_casa);
			frame4.add(comprar_casa);

			
			
		}
		if(vendoPredio) {
			JLabel predio_padrao = new JLabel("🏢");
			predio_padrao.setFont(new Font("Noto Color Emoji", Font.PLAIN, 30));
			predio_padrao.setBounds(90,10, 200, 70);
			JLabel predio_info = new JLabel("<html> Cidade: " + imoveis.get(1).getCidade() + "<br/> Estado: " + imoveis.get(1).getEstado() + "<br/> Rua: " + imoveis.get(1).getRua() + "<br/> Numero: " + imoveis.get(1).getNume() + "<br/> Tamanho: " + imoveis.get(1).getTamanho() + "</html>");
			predio_info.setBounds(90,100, 300, 100);
			JLabel alugar_predio = new JLabel("Preço de aluguel: " + imoveis.get(1).getPreco_aluguel());
			alugar_predio.setBounds(90, 160, 300, 100);
			JLabel comprar_predio = new JLabel("Preço de compra: " + imoveis.get(1).getPreco_compre());
			comprar_predio.setBounds(90, 220, 300, 100);
			
			
			if(cliente != null) {
				
				JLabel saldo = new JLabel("Saldo: " + cliente.getSaldo());
				saldo.setBounds(0, -30, 100, 100);
				
				botaoAlugar = new JButton("Alugar");
				botaoAlugar.setBounds(90, 220, 100, 30);
				botaoComprar = new JButton("Comprar");
				botaoComprar.setBounds(90, 280, 100, 30);
				botaoAlugar.addActionListener(this);
				botaoComprar.addActionListener(this);
				
				frame4.add(saldo);
				frame4.add(botaoAlugar);
				frame4.add(botaoComprar);
			}
			
			frame4.add(predio_padrao);
			frame4.add(predio_info);
			frame4.add(alugar_predio);
			frame4.add(comprar_predio);
			
		}
		
		if(vendoCustom) {
			
			for(int i = 0; i < imoveis.size(); i++) {
				
				if(i > 1) {
				
					if(isPredio_imovel) {
						JLabel imovel_custom = new JLabel("🏢");
						imovel_custom.setFont(new Font("Noto Color Emoji", Font.PLAIN, 30));
						imovel_custom.setBounds(200,300, 200, 70);
						frame3_c.add(imovel_custom);
					}else{
						JLabel imovel_custom = new JLabel("🏠");
						imovel_custom.setFont(new Font("Noto Color Emoji", Font.PLAIN, 30));
						imovel_custom.setBounds(200,300, 200, 70);
						frame3_c.add(imovel_custom);
					}
					
					
					JLabel custom_info = new JLabel("<html> Cidade: " + imoveis.get(2).getCidade() + "<br/> Estado: " + imoveis.get(2).getEstado() + "<br/> Rua: " + imoveis.get(2).getRua() + "<br/> Numero: " + imoveis.get(2).getNume() + "<br/> Tamanho: " + imoveis.get(2).getTamanho() + "</html>");
					custom_info.setBounds(90,100, 300, 100);
					JLabel alugar_custom = new JLabel("Preço de aluguel: " + imoveis.get(2).getPreco_aluguel());
					alugar_custom.setBounds(90, 160, 300, 100);
					JLabel comprar_custom = new JLabel("Preço de compra: " + imoveis.get(2).getPreco_compre());
					comprar_custom.setBounds(90, 220, 300, 100);
					
					
					if(cliente != null) {
						
						JLabel saldo = new JLabel("Saldo: " + cliente.getSaldo());
						saldo.setBounds(0, -30, 100, 100);
						
						botaoAlugar = new JButton("Alugar");
						botaoAlugar.setBounds(90, 220, 100, 30);
						botaoComprar = new JButton("Comprar");
						botaoComprar.setBounds(90, 280, 100, 30);
						botaoAlugar.addActionListener(this);
						botaoComprar.addActionListener(this);
						
						frame4.add(saldo);
						frame4.add(botaoAlugar);
						frame4.add(botaoComprar);
					}
					
					frame4.add(custom_info);
					frame4.add(alugar_custom);
					frame4.add(comprar_custom);
					
					
					
				}
				else {
					custom_text = null;
				}

			}
			
		}
		
		
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setSize(WIDTH, HEIGHT);
		frame4.setResizable(false);
		frame4.setLayout(null);
		frame4.setVisible(true);
		frame4.setLocationRelativeTo(null);
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	//Frame 5, aprovação de compra/aluguel
	
	public void inicia_frame5() {
		
		frame5 = new JFrame("Imobiliaria - Cliente: " + cliente.getNome());
		System.out.println(alugando + " cuuuuuuu");

		
		if(vendoCasa) {

			if(alugando) {
				if(cliente.getSaldo() >= imoveis.get(0).getPreco_aluguel()) {
					JLabel sucessoAlu = new JLabel("<html> PARABÉNS, ALUGADO COM SUCESSO, ENTRE EM CONTATO COM O DONO" + "<br/> Dono: Yuri" + "<br/> Numero: 4002-8922" +"</html>");
					sucessoAlu.setFont(new Font("arial", Font.BOLD, 15));
					sucessoAlu.setBounds(10, 0, 300, 300);
					frame5.add(sucessoAlu);
				}else {
					JLabel erroAlu = new JLabel("<html>EPA!"+ "<br/> PARECE QUE VOCÊ NÃO TEM SALDO SUFICIENTE" + "</html>");
					erroAlu.setFont(new Font("arial", Font.BOLD, 15));
					erroAlu.setBounds(10, -5, 400, 400);
					frame5.add(erroAlu);
				}
			}
			if(comprando) {
				if(cliente.getSaldo() >= imoveis.get(0).getPreco_compre()) {
					JLabel sucessoAlu = new JLabel("<html> PARABÉNS, COMPRADO COM SUCESSO, ENTRE EM CONTATO COM O DONO" + "<br/> Dono: Yuri" + "<br/> Numero: 4002-8922" +"</html>");
					sucessoAlu.setFont(new Font("arial", Font.BOLD, 15));
					sucessoAlu.setBounds(10, 0, 300, 300);
					frame5.add(sucessoAlu);
				}else {
					JLabel erroAlu = new JLabel("<html>EPA!"+ "<br/> PARECE QUE VOCÊ NÃO TEM SALDO SUFICIENTE" + "</html>");
					erroAlu.setFont(new Font("arial", Font.BOLD, 15));
					erroAlu.setBounds(10, -5, 400, 400);
					frame5.add(erroAlu);
				}
			}
		}
		
		if(vendoPredio) {
			if(alugando) {
				if(cliente.getSaldo() >= imoveis.get(1).getPreco_aluguel()) {
					JLabel sucessoAlu = new JLabel("<html> PARABÉNS, ALUGADO COM SUCESSO, ENTRE EM CONTATO COM O DONO" + "<br/> Dono: Wesley" + "<br/> Numero: (16) 98203-4120" +"</html>");
					sucessoAlu.setFont(new Font("arial", Font.BOLD, 15));
					sucessoAlu.setBounds(10, 0, 300, 300);
					frame5.add(sucessoAlu);
				}else {
					JLabel erroAlu = new JLabel("<html>EPA!"+ "<br/> PARECE QUE VOCÊ NÃO TEM SALDO SUFICIENTE" + "</html>");
					erroAlu.setFont(new Font("arial", Font.BOLD, 15));
					erroAlu.setBounds(10, -5, 400, 400);
					frame5.add(erroAlu);
				}
			}
			if(comprando) {
				if(cliente.getSaldo() >= imoveis.get(0).getPreco_compre()) {
					JLabel sucessoAlu = new JLabel("<html> PARABÉNS, COMPRADO COM SUCESSO, ENTRE EM CONTATO COM O DONO" + "<br/> Dono: Wesley" + "<br/> Numero: (16) 98203-4120" +"</html>");
					sucessoAlu.setFont(new Font("arial", Font.BOLD, 15));
					sucessoAlu.setBounds(10, 0, 300, 300);
					frame5.add(sucessoAlu);
				}else {
					JLabel erroAlu = new JLabel("<html>EPA!"+ "<br/> PARECE QUE VOCÊ NÃO TEM SALDO SUFICIENTE" + "</html>");
					erroAlu.setFont(new Font("arial", Font.BOLD, 15));
					erroAlu.setBounds(10, -5, 400, 400);
					frame5.add(erroAlu);
				}
			}
			
		}
		
		if(vendoCustom) {
			
			if(alugando) {
				if(cliente.getSaldo() >= imoveis.get(2).getPreco_aluguel()) {
					JLabel sucessoAlu = new JLabel("<html> PARABÉNS, ALUGADO COM SUCESSO, ENTRE EM CONTATO COM O DONO" + "<br/> Dono: " + nomeArren +  "<br/> Numero: " + telefoneArren +"</html>");
					sucessoAlu.setFont(new Font("arial", Font.BOLD, 15));
					sucessoAlu.setBounds(10, 0, 300, 300);
					frame5.add(sucessoAlu);
				}else {
					JLabel erroAlu = new JLabel("<html>EPA!"+ "<br/> PARECE QUE VOCÊ NÃO TEM SALDO SUFICIENTE" + "</html>");
					erroAlu.setFont(new Font("arial", Font.BOLD, 15));
					erroAlu.setBounds(10, -5, 400, 400);
					frame5.add(erroAlu);
				}
			}
			if(comprando) {
				if(cliente.getSaldo() >= imoveis.get(2).getPreco_compre()) {
					JLabel sucessoAlu = new JLabel("<html> PARABÉNS, COMPRADO COM SUCESSO, ENTRE EM CONTATO COM O DONO" + "<br/> Dono: " + nomeArren +  "<br/> Numero: " + telefoneArren +"</html>");
					sucessoAlu.setFont(new Font("arial", Font.BOLD, 15));
					sucessoAlu.setBounds(10, 0, 300, 300);
					frame5.add(sucessoAlu);
				}else {
					JLabel erroAlu = new JLabel("<html>EPA!"+ "<br/> PARECE QUE VOCÊ NÃO TEM SALDO SUFICIENTE" + "</html>");
					erroAlu.setFont(new Font("arial", Font.BOLD, 15));
					erroAlu.setBounds(10, -5, 400, 400);
					frame5.add(erroAlu);
				}
			}
			
			
		}
		
		botaoRetorno = new JButton("Trocar Usuário");
		botaoRetorno.setBounds(250, 8, 120, 30);
		botaoRetorno.addActionListener(this);
		frame5.add(botaoRetorno);
		
		
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setSize(WIDTH, HEIGHT);
		frame5.setResizable(false);
		frame5.setLayout(null);
		frame5.setVisible(true);
		frame5.setLocationRelativeTo(null);

	}
	
	
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	
	//INTERFACE para dedectar as interações com botões.
	@Override
	public void actionPerformed(ActionEvent e) {

		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		//Caso aperte o botao "cliente" na primeira janela
		if(e.getSource() == botaoCliente) {
			iniciaFrame_2_cliente();
			frame1.dispose();


		}
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		//Caso aperte o botao "arrendador" na primeira janela
		if(e.getSource() == botaoArrendador) {
			iniciaFrame_2_arrendador();
			frame1.dispose();
		}
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		//Caso queira trocar o TIPO de usuário
		if(e.getSource() == botaoRetorno) {
			cliente = null;
			arrendador = null;
			
			
			if(frame2_a != null) frame2_a.dispose();
			if(frame2_c != null) frame2_c.dispose();
			if(frame2_5_a != null) frame2_5_a.dispose();
			if(frame3_c != null) frame3_c.dispose();
			if(frame3_5_a != null) frame3_5_a.dispose();
			if(frame4 != null) frame4.dispose();
			if(frame5 != null) frame5.dispose();
			
			iniciaFrame_1();
			
		}
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		//Caso aperte "concluir" no registro do cliente
		if(e.getSource() == botaoGetAll_c) {
			
			//Pegando os dados do cliente.
			nome_cliente = nome_input.getText();
			System.out.println(nome_cliente);
			telefone_cliente = telefone_input.getText();
			System.out.println(telefone_cliente);
			cpf_cliente = cpf_input.getText();
			System.out.println(cpf_cliente);
			saldo_cliente = saldo_input.getText();
			
			//Trasformando saldo em INT
			intSaldo = Integer.parseInt(saldo_cliente);
			System.out.println(intSaldo);
			
			cliente = new Cliente(nome_cliente, telefone_cliente, cpf_cliente, intSaldo);
			iniciaFrame_3_all();
			frame2_c.dispose();
			
		}
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		//Caso aperte "concluir" no registro do arrendador
		
		if(e.getSource() == botaoGetAll_a) {
			
			//Pegando os dados do arrendador.
			nome_arrendador = nome_input.getText();
			System.out.println(nome_arrendador);
			telefone_arrendador = telefone_input.getText();
			System.out.println(telefone_arrendador);
			cpf_arrendador = cpf_input.getText();
			System.out.println(cpf_arrendador);

			
			arrendador = new Arrendador(nome_arrendador, telefone_arrendador, cpf_arrendador);
			//iniciaFrame_2_5_arrendador();
			iniciaFrame_2_5_arrendador();
			frame2_a.dispose();
			
		}
		
		if(e.getSource() == botaoCadastroImovel) {
			iniciaFrame_3_5_arrendador();
			frame2_5_a.dispose();
		}
		
		if(e.getSource() == botaoVer) {
			iniciaFrame_3_all();
			frame2_5_a.dispose();
		}

		if(e.getSource() == isPredio_input) {
			isPredio_imovel = true;
		}
		else if(e.getSource() == isCasa_input) {
			isPredio_imovel = false;
		}
		
		
		if(e.getSource() == botaoGetImovel) {
			
			//Pegando os dados do Imovel.
			cidade_imovel = cidade_input.getText();
			
			estado_imovel = estado_input.getText();
			
			rua_imovel = rua_input.getText();
			
			numero_imovel = numero_input.getText();
			
			tamanho_imovel = tamanho_input.getText();
			
			preco_aluguel_imovel = preco_alugel_input.getText();
			preco_compre_imovel = preco_compre_input.getText();
			
			//Transformando tamanho em int
			intTamanho = Integer.parseInt(tamanho_imovel);
			intPreco_aluguel = Integer.parseInt(preco_aluguel_imovel);
			intPreco_compre = Integer.parseInt(preco_compre_imovel);
			
			
			System.out.println(isPredio_imovel);
			Imovel i = new Imovel(cidade_imovel, estado_imovel, rua_imovel, numero_imovel, isPredio_imovel, intTamanho, intPreco_aluguel, intPreco_compre);
			imoveis.add(i);
			
			
			iniciaFrame_3_all();
			frame3_5_a.dispose();
		}
		
		if(e.getSource() == botaoVerCasa) {
			vendoCustom = false;
			vendoPredio = false;
			vendoCasa = true;
			inicia_frame_4();
			frame3_c.dispose();
		}
		
		if(e.getSource() == botaoVerPredio) {
			vendoCustom = false;
			vendoPredio = true;
			vendoCasa = false;
			inicia_frame_4();
			frame3_c.dispose();
		}
		
		if(e.getSource() == botaoVerCustom) {
			vendoCustom = true;
			vendoPredio = false; 
			vendoCasa = false;
			inicia_frame_4();
			frame3_c.dispose();
		}
		
		if(e.getSource() == botaoAlugar) {
			
			alugando = true;
			comprando = false;
			inicia_frame5();
			frame4.dispose();
		}
		
		if(e.getSource() == botaoComprar) {
			alugando = false;
			comprando = true;
			inicia_frame5();
			frame4.dispose();
			
		}
		
		
		
		
	}//METODO DA INTERFACE
	
}//CORRETOR CLASS
