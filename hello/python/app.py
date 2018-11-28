import os

from flask import Flask
app = Flask(__name__)

@app.route("/")
def main():
    return "Python Hello on " + os.getenv('HOSTNAME', "unknown") + "\n"

if __name__ == "__main__":
    app.run(host='0.0.0.0',port='8000')

