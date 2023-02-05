package kr.hirit98;

import com.google.gson.Gson;
import kr.hirit98.obj.Student;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Student st1 = new Student("홍길동", 15);
        // json
        // {fieldName: value}
        // google 에서 만든 object -> json 으로 변환해주는 library.
        // "홍길동" + ".json" => 홍길동.json
        File file = new File(st1.getName()+".json");
        if(!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException ex){
                System.out.println("파일 생성에 실패함.");
            }

        }

        Gson gson = new Gson();
        String json = gson.toJson(st1);

        try(FileWriter fw = new FileWriter(file)){
            fw.write(json);

        }catch (IOException ex){
            System.out.println("파일을 쓰는데 실패함.");
        }

        // ----------------File -> Student------------------
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            // .read(); -> return int
            String data = br.readLine();
            Student fromJsonStudent = gson.fromJson(data,Student.class);
            System.out.println(fromJsonStudent.getName());
            System.out.println(fromJsonStudent.getAge());
        }catch (FileNotFoundException ef){
            System.out.println("파일을 찾을 수 없습니다.");
        }catch (IOException ex){
            System.out.println("파일을 읽는 데 실패함.");
        }
    }
}