public class DecryptCaesarCipher {
    public static void main(String[] args) {
        String str1 = "mnv xnt zqd qdzcx sn lnud sn hlldqrhud bntqrd";
        String str2 = "khoor zruog";

        String output = Solution32.decryptCaesarCipher(str1, 25);
        System.out.println(output);

        output = Solution32.decryptCaesarCipher(str2, 3);
        System.out.println(output);
    }
}

// 암호화된 문자열과 암호화 키를 입력받아 복호화된 문자열을 리턴
// 카이사르 암호는 평문을 암호키 secret 개만큼 오른쪽으로 평행이동시켜 암호화한다.
class Solution32 {
    public static String decryptCaesarCipher(String str, int secret) {
        String result = "";
        if (str.length() == 0) return result; // 빈 문자열 그대로 리턴

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') result += str.charAt(i); // 공백이면 그대로 입력
            else {
                int ascii = (int)str.charAt(i) - secret; // 복호화된 i번째 인덱스 문자
                if (ascii < 97) { // 소문자 범위를 넘어가면
                    ascii += 26;
                }
                result += (char) ascii;
            }
        }
        return result;
    }
}