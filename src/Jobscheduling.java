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

    void bruteforce(int[]arr,int j){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        int sum_2 = sum/2;
        while(sum_2 < sum){//정확히 반으로 나누고 최적해가 그것이 아니라면 1증가시켜 다시 수행
            int num=1;
            while(num<=arr.length/2) {
                switch (num) {
                    case 1:
                        if(bf_1(arr,sum_2) != 0) {
                            System.out.println(bf_1(arr, sum_2));cd 
                            sum_2+=9999;
                            num += 9999;
                        }break;
                    case 2:
                        if(bf_2(arr,sum_2) != 0) {
                            System.out.println(bf_2(arr, sum_2));
                            sum_2+=9999;
                            num += 9999;
                        }break;
                    case 3:
                        if(bf_3(arr,sum_2) != 0) {
                            System.out.println(bf_3(arr, sum_2));
                            sum_2+=9999;
                            num += 9999;
                        }break;
                    case 4:
                        if(bf_4(arr,sum_2) != 0) {
                            System.out.println(bf_4(arr, sum_2));
                            sum_2+=9999;
                            num += 9999;
                        }break;
                    case 5:
                        if(bf_5(arr,sum_2) != 0) {
                            System.out.println(bf_5(arr, sum_2));
                            sum_2 += 9999;
                            num += 9999;
                        }break;
                    case 6:
                        if(bf_6(arr,sum_2) != 0) {
                            System.out.println(bf_6(arr, sum_2));
                            sum_2 += 9999;
                            num += 9999;
                        }break;
                    case 7:
                        if(bf_7(arr,sum_2) != 0) {
                            System.out.println(bf_7(arr, sum_2));
                            sum_2 += 9999;
                            num += 9999;
                        }break;
                    case 8:
                        if(bf_8(arr,sum_2) != 0) {
                            System.out.println(bf_8(arr, sum_2));
                            sum_2 += 9999;
                            num += 9999;
                        }break;
                }
                num++;
            }
            sum_2++;
        }

    }
    ////////////////////////////////////////////////////////////////
    int bf_1(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            if(arr[a] == sum2) {
                System.out.println(a+"번째작업"+arr[a]);
                OPT = arr[a];
            }
        }
        return OPT;
    }
    int bf_2(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            for(int b=a+1;b<arr.length;b++){
                if(arr[a]+arr[b] == sum2) {
                    System.out.println(a+"번째작업"+arr[a]+b+"번째작업"+arr[b]);
                    OPT = arr[a] + arr[b];
                    return OPT;
                }
            }
        }
        return OPT;
    }
    int bf_3(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            for(int b=a+1;b<arr.length;b++){
                for(int c=b+1;c<arr.length;c++) {
                    if (arr[a] + arr[b] + arr[c] == sum2) {
                        System.out.println(a+"번째작업"+arr[a]+b+"번째작업"+arr[b]+c+"번째작업" +arr[c]);
                        OPT = arr[a] + arr[b] + arr[c];
                    }
                }
            }
        }
        return OPT;
    }
    int bf_4(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            for(int b=a+1;b<arr.length;b++){
                for(int c=b+1;c<arr.length;c++) {
                    for(int d=c+1;d<arr.length;d++) {
                        if (arr[a] + arr[b]+arr[c]+arr[d] == sum2){
                            System.out.println(a+"번째작업"+arr[a]+b+"번째작업"+arr[b]+c+"번째작업" +arr[c]
                                    +d+"번째작업"+arr[d]);
                            OPT = arr[a] + arr[b] + arr[c]+arr[d];
                        }
                    }
                }
            }
        }
        return OPT;
    }
    int bf_5(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            for(int b=a+1;b<arr.length;b++){
                for(int c=b+1;c<arr.length;c++) {
                    for(int d=c+1;d<arr.length;d++) {
                        for(int e=d+1;e<arr.length;e++) {
                            if (arr[a] + arr[b]+arr[c]+arr[d]+arr[e] == sum2) {
                                System.out.println(a+"번째작업"+arr[a]+b+"번째작업"+arr[b]+c+"번째작업" +arr[c]
                                        +d+"번째작업"+arr[d]+e+"번째작업"+arr[e]);
                                OPT = arr[a] + arr[b] + arr[c] + arr[d] + arr[e];
                            }
                        }
                    }
                }
            }
        }
        return OPT;
    }
    int bf_6(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            for(int b=a+1;b<arr.length;b++){
                for(int c=b+1;c<arr.length;c++) {
                    for(int d=c+1;d<arr.length;d++) {
                        for(int e=d+1;e<arr.length;e++) {
                            for(int f=e+1;f<arr.length;f++) {
                                if (arr[a] + arr[b]+arr[c]+arr[d]+arr[e]+arr[f] == sum2) {
                                    System.out.println(a+"번째작업"+arr[a]+b+"번째작업"+arr[b]+c+"번째작업" +arr[c]
                                            +d+"번째작업"+arr[d]+e+"번째작업"+arr[e]+f+"번째작업"+arr[f]);
                                    OPT = arr[a] + arr[b] + arr[c] + arr[d] + arr[e] + arr[f];
                                }
                            }
                        }
                    }
                }
            }
        }
        return OPT;
    }
    int bf_7(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            for(int b=a+1;b<arr.length;b++){
                for(int c=b+1;c<arr.length;c++) {
                    for(int d=c+1;d<arr.length;d++) {
                        for(int e=d+1;e<arr.length;e++) {
                            for(int f=e+1;f<arr.length;f++) {
                                for(int g=f+1;g<arr.length;g++) {
                                    if (arr[a] + arr[b]+arr[c]+arr[d]+arr[e]+arr[f]+arr[g] == sum2) {
                                        System.out.println(a+"번째작업"+arr[a]+b+"번째작업"+arr[b]+c+"번째작업" +arr[c]
                                                +d+"번째작업"+arr[d]+e+"번째작업"+arr[e]+f+"번째작업"+arr[f]
                                                +g+"번째작업"+arr[g]);
                                        OPT = arr[a] + arr[b] + arr[c] + arr[d] + arr[e] + arr[f] + arr[g];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return OPT;
    }
    int bf_8(int[] arr,int sum2){
        int OPT=0;
        for(int a=0;a<arr.length;a++){
            for(int b=a+1;b<arr.length;b++){
                for(int c=b+1;c<arr.length;c++) {
                    for(int d=c+1;d<arr.length;d++) {
                        for(int e=d+1;e<arr.length;e++) {
                            for(int f=e+1;f<arr.length;f++) {
                                for(int g=f+1;g<arr.length;g++) {
                                    for(int h=g+1;h<arr.length;h++) {
                                        if (arr[a] + arr[b]+arr[c]+arr[d]+arr[e]+arr[f]+arr[g]+arr[h] == sum2) {
                                            System.out.println(a+"번째작업"+arr[a]+b+"번째작업"+arr[b]+c+"번째작업" +arr[c]
                                                    +d+"번째작업"+arr[d]+e+"번째작업"+arr[e]+f+"번째작업"+arr[f]
                                                    +g+"번째작업"+arr[g]+h+"번째작업"+arr[h]);
                                            OPT = arr[a] + arr[b] + arr[c] + arr[d] + arr[e] + arr[f] + arr[g] + arr[h];
                                            return OPT;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
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

        System.out.println("브루트포스");
        int[] test = new int[]{4,7,9,8};
//        jsc_16.bruteforce(test,4);
        int[] test_8 = new int[]{2,2,10,6,7,6,10,4};
        System.out.println(" 4b");
        jsc_4.bruteforce(test,4);
        System.out.println(" 8b");
        jsc_4.bruteforce(test_8,8);
        System.out.println(" 16b");
        jsc_4.bruteforce(jsc_16.job,16);

    }
}
