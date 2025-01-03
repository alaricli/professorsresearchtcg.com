package com.competition.competition.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Archetype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String tier;
    @Column(unique = true, nullable = false)
    private Integer ranking;
    private Integer wins;
    private String image;
    private String category;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "archetype_pokemons", joinColumns = @JoinColumn(name = "archetype_id"))
    @Column(name = "archetype_pokemons")
    private List<String> pokemons;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "archetype_pokemonsImages", joinColumns = @JoinColumn(name = "archetype_id"))
    @Column(name = "archetype_pokemonsImages")
    private List<String> pokemonsImages;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "archetype_energy_types_icons", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "archetype_energy_types_icons")
    private List<String> energyTypesIcons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<String> pokemons) {
        this.pokemons = pokemons;
    }

    public List<String> getPokemonsImages() {
        return pokemonsImages;
    }

    public void setPokemonsImages(List<String> pokemonsImages) {
        this.pokemonsImages = pokemonsImages;
    }

    public List<String> getEnergyTypesIcons() {
        return energyTypesIcons;
    }

    public void setEnergyTypesIcons(List<String> energyTypes) {
        this.energyTypesIcons = energyTypes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
