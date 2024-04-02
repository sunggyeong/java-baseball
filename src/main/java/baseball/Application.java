package baseball;

public class Application {
    public static void main(String[] args) {

        //상태 state가 true면 게임 계속, false면 게임 종료
        boolean state=false;

        do{
            Setting baseball=new Setting();

            baseball.startGame(); //Setting클래스의 startGame 메소드로 게임 진행

            int input=baseball.endGame(); //Setting 클래스의 endGame 메소드로 계속 할지 말지 숫자 입력받음

            if(input==1){
                state=false;
            }

            else if(input==2){
                state=true;
            }

            else{
                System.out.println("다시 입력하세요: ");
                baseball.endGame();
            }



        }while(!state);


    }
}
