import java.util.Random;

public class Jobscheduling {
    int machine_number;//기계의 수
    int job_number;//작업의 수
    int []machine = new int[machine_number];
    int []job = new int[job_number];
    Jobscheduling(int m,int j){
        this.machine_number = m;
        this.job_number = j;
    }
    void init(){
        init_job();
        init_machine();
        print_job();
    }
    int[] init_job(){
        int[] job = new int[job_number];
        Random r = new Random();
        for(int i=0;i<job_number;i++){
            job[i] = r.nextInt(10)+1;
        }
        this.job = job;
        return job;
    }
    void print_job(){
        for(int i=0;i<job_number;i++){
            System.out.print("작업: "+this.job[i]+" ");
        }
        System.out.println();
    }
    int[] init_machine(){
        int[] machine = new int[machine_number];
        for(int i=0;i<machine_number;i++){
            machine[i] = 0;
        }
        this.machine = machine;
        return machine;
    }


    int Approx_Jobscheduling(){
        for(int j=0;j<job_number;j++){
            int min = 0;
            for(int l=0;l<machine_number;l++){
                if(machine[l] < machine[min]){
                    min = l;
                }
            }
            machine[min] += job[j];
        }
        int max=0;
        for(int l=0;l<machine_number;l++){
            if(machine[l] > machine[max]){
                max = l;
            }
        }
        System.out.println("머신1: "+machine[0]+" , "+"머신2: "+machine[1]);
        return machine[max];
    }
//    int Bruteforce_Jobscheduling(){
//        for()
//    }
    void bruteforce(int[]arr,int j){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        sum = sum/2;
        int num=1;
        while(num<arr.length) {
            switch (num) {
                case 1:
                    System.out.println(bf_1(arr, sum));
                    break;
                case 2:
                    bf_2(arr,sum);
                    break;
            }
            num++;
        }

    }
    ////////////////////////////////////////////////////////////////
    int bf_1(int[] arr,int sum2){
        int OPT=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == sum2)
                OPT = arr[i];
        }
        return OPT;
    }
    int bf_2(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            for(int b=a+1;b<arr.length;b++){
                if(arr[a]+arr[b] == sum2)
                    OPT = arr[a]+arr[b];
            }
        }
        return OPT;
    }
    int bf_3(int[] arr,int sum2){
        int OPT=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == sum2)
                OPT = arr[i];
        }
        return OPT;
    }
    int bf_4(int[] arr,int sum2){
        int OPT=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == sum2)
                OPT = arr[i];
        }
        return OPT;
    }
    int bf_5(int[] arr,int sum2){
        int OPT=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == sum2)
                OPT = arr[i];
        }
        return OPT;
    }
    int bf_6(int[] arr,int sum2){
        int OPT=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == sum2)
                OPT = arr[i];
        }
        return OPT;
    }




    public static void main(String[] args) {
        Jobscheduling jsc_4 = new Jobscheduling(2,4);
        jsc_4.init();
        System.out.println(jsc_4.Approx_Jobscheduling());
        jsc_4.init_machine();


        Jobscheduling jsc_8 = new Jobscheduling(2,8);
        jsc_8.init();
        System.out.println(jsc_8.Approx_Jobscheduling());

        Jobscheduling jsc_16 = new Jobscheduling(2,16);
        jsc_16.init();
        System.out.println(jsc_16.Approx_Jobscheduling());

    }
}
