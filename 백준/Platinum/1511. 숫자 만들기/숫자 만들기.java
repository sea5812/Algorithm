import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int recent = -1;
        for (int k = 0; k < 505; k++) {
            boolean flag = false;
            for (int i = 0; i < 10; i++) {
                if (arr[i] >= sum - arr[i] + 1 && i != recent) {
                    sb.append(i);
                    arr[i]--;
                    recent = i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int i = 9; i >= 0; i--) {
                    if (arr[i] == 0 || i == recent) continue;
                    sb.append(i);
                    arr[i]--;
                    recent = i;
                    break;
                }
            }
            sum = Arrays.stream(arr).sum();
            if (sum - arr[recent] == 0) break;
        }
        if (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}

//1.제일 많이 남아 있는 수 >= (나머지 수들의 합 + 1) 이면 그 수 먼저 써야함! ??
//2.그냥 방금 쓴 수 저장하고 그 수 건너뛰어야함
//3.남아 있는 것 중에서 제일 큰 수
//4.남은 배열이 다 없다면 종료
//3 1 3
//
//2102020
