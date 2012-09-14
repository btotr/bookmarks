## Usage


redis (http://redis.io/)

mvn package
java -cp target/dependency/*:target/classes com.activevideo.bookmarks.Main

examples: 

post a bookmark
	curl -v -H "Content-Type: application/json" -X POST -d '{"id:"1"}' 'http://localhost:9998/bookmarks/1'
	
get the bookmark
	curl 'http://localhost:9998/bookmarks/1'
