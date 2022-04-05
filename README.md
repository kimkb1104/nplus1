# 1. JPA의 N + 1
1 : N의 관계를 갖는 엔티티를 조회할 때(쿼리를 날렸을 때) 의도하지 않은 쿼리가 추가적으로 N번 실행되는 현상

# 2. 언제 발생하는가?
1. EAGER 전략으로 데이터를 가져오는 경우
2. LAZY 전략으로 데이터를 가져온 후에 하위 객체에 접근했을 때

# 3. 해결 방법
* Fetch Join (inner join)
```
@Query("SELECT a FROM Album a JOIN FETCH a.songs")
LinkedHashSet<Album> findAllJoinFetch();
```
* @EntityGraph (outer join)
```
@EntityGraph(attributePaths = "songs")
@Query("SELECT a FROM Album a")
LinkedHashSet<Album> findAllEntityGraph();
```
