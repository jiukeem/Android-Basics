# Android-Basics
구글 디벨로퍼에 있는 코틀린 코스 작업물들 기록

모든 자료와 이미지 출처: https://developer.android.com/courses/android-basics-kotlin/course

----
## Unit2 Part3 Affirmation App
- RecyclerView 활용해보기
- Adapter, ViewHolder, Item List 등 RecyclerView Structure 익히기
- 용도에 따라 파일나눠 관리하는 연습하기(dataset 준비/ data class 정의/ MainActivity 등)
![image](https://user-images.githubusercontent.com/68096732/109395416-96025c80-796f-11eb-8e6d-e575b5c4fd47.png)
- color theme 을 쉽게 적용해볼 수 있는 곳 : https://material.io/resources/color/#!/?view.left=0&view.right=0

* RecyclerView 구현 중 Adapter에서 아직 이해하지 못한 부분: onCreateViewHolder()
<img src = "https://user-images.githubusercontent.com/68096732/109755972-54e9a100-7c2a-11eb-9865-0800c94fb448.png" width="800px">


----
## Unit3 Part1 Words App
- 새로 사용하는 개념: lambdas, higher order functions
- navigation between multi activities, explicit/ implicit intent 활용해보기
- menu option 다뤄보기
<img src = "https://user-images.githubusercontent.com/68096732/109458524-538c6d00-7aa0-11eb-8894-d4d7f2005539.png" width="400px">

----
## Unit3 Part1 - 2 Dessert Clicker App
- Activity LifeCycle 이해하기
- Preserving activity state( onSaveInstanceState(), onRestoreInstanceState() )
- Configuration changes 
  - happens when the state of the device changes so radically that the easiest way for the system to resolve the change is to destroy and rebuild the activity

<img src = "https://user-images.githubusercontent.com/68096732/109491643-2dc98d00-7acd-11eb-8171-f7e6e825f4c6.png" width="400px">

----
## Unit3 Part2 Words App (3-1에서 멀티액티비티로 구현했던 걸 프레그먼트로 구현해보기)
- Fragment 활용해보기
- navigation graph 활용해보기
- lifecycle 과 callback methods 들은 액티비티와 유사하나, onCreate() 에서의 작업에 유의해야 한다. 액티비티에서는 onCreate() 에서 inflating layout 과 view binding 을 진행하지만, 프레그먼트에서의 onCreate()는 아직 view가 생성되지 않은 상태이므로 진행할 수 없다. inflating layout은 onCreateView()에서, view binding 은 onViewCreated()에서 해줘야한다.
- 위와 연결되는 사항으로, view binding 시 nullable 하며, 초기값은 null 이다. onCreateView() 에서 값을 할당해줄거다. (세번째 이미지 참고)
- Jetpack Navigation Components 그래들 설정 페이지: https://developer.android.com/codelabs/basic-android-kotlin-training-fragments-navigation-component?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-fragments-navigation-component#6
<img src = "https://user-images.githubusercontent.com/68096732/109741978-886c0180-7c11-11eb-877a-591870aec674.png" width="400px">
<img src = "https://user-images.githubusercontent.com/68096732/109912798-20401d00-7cf0-11eb-9441-ba291ca22ce4.png" width="800px">
<img src = "https://user-images.githubusercontent.com/68096732/109785486-86289800-7c4f-11eb-83b0-dd63b4defaf1.png" width="800px">

----
그 밖에 기록해놓을만한 부분들

1. findViewById 와 view binding (Unit2 Part1의 5번째 활동)
<img src = "https://user-images.githubusercontent.com/68096732/109755719-dc82e000-7c29-11eb-8ea9-5ffc351071d1.png" width="550px">
