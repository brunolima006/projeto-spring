package com.springproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springproject.domain.Categoria;
import com.springproject.domain.Cidade;
import com.springproject.domain.Estado;
import com.springproject.domain.Produto;
import com.springproject.repositories.CategoriaRepository;
import com.springproject.repositories.CidadeRepository;
import com.springproject.repositories.EstadoRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Cria Categorias para Teste.
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		
		//Cria Produtos para Teste.
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);
		
		//Cria Estados para Teste.
		Estado estado1 = new Estado(null, "São Paulo");
		Estado estado2 = new Estado(null,"Minas Gerais");
		
		//Cria Cidades para Teste.
		Cidade cidade1 = new Cidade(null, "Uberlândia", estado2);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado1);
		Cidade cidade3 = new Cidade(null, "Campinas", estado1);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1,produto2,produto3));
		categoria2.getProdutos().add(produto2);
		
		produto1.getCategorias().add(categoria1);
		produto2.getCategorias().addAll(Arrays.asList(categoria1,categoria2));
		produto3.getCategorias().add(categoria1);
		
		estado1.getCidades().add(cidade1);
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1,produto2,produto3));
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
	}
}
