import java.util.Random;
public class NetprolabMember {
    public static final int years = 15;
    public static final int columns = 3;
    public static void main(String[] args) {
        int[][] members = new int[years][columns];
        Random random = new Random();
        double totalRatio = 1;
        for (int i = 0; i < years; i++) {
            // 学生の総数
            members[i][0] = 110 + random.nextInt(21); // 110から130のランダムな数
            // 女性の割合(%)
            members[i][1] = 20 + i; // 年ごとに1%ずつ増加
            // 岩井研の人数
            members[i][2] = 10 + random.nextInt(7) - 3; // 7人のランダムな数から3を引いて10人の定員から外れる
            // 岩井研に女性の学生が来ない確率を計算
            double femaleRatio = (double) members[i][1] / 100;
            double noFemaleInLab = Math.pow((1 - femaleRatio), members[i][2]);
            totalRatio *= noFemaleInLab;
        }
        System.out.println(totalRatio);
    }
}
