# Kotlin in Action Study
> 'Kotlin in Action' 스터디를 위한 Repo

## 목차
1. 코틀린 시작하기
2. 코틀린 기초

# 1. 코틀린 시작하기
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

<hr/>

# 2. 코틀린 기초
> 이번에는 모든 프로그램에서 필수 요소인 변수, 함수, 클래스 등을 코틀린에서 어떻게 선언하고 활용하는지 살펴본다. 또한, 제어 구조문과 스마트 캐스트, 예외처리에 대해서도 알아본다.

## 함수와 변수

### Hello World 프로그램
Hello World를 콘솔에 출력하는 프로그램을 만들어보자. 코틀린에서는 함수 하나로 쉽게 만들 수 있다.

```kotlin
fun main(args: Array<String>) {
    println("Hello World")
}
```

- 함수를 선언할 때 <code>fun</code> 키워드를 사용한다.
- 자바와 다르게 파라미터 이름 뒤에 파라미터 타입을 쓴다.
- 함수를 클래스 안이 아닌 최상위 수준에 정의할 수 있다.
- 배열도 일반적인 클래스와 마찬가지이다.
- 코틀린은 자바 코드를 간결하게 사용할 수 있게 래퍼를 제공한다.
- 문장의 끝에 세미콜론을 붙이지 않아도 된다.

### 함수
Hello World 프로그램에서 작성한 함수는 반환 타입이 없는 자바에서 말하는 void 타입이다. 코틀린에서는 Unit 이라고 한다.

값을 반환하는 함수를 작성할 때, 반환 값의 타입은 파라미터 목록 뒤에 정의한다.

```kotlin
fun max(a: Int, b: Int) : Int {
    return if (a > b) a else b
}
```

- 반환 값의 타입은 파라미터 목록 뒤에 <code>: 반환타입</code>을 정의한다.
- 코틀린에서 if 조건문은 결과를 만드는 식(expression)이다.
- 코틀린은 <code>=</code>을 붙이고 식(expression)을 본문으로 바로 작성할 수 있다. 

### 변수
자바에서는 변수를 선언할 때 타입이 가장 먼저 나온다. 코틀린에서는 타입을 생략하는 것이 흔하다.

```kotlin
val number = 10 // 타입 추론
val number: Int = 20
```

### 변경 가능 및 불가능한 변수
변수 선언 시 사용하는 키워드는 <code>val</code>와 <code>var</code> 2가지가 있다.

#### val
변경 불가능한 참조를 저장하는 변수이다. 한번 초기화하고 나면 다시 변경할 수 없다. 자바에서 final 변수에 해당한다.

#### var
변경 가능한 참조다. 변수의 값은 계속 변경할 수 있다. 하지만 타입은 고정되기 때문에 타입을 변경할 수는 없다. 자바에서 일반 변수에 해당한다.

### 문자열 템플릿
다음 예제 코드는 문자열 템플릿 기능을 보여준다. name이라는 변수를 선언하고 문자열 리터럴 안에서 그 변수를 사용했다. 문자열 안에서 <code>$</code>를 써서 변수를 쉽게 사용할 수 있다.

```kotlin
fun main(args: Array<String>) {
    val name = "Jayden"
    println("Hello, $name")
}
```

## 클래스와 프로퍼티
코틀린에서는 클래스는 자바에서 같은 코드가 반복적으로 들어가는 부분을 줄일 수 있다. 코틀린 코드로 작성한 name 프로퍼티 하나를 가진 <code>Person</code> 클래스이다.

```kotlin
class Person(val name: String)
```

코틀린에서는 자바에서 사용하던 public 키워드가 보이지 않는다. 이는 코틀린의 기본 가시성은 public 이므로 생략해도 된다.

### 프로퍼티
자바에서는 클래스 내부에 데이터를 담기 위해서 필드를 선언한다. 필드의 경우에 private 으로 선언해서 외부에 보이지 않게 캡슐화한다. 만약 필요하다면 게터 메서드를 만들어서 접근할 수 있도록 제공한다. 값을 변경하기 위해서는 세터 메서드를 추가한다. 필드와 접근자를 하나로 묶어서 프로퍼티라고 부른다.

코틀린은 프로퍼티를 언어 기본 기능을 제공하며 자바의 필드와 접근자 메서드(게터 메서드)를 대신한다. 코틀린에서 변수를 선언할 때 val 또는 var 키워드를 사용한다. val로 선언한 프로퍼티는 읽기 전용이며, var는 읽기 및 쓰기가 가능하다.

```kotlin
class Person(val name: String, var isMarried: Boolean)

fun main(args: Array<String>) {
    // 코틀린은 new 키워드를 사용하지 않고 생성자를 호출한다
    val person = Person("Jayden", false)
        
     // person.name = "gglee" // 수정 불가능
     // person.isMarried = true // 수정 가능
}
```

### 커스텀 접근자
코틀린에서 프로퍼티를 접근할 때 게터 메서드가 아닌 직접 호출해서 사용할 수 있다. 프로퍼티에는 프로퍼티 값을 저장하기 위한 필드가 있다. 프로퍼티 접근자 메서드를 자신의 환경에 맞게 커스텀 할 수도 있다.

Rectangle 클래스에서 정사각형 여부를 나타내는 프로퍼티는 isSquare이다. 이 프로퍼티의 값을 별도의 필드로 저장하고 있지 않다. 커스텀 접근자를 작성하고 넓이와 높이 값을 비교한 값을 반환하고 있다. 단점으로는 정사각형 여부 값을 따로 필드로 갖고 있지 않기 때문에 접근자 메서드를 사용할 때마다 매번 계산해야 하는 단점이 있다.

```kotlin
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return this.height == this.width
        }
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(100, 100)
    println("정사각형: ${rectangle.isSquare}")
}
```

## 코틀린 소스코드 구조
자바와 비슷한 개념의 패키지가 있다. 다른 패키지에 정의된 클래스를 사용하기 위해서는 임포트를 통해 불러와야 한다.

```kotlin
package ch02 // 패키지 선언

import java.util.Random // 외부 라이브러리 클래스 임포트

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return this.height == this.width
        }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
```

코틀린에서는 자바와 다르게 여러 클래스를 한 파일에 넣을 수 있으며, 파일의 이름도 마음대로 정할 수 있다. 코틀린에서는 자바에서 파일명과 클래스명이 다르면 오류가 발생하는 일이 생기지 않는다.

## enum
자바에서 enum을 선언할 때 enum 키워드만 사용했지만, 코틀린에서는 <code>enum class</code>라고 붙여야한다.

```kotlin
enum class Color {
    RED, BLUE, BLACK
}
```

코틀린 enum class 안에 프로퍼티와 메서드를 선언할 수 있다.

## when
자바에서 제공하는 switch문과 유사한 것이 코틀린에서는 <code>when</code>이다. if 문처럼 when도 값을 만들어내는 식(expression)이다.

getColorRgb 함수는 enum class인 Color를 매개변수로 받아서 rgb 값에 해당하는 문자열을 반환한다. 자세히 보면 switch와 유사하다고 했는데 break가 없는 것을 볼 수 있다.

```kotlin
fun getColorRgb(color: Color) =
    when (color) {
        RED -> "rgb(255, 0, 0)"
        BLUE -> "rgb(0, 0, 255)"
        BLACK -> "rgb(0, 0, 0)"
        else -> "rgb(255, 255, 255)"
    }
```

### when과 임의의 객체 함께 사용
자바에서는 switch 분기 조건에 상수만 사용할 수 있다. 반면 코틀린에서는 분기 조건으로 임의의 객체를 사용할 수 있다.

```kotlin
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOF(YELLOW, BLUE) -> GREEN
        else -> throw Exception("No Match Color")
    }   
```

### 인자 없는 when 사용
인자 없는 when 식을 사용할 수도 있다. 각 조건에 해당하는 순차적으로 매칭한다. 조건들은 boolean 결과를 계산하는 식이어야 한다.

```kotlin
when {
    color == RED -> RED
    color == BLUE -> BLUE
    color == BLACK -> BLACK
    else -> throw Exception("No Match Color")
}
```

## 스마트 캐스트

```kotlin
interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }

    if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("Unknown expression")
}

fun main(args: Array<String>) {
    val sum = eval(Sum(Sum(Num(1), Num(2)), Num(4)))
    println("Sum: $sum")
}
```

코틀린에서는 <code>is</code>를 사용해 변수 타입을 체크한다. 마치 자바의 <code>instanceof</code>와 비슷하다. 자바에서는 변수 타입을 체크하고 명시적으로 변수 타입으로 캐스팅해야 한다. 그렇지 않으면 그 변수 타입에 속한 멤버 접근을 할 수 없다. 타입 체크, 캐스트를 각각 수행해야 한다.

코틀린은 컴파일러가 프로그래머 대신 컴파일러가 캐스팅을 도와준다. <code>is</code>로 타입을 검사하면 컴파일러가 타입 캐스팅을 대신 수행해준다. 이를 <b>스마트 캐스트</b>라고 부른다.

원하는 타입을 명시적으로 타입 캐스팅하려면 <code>as</code> 키워드를 사용한다.

```kotlin
val n = e as Num
```

## 이터레이션
이터레이션 부분은 자바와 가장 비슷하다. while문은 거의 동일하고, for는 자바의 for-each 루프에 해당하는 형태만 존재한다.

### while 루프
코틀린에서 사용되는 while, do-while 루프이다. 자바와 동일하다.

```kotlin
while (조건) {
    // 로직
}

do {
    // 로직
} while (조건)
```

### 수에 대한 이터레이션
코틀린에는 자바의 for 루프(초깃값, 증가 값, 최종 값)을 사용하는 형태는 존재하지 않는다. 범위를 통해 반복하는 for 루프문만 존재한다.

```kotlin
for (i in 1..100) {
    println(i)
}
``` 

step, downTo, until을 통해 for 루프문을 원하는 형식대로 변경할 수 있다.

```kotlin
for (i in 100 downTo 1 step 2) {
    // 98, 94, 92, 88 ...
    println(i)
}
```

### 맵에 대한 이터레이션
코틀린 for 루프는 맵에 있는 원소를 순회하는 이터레이션을 쉽게 작성할 수 있다.

```kotlin
val map = TreeMap<Char, String>()

for ((ch, text) in map) {
    println("$ch : $text")
}
```

맵에 사용한 구조 분해 구문을 맵이 아닌 컬렉션에서도 사용할 수 있다. 이 구조 분해는 자바스크립트에도 있다.

```kotlin
var list = arrayListOf("java", "kotlin", "javascript")
for ((index, element) in list.withIndex()) {
    println("$index : $element")
}
```

# 코틀린 예외 처리
자바와 같이 오류가 발생하면 예외를 던질 수 있다. 함수를 호출하는 쪽에서 그 예외를 잡아서 처리할 수 있다. 예외를 처리하지 못하면 함수 호출 스택을 거슬러 올라가면서 예외를 처리하는 부분이 나올 때까지 예외를 던진다.

```kotlin
if (num !in 0..10) {
    throw new IllegalArgumentException("Invalid Number Value")
}
```

### try-catch-finally
예외를 처리하려면 try, catch, finally 절을 함께 사용한다.

```kotlin
try {
    val line = reader.readLine()
    return Integer.parseInt(line)
} catch (e: NumberFormatException) {
    return null
} finally {
    reader.close()
}
```

try를 식으로 사용할 수도 있다. 따라서 try의 값을 변수에 대입할 수 있다.

```kotlin
val number = try {
    Integer.parseInt(reader.readLine())
} catch (e: NumberFormatException) {
    return null
}

println(number)
```

## 요약
- 함수를 정의할 때 <code>fun</code> 키워드를 사용한다.
- <code>val</code> 읽기 전용 변수, <code>var</code> 변경 가능한 변수를 선언할 때 사용한다.
- 문자열 템플릿을 이용해서 간결하며 가독성 있는 코드를 작성할 수 있다.
- 값 객체를 <code>data class</code>로 간결하게 표현할 수 있다.
- 코틀린에서 <code>if</code> 문은 값을 만들어낸다.
- 코틀린에서 제공하는 <code>when</code>은 자바의 <code>switch</code>와 유사하나 더 많은 기능을 제공한다.
- 코틀린은 <code>is</code>를 통해서 스마트 캐스트를 제공한다.
- 코틀린의 이터레이션 while, do-while, for 루프에 대해서 알아봤다.

# References
- [Kotlin Programming Language](https://kotlinlang.org/)

  