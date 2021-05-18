import java.util.Random;

public class Jobscheduling {
    int machine_number;//기계의 수
    int job_number;//작업의 수
    int []machine = new int[machine_number];
    int []job = new int[job_number];

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
            System.out.print(this.job[i]+" ");
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
        System.out.println(machine[0]+" , "+machine[1]);
        return machine[max];
    }




    public static void main(String[] args) {
        Jobscheduling jsc = new Jobscheduling();
        jsc.job_number=4;
        jsc.machine_number=2;
        jsc.init_job();
        jsc.init_machine();
        jsc.print_job();
        System.out.println(jsc.Approx_Jobscheduling());

    }
}
