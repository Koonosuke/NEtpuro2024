import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class HowOldAreYou {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("何歳ですか?");
                String line = reader.readLine();
                if (line.equalsIgnoreCase("q") || line.equalsIgnoreCase("e")) {
                    break;
                }

                int age = Integer.parseInt(line);
                if (age < 0 || age >= 120) {
                    System.out.println("年齢は0歳以上120歳未満で入力してください。");
                    continue;
                }

                System.out.println("あなたは" + age + "歳ですね。");
                System.out.println("あなたは2030年には、" + (age + 6) + "歳ですね。");
                LocalDate now = LocalDate.now();
                int currentYear = now.getYear();
                int birthYear = currentYear - age;

            
                String era = getEra(birthYear);
                int e = getE(birthYear); 

                System.out.println("あなたの生まれた年の元号: " + (era + e) + "年"); 
            } catch (IOException e) {
                System.out.println(e);
            } catch (NumberFormatException e) {
                System.out.println("年齢は数字で入力してください。");
            }
        }
    }

    private static String getEra(int birthYear) {
        String era;
        if (birthYear >= 1868 && birthYear < 1912) {
            era = "明治";
        } else if (birthYear >= 1912 && birthYear < 1926) {
            era = "大正";
        } else if (birthYear >= 1926 && birthYear < 1989) {
            era = "昭和";
        } else if (birthYear >= 1989 && birthYear < 2019) {
            era = "平成";
        } else {
            era = "令和";
        }
        return era;
    }

    private static int getE(int birthYear) {

        int e;
        if (birthYear >= 1868 && birthYear < 1912) {
            e = birthYear - 1868;
        } else if (birthYear >= 1912 && birthYear < 1926) {
            e = birthYear - 1912;
        } else if (birthYear >= 1926 && birthYear < 1989) {
            e = birthYear - 1926;
        } else if (birthYear >= 1989 && birthYear < 2019) {
            e = birthYear - 1989;
        } else {
            e = birthYear - 2019;
        }
        return e;
    }
}
