package edu.ifsc.fln.confortaid.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @jakarta.persistence.JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    private LocalDateTime dataHora;

    //    @Setter(value = lombok.AccessLevel.NONE) // Impede a geração automática do setStatus
    @Enumerated(EnumType.STRING)
    private Agendamento.Status status= Status.PENDENTE; // Status inicial do agendamento: "Pendente".

    public enum Status {
        CONFIRMADO, PENDENTE, CANCELADO, ATENDIDO
    }
}
