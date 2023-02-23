package community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PopularSearch implements Serializable {
    private Integer popKwdNo;

    private String userId;

    private String licenseNum;

    private String buTell;

    private String searchKw;

    private Date searchTime;

    private String searchIp;

    private static final long serialVersionUID = 1L;
}