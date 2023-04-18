package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//@NoArgsConstructor //cria um construtor vazio
//@AllArgsConstructor //cria um construtor com todos os atributos
//@Entity
//@Table able(name = "tb_alunos")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tb_alunos")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
