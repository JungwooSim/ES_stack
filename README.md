#ES Stack

### ElasticSearch
**간단한 정리 및 장점**

- Apache Lucene 기반
- 실시간 분산처리 → 쉽게 확장 가능
- full-text search
- analysis engine
- Http interface 제공
- Json Type으로 문서 저장
- Java 프로그래밍 기반 → 범용성(JVM 있으면 사용가능)
- NRT (Near Relatime)
    - 문서 추가 후 색인부터 검색이 가능한 상태까지 1초 정도 걸림

**단점**

- Split Brance (정리 필요)

**ElasticSearch 와 RDBMS 비교**

- Cluster - Database
- Shard - Shard
- Index - Table
- Field - Column
- Document - Row

**Cluster**

하나의 Cluster 는 하나 이상의 Node 로 구성된다.

**Node**

- Data Node : 데이터 저장, 검색 및 집계, 등 데이터와 관련하여 담당
- Master Node : Node 추가 및 제거를 담당하고 Cluster 전체 관리 및 구성 담당
- Client Node : Client 요청을 Master Node, Data Node 로 전달
- Tribe Node : Client Node 로 작동하며 Client Node 에 대해 읽기 및 쓰기 작업 수행 (내용 보강 필요)
- Ingestion node : 인덱싱 전에 document 전처리
- Machine Learning node : 머신러능을 지원

모든 노드는 기본적으로 Master Node, Data Node, Ingestion Node, Machine Learning node가 될 수 있다. 클러스터가 커질수록 단일 유형의 노드로 구성하는게 효율적이다.

**Shard**

Index 에 포함되어 있는 Document 들을 수평 분할하여 분할된 것을 말함.

Shard 가 용량이 클수록 Cluster 에서 재조정(rebalance) 할때 오래걸린다.

작은 Shard 가 많을 수록 Sahrd 당 처리 속도는 빠르지만 overhead 가 증가하므로 적은 수의 용량이 큰 Shard 로 구성하는게 더 안정적이며 빠를 수 있다.

보통 Shard 의 크기는 20GB ~ 40GB 를 권장한다.

Node 가 보유할 수 있는 Shard 의 수는 ElasticSearch 에 할당된 Heap 에 비례한다. 일반적으로 1GB Heap 당 Shard 의 수는 20개 미만이여야 한다.

**Shard Replicas**

Shard 를 만약의 경우를 대비하여 복사한것.

default 개수는 옵션을 통해 설정가능하다.
읽기 전용의 업무를 분담하여 수행하기도 한다.

참고자료
https://www.tutorialspoint.com/elasticsearch/elasticsearch_basic_concepts.htm

https://logz.io/blog/10-elasticsearch-concepts/

https://www.elastic.co/guide/en/elasticsearch/reference/current/scalability.html 
