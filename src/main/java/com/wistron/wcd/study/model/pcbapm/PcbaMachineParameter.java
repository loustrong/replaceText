package com.wistron.wcd.study.model.pcbapm;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "pcba_machine_parameter")
public class PcbaMachineParameter {
    @Id
    @Column(name = "syncid",length = 21)
    @NotNull(message = "syncid is not empty.")
    private String syncid;

    @Column(name = "site",length = 4)
	private String site;

    @Column(name = "plant",length = 5)
	private String plant;

    @Column(name = "line",length = 5)
	private String line;

    @Column(name = "modelno",length = 30)
	private String modelno;

    @Column(name = "pcbno",length = 30)
    private String pcbno;

    @Column(name = "pcbpn",length = 30)
    private String pcbpn;

    @Column(name = "department",length = 4)
    private String department;

    @Column(name = "machinename",length = 30)
    private String machinename;

    @Column(name = "side",length = 20, nullable=true,columnDefinition="String default null")
    private String side;

    @Column(name = "programmename",length = 20)
    @NotNull(message = "programmename is not empty.")
	private String programmename;

    @Column(name = "parametername",length = 50)
    @NotNull(message = "parametername is not empty.")
	private String parametername;

    @Column(name = "parametervalue", nullable=true,columnDefinition="Float default 0")
    private float parametervalue;

    @Column(name = "warningtype", nullable=true,columnDefinition="Float default 0")
    private float warningtype;

    @Column(name = "parameterrange",length = 30, columnDefinition="String default null")
    private String parameterrange;

    @Column(name = "rangetopupper", nullable=true,columnDefinition="Float default 0")
    private float rangetopupper;

    @Column(name = "rangetoplower", nullable=true,columnDefinition="Float default 0")
    private float rangetoplower;
    @Column(name = "rangebottomupper", nullable=true,columnDefinition="Float default 0")
    private float  rangebottomupper;

    @Column(name = "rangebottomlower", nullable=true,columnDefinition="Float default 0")
    private float  rangebottomlower;
}
