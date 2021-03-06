package com.springproject;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springproject.domain.Categoria;
import com.springproject.domain.Cidade;
import com.springproject.domain.Cliente;
import com.springproject.domain.Endereco;
import com.springproject.domain.Estado;
import com.springproject.domain.Pagamento;
import com.springproject.domain.PagamentoComBoleto;
import com.springproject.domain.PagamentoComCartao;
import com.springproject.domain.Pedido;
import com.springproject.domain.Produto;
import com.springproject.enums.EstadoPagamento;
import com.springproject.enums.TipoCliente;
import com.springproject.repositories.CategoriaRepository;
import com.springproject.repositories.CidadeRepository;
import com.springproject.repositories.ClienteRepository;
import com.springproject.repositories.EnderecoRepository;
import com.springproject.repositories.EstadoRepository;
import com.springproject.repositories.PagamentoRepository;
import com.springproject.repositories.PedidoRepository;
import com.springproject.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	
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

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Cria Categorias para Teste.
		Categoria categoria1 = new Categoria(null, "Inform??tica");
		Categoria categoria2 = new Categoria(null, "Escrit??rio");
		
		//Cria Produtos para Teste.
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		
		//Cria Estados para Teste.
		Estado estado1 = new Estado(null, "S??o Paulo");
		Estado estado2 = new Estado(null,"Minas Gerais");
		
		//Cria Cidades para Teste.
		Cidade cidade1 = new Cidade(null, "Uberl??ndia", estado2);
		Cidade cidade2 = new Cidade(null, "S??o Paulo", estado1);
		Cidade cidade3 = new Cidade(null, "Campinas", estado1);
		
		//Cria Cliente para Teste.
		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "000.000.000-00", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("(61)3333-3333","(62)2222-2222"));
		
		//Cria Endere??os para Teste.
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto.203", "Jardim", "00000-000", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "11111-111", cliente1, cidade2);
		
		//Cria Pedidos para Teste.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), endereco1, cliente1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), endereco2, cliente1);
		
		//Cria Pagamento para Teste.
		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);
		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagamento2);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		categoria2.getProdutos().add(produto2);
		
		produto1.getCategorias().add(categoria1);
		produto2.getCategorias().addAll(Arrays.asList(categoria1,categoria2));
		produto3.getCategorias().add(categoria1);
		
		estado1.getCidades().add(cidade1);
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		
	}
}
