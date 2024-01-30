# 1. 컬렉션 프레임워크

**컬렉션 프레임워크** : 데이터 군을 저장하는 클래스들을 표준화한  설계.
- 컬렉션 : 다수의 데이터, 즉 데이터 그룹.
- 프레임워크 : 표준화된 프로그래밍 방식.

## 1.1 컬렉션 프레임워크의 핵심 인터페이스
- Collection
  - List : 순서가 있는 데이터의 집합, 데이터의 중복을 허용
    - ArrayList, LinkedList, Stack, Vector 등
  - Set : 순서를 유지하지 않는 데이터의 집합, 데이터의 중복 허용 X
    - HashSet, TreeSet 등
- Map : 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합, 
  - HashMap, TreeMap, Hashtable, Properties 등

### Collection 인터페이스
**List**와 **Set**의 조상인 Collection인터페이스에 정의된 메서드들.
<table>
    <tr>
        <th>메서드</th><th>설 명</th>
    </tr>
    <tr>
        <td>boolean add(Object O)</br>boolean addAll(Collection c)</td>
        <td>지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.</td>
    </tr>
    <tr>
        <td>void clear()</td>
        <td>Collection의 모든 객체를 삭제한다.</td>
    </tr>
    <tr>
        <td>boolean contains(Object o)</br>boolean containsAll(Collection c)</td>
        <td>지정된 객체(o) 또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다.</td>
    </tr>
    <tr>
        <td>boolean equals(Object o)</td>
        <td>동일한 Collection인지 비교한다.</td>
    </tr>
    <tr>
        <td>int hashCode()</td>
        <td>Collection의 hash code를 반환한다.</td>
    </tr>
    <tr>
        <td>boolean isEmpty()</td>
        <td>Collection이 비어있는지 확인한다.</td>
    </tr>
    <tr>
        <td>Iterator iterator()</td>
        <td>Collection의 Iterator를 얻어서 반환한다.</td>
    </tr>
    <tr>
        <td>boolean removeAl(Collectino c)</td>
        <td>지정된 Collection에 포함된 객체들을 삭제한다.</td>
    </tr>
    <tr>
        <td>boolean retainAll(Collection c)</td>
        <td>지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다.
            이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.
        </td>
    </tr>
    <tr>
        <td>int size()</td>
        <td>Collection에 저장된 객체의 개수를 반환한다.</td>
    </tr>
    <tr>
        <td>Object[] toArray()</td>
        <td>Collection에 저장된 객체를 객체배열(Object[])로 반환한다.</td>
    </tr>
    <tr>
        <td>Object[] toArray(Object[] a)</td>
        <td>지정된 배열에 Collection의 객체를 저장해서 반환한다.</td>
    </tr>
</table>

### List 인터페이스
**중복 허용**하면서 **저장순서가 유지**되는 컬렉션을 구현하는데 사용된다.
<table>
    <tr>
        <th>메서드</th><th>설 명</th>
    </tr>
    <tr>
        <td>void add(int index, Object element)</br>boolean addAll(int index, Collection c)</td>
        <td>지정된 위치(index)에 객체(element) 또는 컬렉션에 포함된 객체들을 추가한다.</td>
    </tr>
    <tr>
        <td>Object get(int index)</td>
        <td>지정된 위치(index)에 있는 객체를 반환한다.</td>
    </tr>
    <tr>
        <td>int indexOf(Object o)</td>
        <td>지정된 객체의 위치(index)를 반환한다.(List의 첫 번째 요소부터 순방향으로 찾는다.)</td>
    </tr>
    <tr>
        <td>int lastIndexOf(Object o)</td>
        <td>지정된 객체의 위치(index)를 반환한다.(List의 마지막 요소부터 역방향으로 찾는다.)</td>
    </tr>
    <tr>
        <td>ListIterator listIterator()</br>ListIterator listIterator(int index)</td>
        <td>List의 객체에 접근할 수 있는 ListIterator를 반환한다.</td>
    </tr>
    <tr>
        <td>Object remove(int index)</td>
        <td>지정된 위치(index)에 있는 객체를 삭제하고 삭제된 객체를 반환한다.</td>
    </tr>
    <tr>
        <td>Object set(int index, Object element)</td>
        <td>지정된 위치(index)에서 객체(element)를 저장한다.</td>
    </tr>
    <tr>
        <td>void sort(Comparator c)</td>
        <td>지정된 비교자(comparator)로 List를 정렬한다.</td>
    </tr>
    <tr>
        <td>List subList(int fromIndex, int toIndex)</td>
        <td>지정된 범위(fromIndex부터 toIndex)에 있는 객체를 반환한다.</td>
    </tr>
</table>

### Set 인터페이스
**중복 허용하지 않고 저장 순서 유지되지 않는 컬렉션 클래스 구현**

### Map 인터페이스
**Key**와 **값(value)**을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현.

<table>
    <tr>
        <th>메서드</th><th>설 명</th>
    </tr>
    <tr>
        <td>void clear()</td>
        <td>Map의 모든 객체를 삭제한다.</td>
    </tr>
    <tr>
        <td>boolean containsKey(Object key)</td>
        <td>지정된 key객체와 일치하는 Map의 key객체가 있는지 확인한다.</td>
    </tr>
    <tr>
        <td>boolean containsValue(Object value)</td>
        <td>지정된 value객체와 일치하는 Map의 value객체가 있는지 확인한다.</td>
    </tr>
    <tr>
        <td>Set entrySet()</td>
        <td>Map에 저장되어 있는 key-value쌍을 Map.Entry타입의 객체로 저장한 Set으로 반환한다.</td>
    </tr>
    <tr>
        <td>boolean equals(Object o)</td>
        <td>동일한 Map인지 비교한다.</td>
    </tr>
    <tr>
        <td>Object get(Object key)</td>
        <td>지정한 key객체에 대응하는 value객체를 찾아서 반환한다.</td>
    </tr>
    <tr>
        <td>int hashCode()</td>
        <td>해시코드를 반환한다.</td>
    </tr>
    <tr>
        <td>boolean isEmpty()</td>
        <td>Map이 비어있는지 확인한다.</td>
    </tr>
    <tr>
        <td>Set keySet()</td>
        <td>Map에 저장된 모든 key객체를 반환한다.</td>
    </tr>
    <tr>
        <td>Object put(Object key, Object value)</td>
        <td>Map에 value객체를 key객체에 연결(mapping)하여 저장한다.</td>
    </tr>
    <tr>
        <td>void putAll(Map t)</td>
        <td>지정된 Map의 모든 key-value쌍을 추가한다.</td>
    </tr>
    <tr>
        <td>Object remove(Object key)</td>
        <td>지정한 key객체와 일치하는 key-value객체를 삭제한다.</td>
    </tr>
    <tr>
        <td>int size()</td>
        <td>Map에 저장된 key-value쌍의 개수를 반환한다.</td>
    </tr>
    <tr>
        <td>Collection values()</td>
        <td>Map에 저장된 모든 value객체를 반환한다.</td>
    </tr>
</table>

values()에서는 반환타입이 **Collection**이고, keySet()에서는 반환타입이 **Set**.

Map인터페이스에서 값은 중복 허용하기 때문에 Collection타입, 키는 중복을 허용하지 않아 Set타입.

### Map.Entry 인터페이스
Map인터페이스의 내부 인터페이스. 

<table>
    <tr>
        <th>메서드</th><th>설 명</th>
    </tr>
    <tr>
        <td>boolean equals(Object o)</td>
        <td>동일한 Entry인지 비교한다.</td>
    </tr>
    <tr>
        <td>Object getKey()</td>
        <td>Entry의 key객체를 반환한다.</td>
    </tr>
    <tr>
        <td>Object getValue()</td>
        <td>Entry의 value객체를 반환한다.</td>
    </tr>
    <tr>
        <td>int hashCode()</td>
        <td>Entry의 해시코드를 반환한다.</td>
    </tr>
    <tr>
        <td>Object setValue(Object value)</td>
        <td>Entry의 value객체를 지정된 객체로 바꾼다.</td>
    </tr>
</table>

## 1.2 ArrayList
List인터페이스를 구현한다. 데이터 저장순서 유지, 중복을 허용한다.

<table>
    <tr>
        <th>메서드</th><th>설 명</th>
    </tr>
    <tr>
        <td>ArrayList()</td>
        <td>크기가 10인 ArrayList를 생성.</td>
    </tr>
    <tr>  
        <td>ArrayList(Collection c)</td>
        <td>주어진 컬렉션이 저장된 ArrayList를 생성.</td>
    </tr>
    <tr>
        <td>ArrayList(int initialCapacity)</td>
        <td>지정된 초기용량을 갖는 ArrayList를 생성.</td>
    </tr>
    <tr>
        <td>boolean add(Object o)</td>
        <td>ArrayList의 마지막에 객체를 추가.</td>
    </tr>
    <tr>
        <td>void add(int index, Object element)</td>
        <td>지정된 위치(index)에 객체를 저장.</td>
    </tr>
    <tr>
        <td>boolean addAll(Collection c)</td>
        <td>주어진 컬렉션의 모든 객체를 저장한다.</td>
    </tr>
    <tr>
        <td>boolean addAll(int index, Collection c)</td>
        <td>저장된 위치부터 주어진 컬렉션의 모든 객체를 저장한다.</td>
    </tr>
    <tr>
        <td>void clear()</td>
        <td>ArrayList를 완전히 비운다.</td>
    </tr>
    <tr>
        <td>Object clone()</td>
        <td>ArrayList를 복제한다.</td>
    </tr>
    <tr>
        <td>boolean contains(Object o)</td>
        <td>저장된 객체(o)가 ArrayList에 포함되어 있는지 확인</td>
    </tr>
    <tr>
        <td>void ensureCapacity(int minCapacity)</td>
        <td>ArrayList의 용량이 최소한 minCapacity가 되도록 한다..</td>
    </tr>
    <tr>
        <td>Object get(int index)</td>
        <td>지정된 위치(index)에 저장된 객체를 반환한다.</td>
    </tr>
    <tr>
        <td>int indexOf(Object o)</td>
        <td>지정된 객체가 저장된 위치를 찾아 반환한다.</td>
    </tr>
    <tr>
        <td>boolean isEmpty()</td>
        <td>ArrayList가 비어있는지 확인한다.</td>
    </tr>
    <tr>
        <td>Iterator iterator()</td>
        <td>ArrayList의 Iterator객체를 반환한다.</td>
    </tr>
    <tr>
        <td>int lastIndexOf(Object o)</td>
        <td>객체(o)가 저장된 위치를 끝부터 역방향으로 검색해서 반환한다.</td>
    </tr>
    <tr>
        <td>ListIterator listIterator()</td>
        <td>ArrayList의 ListIterator를 반환한다.</td>
    </tr>
    <tr>
        <td>ListIterator listIterator(int index)</td>
        <td>ArrayList의 지정된 위치부터 시작하는 ListIterator를 반환한다.</td>
    </tr>
    <tr>
        <td>Object remove(int index)</td>
        <td>지정된 위치(index)에 있는 객체를 제거한다.</td>
    </tr>
    <tr>
        <td>boolean remove(Object o)</td>
        <td>지정한 객체를 제거한다.(성공 true, 실패 false)</td>
    </tr>
    <tr>
        <td>boolean removeAll(Collection c)</td>
        <td>지정한 컬렉션에 저장된 것과 동일한 객체들을 ArrayList에서 제거한다.</td>
    </tr>
    <tr>
        <td>boolean retainAll(Collection c)</td>
        <td>ArrayList에 저장된 객체 중에서 주어진 컬렉션과 공통된 것들만을 남기고
        나머지는 삭제한다.</td>
    </tr>
    <tr>
        <td>Object set(int index, Object element)</td>
        <td>주어진 객체(element)를 지정된 위치(index)에 저장한다.</td>
    </tr>
    <tr>
        <td>int size()</td>
        <td>ArrayList에 저장된 객체의 개수를 반환한다.</td>
    </tr>
    <tr>
        <td>void sort(Comparator c)</td>
        <td>지정된 정렬기준(c)으로 ArrayList를 정렬한다.</td>
    </tr>
    <tr>
        <td>List subList(int fromIndex, int toIndex)</td>
        <td>fromIndex부터 toIndex사이에 저장된 객체를 반환한다.</td>
    </tr>
    <tr>
        <td>Object[] toArray()</td>
        <td>ArrayList에 저장된 모든 객체들을 객체배열로 반환한다.</td>
    </tr>
    <tr>
        <td>Object[] toArray(Object[] a)</td>
        <td>ArrayList에 저장된 모든 객체들을 객체배열 a에 담아 반환한다.</td>
    </tr>
    <tr>
        <td>void trimToSize()</td>
        <td>용량을 크기에 맞게 줄인다.</td>
    </tr>
</table>
 
## LinkedList

배열의 단점(크기 변경 X, 비순차적인 데이터의 추가 or 삭제에 시간이 많이 걸림) 보완하기 위해 링크드 리스트 고안.

각 요소들은 자신과 연결된 다음 요소에 대한 참조(주소값)와 데이터로 구성.

**더블 링크드 리스트**는 양방향.

이전 요소에 대한 참조변수를 하나 더 추가하여 구성

<table>
    <tr>
        <th>메서드</th><th>설 명</th>
    </tr>
    <tr>
      Queue인터페이스 구현하면서 추가된 것.
    </tr>
    <tr>
        <td>Object element()</td>
        <td>LinkedList의 첫 번째 요소를 반환.</td>
    </tr>
    <tr>  
        <td>boolean offer(Object o)</td>
        <td>지정된 객체(o)를 LinkedList의 끝에 추가. 성공하면 true, 실패하면 false.</td>
    </tr>
    <tr>
        <td>Object peek()</td>
        <td>LinkedList의 첫 번째 요소를 반환.</td>
    </tr>
    <tr>
        <td>Object poll()</td>
        <td>LinkedList의 첫 번째 요소를 반환. LinkedList에서는 제거된다.</td>
    </tr>
    <tr>
        <td>Object remove()</td>
        <td>LinkedList의 첫 번째 요소를 제거.</td>
    </tr>
    <tr>
      Deque인터페이스를 구현하면서 추가된 것.
    </tr>
    <tr>
        <td>boolean addAll(Collection c)</td>
        <td>주어진 컬렉션의 모든 객체를 저장한다.</td>
    </tr>
    <tr>
        <td>void addFirst(Object o)</td>
        <td>LinkedList의 맨 앞에 객체(o)를 추가.</td>
    </tr>
    <tr>
        <td>void addLast(Object o)</td>
        <td>LinkedList의 맨 끝에 객체(o)를 추가.</td>
    </tr>
    <tr>
        <td>Iterator descendingIterator()</td>
        <td>역순으로 조회하기 위한 DescendingIterator를 반환.</td>
    </tr>
    <tr>
        <td>Object getFirst()</td>
        <td>LinkedList의 첫 번째 요소를 반환.</td>
    </tr>
    <tr>
        <td>Object getLast()</td>
        <td>LinkedList의 마지막 요소를 반환.</td>
    </tr>
    <tr>
        <td>boolean offerFirst(Object o)</td>
        <td>LinkedList의 맨 앞에 객체(o)를 추가. 성공하면 true.</td>
    </tr>
    <tr>
        <td>boolean offerLast(Object o)</td>
        <td>LinkedList의 맨 끝에 객체(o)를 추가. 성공하면 true.</td>
    </tr>
    <tr>
        <td>Object peekFirst()</td>
        <td>LinkedList의 첫번째 요소를 반환.</td>
    </tr>
    <tr>
        <td>Object peekLast()</td>
        <td>LinkedList의 마지막 요소를 반환.</td>
    </tr>
    <tr>
        <td>Object pollFirst()</td>
        <td>LinkedList의 첫번째 요소를 반환하면서 제거.</td>
    </tr>
    <tr>
        <td>Object pollLast()</td>
        <td>LinkedList의 마지막 요소를 반환하면서 제거.</td>
    </tr>
    <tr>
        <td>Object pop()</td>
        <td>removeFirst()와 동일.</td>
    </tr>
    <tr>
        <td>void push(Object o)</td>
        <td>addFirst()와 동일.</td>
    </tr>
    <tr>
        <td>Object removeFirst()</td>
        <td>LinkedList의 첫번째 요소를 제거.</td>
    </tr>
    <tr>
        <td>Object removeLast()</td>
        <td>LinkedList의 마지막 요소를 제거.</td>
    </tr>
    <tr>
        <td>boolean removeFirstOccurrence(Object o)</td>
        <td>LinkedList에서 첫번째로 일치하는 객체를 제거.</td>
    </tr>
    <tr>
        <td>boolean removeLastOccurrence(Object o)</td>
        <td>LinkedList에서 마지막으로 일치하는 객체를 제거.</td>
    </tr>
</table>

LinkedList도 List인터페이스를 구현했기 때문에 ArrayList와 제공하는 메서드의 종류와
기능은 거의 같다.

LinkedList vs ArrayList

순차적으로 추가/삭제하는 경우에는 ArrayList가 LinkedList보다 빠르다.

중간 데이터를 추가/삭제하는 경우에는 LinkedList가 ArrayList보다 빠르다.

## 1.4 Stack과 Queue

**Stack**은 **LIFO**(Last In First Out)이고, **Stack**에는 ArrayList와 같은 배열기반의 컬렉션 클래스가 적합.

스택의 활용 예 - 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로

**Stack의 메서드**
<table>
    <tr>
        <th>메서드</th><th>설 명</th>
    </tr>
    <tr>
        <td>boolean empty()</td>
        <td>Stack이 비어있는지 알려준다.</td>
    </tr>
    <tr>  
        <td>Object peek()</td>
        <td>Stack의 맨 위에 저장된 객체를 반환. pop()과 달리 Stack에서 객체를
            꺼내지는 않음.(비었을 때는 EmptyStackException 발생)</td>
    </tr>
    <tr>
        <td>Object pop()</td>
        <td>Stack의 맨 위에 저장된 객체를 꺼낸다.(비었을 때는 EmptyStackException 발생)</td>
    </tr>
    <tr>
        <td>Object push(Object item)</td>
        <td>Stack에 객체(item)를 저장한다.</td>
    </tr>
    <tr>
        <td>int search(Object o)</td>
        <td>Stack에서 주어진 객체(o)를 찾아서 그 위치를 반환. 못 찾으면 -1을 반환.</td>
    </tr>
</table>

**Queue**는 **FIFO**(First In First Out)이다.</br>
**Queue**는 ArrayList와 같은 배열기반의 컬렉션 클래스를 사용한다면 꺼낼때마다 빈공간 생겨</br>
빈 공간을 채우기 위해 계속 복사가 발생하므로 비효율적. 데이터 추가/삭제가 쉬운 LinkedList가 나음.

큐의 활용 예 - 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)

**Queue의 메서드**
<table>
    <tr>
        <th>메서드</th><th>설 명</th>
    </tr>
    <tr>
        <td>boolean add()</td>
        <td>지정된 객체를 Queue에 추가한다. 성공하면 true를 반환. 저장공간이 부족하면
            IllegalStateException 발생.</td>
    </tr>
    <tr>  
        <td>Object remove()</td>
        <td>Queue에서 객체를 꺼내 반환. 비어있으면 NoSuchElementException 발생.</td>
    </tr>
    <tr>
        <td>Object element()</td>
        <td>삭제없이 요소를 읽어온다. peek와 달리 Queue가 비었을 때 NoSuchElementException 발생.</td>
    </tr>
    <tr>
        <td>boolean offer(Object o)</td>
        <td>Queue에 객체를 저장. 성공하면 true, 실패하면 false를 반환.</td>
    </tr>
    <tr>
        <td>Object poll()</td>
        <td>Queue에서 객체를 꺼내서 반환. 비어있으면 null을 반환.</td>
    </tr>
    <tr>
        <td>Object peek()</td>
        <td>삭제없이 요소를 읽어온다. Queue가 비어있으면 null을 반환.</td>
    </tr>
</table>

### PriorityQueue

Queue인터페이스의 구현체 중 하나로 저장한 순서 관계없이 우선순위가 높은 것부터 꺼냄.

우선순위는 숫자가 작을수록 높은 것.

### Deque(Double-Ended Queue)

Deque은 양쪽 끝에 추가/삭제가 가능하다. 스택과 큐를 하나로 합쳐놓은 것.

<table>
  <tr>
    <td>Deque</td>
    <td>Queue</td>
    <td>Stack</td>
  </tr>
  <tr>
    <td>offerLast()</td>
    <td>offer()</td>
    <td>push()</td>
  </tr>
  <tr>
    <td>pollLast()</td>
    <td>-</td>
    <td>pop()</td>
  </tr>
  <tr>
    <td>pollFirst()</td>
    <td>poll()</td>
    <td>-</td>
  </tr>
  <tr>
    <td>peekFirst()</td>
    <td>peek()</td>
    <td>-</td>
  </tr>
  <tr>
    <td>peekLast()</td>
    <td>-</td>
    <td>peek()</td>
  </tr>
</table>

## 1.5 Iterator, ListIterator, Enumeration
컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스.

### Iterator
컬렉션에 저장된 요소들을 읽어오는 방법을 표준화.

```agsl
public interface Iterator {
    boolean hasNext();
    Object next();
    void remove();
}
public interface Collection {
    ```
    public Iterator iterator();
    ```
}
```

<table>
<tr><td>메서드</td><td>설 명</td></tr>
<tr><td>boolean hasNext()</td><td>읽어 올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환한다.</td></tr>
<tr><td>Object next()</td><td>다음 요로를 읽어온다. next()를 호출하기 전에 hasNext()를 호출해서 읽어 올 요소가 있는지</br>
                              확인하는 것이 안전하다.</td></tr>
<tr><td>void remove()</td><td>next()로 읽어 온 요소를 삭제한다. next()를 호출한 다음에 remove()를 호출해야한다.(선택적 기능).</td></tr>
</table>

```agsl
Collection c = new ArrayList();
Iterator it = c.iterator();
while(it.hasNext()) {
    System.out.println(it.next());
}
```

Map인터페이스를 구현한 컬렉션 클래스는 키와 값을 쌍으로 저장하고 있기 때문에 **keySet()** 이나 **entrySet()**
을 사용해 iterator()를 호출해야함.
```agsl
Map map = new HashMap();
Iterator it = map.entrySet().iterator();
```

**Enumeration** : Iterator의 구버전

**ListIterator** : Iterator에 양방향 조회기능추가(List를 구현한 경우만 사용가능)

### Arrays

* 배열의 복사
  * copyOf() : 배열 전체를 복사해서 새로운 배열을 만들어 반환.
  * copyOfRange() : 배열의 일부를 복사해서 새로운 배열을 만들어 반환.

* 배열 채우기
  * fill() : 배열의 모든 요소를 지정된 값으로 채움.
  * setAll() : 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받음.
```agsl
int[] arr = new int[5];
Arrays.fill(arr, 9); // arr = [9, 9, 9, 9, 9]
Arrays.setAll(arr, () -> (int)(Math.random()*5) + 1); // arr = [1, 5, 2, 1, 1]
```
* 배열의 정렬과 검색
  * sort() : 배열을 정렬할 때 사용. 
  * binarySearch() : 배열에 저장된 요소를 검색할 때 사용.
```agsl
int[] arr = { 3, 2, 0, 1, 4 };
int idx = Arrays.binarySearch(arr, 2); // idx = -5 <- 잘못된 결과

Arrays.sort(arr); // 배열 arr을 정렬한다.
System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4]
int idx = Arrays.binarySearch(arr, 2); // idx = 2 <- 올바른 결과
```

* 배열의 비교와 출력
  * equals() : 두 배열에 저장된 모든 요소를 비교하여 같으면 true, 다르면 false
  * toString() : 배열의 모든 요소를 문자열로 편하게 출력, 일차원 배열에서만 가능.

다차원 배열에서 사용하고 싶으면 deepEquals(), deepToString()을 사용함.

* 배열을 List로 변환
  * asList(Object... a) : 배열을 List에 담아서 반환함. 
  * asList()가 반환한 List의 크기를 변경 불가. 추가, 삭제 불가.
```agsl
List list = Arrays.asList(new Integer[] {1,2,3,4,5}); // list = [1, 2, 3, 4, 5]
List list = Arrays.asList(1,2,3,4,5); // list = [1, 2, 3, 4, 5]
list.add(6); // UnsupportedOperationException 예외 발생
```wkr 
크기 변경 가능한 List가 필요하다면
```agsl
List list = new ArrayList(Arrays.asList(1,2,3,4,5));
```

* parallelXXX(), spliterator(), stream()
  * parallelXXX() : 여러 쓰레드가 작업을 나누어 처리.
  * spliterator() : 여러 쓰레드가 처리할 수 있게 하나의 작업을 여러 작업으로 나누는 Spliterator를 반환.
  * stream() : 컬렉션을 스트림으로 변환.

## 1.7 Comparator와 Comparable

