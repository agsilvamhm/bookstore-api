package com.agsilva.bookstore.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nome;
        private String descricao;
        @OneToMany(mappedBy = "categoria")
        private List<Livro> livros = new ArrayList<>();
        public Categoria() {
                super();
        }
        public Categoria(Integer id, String nome, String descricao) {
                this.id = id;
                this.nome = nome;
                this.descricao = descricao;
        }

        public Integer getId() {
                return id;
        }

        public String getNome() {
                return nome;
        }

        public String getDescricao() {
                return descricao;
        }

        public List<Livro> getLivros() {
                return livros;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public void setLivros(List<Livro> livros) {
                this.livros = livros;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Categoria categoria)) return false;
                return getId().equals(categoria.getId());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getId());
        }
}