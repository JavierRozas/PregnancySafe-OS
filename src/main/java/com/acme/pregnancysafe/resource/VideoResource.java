package com.acme.pregnancysafe.resource;

import com.acme.pregnancysafe.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VideoResource extends AuditModel{
    private Long id;
    private String url;
    private Date postdate;
    private String title;
}
