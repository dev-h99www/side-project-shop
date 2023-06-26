package com.h9w.shop;

import lombok.*;

import javax.persistence.*;

@Entity(name = "hello")
@Table(name = "hello")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "hello_seq_generator",
        sequenceName = "seq_hello",
        initialValue = 1,
        allocationSize = 1
)
public class Hello {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hello_seq_generator"
    )
    private Long id;
}