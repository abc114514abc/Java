import java.util.Scanner;
import java.util.Random;

public class Chouka {
    public int yuanshi = 0;       //充值货币
    public int hechengyu = 0;       //抽卡货币
    public static String aaa[] = {"User1","User2","User3"};
    public static String zhanghao[] = {"123456","234567","345678"};
    public static String mima[] = {"1a","2b","3c"};
    public static int Chong[] = {1,6,20,40,66,130};    //首充双倍
    public static String xian[] = {"凛御银灰"};
    public static String up[] = {"凛御银灰","圣聆初雪"};
    public static String six[] = {"橙闪","玛恩纳","棘刺","酒神","斥罪","仇白","安洁莉娜","星熊","死芒","娜斯提","遥","Mon3tr","忍冬","乌尔比安","涤火杰西卡","黑键"};
    public static String five[] = {"雪猎","德克萨斯","哈蒂娅","羽毛笔","埃拉托","玫拉","灰喉","星极","天火","晓歌","吉星","蒂比","桑葚","赤冬","炎狱炎熔","奥斯塔"};
    public static String four[] = {"协律","云迹","红豆","蛇屠箱","桃金娘","露托","角峰","末药","霜叶","讯使","夜烟","宴","波登可","芳汀","松果","维荻","休谟斯","石英","褐果"};
    public static String three[] = {"空爆","克洛丝","玫兰莎","芬","斑点","香草","月见夜","安塞尔","卡提","安德切尔","史都华德","梓兰","米格鲁","炎熔"};

    public void chouqu() {
        int New = 0;
        int jiu = 0;
        int cha = 0;
        int e = 0;  //6星抽取次数
        int f = 0;  //5星抽取次数
        int baodi6 = 0;
        int baodi5 = 0;
        int baodi4 = 0;
        int m = 0;   //调整概率变量
        double x = 2;  //6星初始概率
        double y = 10;  //5星初始概率
        double z = 60;   //4星初始概率

        System.out.println("您的余额为：源石："+this.yuanshi+"  合成玉："+this.hechengyu+"  (600合成玉1抽)");
        System.out.println("请输入抽卡的次数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(this.hechengyu<600*n){
            if(yuanshi*200+hechengyu<600*n){
                System.out.println("您的合成玉和源石均不足，是否跳转到充值界面。\n1.是  2.否 （请选择1或2）");
                int a = sc.nextInt();
                if(a==1){
                    chongzhi();
                }
                if(a==2){
                    chouqu();
                }

            }
            else{
                System.out.println("您的合成玉不足,是否用源石转化成抽卡资源(3源石转换为1抽)\n1.是  2.否 （请选择1或2）");

                int b = sc.nextInt();
                if(b==1){
                    zhuanhuan(n);
                }
                if(b==2){
                    chouqu();
                }
            }
        }
        else{
            hechengyu-=600*n;
            for(int i = 0;i<n;i++) {

                if(i%10==0&&i!=0){
                    New = f;
                    cha = New -jiu;
                    jiu = New;
                    if(cha>2){
                        System.out.println("您在第"+i/10+"次十连出了"+cha+"金");
                    }
                }
                double a = Math.random()*100;
                if (i==299) {
                    System.out.println(xian[0]);
                    e++;
                    continue;
                }
                if(i==9&&baodi5==0) {
                    Five();
                    f++;
                    continue;
                }
                if(baodi4 >=10){
                    baodi4=0;
                    Four();
                    continue;
                }

                if(baodi6>50) {
                    m++;
                    x = 2+2*m;
                    y = x+4*(98-2*m)/49;
                    z = x+29*(98-2*m)/49;
                }
                else {
                    m = 0;
                    x = 2;
                    y = 10;
                    z = 60;
                }

                if (a < x) {
                    baodi6 = 0;
                    Six();
                    e++;
                    continue;
                }
                if (a < y) {
                    Five();
                    f++;
                    continue;
                }
                if (a < z) {
                    baodi4 = 0;
                    Four();
                    continue;
                }
                if (a < 100) {
                    Three();
                }
                baodi5++;
                baodi6++;
                baodi4++;
            }
            System.out.println("\n您本次一共抽取"+n+"抽\n抽到6星次数为："+e+"次\n抽到5星的次数为："+f+"次");
            System.out.println("1.重新抽取\n2.退出账号\n3，退出程序");
            int b = sc.nextInt();
            if(b==1){
                chouqu();
            }
            if(b==2){
                main(null);
            }
            if(b==3){
                System.exit(0);
            }
        }
    }

    public static void Six() {
        int up1 = (int)(Math.random()*up.length);
        int six1 = (int)(Math.random()*six.length);
        int p = (int)(Math.random()*100);
        if(p<35) {
            System.out.println(xian[0]+"************************");
        }
        else if(p<70) {
            System.out.println(up[up1]+"************************");
        }
        else if(p<100) {
            System.out.println(six[six1]+"************************");
        }

    }
    public static void Five() {
        int five1 = (int)(Math.random()*five.length);
        System.out.println(five[five1]+"/////////////");
    }
    public static void Four() {
        int four1 = (int)(Math.random()*four.length);
        System.out.println(four[four1]+"^^^^^");
    }
    public static void Three() {
        int three1 = (int)(Math.random()*three.length);
        System.out.println(three[three1]);
    }

    public void chongzhi(){
        System.out.println("请选择您充值的余额：\n1. 6元1源石   2. 30元6源石   3. 98元20源石\n4. 198元40源石   5. 328元66源石   6. 648元130源石");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a==0){
            System.out.println("恭喜0元购成功！账户已添加99999999源石！");
            this.yuanshi+=99999999;
            chouqu();
        }
        yuanshi+=Chong[a-1];
        System.out.println("恭喜您充值成功！源石数量加"+Chong[a-1]);

        if(a!=0&&a!=1&&a!=2&&a!=3&&a!=4&&a!=5&&a!=6){
            System.out.println("请输入正确的选项。");
            chongzhi();
        }
        chouqu();
    }
    public void zhuanhuan(int n){
        int a = 0;
        a = (n*600-hechengyu)/200;
        if((n*600-hechengyu)%200!=0){
            a++;
        }
        yuanshi-=a;
        hechengyu+=a*200;
        System.out.println("您已将"+a+"颗源石成功转换成"+a*200+"合成玉！");
        chouqu();
    }

    public static void denglu(Chouka User1,Chouka User2,Chouka User3){
        System.out.println("     登录\n账号：123456  234567 345678\n密码：1a       2b       3c");
        a:
        for(int j=0;j<100;j++){
            System.out.println("请输入账号密码:");
            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();
            String b = sc.nextLine();
            for (int i=0;i<zhanghao.length;i++){
                if(a.equals(zhanghao[i])){
                    if(b.equals(mima[i])){
                        if(i==0){
                            User1.chouqu();
                        }
                        if(i==1){
                            User2.chouqu();
                        }
                        if(i==2){
                            User3.chouqu();
                        }
                    }
                    else{
                        System.out.println("您输入的密码错误,请重新输入！");
                        continue;
                    }
                }
                else if(i==zhanghao.length-1){
                    System.out.println("该账号未注册，请重新输入！");
                    i=0;
                    continue a;
                }
                else{
                    continue;
                }
            }
        }
    }
    public static void tuichu(){
        System.out.println("退出成功！");
        System.exit(0);
    }
    Chouka(int yuanshi,int hechengyu,int zhanghao,String mima ){
        this.hechengyu = hechengyu;
        this.yuanshi = yuanshi;
    }
    public static void main(String[] args) {
        Chouka User1 = new Chouka(50,6000,123456,"1a");
        Chouka User2 = new Chouka(100,32500,234567,"2b");
        Chouka User3 = new Chouka(500,325000,345678,"3c");
        denglu(User1,User2,User3);
    }
}
