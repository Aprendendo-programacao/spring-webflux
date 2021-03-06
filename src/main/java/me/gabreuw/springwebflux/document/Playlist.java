package me.gabreuw.springwebflux.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Playlist implements Serializable {

    @Id
    private String id;

    private String name;

}
