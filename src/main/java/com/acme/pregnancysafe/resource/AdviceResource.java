package com.acme.pregnancysafe.resource;
import com.acme.pregnancysafe.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AdviceResource extends AuditModel {
    private Long id;
    private String title;
    private String text;
    private Date postdate;
}
