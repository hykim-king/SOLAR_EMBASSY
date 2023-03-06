//package com.community.solar_embassy.google;
//
//import com.community.solar_embassy.google.Role;
//import com.community.solar_embassy.google. *;
//import lombok.Builder;
//import lombok.Getter;
//
//import java.util.Map;
//
//// // 구글 로그인 이후 가져온 사용자의 이메일, 이름, 프로필 사진 주소 를 저장하는 DTO
//@Getter
//public class OAuthAttributes {
//    private Map<String, Object> attributes;
//    private String nameAttributeKey, name, email, picture;
//    @Builder
//    public OAuthAttributes(Map<String, Object> attributes,
//                           String nameAttributeKey,
//                           String name, String email, String picture) {
//        this.attributes = attributes;
//        this.nameAttributeKey = nameAttributeKey;
//        this.name = name;
//        this.email = email;
//        this.picture = picture;
//    }
//    public static OAuthAttributes of(String registrationId,
//                                     String userNameAttributeName,
//                                     Map<String, Object> attributes) {
//        return ofGoogle(userNameAttributeName, attributes);
//    }
//    public static OAuthAttributes ofGoogle(String userNameAttributeName,
//                                           Map<String, Object> attributes) {
//        return OAuthAttributes.builder()
//                .name((String) attributes.get("name"))
//                .email((String) attributes.get("email"))
//                .picture((String) attributes.get("picture"))
//                .attributes(attributes)
//                .nameAttributeKey(userNameAttributeName)
//                .build();
//    }
//    public User toEntity() {
//        return User.builder()
//                .name(name)
//                .email(email)
//                .picture(picture)
//                .role(Role.GUEST)
//                .build();
//    }
//}