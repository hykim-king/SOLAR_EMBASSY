//package community.solar_embassy.site;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity  // 데이터의 집합을 의미한다.
//public class SiteUser {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long buId;
//
//    //@Column(unique = true) 처럼 unique = true를 지정했다.
//    // unique = true는 유일한 값만 저장할 수 있음을 의미한다.
//    @Column(unique = true)
//    private String buName;
//
//    private String buPasswords;
//
//    @Column(unique = true)
//    private String email;
//}
