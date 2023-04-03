import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner cin = new Scanner(System.in);
        int year=cin.nextInt(); //年份
        int k=cin.nextInt();//第几天
        int max_day=365;
        if(year %400==0||(year%10!=0&&year%4==0))
        {
            a[2]=29;
            max_day=366;
        }
        if(k>=1&&k<=max_day)
        {
            int sum=0;
            int temp=0;
            for(int i=1;;i++)
            {
                sum+=a[i];
                if(sum>=k) {
                    temp=i;
                    break;
                }
            }
            //这里会出现两个情况一个是sum+a[i]正好等于第k天 还有一种情况是sum+a[i]大于第k天
            if(sum==k)
            {
                System.out.println(year+"-"+temp+"-"+a[temp]);
            }
            else
            {
                sum-=k;
                System.out.println(year+"-"+temp+"-"+(a[temp]-sum));
            }

        }
        else{
            System.out.println("输入错误");
        }

    }

}
