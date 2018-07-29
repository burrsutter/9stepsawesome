from flask import Flask
app = Flask(__name__)

@app.route("/")
def main():
    return "Hello Python Flask World"

if __name__ == "__main__":
    app.run(host='0.0.0.0')

