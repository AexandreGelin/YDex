package com.j2ee.sorties.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "type")
public class Type {
    @Id @Column @NotEmpty
    private String type_id;

    @Column @NotEmpty
    private String name;


    @ManyToMany(mappedBy = "types")
    @JsonIgnore
    private List<Pokemon> pokemons;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getType_id() {return type_id;}
    public void setType_id(String type_id) {this.type_id = type_id;}
    public List<Pokemon> getPokemons() {return pokemons;}
    public void setPokemons(List<Pokemon> pokemons) {this.pokemons = pokemons;}
}
