
Download and install go
https://golang.org/dl/

go build myrest.go

then run the compiled executable
./myrest

curl localhost:8000/hello

ctrl-c

Note: go compiles to native and if you have been using a Mac/Windows
you likely need to recompile the binary

env GOOS=linux GOARCH=amd64 go build myrest.go

docker build -t burr/mygo:v1 .

docker run -it -p 8000:8000 burr/mygo:v1

Thank you to Jesus R who figured this out for me!
https://github.com/jmrodri/go-demo


