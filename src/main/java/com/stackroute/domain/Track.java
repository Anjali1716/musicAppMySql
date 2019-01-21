package com.stackroute.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.annotation.Documented;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Track {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ApiModelProperty(notes="Track name")
    private String trackName;
    @ApiModelProperty(notes="Give your comment on this track")
    private String trackComment;


}
