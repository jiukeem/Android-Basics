package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

// 어노테이션이 없어도 문제는 없지만, 둘 다 인티저 값을 받기 때문에 실수로 잘못 들어가는 일이 없도록 설정함
// 어노테이션은 additional info 를 추가해준다 (parameter 뿐만 아니라 class, function 등등)
// 저 어노테이션은 내가 임의로 만들어낸게 아니라 android.annotation 에 저장되어 있는 값인데, annotation 에 커서를 갖다대면 볼 수 있다.
// StringRes 인 경우, Denotes that an integer parameter, field or method return value is expected to be a drawable resource reference (e.g. android.R.attr.alertDialogIcon).
// 즉, 인티저 중에서도 직접 살펴보고 드로어블 리소스를 가리키는지 확인하고 받는다는 얘기.
// 이러면 나중에 파라미터를 잘못 입력할 일도 없고, 에러를 미연에 방지할 수 있다.