curl -X PUT "localhost:9200/hotel?pretty"

curl -X PUT "localhost:9200/hotel?pretty" -H 'Content-Type: application/json' -d @elasticsearch-data/hotel-mapping.json

curl -XPOST "http://localhost:9200/_bulk?pretty" -H 'Content-Type: application/json' --data-binary @data/ES-bulk-insert-hotel.json
