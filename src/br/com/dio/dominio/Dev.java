package br.com.dio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosconcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(BootCamp bootCamp) {
        this.conteudosInscritos.addAll(bootCamp.getConteudos());
        bootCamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosconcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());

        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!!! ");
        }
    }

    public double calcularTotalXp() {
         return this.conteudosconcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosconcluidos() {
        return conteudosconcluidos;
    }

    public void setConteudosconcluidos(Set<Conteudo> conteudosconcluidos) {
        this.conteudosconcluidos = conteudosconcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosconcluidos, dev.conteudosconcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosconcluidos);
    }
}
