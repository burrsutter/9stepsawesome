from BaseHTTPServer import BaseHTTPRequestHandler, HTTPServer
import json
import logging

class Controller(BaseHTTPRequestHandler):
  def sync(self, parent, children):
    
    # Compute status based on observed state.
    desired_status = {
       "pods": 1
    }

    # Collect the specifications
    name = parent["metadata"]["name"]
    sauce = parent.get("spec", {}).get("sauce")
    toppings = parent.get("spec",{}).get("toppings")
    print("\n\nsauce: %s" % sauce)
    print("toppings: %s" % toppings)
    for topping in toppings:
      print(topping)

    stuff = ' ' + sauce + ' ' + ' '.join(toppings) + ' of ' + name
   
    print stuff

    # Generate the desired child object(s)
    
    desired_pods = [
      {
        "apiVersion": "v1",
        "kind": "Pod",
        "metadata": {
          "name": name
        },
        "spec": {
          "restartPolicy": "OnFailure",
          "containers": [
            {
              "name": "pizza",
              "image": "busybox",
              "command": ["echo", "requested pizza: %s" % stuff]
            }
          ]
        }
      }
    ]

    return {"status": desired_status, "children": desired_pods}

  def do_POST(self):
    # Serve the sync() function as a JSON webhook.
    
    observed = json.loads(self.rfile.read(int(self.headers.getheader("content-length"))))
    desired = self.sync(observed["parent"], observed["children"])

    self.send_response(200)
    self.send_header("Content-type", "application/json")
    self.end_headers()
    self.wfile.write(json.dumps(desired))

HTTPServer(("", 8080), Controller).serve_forever()