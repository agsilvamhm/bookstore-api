package com.agsilva.bookstore.service;

import com.agsilva.bookstore.domain.Categoria;
import com.agsilva.bookstore.domain.Livro;
import com.agsilva.bookstore.repositories.CategoriaRepository;
import com.agsilva.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instaciaBaseDeDados(){
        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro l1 = new Livro(null, "Código Limpo", "Robert C. Martin", "Lorem ipsum", cat1);
        Livro l2 = new Livro(null, "Engenharia de software", "Louis V. Gerstner", "Lorem ipsum", cat1);
        Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat1);
        Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat1);
        Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat1);

        cat1.getLivros().addAll(Arrays.asList(l1,l2));
        cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));

        this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
