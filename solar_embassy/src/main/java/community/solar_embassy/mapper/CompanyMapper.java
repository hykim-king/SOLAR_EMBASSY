package community.solar_embassy.mapper;

import community.solar_embassy.dto.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {
    Company selectCompanyDetail(String comName);
    int insert(Company company);
}
