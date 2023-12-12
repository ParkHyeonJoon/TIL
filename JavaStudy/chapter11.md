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
        <th>boolean add(Object O)</br>boolean addAll(Collection c)</th>
        <th>지정된 객체(o) 또는 Collection(c)의 객체들을 Collection에 추가한다.</th>
    </tr>
    <tr>
        <th>void clear()</th>
        <th>Collection의 모든 객체를 삭제한다.</th>
    </tr>
    <tr>
        <th>boolean contains(Object o)</br>boolean containsAll(Collection c)</th>
        <th>지정된 객체(o) 또는 Collection의 객체들이 Collection에 포함되어 있는지 확인한다.</th>
    </tr>
    <tr>
        <th>boolean equals(Object o)</th>
        <th>동일한 Collection인지 비교한다.</th>
    </tr>
    <tr>
        <th>int hashCode()</th>
        <th>Collection의 hash code를 반환한다.</th>
    </tr>
    <tr>
        <th>boolean isEmpty()</th>
        <th>Collection이 비어있는지 확인한다.</th>
    </tr>
    <tr>
        <th>Iterator iterator()</th>
        <th>Collection의 Iterator를 얻어서 반환한다.</th>
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
        <td>지정된 위치에 객체를 저장.</td>
    </tr>
    <tr>
        <td>boolean addAll(Collection c)</td>
        <td>주어진 컬렉션의 모든 객체를 저장한다.</td>
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
 
