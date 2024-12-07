package com.competition.competition.repository;

import com.competition.competition.dto.CardResponseSimplifiedDTO;
import com.competition.competition.entity.Card;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// TODO: expand text matching search

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    @Query("SELECT new com.competition.competition.dto.CardResponseSimplifiedDTO(c.id, c.name, c.cardImages.small) " +
            "FROM Card c " +
            "WHERE (:expansionId IS NULL OR c.expansion.id = :expansionId) " +
            "AND (:rarity IS NULL OR c.rarity = :rarity) " +
            "AND (:packId IS NULL OR :packId MEMBER OF c.foundInPacks) " +
            "AND (:searchText IS NULL OR c.name = :searchText) " +
//            "AND (:searchText IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :searchText, '%'))) " +
            "AND (:hasAbility IS NULL OR c.hasAbility = :hasAbility) " +
            "AND (:hasRuleBox IS NULL OR c.hasRuleBox = :hasRuleBox) " +
            "AND (:energyType IS NULL OR :energyType MEMBER OF c.energyTypes) " +
            "AND (:weakness IS NULL OR :weakness MEMBER OF c.weakness) " +
            "AND (:retreatCost IS NULL OR c.retreatCost = :retreatCost) " +
            "AND (:superType IS NULL OR :superType = c.superType) " +
            "AND (:subType IS NULL OR :subType MEMBER OF c.subTypes)")
    List<CardResponseSimplifiedDTO> findSummarizedCardsFiltered(
            @Param("expansionId") String expansionId,
            @Param("searchText") String searchText,
            @Param("rarity") String rarity,
            @Param("packId") String packId,
            @Param("hasAbility") Boolean hasAbility,
            @Param("hasRuleBox") Boolean hasRuleBox,
            @Param("energyType") String energyType,
            @Param("weakness") String weakness,
            @Param("retreatCost") Integer retreatCost,
            @Param("superType") String superType,
            @Param("subType") String subType,
            Sort sort
    );
}
