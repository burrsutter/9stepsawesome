package main

import (
	"fmt"
	"net/http"
	"os"
//	"time"
)

func main() {

	//api := mux.NewRouter()
	http.HandleFunc("/", HelloHandler)
	//http.Handle("/hello", api)
    
	fmt.Println("Listening on localhost:8000")
	http.ListenAndServe(":8000", nil)
}

func HelloHandler(w http.ResponseWriter, r *http.Request) {
	w.WriteHeader(http.StatusOK)
	hostname, err := os.Hostname()
	if err != nil {
		fmt.Println("unable to get hostname")
	}
    
	// fmt.Fprintf(w, "Hello from Go! %s on %s\n", time.Now(), hostname)
	fmt.Fprintf(w, "Go Hello on %s\n", hostname)
}
