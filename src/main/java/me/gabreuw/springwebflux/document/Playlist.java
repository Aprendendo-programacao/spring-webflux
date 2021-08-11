package me.gabreuw.springwebflux.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Playlist {

    @Id
    private String id;

    private String nome;

}
