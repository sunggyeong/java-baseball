package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Array {
    static int length=3;  //배열의 길이는 3

    //Array의 인스턴수 변수로 computerArray,userArray 선언
    List<Integer> computerArray = new ArrayList<>();
    List<Integer> userArray= new ArrayList<>();

    //생성자로 인스턴스를 생성할 때 computerArray생성
    Array(){
        while (computerArray.size() <= length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerArray.contains(randomNumber)) {
                computerArray.add(randomNumber);
            }
        }

    }

    //사용자에게 입력받아 userArray를 생성하는 메소드
    List<Integer> CreateUserArray(){
        while (userArray.size() <= length) {
            System.out.println("숫자를 입력해주세요: ");
            String line= Console.readLine();
            int number=Integer.parseInt(line);
            if(number>999){
                throw new IllegalArgumentException();
            }
            for(int i=0; i<length; i++){
                int div= (int)Math.pow(10,i);
                int num=number%(100/div);
                if(!userArray.contains(num)){
                    userArray.add(num);
                }
            }
        }

        return userArray;
    }

    //strike를 계산하는 메소드
    int computeStrike(List<Integer> userArray){
        int strike=0;
        for(int i=0;i<length;i++){
            if(computerArray.get(i)==userArray.get(i)){
                strike++;
            }
        }

        return strike;
    }

    //foul를 계산하는 메소드
    int computeFoul(List<Integer> userArray){
        int foul=0;
        for(int i=0; i<length; i++){
            for(int j=0; j<length;j++){
                if((computerArray.get(i)==userArray.get(j))&&(i!=j)){
                    foul++;
                }
            }
        }

        return foul;
    }
}
