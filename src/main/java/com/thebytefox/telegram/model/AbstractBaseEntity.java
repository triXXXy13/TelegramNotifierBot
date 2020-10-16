package com.thebytefox.telegram.model;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.Hibernate;

import javax.persistence.*;
@MappedSuperclass
@Access(AccessType.FIELD)
@Getter
@Setter
public abstract class AbstractBaseEntity {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    protected AbstractBaseEntity() {

    }
    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }
}
