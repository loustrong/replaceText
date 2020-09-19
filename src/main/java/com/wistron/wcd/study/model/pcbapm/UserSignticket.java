package com.wistron.wcd.study.model.pcbapm;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class UserSignticket {
    private String ticketid;
    private String documentid;
    private String site;
    private String plant;
    private String department;
    private String creator;
    private String creatorcname;
    private String reviewer;
    private String reviewercname;
    private String approver;
    private String approvercname;
    private String signdate;
    private String mailto;
    private String mailtouserid;
    private String mailcc;
    private String mailcname;
    private String stage;
    private String mailename;
    private String createdate;
    private int status;
    private String reviewercomment;
    private String approvercomment;
    private String version;
    private String rejectComment;
    private String updatedate;
    private String page;
    private String releasereason;
}
