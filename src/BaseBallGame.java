import java.util.*;

public class BaseBallGame {
    /*
    * - 컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759 v
      - 사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.
      - 컴퓨터는 사용자가 입력한 세자리 숫자에 대해서, 아래의 규칙대로 스트라이크(S)와 볼(B)를 알려줍니다.
      - 숫자의 값과 위치가 모두 일치하면 S
      - 숫자의 값은 일치하지만 위치가 틀렸으면 B
      - 기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록됩니다.
      - 숫자 3개를 모두 맞춘 경우, 게임을 종료합니다.
    * */
    public static void main(String[] args) {
        Random random = new Random();
        List<String> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // 배열 생성
        for (int i = 0; i < 3; i++) {
            String num = Integer.toString(random.nextInt(10));

            // arr 포함되지 않는 num 을 생성할때까지
            while (arr.contains(num)) {
                num = Integer.toString(random.nextInt(10));
            }
            // 없을 경우 배열에 집어넣기
            arr.add(num);
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");


        int i = 1;

        while (true) {
            int strike = 0;
            int ball = 0;

            System.out.print(i + "번째 시도: ");
            String userNum = scanner.nextLine();

            for (int j = 0; j < 3; j++) {
                String compareNum = userNum.substring(j, j+1); // 123 (0,1) index = 0 인 character 반환 1
                // 컴퓨터가 가진 배열을 돌면서, 비교
                for (int k = 0; k < 3; k++) {
                    if (arr.get(k).equals(compareNum) && j == k) {
                        strike++;
                    } else if (arr.get(k).equals(compareNum) && j != k) {
                        ball++;
                    }
                }
            }

            if (strike == 0 && ball == 0) {
                System.out.println("0B0S");
            } else if (strike == 0) {
                System.out.println(ball + "B");
            } else if (ball == 0) {
                System.out.println(strike + "S");
            } else {
                System.out.println(ball + "B" + strike + "S");
            }

            if (strike ==3) {
                System.out.println(i+"번만에 맞히셨습니다. ");
                break;
            }

            i++;
        }
        System.out.println("게임을 종료합니다.");
    }
}
