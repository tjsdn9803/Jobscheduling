# Jobscheduling
brute force &amp; greedy algorithm

# 목차

1. bruteforce 를 이용한 Jobscheduling
   * bruteforce란
   * 이번 주제에서의 bruteforce 적용방법
2. greedy 알고리즘을 이용한 Jobscheduling
   * greedy 알고리즘이란
   * 이번 주제에서의 greedy알고리즘 적용방법
3. 코드
   * 코드설명
   * 실행결과
4. 시간복잡도
5. 근사비율
6. 결론

## 1. bruteforce 를 이용한 Jobscheduling

	### bruteforce란

bruteforce란 직역하면 난폭한 힘, 폭력이지만 알고리즘에선 조합가능한 모든 경우의 수를 모두 대입해보는 방식을 뜻한다.    

모든 경우의 수를 모두 대입해서 문제를 해결하기 때문에 시간과 자원이 엄청나게 필요하다. 하지만 브루트포스의 **가장 큰 장점은 항상 정확도가 100%**라는 것이다.    

예를 들어 3자리 숫자로 이루어진 비밀번호를 알아낼때 비밀번호는 000~999중 하나이므로 000부터 999까지 하나씩 대입해 나가며 해결한다. 

### 이번 주제에서의 bruteforce 적용방법

Jobscheduling에서 bruteforce 를 이용하여 문제를 해결 할땐 각 작업의 시간을 더할 때 나올 수 있는 모든 시간의 경우의 수를 구하여 가장 최적의 해를 구한다.   

ex)기계가 2대이고 작업의 시간이 {9,2,3,7}로 주어졌을 때 최적해는 (작업의 시간 총합) / (기계의 수) 보다 항상 크거나 같으므로 먼저 최적해를 11(최적해는 두 기계중 더 긴시간에 해당하므로 나누었을때 가장 큰수로 한다.)이라 가정하고 1개씩 조합 {9},{2},{3},{7} 없다면 2개씩 조합 {9,2},{9,3} ..... {2,7},{3,7} 없다면 3개씩조합 ...  없다면 4개씩 조합 더이상 조합할 수 없다면 최적해가 (작업의 시간 총합) / (기계의 수)보다 크다는 의미이므로 1증가시켜 같은 과정을 반복한다.     

결과는 첫번쨰 사이클의 {9,2}이 되고 최적해는 9+2=11가 된다.

## 2. greedy 알고리즘을 이용한 Jobscheduling

### greedy알고리즘이란 

greedy알고리즘이란 현재 상태에서 최적의 경우를 선택해나가는 알고리즘이다.

그리디 알고리즘을 가장 잘 설명하는 것은 마시멜로 이야기인데 그리디 알고리즘을 이요한다면 현재순간에서 가장 최적인 답은 마시멜로 1개를 받는것이다. 하지만 이경우에는 기다렸다가 마시멜로 2개를 받는 최적해를 보장받지 못한다.     

### 이번 주제에서의 greedy알고리즘 적용방법

Jobscheduling에서 greedy알고리즘은 이용하는 방법은 현재상태에서 작업시간이 가장 적은 기계 다음 작업을 할당시키는 방식이다.     

ex)기계가 2대이고 작업의 시간이 {9,2,3,7}로 주어졌을 때 첫번쨰 기계에 1번째 작업인 9할당하고, 2번째 작업은 첫번째 기계는 작업시간이 9이고 두번째 기계는 0이므로 현재 가장 작업시간이 적은 2번째 기계에 할당된다.3번째 작업은 두번째기계에 할당될것이고 4번째 작업도 두번째 기게에 할당될것이다.

결과는 첫번째기계:{9} 두번째기계:{2,3,7}로 해는 2+3+7=12가 될것이다. 

위 bruteforce와 비교하면 작업시간과 기계의 수 모두 같지만 최적해인 11보다 greedy알고리즘을 사용했을 때 더 큰 값이 나온것을 볼 수 있다. 이는 **greedy 알고리즘이 최적해를 보장해주지 못한다**는 것을 보여준다.

## 3. 코드

### 코드설명

* 작업시간 설정

  ```java
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
  ```

  기계의 수와 작업의 수를 입력 받아 작업시간을 1~10의 랜덤한 값으로 설정한다.

* 그리디 알고리즘

  ```java
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
  ```

  각 작업마다 기계를 돌며 가장 작업시간이 적은 기계를 갱신하고 가장 작업시간이 적은 기계에 작업시간을 더해준다. 그리고 최종적으로 기계들 중 가장 작업시간이 긴 기계의 시간을 반환한다. 

* 브루트 포스

  ```java
  int bruteforce(int[]arr,int j){
          int sum=0;
          int sum_2=0;
          for(int i=0;i<arr.length;i++){
              sum += arr[i];
          }
          if(sum%2 == 0) {
              sum_2 = sum / 2;
          }else{
              sum_2 = (sum/2)+1;
          }
          int OPT=0;
          int bruteforce_OPT=0;
          while(sum_2 < sum){//정확히 반으로 나누고 최적해가 그것이 아니라면 1증가시켜 다시 수행
              int num=1;
              while(num<=arr.length) {
                  switch (num) {
                      case 1:
                          OPT = bf_1(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2+=9999;
                              num += 9999;
                          }break;
                      case 2:
                          OPT = bf_2(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2+=9999;
                              num += 9999;
                          }break;
                     ~~~~~~~~~~~~~~~생략~~~~~~~~~~~~~~~~~~전체코드에서 확인가능
                      case 8:
                          OPT = bf_8(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2 += 9999;
                              num += 9999;
                          }break;
                  }
                  num++;
              }
              sum_2++;
          }
          return bruteforce_OPT;
      }
  ```

  ```java
  int bf_1(int[] arr,int sum2){
          int OPT=0;
          for(int a=0;a<arr.length;a++){
              if(arr[a] == sum2) {
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
                      OPT = arr[a] + arr[b];
                      return OPT;
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
  ```

  

  작업시간의 총합을 구한 후 홀수라면 /2 +1 짝수라면 /2 하여  최적의 해를 가정한다. 그 후 1개작업의 조합으로 확인하여 최적해에 해당하는 조합이 있다면 반환 없다면 2개작업의 조합 확인,없다면 3개 작업의 조합 확인 이 과정을 작업의 수만큼 반복하고 없다면 최적해가 평균보다 크다는 의미이므로 sum_2를 증가시켜 같은 과정을 반복한다. 만약 작업의 조합의 합과 sum_2가 같다면 그 수를 저장하고 강제로 반복문을 탈출하여 값을 얻는다. (아 과정이 없으면 과정이 계속 반복되어 같은 수 가 계속 출력 될 수 있다.)

  ```java
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
  
      int bruteforce(int[]arr,int j){
          int sum=0;
          int sum_2=0;
          for(int i=0;i<arr.length;i++){
              sum += arr[i];
          }
          if(sum%2 == 0) {
              sum_2 = sum / 2;
          }else{
              sum_2 = (sum/2)+1;
          }
          int OPT=0;
          int bruteforce_OPT=0;
          while(sum_2 < sum){//정확히 반으로 나누고 최적해가 그것이 아니라면 1증가시켜 다시 수행
              int num=1;
              while(num<=arr.length) {
                  switch (num) {
                      case 1:
                          OPT = bf_1(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2+=9999;
                              num += 9999;
                          }break;
                      case 2:
                          OPT = bf_2(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2+=9999;
                              num += 9999;
                          }break;
                      case 3:
                          OPT = bf_3(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2+=9999;
                              num += 9999;
                          }break;
                      case 4:
                          OPT = bf_4(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2+=9999;
                              num += 9999;
                          }break;
                      case 5:
                          OPT = bf_5(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2 += 9999;
                              num += 9999;
                          }break;
                      case 6:
                          OPT = bf_6(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2 += 9999;
                              num += 9999;
                          }break;
                      case 7:
                          OPT = bf_7(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2 += 9999;
                              num += 9999;
                          }break;
                      case 8:
                          OPT = bf_8(arr,sum_2);
                          if(OPT != 0) {
                              bruteforce_OPT = OPT;
                              System.out.println(OPT);
                              sum_2 += 9999;
                              num += 9999;
                          }break;
                  }
                  num++;
              }
              sum_2++;
          }
          return bruteforce_OPT;
      }
      int bf_1(int[] arr,int sum2){
          int OPT=0;
          for(int a=0;a<arr.length;a++){
              if(arr[a] == sum2) {
  //                System.out.println(a+"번째작업"+arr[a]);
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
  //                    System.out.println(a+"번째작업"+arr[a]+" "+b+" 번째작업"+arr[b]);
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
  //                        System.out.println(a+"번째작업"+arr[a]+" "+b+"번째작업"+arr[b]+" "+c+"번째작업" +arr[c]);
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
  //                            System.out.println(a+"번째작업"+arr[a]+" "+b+"번째작업"+arr[b]+" "+c+"번째작업" +arr[c]
  //                                    +" "+d+"번째작업"+arr[d]);
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
  //                                System.out.println(a+"번째작업"+arr[a]+" "+b+"번째작업"+arr[b]+" "+c+"번째작업" +arr[c]
  //                                        +" "+d+"번째작업"+arr[d]+" "+e+"번째작업"+arr[e]);
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
  //                                    System.out.println(a+"번째작업"+arr[a]+" "+b+"번째작업"+arr[b]+" "+c+"번째작업" +arr[c]
  //                                            +" "+d+"번째작업"+arr[d]+" "+e+"번째작업"+arr[e]+" "+f+"번째작업"+arr[f]);
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
  //                                        System.out.println(a+"번째작업"+arr[a]+" "+b+"번째작업"+arr[b]+" "+c+"번째작업" +arr[c]
  //                                                +" "+d+"번째작업"+arr[d]+" "+e+"번째작업"+arr[e]+" "+f+"번째작업"+arr[f]
  //                                                +" "+g+"번째작업"+arr[g]);
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
  //                                            System.out.println(a+"번째작업"+arr[a]+" "+b+"번째작업"+arr[b]+" "+c+"번째작업" +arr[c]
  //                                                    +" "+d+"번째작업"+arr[d]+" "+e+"번째작업"+arr[e]+" "+f+"번째작업"+arr[f]
  //                                                    +" "+g+"번째작업"+arr[g]+" "+h+"번째작업"+arr[h]);
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
          int greedy_OPT;
          int Bruteforce_OPT;
          double ratio;
          int[] test = new int[]{4,10,3,5};
          Jobscheduling jsc_4 = new Jobscheduling(2,4);
          jsc_4.init();
          greedy_OPT = jsc_4.Approx_Jobscheduling();
          Bruteforce_OPT = jsc_4.bruteforce(jsc_4.job,4);
          ratio = (double)Bruteforce_OPT/greedy_OPT;
          System.out.println("그리디: "+greedy_OPT);
          System.out.println("브루트포스: "+Bruteforce_OPT);
          System.out.println("근사비: "+ratio);
  
          Jobscheduling jsc_8 = new Jobscheduling(2,8);
          jsc_8.init();
          greedy_OPT = jsc_8.Approx_Jobscheduling();
          Bruteforce_OPT = jsc_8.bruteforce(jsc_8.job,8);
          ratio = (double)Bruteforce_OPT/greedy_OPT;
          System.out.println("그리디: "+greedy_OPT);
          System.out.println("브루트포스: "+Bruteforce_OPT);
          System.out.println("근사비: "+ratio);
  
          Jobscheduling jsc_16 = new Jobscheduling(2,16);
          jsc_16.init();
          greedy_OPT = jsc_16.Approx_Jobscheduling();
          Bruteforce_OPT = jsc_16.bruteforce(jsc_16.job,16);
          ratio = (double)Bruteforce_OPT/greedy_OPT;
          System.out.println("그리디: "+greedy_OPT);
          System.out.println("브루트포스: "+Bruteforce_OPT);
          System.out.println("근사비: "+ratio);
      }
  }
  
  ```

  

  ### 실행결과

  ```
  작업: 10 작업: 3 작업: 9 작업: 5 
  머신1: 15 , 머신2: 12
  그리디: 15
  브루트포스: 14
  근사비: 0.9333333333333333
  작업: 8 작업: 8 작업: 2 작업: 1 작업: 3 작업: 10 작업: 3 작업: 2 
  머신1: 20 , 머신2: 17
  그리디: 20
  브루트포스: 19
  근사비: 0.95
  작업: 6 작업: 3 작업: 9 작업: 8 작업: 6 작업: 8 작업: 10 작업: 3 작업: 9 작업: 1 작업: 9 작업: 1 작업: 6 작업: 5 작업: 1 작업: 3 
  머신1: 45 , 머신2: 43
  그리디: 45
  브루트포스: 44
  근사비: 0.9777777777777777
  ```

## 4.시간복잡도

greedy 알고리즘의 시간복잡도는 기계의 수를 m 작업의 수를 j라 할때 코드의

```java
for(int j=0;j<job_number;j++){
            int min = 0;
            for(int l=0;l<machine_number;l++){
                if(machine[l] < machine[min]){
                    min = l;
                }
            }
            machine[min] += job[j];
        }
```

작업하나당 모든 기계를 돌며  작업을 할당하는 방식으로 2중for문이고 하나의 반복횟수는 m, 다른하나의 반복횟수는 j이므로 시간복잡도는 O(mj)이 된다.

반면 bruteforce의 시간복잡도는 상황에 따라 천차만별인데 최선의 경우의 시간복잡도는 작업1개의 조합으로 (작업의 시간총합)/(기계의 수)이 완성되는 경우로 ex){10,3,5,2} O(j)가 된다. 하지만 최악의 경우의 시간복잡도는 작업의 갯수 -1 만큼 조합해도 최적해로 가정한 수가 안나와서 최적해까지 증가시키며 구하는 경우로 ex){4,10,3,5} 시간복잡도는 O{j^(j-1)}가 된다.

bruteforce의 처리시간이 greedy알고리즘의 실행시간보다 짧을 순 있지만 매우 드문경우이고 대부분의 경우에는 bruteforce의 처리시간이 greedy알고리즘의 실행시간비해 매우 길다.

## 5. 근사비율

T는 greedy알고리즘을 이용한 문제해결중 마지막 작업시간t_last을 제외한 해 즉 최종적인 해는 T+t_last

T`은 t_last를 제외한 모든 작업의 합을 기계의 수 m으로 나눈 값 이라 가정하면 

T <= T`이다 왜냐하면 최적해 보다 적은 실행시간은 존재하지 않기 떄문이다.

OPT는 최적해 OPT`은 그리디 알고리즘의 해라 가정하고 아래 식을 보면 

![image-20210520214204352](C:\Users\samsung\AppData\Roaming\Typora\typora-user-images\image-20210520214204352.png)
![사진](https://github.com/tjsdn9803/Jobscheduling/blob/main/%EC%BA%A1%EC%B2%98.PNG)

1번 문단에서는 T<=T`인 성질을 이용하였고

2번 문단에서는 최적해는 항상 작업시간의 총합을 기계의 수 로 나눈것보다 크거나같은 성질 그리고 하나의 작업시간은 항상 최적해보다 작거나 같은 성질을 이용하여 변환하였다.    

최종적으로 m기계의 수가 무한으로 늘어난다면 2OPT만이 남게된다.

## 6. 결론

greedy알고리즘은 항상 **최적해를 보장하지 못하지만** 실행시간이 짧고

bruteforce는 항상 **최적해를 보장**하지만 대부분의 상황에서는 greedy알고리즘보다 실행시간이 매우 길다.

그리고 greedy알고리즘의 해는 항상 bruteforce의 최적해의 2배보다 작거나 같다.(bruteforce를 이용한 최적해는 항상 greedy알고리즘 해의 절반보다 크거나 같다.)

따라서 **실행시간이 짧은 greedy알고리즘을 먼저 실행하여 최적해의 범위를 확인하는것이 가능하다.**



