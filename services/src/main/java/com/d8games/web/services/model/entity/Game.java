package com.d8games.web.services.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GAME")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SuppressWarnings("unused")
public class Game implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "GAME_ID", unique = true, nullable = false)
    private String gameId;

    @Column(name = "GAME_NAME", nullable = false)
    private String gameName;

    @Column(name = "GAME_SUMMARY", nullable = false)
    private String gameSummary;

    @Column(name = "GAME_DESCRIPTION")
    private String gameDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "GAME_RELEASE_DATE")
    private Date gameReleaseDate;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameSummary() {
        return gameSummary;
    }

    public void setGameSummary(String gameSummary) {
        this.gameSummary = gameSummary;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public Date getGameReleaseDate() {
        return gameReleaseDate;
    }

    public void setGameReleaseDate(Date gameReleaseDate) {
        this.gameReleaseDate = gameReleaseDate;
    }
}
