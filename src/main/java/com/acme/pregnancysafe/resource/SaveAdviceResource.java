package com.acme.pregnancysafe.resource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class SaveAdviceResource {
    @NotNull
    @Lob
    private String title;

    @NotNull
    @Lob
    private String text;

    @NotNull
    @NotBlank
    private Date postdate;

}