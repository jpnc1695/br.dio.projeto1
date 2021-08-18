import br.com.dio.dominio.BootCamp;
import br.com.dio.dominio.Curso;
import br.com.dio.dominio.Dev;
import br.com.dio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("descrição curso Java");
        curso1.setCargahoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Js");
        curso2.setDescricao("descrição curso Js");
        curso2.setCargahoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(" Mentoria Java");
        mentoria.setDescricao(" Mentoria Java");
        mentoria.setData(LocalDate.now());

       /* System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);
        */

        BootCamp bootCamp = new BootCamp();
        bootCamp.setNome("Bootcamp Java Developer");
        bootCamp.setDescricao("Descrição Bootcamp Java Developer");
        bootCamp.getConteudos().add(curso1);
        bootCamp.getConteudos().add(curso2);
        bootCamp.getConteudos().add(mentoria);

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootCamp);
        System.out.println("Conteudos Inscritos João : " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("Conteudos Inscritos João : " + devJoao.getConteudosInscritos());
        System.out.println("Conteudos Concluidos João : " + devJoao.getConteudosconcluidos());
        System.out.print("XP: " + devJoao.calcularTotalXp());

        System.out.print("[-------]");

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootCamp);
        System.out.println("Conteudos Inscritos Camila : " + devCamila.getConteudosInscritos());
        devCamila.progredir();
        System.out.println("Conteudos Inscritos Camila : " + devJoao.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Camila : " + devCamila.getConteudosconcluidos());
        System.out.print("XP: " + devCamila.calcularTotalXp());
    }
}
