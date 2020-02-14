# Kotlin in Action Study
> 'Kotlin in Action' 스터디를 위한 Repo

# 코틀린 시작하기
> 코틀린은 자바 플랫폼에서 돌아가는 새로운 프로그래밍 언어이다. 자바 코드와의 상호운용성이 가능하며 간결하고 실용적이다. 안드로이드 앱 뿐만 아니라 서버 개발에서도 사용 할 수 있다.

## 코틀린 코드 맛보기
이번 예제에서는 <code>Person</code> 클래스를 정의하고, 여러 <code>Person</code>을 모아둔 컬렉션을 만들어서 가장 나이가 많은 사람을 찾아 결과를 출력해보는 코드를 작성해본다.

```kotlin
// Person 데이터 클래스
data class Person(val name: String, val age: Int ?= null)

fun main(args: Array<String>) {
    // Person 컬렉션 생성
    val persons = listOf(
        Person("jayden", 29),
        Person("ella", 28)
    )

    // 람다, 엘비스 연산자를 통해 가장 나이가 많은 Person 필터
    val oldest = persons.maxBy { it.age?: 0 }

    // 문자열 템플릿으로 결과 출력
    println("나이가 가장 많은 사람: $oldest")
}
```

결과 출력 화면

```
나이가 가장 많은 사람: Person(name=jayden, age=29)
```

위 코드를 하나씩 살펴보면서 코틀린 특징에 대해 간단하게 알아보자.

코틀린에서는 값을 담는 클래스를 생성할 때, <code>data</code> 키워드를 붙여서 생성한다. Person 데이터 클래스는 name, age 프로퍼티를 갖고 있다. age 경우에는 <code>?</code> 키워드를 사용해서 널이 될 수 있는 타입을 명시하고 있다. 그리고 프로퍼티의 디폴트 값으로 null을 지정하고 있다.

특정 값을 기준으로 가장 나이가 많은 사람을 추출하기 위해서 <code>maxBy</code> 함수를 사용하고 있다. maxBy 함수에 전달한 람다 식은 파라미터 하나를 받고 있고, <code>it</code> 이라는 이름을 사용하여 age 프로퍼티에 접근한다. 이 때, age 프로퍼티가 null 값일수도 있으므로 <code>?:</code> 엘비스 연산자를 사용해서 null인 경우 0을 반환한다.

## 코틀린 주요 특성

### 코틀린 대상 플랫폼
코틀린은 자바가 사용되고 있는 모든 용도에 적합하므로 같이 사용하거나 자바 코드를 대체할 수 있다. 자바 코드는 이미 네이버, 카카오, 11번가 등과 같이 대기업에서도 사용하는 안정적인 언어이지만, 그럼에도 불구하고 코틀린을 사용해야 하는 이유는 자바 코드보다 간결하고 생산적이며 안전한 언어이기 때문이다.

코틀린을 일반적으로 활용할 수 있는 영역은 다음과 같다.
- 서버 코드 (웹 애플리케이션 백엔드 코드)
- 안드로이드 앱 코드

이외에도 iOS, 데스크탑 애플리케이션, 노드, 브라우저에서도 실행할 수 있다.

### 정적 타입 지정 언어
자바와 마찬가지로 코틀린도 정적 타입 지정 언어이다. 정적 타입 지정이란 프로그램 구성 요소의 타입을 컴파일 시점에 알 수 있기 때문에 컴파일러가 타입을 검증해주는 안정성을 보장 받을 수 있다.

동적 타입 지정 언어에서는 타입과 관계없이 모든 값을 변수에 넣을 수 있고, 검증을 컴파일 시점이 아닌 실행 시점에 이루어진다. 동적 타입 지정이기 때문에 유연하게 사용할 수 있는 장점이 있을 수 있다. 다만, 컴파일 시점이 아닌 실행 시점에 오류를 발견한다는 점은 실제 운영되는 애플리케이션을 만들 때 안정성이 떨어질 수 있는 문제점이 있다.

코틀린 변수 지정한 코드를 보면 다음과 같다.

```kotlin
// 코틀린은 변수 x가 Int 타입이라는 것을 문맥을 통해 유추한다
var x = 1
``` 

정적 타입 지정 언어라고 했는데 마치 자바스크립트와 유사해보이기 때문에 동적 타입 지정 언어라고 오해할 수 있다. 코틀리엔서는 모든 변수 타입을 프로그래머가 직접 명시하지 않더라도 컴파일러가 문맥으로부터 변수 타입을 자동으로 유추하기 때문에 타입 선언을 생략해도 된다. 자바 10에서도 코틀린처럼 타입을 명시적으로 선언하지 않아도 컴파일러가 유추한다.

컴파일러가 문맥을 파악해서 변수 타입을 결정하는 것을 <code>타입 추론</code>이라고 한다.

## 코틀린 철학
코틀린은 자바와 비교해서 실용적이고 간결하며 안전한 언어를 장점을 내세운다 실용성, 간결성, 안정성, 상호운용성 각각의 장점에 대해 자세히 살펴보자.

### 실용성
코틀린은 실제 문제를 해결하기 위해 만들어진 실용적인 언어이다. 다른 최신 언어 설계나 연구중인 아이디어를 코틀린을 통해 탐구하려 하지 않고, 다른 프로그래밍 언어가 채택한 이미 입증된 해법과 기능에 의존한다. 이로인해 언어의 복잡도가 줄고 흔히 알고 있는 개념을 통해 쉽게 코틀린 언어를 배울 수 있다.

자바를 기존에 사용했다면 자바 언어 스타일이나 기법을 활용할 수 있고, 나중에는 코틀린만의 강력한 특징을 배워서 이를 코드에 녹여내서 더 간결한 코드를 작성할 수 있다.

실용성에 있어서 다른 측면으로 편리한 개발 도구 및 환경이 생산성 향상에 필수 요소이다. 자바 개발자라면 많이 사용하고 있는 인텔리J의 경우에 코틀린 코드를 작성하면 IDE 차원에서 작성된 코드를 감지하고 더 좋은 패턴을 추천한다. 이는 자바 개발할 때 경험할 수 있는 부분이다. 예를 들어, 절차형으로 작성한 부분을 람다식으로 변경하라고 코드에서 추천해주고 기존 코드를 변경해준다.

### 간결성
개발자는 새로운 코드를 작성하는 시간만큼 기존에 작성된 코드를 파악하고 유지보수 하는 업무를 하게 된다. 코틀린으로 작성하게 되면 장황한 코드를 줄이고 간결하게 작성할 수 있으므로 코드를 파악하기가 더 수월하다. 파악하기 쉽다는 것은 단순히 코드 라인 수가 적은것 뿐만 아니라 코드 자체에서 쉽게 의도를 파악할 수 있는 구문 구조를 제공하는지 또는 실제 의미를 이해하기 위해서 방해가 되는 부가적인 코드가 적은지이다.

자바에서 게터, 세터, 생성자 파라미터를 쉽게 만들기 위해서 롬복 라이브러리를 사용했었다. 코틀린에서는 이러한 로직을 묵시적으로 제공하기 때문에 준비 코드로 인해 지저분해지는 일은 없다. 이러한 기능은 C#에서도 제공하는 기능이다.

### 안정성
프로그래밍에서 안전하는 말은 프로그램에서 발생하는 일부 유형의 오류를 프로그램 설계가 원천적으로 방지해준다는 뜻이다. 물론 절대적이지 않다. 컴파일러에게 프로그램이 어떻게 동작하는지에 대한 자세한 코드를 작성하고 제공함으로써 작동 의도에 대한 일치를 검증할 수 있다. 하지만 더 많은 정보를 붙임으로써 생산성이 하락하는 것을 감수해야 한다.

코틀린은 오랜시간동안 검증 받은 JVM 위에서 동작하기 때문에 안정성을 달성하되 자바보다 더 작은 비용을 지불하며 견고한 프로그램을 만들기 위해 설계되었다. 특히 코틀린은 NullPointerException(NPE) 에러를 방지하기 위해서 노력한다.

코틀린의 타입 시스템은 null이 될 수 있는 값과 될 수 없는 값을 정의하며 컴파일 시점에 체크해준다. 특정 타입이 null 값이 될 수 있는 여부를 표시하기 위해서 <code>?</code> 글자를 추가한다.

```kotlin
val s: String? = null // null 허용함
val s: String = "" // null 허용하지 않음
```

그리고 어떤 객체를 다른 타입으로 캐스팅 하기 전에 타입을 미리 검사하지 않으면 ClassCastException이 발생할 수 있다. 코틀린에서는 타입 검사와 캐스팅이 한 연산자에 의해 이루어지기 때문에 더 안전한다.

```kotlin
if (value is String) // 타입 검사
    println(value.toUpperCase())
```

### 상호운용성
코틀린에서 기존 자바에서 사용하던 라이브러리, 클래스, 상속, 인터페이스, 구현, 애노테이션 등을 그대로 사용할 수 있다. 다른 JVM 언어와 달리 코틀린은 자바 코드를 아무런 노력 없이 호출할 수 있고, 반대로 자바에서도 코틀린 코드를 호출할 수 있다. 이에 따라 자바와 코틀린 코드를 하나의 프로젝트에서 섞어 쓸 수 있다.

이러한 장점 때문에 기존 프로젝트에 작성된 자바 코드를 그대로 가져가며 일정 부분을 코틀린으로 변경할 수 있다. 그리고 인텔리J와 같은 도구를 사용하면 도구 자체에서 자바 코드를 코틀린 코드로 컨버팅하는 기능을 제공해준다. 이 기능은 완벽하게 대체해주지는 않지만 프로그래머가 해야 하는 일정 부분의 수고스러움을 덜어 준다는 점에 있어서 편하다.

## 코틀린 도구 사용
자바와 마찬가지로 코틀린도 컴파일 언어이다. 자바는 <code>.java</code> 파일을 컴파일해서 <code>.class</code> 파일을 생성한다. 그리고 <code>.class</code> 파일을 JVM 위에서 실행한다. 코틀린에서는 컴파일 과정이 어떻게 이뤄지는지와 그 과정에서 어떤 도구가 쓰여지는지 알아보자.

### 코틀린 코드 컴파일
코틀린 소스코드를 저장할 때는 <code>.ks</code> 확장자를 파일에 붙인다. 코틀린 컴파일러는 소스코드를 분석해서 <code>.class</code> 파일을 생성한다. 생성된 <code>.class</code> 파일은 개발 중인 애플리케이션에 맞는 표준 패키징 과정을 거쳐 실행될 수 있다.

간단한 컴파일 방식은 커맨드라인에서 <code>kotlinc</code> 명령을 통해 할 수 있다. 컴파일하고 나서 <code>java</code> 명령으로 그 코드를 실행한다. 코틀린 컴파일러로 컴파일한 코드는 코틀린 런타임 라이브러리에 의존한다. 이 라이브러리에는 코틀린 자체 표준 라이브러리 클래스와 자바 API의 기능을 확장한 내용이 있다. 코틀린 컴파일한 애플리케이션을 배포할 때는 런타임 라이브러리도 함께 배포해야 한다.

자바에서 사용한 빌드 도구로는 메이븐과 그레이들, 앤트 등이 있다. 이러한 빌드 도구는 애플리케이션을 패키징 할 때, 알아서 코틀린 라이브러리를 포함시켜준다.

## 코틀린 플레이그라운드
프로그램 설치 없이 코틀린 언어를 배우기 위한 가장 쉬운 방법은 코틀린에서 제공하는 [코틀린 플레이그라운드](https://play.kotlinlang.org/)를 이용하면 된다. 웹 브라우저에서 코틀린 코드를 작성, 컴파일, 실행을 편하게 할 수 있다.

![kotlin-playground](https://user-images.githubusercontent.com/43853352/74547025-cce91880-4f8e-11ea-9ac3-5d435cc83a65.png)

## 요약
- 코틀린은 타입 추론을 지원하는 정적 타입 지정 언어이다.
- 객체지향과 함수형 프로그래밍 스타일 모두를 지원한다.
- 서버 애플리케이션, 안드로이드 등 다양한 대상한 플랫폼에서 활용 가능하다.
- 코틀린은 무료이며 오픈소스이다. 주요 IDE와 빌드 시스템을 지원한다.
- 코틀린은 실용적이며, 안전하고, 간결하며 상호운용성이 좋다.

# References
- [Kotlin Programming Language](https://kotlinlang.org/)

  