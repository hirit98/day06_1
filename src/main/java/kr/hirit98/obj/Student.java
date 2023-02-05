package kr.hirit98.obj;

import lombok.*;

// All Arguments Constructor

 @Getter
// @Setter
// @AllArgsConstructor
 @RequiredArgsConstructor // 필요한 인자에 대해서만 인자를 생성
// @Builder
public class Student {

    @NonNull private String name;
    @NonNull private int age;





}
