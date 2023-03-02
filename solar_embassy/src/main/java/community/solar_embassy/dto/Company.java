package community.solar_embassy.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class Company implements Serializable {
    private Integer comNo;

    private String comName;

    private String address;

    private String parentName;

    private Date foundDate;

    private String founders;

    private String ceo;

    private String industries;

    private String slogan;

    private String content;

    private static final long serialVersionUID = 1L;

    public Company(String comName, String address, String parentName, Date foundDate, String founders, String ceo, String industries, String slogan, String content) {
        this.comName = comName;
        this.address = address;
        this.parentName = parentName;
        this.foundDate = foundDate;
        this.founders = founders;
        this.ceo = ceo;
        this.industries = industries;
        this.slogan = slogan;
        this.content = content;
    }

    public Company() {
    }
}