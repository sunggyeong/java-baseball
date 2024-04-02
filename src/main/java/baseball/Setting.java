package baseball;

import java.util.List;
import java.util.Scanner;

public class Setting {

    //Array 클래스의 game 인스턴스 생성
    Array game =new Array();

    boolean win;

    Setting(){

        //game 인스턴스에서 computerArray변수를 가져와 computer 변수에 저장
        List<Integer> computer = game.computerArray;

        //승리 상태 변수, 3스트라이크로 승리시 win=true가 됨
        boolean win=false;
    }


    //game를 진행하는 메소드, win==true가 되면 게임 종료
    void startGame(){
        do{
            //user에게 입력받고 리스트를 생성
            List<Integer> user=game.CreateUserArray();
            //strike와 foul를 계산하고 결과를 도출
            int strike=game.computeStrike(user);
            int foul=game.computeFoul(user);

            if(strike==3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                win=true;
            }
            else if(strike==0&&foul==0){
                System.out.println("낫싱");
            }
            else if(strike==0||foul==0){
                if(strike==0){
                    System.out.println(foul+"볼");
                }
                else{
                    System.out.println(strike+"스트라이크");
                }

            }
            else{
                System.out.println(foul+"볼 "+strike+"스트라이크");
            }

        }while(!win);
    }

    //사용자에게 종료 숫자를 입력받는 메소드
    int endGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");

        Scanner scanner= new Scanner(System.in);
        int input=scanner.nextInt();

        return input;
    }
}
