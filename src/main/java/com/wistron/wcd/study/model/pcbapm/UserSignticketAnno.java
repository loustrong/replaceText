package com.wistron.wcd.study.model.pcbapm;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pcba_user_signticket")
@Data
public class UserSignticketAnno {
    @Id
    @Column(name = "ticketid")
    private String ticketid;
    @Column(name = "documentid")
    private String documentid;
    @Column(name = "site")
    private String site;
    @Column(name = "plant")
    private String plant;
    @Column(name = "department")
    private String department;
    @Column(name = "creator")
    private String creator;
    @Column(name = "creatorcname")
    private String creatorcname;
    @Column(name = "reviewer")
    private String reviewer;
    @Column(name = "reviewercname")
    private String reviewercname;
    @Column(name = "approver")
    private String approver;
    @Column(name = "approvercname")
    private String approvercname;
    @Column(name = "signdate")
    private String signdate;
    @Column(name = "mailto")
    private String mailto;
    @Column(name = "mailtouserid")
    private String mailtouserid;
    @Column(name = "mailcc")
    private String mailcc;
    @Column(name = "mailcname")
    private String mailcname;
    @Column(name = "stage")
    private String stage;
    @Column(name = "mailename")
    private String mailename;
    @Column(name = "createdate")
    private String createdate;
    @Column(name = "status")
    private int status;
    @Column(name = "reviewercomment")
    private String reviewercomment;
    @Column(name = "approvercomment")
    private String approvercomment;
    @Column(name = "version")
    private String version;
    @Column(name = "rejectComment")
    private String rejectComment;
    @Column(name = "updatedate")
    private String updatedate;
    @Column(name = "page")
    private String page;
    @Column(name = "releasereason")
    private String releasereason;

}
