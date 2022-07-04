package com.j2ee.sorties.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pokemon")
public class Pokemon {
    @Id @Column @NotEmpty
    private String idPoke;

    @Column @NotEmpty
    private String name;

    @Column
    private String spriteUrl;

    @ManyToMany
    @JoinTable(name = "pokemon_types",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private List<Type> types;

    public String getId() {return idPoke;}
    public void setId(String id) {this.idPoke = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSpriteUrl() {return spriteUrl;}
    public void setSpriteUrl(String spriteUrl) {this.spriteUrl = spriteUrl;}
    public List<Type> getTypes() {return types;}
    public void setTypes(List<Type> types) {this.types = types;}
}
