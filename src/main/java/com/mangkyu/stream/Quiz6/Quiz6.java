package com.mangkyu.stream.Quiz6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Quiz6 {

    private Student[] stuArr;

    public Quiz6() {
        stuArr = new Student[]{
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),
                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };
    }

    // stuArr에서 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별하여라. (Boolean, List)
    public Map<Boolean, List<Student>> quiz1() {
        Map<Boolean, List<Student>> lst = Arrays.stream(stuArr)
                .filter(st -> st.getScore() < 150)
                .collect(groupingBy(Student::isMale));
        for (Boolean aBoolean : lst.keySet()) {
            System.out.println("lst.get(aBoolean) = " + lst.get(aBoolean));
        }

        return lst;
    }

    // 각 반별 총점을 학년 별로 나누어 구하여라 (Map<Integer, Map<Integer, Integer>>)
    public Map<Integer, Map<Integer, Integer>> quiz2() {
        Map<Integer, Map<Integer, Integer>> lst = Arrays.stream(stuArr)
                .collect(groupingBy(Student::getHak, groupingBy(Student::getBan, summingInt(Student::getScore))));
//        Map<Integer, Map<Integer, Integer>> lst = Stream.of(stuArr)
//                .collect(groupingBy(Student::getHak, groupingBy(Student::getBan, summingInt(Student::getScore))));

        for (Integer integer : lst.keySet()) {
            System.out.println(integer + " =" + lst.get(integer));

        }
        return lst;
    }

}
