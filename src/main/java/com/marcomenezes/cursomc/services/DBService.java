package com.marcomenezes.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marcomenezes.cursomc.domain.Categoria;
import com.marcomenezes.cursomc.domain.Cidade;
import com.marcomenezes.cursomc.domain.Cliente;
import com.marcomenezes.cursomc.domain.Endereco;
import com.marcomenezes.cursomc.domain.Estado;
import com.marcomenezes.cursomc.domain.ItemPedido;
import com.marcomenezes.cursomc.domain.Pagamento;
import com.marcomenezes.cursomc.domain.PagamentoComBoleto;
import com.marcomenezes.cursomc.domain.PagamentoComCartao;
import com.marcomenezes.cursomc.domain.Pedido;
import com.marcomenezes.cursomc.domain.Produto;
import com.marcomenezes.cursomc.domain.enums.EstadoPagamento;
import com.marcomenezes.cursomc.domain.enums.Perfil;
import com.marcomenezes.cursomc.domain.enums.TipoCliente;
import com.marcomenezes.cursomc.repositories.CategoriaRepository;
import com.marcomenezes.cursomc.repositories.CidadeRepository;
import com.marcomenezes.cursomc.repositories.ClienteRepository;
import com.marcomenezes.cursomc.repositories.EnderecoRepository;
import com.marcomenezes.cursomc.repositories.EstadoRepository;
import com.marcomenezes.cursomc.repositories.ItemPedidoRepository;
import com.marcomenezes.cursomc.repositories.PagamentoRepository;
import com.marcomenezes.cursomc.repositories.PedidoRepository;
import com.marcomenezes.cursomc.repositories.ProdutoRepository;


@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama, mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Notebook Lenovo", 2399.99);
		Produto p2 = new Produto(null, "Notebook Acer", 2559.99);
		Produto p3 = new Produto(null, "Notebook Asus", 1899.99);
		Produto p4 = new Produto(null, "Notebook Sansumg", 2479.99);
		Produto p5 = new Produto(null, "Mac Book", 4999.99);
		Produto p6 = new Produto(null, "Tablet Samsung Galaxy", 944.91);
		Produto p7 = new Produto(null, "Tablet Ipad", 1254.26);
		Produto p8 = new Produto(null, "Celular Xiaomi Redmi 8", 1279.99);
		Produto p9 = new Produto(null, "Celular Xiaomi Redmi 9", 1649.89);
		Produto p10 = new Produto(null, "Celular Iphone XR Apple Branco", 3499.00);
		Produto p11 = new Produto(null, "Celular Iphone 7 Tela LCD Retina", 3499.00);
		Produto p12 = new Produto(null, "Fone de Ouvido Bluetooth on Ear", 274.99);
		Produto p13 = new Produto(null, "Fone de Ouvido JBL Quantum", 269.99);
		Produto p14 = new Produto(null, "Fone de Ouvido Audio Technica", 1599.99);
		Produto p15 = new Produto(null, "Impressora", 800.00);
		Produto p16 = new Produto(null, "Mouse sem fio Logitech", 469.90);
		Produto p17 = new Produto(null, "Mouse Dell WM126", 89.90);
		Produto p18 = new Produto(null, "Mouse Gamer Fortrek", 56.90);
		Produto p19 = new Produto(null, "TV true color", 1200.00);
		Produto p20 = new Produto(null, "SSD", 230.00);
		Produto p21 = new Produto(null, "Caixa de som JBL", 159.99);
		Produto p22 = new Produto(null, "Patinete Elétrico", 899.99);
		Produto p23 = new Produto(null, "Escrivaninha Porto Expresso", 170.90);
		Produto p24 = new Produto(null, "Mesa para escritório", 341.99);
		Produto p25 = new Produto(null, "Cadeira de Escritório Presidente Giratória", 953.99);
		Produto p26 = new Produto(null, "Cadeira de Escritório Giratória DIR-002", 217.50);
		Produto p27 = new Produto(null, "Kit Toalhas cor preta", 70.00);
		Produto p28 = new Produto(null, "Kit Toalhas cor branca", 90.00);
		Produto p29 = new Produto(null, "Colcha de Solteiro", 200.00);
		Produto p30 = new Produto(null, "Colcha de Casal", 340.00);
		Produto p31 = new Produto(null, "Travesseiro da Nasa", 149.99);
		Produto p32 = new Produto(null, "Travesseiro com pena de Pavão", 279.99);
		Produto p33 = new Produto(null, "Roupão VIP person", 199.90);
		Produto p34 = new Produto(null, "Roupão Plus Size", 249.10);
		Produto p35 = new Produto(null, "Cortinas", 39.99);
		Produto p36 = new Produto(null, "Lustre Parisiense", 579.99);
		Produto p37 = new Produto(null, "Abajour Le Parisiè", 100.00);
		Produto p38 = new Produto(null, "Furadeira Bosch 500W", 549.99);
		Produto p39 = new Produto(null, "Furadeira Dewalt 500W", 345.79);
		Produto p40 = new Produto(null, "Roçadeira Bosch elétrica 800W", 750.50);
		Produto p41 = new Produto(null, "Roçadeira Bosch a gasolina 1 CV", 1455.99);
		Produto p42 = new Produto(null, "Aparador de grama", 390.00);
		Produto p43 = new Produto(null, "Shampoo Palmolive", 13.50);
		Produto p44 = new Produto(null, "Shampoo L'Óreal Professional", 28.40);
		Produto p45 = new Produto(null, "Condicionador Palmolive", 12.99);
		Produto p46 = new Produto(null, "Condicionador L'Óreal Professional", 33.10);
		Produto p47 = new Produto(null, "Desodorante Rexona", 12.99);
		Produto p48 = new Produto(null, "Desodorante Adidas", 11.99);
		Produto p49 = new Produto(null, "Perfume Carolina Herrera 212", 198.00);
		Produto p50 = new Produto(null, "Perfume Dolce Gabana", 300.00);
		Produto p51 = new Produto(null, "Perfume Paco Rabanne Eau Toillet", 408.90);
		Produto p52 = new Produto(null, "Perfume Polo Blue Ralph Laren", 160.00);
		
		Produto p53 = new Produto(null, "Computador Asus 32GB de RAM i9 core", 7480.00);
		Produto p54 = new Produto(null, "Computador Acer 32GB de RAM i9 core", 5681.50);
		Produto p55 = new Produto(null, "Computador Samsumg 32GB de RAM i9 core", 6581.91);
		Produto p56 = new Produto(null, "Computador Lenovo 32 GB de RAM i9 core", 5655.10);
		Produto p57 = new Produto(null, "Computador Asus 16GB de RAM i7 core", 7480.00);
		Produto p58 = new Produto(null, "Computador Acer 16GB de RAM i7 core", 5681.50);
		Produto p59 = new Produto(null, "Computador Samsumg 16GB de RAM i7 core", 6581.91);
		Produto p60 = new Produto(null, "Computador Lenovo 16GB de RAM i7 core", 5655.10);
		Produto p61 = new Produto(null, "Computador Asus 8GB de RAM i7 core", 7480.00);
		Produto p62 = new Produto(null, "Computador Acer 8GB de RAM i7 core", 5681.50);
		Produto p63 = new Produto(null, "Computador Samsumg 8GB de RAM i7 core", 6581.91);
		Produto p64 = new Produto(null, "Computador Lenovo 8GB de RAM i7 core", 5655.10);
		Produto p65 = new Produto(null, "Computador Asus 32GB de RAM com SSD i9 core", 7480.00);
		Produto p66 = new Produto(null, "Computador Acer 32GB de RAM com SSD i9 core", 5681.50);
		Produto p67 = new Produto(null, "Computador Samsumg 32GB de RAM com SSD i9 core", 6581.91);
		Produto p68 = new Produto(null, "Computador Lenovo 32 GB de RAM com SSD i9 core", 5655.10);
		Produto p69 = new Produto(null, "Computador Asus 16GB de RAM com SSD i7 core", 7480.00);
		Produto p70 = new Produto(null, "Computador Acer 16GB de RAM com SSD i7 core", 5681.50);
		Produto p71 = new Produto(null, "Computador Samsumg 16GB de RAM com SSD i7 core", 6581.91);
		Produto p72 = new Produto(null, "Computador Lenovo 16GB de RAM com SSD i7 core", 5655.10);
		Produto p73 = new Produto(null, "Computador Asus 8GB de RAM com SSD i7 core", 7480.00);
		Produto p74 = new Produto(null, "Computador Acer 8GB de RAM com SSD i7 core", 5681.50);
		Produto p75 = new Produto(null, "Computador Samsumg 8GB de RAM com SSD i7 core", 6581.91);
		Produto p76 = new Produto(null, "Computador Lenovo 8GB de RAM com SSD i7 core", 5655.10);
		Produto p77 = new Produto(null, "Computador Asus 16GB de RAM i7 core", 7480.00);
		Produto p78 = new Produto(null, "Computador Acer 16GB de RAM i7 core", 5681.50);
		Produto p79 = new Produto(null, "Computador Samsumg 16GB de RAM i7 core", 6581.91);
		Produto p80 = new Produto(null, "Computador Lenovo 16GB de RAM i7 core", 5655.10);
		Produto p81 = new Produto(null, "Computador Asus 8GB de RAM i7 core", 7480.00);
		Produto p82 = new Produto(null, "Computador Acer 8GB de RAM i7 core", 5681.50);
		Produto p83 = new Produto(null, "Computador Samsumg 8GB de RAM i7 core", 6581.91);
		Produto p84 = new Produto(null, "Computador Lenovo 8GB de RAM i7 core", 5655.10);
		Produto p85 = new Produto(null, "Computador Asus 32GB de RAM com SSD i7 core", 7480.00);
		Produto p86 = new Produto(null, "Computador Acer 32GB de RAM com SSD i7 core", 5681.50);
		Produto p87 = new Produto(null, "Computador Samsumg 32GB de RAM com SSD i7 core", 6581.91);
		Produto p88 = new Produto(null, "Computador Lenovo 32 GB de RAM com SSD i7 core", 5655.10);
		Produto p89 = new Produto(null, "Computador Asus 16GB de RAM com SSD i5 core", 7480.00);
		Produto p90 = new Produto(null, "Computador Acer 16GB de RAM com SSD i5 core", 5681.50);
		Produto p91 = new Produto(null, "Computador Samsumg 16GB de RAM com SSD i5 core", 6581.91);
		Produto p92 = new Produto(null, "Computador Lenovo 16GB de RAM com SSD i5 core", 5655.10);
		Produto p93 = new Produto(null, "Computador Asus 8GB de RAM com SSD i5 core", 7480.00);
		Produto p94 = new Produto(null, "Computador Acer 8GB de RAM com SSD i5 core", 5681.50);
		Produto p95 = new Produto(null, "Computador Samsumg 8GB de RAM com SSD i5 core", 6581.91);
		Produto p96 = new Produto(null, "Computador Lenovo 8GB de RAM com SSD i5 core", 5655.10);
		
		
		
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
				p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21,
				p53, p54, p55, p56, p57, p58, p59, p60, p61, p62, p63, p64, p65, p66, p67, p68, p69, p70, p71,
				p72, p73, p74, p75, p76, p77, p78, p79, p80, p81, p82, p83, p84, p85, p86, p87, p88, p89, p90, p91,
				p92, p93, p94, p95, p96));
		cat2.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p23, p24, p25, p26));
		cat3.getProdutos().addAll(Arrays.asList(p27, p28, p29, p30, p31, p32, p33, p34, p35));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
				p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p38, p39));
		cat5.getProdutos().addAll(Arrays.asList(p40, p41, p42));
		cat6.getProdutos().addAll(Arrays.asList(p35, p36, p37));
		cat7.getProdutos().addAll(Arrays.asList(p43, p44, p45, p46, p47, p48, p49, p50, p51, p52));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p5.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p6.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p7.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p8.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p9.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p10.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p11.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p12.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p13.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p14.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p15.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p16.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p17.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p18.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p19.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p20.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p21.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p22.getCategorias().addAll(Arrays.asList(cat4));
		p23.getCategorias().addAll(Arrays.asList(cat2));
		p24.getCategorias().addAll(Arrays.asList(cat2));
		p25.getCategorias().addAll(Arrays.asList(cat2));
		p26.getCategorias().addAll(Arrays.asList(cat2));
		p27.getCategorias().addAll(Arrays.asList(cat3));	
		p28.getCategorias().addAll(Arrays.asList(cat3));
		p29.getCategorias().addAll(Arrays.asList(cat3));
		p30.getCategorias().addAll(Arrays.asList(cat3));
		p31.getCategorias().addAll(Arrays.asList(cat3));
		p32.getCategorias().addAll(Arrays.asList(cat3));
		p33.getCategorias().addAll(Arrays.asList(cat3));
		p34.getCategorias().addAll(Arrays.asList(cat3));
		p35.getCategorias().addAll(Arrays.asList(cat3, cat6));
		p36.getCategorias().addAll(Arrays.asList(cat6));
		p37.getCategorias().addAll(Arrays.asList(cat6));
		p38.getCategorias().addAll(Arrays.asList(cat4));
		p39.getCategorias().addAll(Arrays.asList(cat4));
		p40.getCategorias().addAll(Arrays.asList(cat5));
		p41.getCategorias().addAll(Arrays.asList(cat5));
		p42.getCategorias().addAll(Arrays.asList(cat5));
		p43.getCategorias().addAll(Arrays.asList(cat7));
		p44.getCategorias().addAll(Arrays.asList(cat7));
		p45.getCategorias().addAll(Arrays.asList(cat7));
		p46.getCategorias().addAll(Arrays.asList(cat7));
		p47.getCategorias().addAll(Arrays.asList(cat7));
		p48.getCategorias().addAll(Arrays.asList(cat7));
		p49.getCategorias().addAll(Arrays.asList(cat7));
		p50.getCategorias().addAll(Arrays.asList(cat7));
		p51.getCategorias().addAll(Arrays.asList(cat7));
		p52.getCategorias().addAll(Arrays.asList(cat7));
		
		
		p53.getCategorias().addAll(Arrays.asList(cat1));
		p54.getCategorias().addAll(Arrays.asList(cat1));
		p55.getCategorias().addAll(Arrays.asList(cat1));
		p56.getCategorias().addAll(Arrays.asList(cat1));	
		p57.getCategorias().addAll(Arrays.asList(cat1));
		p58.getCategorias().addAll(Arrays.asList(cat1));
		p59.getCategorias().addAll(Arrays.asList(cat1));
		p60.getCategorias().addAll(Arrays.asList(cat1));
		p61.getCategorias().addAll(Arrays.asList(cat1));
		p62.getCategorias().addAll(Arrays.asList(cat1));
		p63.getCategorias().addAll(Arrays.asList(cat1));
		p64.getCategorias().addAll(Arrays.asList(cat1));
		p65.getCategorias().addAll(Arrays.asList(cat1));
		p66.getCategorias().addAll(Arrays.asList(cat1));
		p67.getCategorias().addAll(Arrays.asList(cat1));
		p68.getCategorias().addAll(Arrays.asList(cat1));
		p69.getCategorias().addAll(Arrays.asList(cat1));
		p70.getCategorias().addAll(Arrays.asList(cat1));
		p71.getCategorias().addAll(Arrays.asList(cat1));
		p72.getCategorias().addAll(Arrays.asList(cat1));
		p73.getCategorias().addAll(Arrays.asList(cat1));
		p74.getCategorias().addAll(Arrays.asList(cat1));
		p75.getCategorias().addAll(Arrays.asList(cat1));
		p76.getCategorias().addAll(Arrays.asList(cat1));
		p77.getCategorias().addAll(Arrays.asList(cat1));
		p78.getCategorias().addAll(Arrays.asList(cat1));
		p79.getCategorias().addAll(Arrays.asList(cat1));
		p80.getCategorias().addAll(Arrays.asList(cat1));
		p81.getCategorias().addAll(Arrays.asList(cat1));
		p82.getCategorias().addAll(Arrays.asList(cat1));
		p83.getCategorias().addAll(Arrays.asList(cat1));
		p84.getCategorias().addAll(Arrays.asList(cat1));
		p85.getCategorias().addAll(Arrays.asList(cat1));
		p86.getCategorias().addAll(Arrays.asList(cat1));
		p87.getCategorias().addAll(Arrays.asList(cat1));
		p88.getCategorias().addAll(Arrays.asList(cat1));
		p89.getCategorias().addAll(Arrays.asList(cat1));
		p90.getCategorias().addAll(Arrays.asList(cat1));
		p91.getCategorias().addAll(Arrays.asList(cat1));
		p92.getCategorias().addAll(Arrays.asList(cat1));
		p93.getCategorias().addAll(Arrays.asList(cat1));
		p94.getCategorias().addAll(Arrays.asList(cat1));
		p95.getCategorias().addAll(Arrays.asList(cat1));
		p96.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
				p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26,
				p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41,
				p42, p43, p44, p45, p46, p47, p48, p49, p50, p51, p52,
				p53, p54, p55, p56, p57, p58, p59, p60, p61, p62, p63, p64, p65, p66, p67, p68, p69, p70, p71,
				p72, p73, p74, p75, p76, p77, p78, p79, p80, p81, p82, p83, p84, p85, p86, p87, p88, p89, p90, p91,
				p92, p93, p94, p95, p96 ));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia",est1);
		Cidade cid2 = new Cidade(null, "Inhaúma", est1);
		Cidade cid3 = new Cidade(null, "Sete Lagoas", est1);
		Cidade cid4 = new Cidade(null, "São Carlos", est2);
		Cidade cid5 = new Cidade(null, "Campinas", est2);
		Cidade cid6 = new Cidade(null, "São Paulo", est2);
		
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2, cid3));
		est2.getCidades().addAll(Arrays.asList(cid4, cid5, cid6));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5, cid6));
		
		Cliente cli1 = new Cliente(null, "Marco Aurelio Menezes", "marcoaurelioreislima@gmail.com", 
									"36378912377", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Cliente cli2 = new Cliente(null, "Felipe Etrusco Kandido", "marco_aurelio_reis@yahoo.com.br",
									"31628382740", TipoCliente.PESSOAFISICA, pe.encode("123"));
		cli2.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("37155662","997652392"));
		
		
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid6);
		Endereco e3 = new Endereco(null, "Rua da Quebrada", "420", "Sala 12", "Morro Vermelho", "01509001", cli2, cid4);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
				
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
